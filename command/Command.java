////////////////////////////////////////////////////////////////
package command;
////////////////////////////////////////////////////////////////
import java.util.Stack;
import java.util.Arrays;
////////////////////////////////////////////////////////////////
class App { // The Receiver
    private StringBuilder bufr = new StringBuilder();
    void append( String text ){
        bufr.append( text );
    }
    void delete( int start, int end ){
        bufr.delete( start, end );
    }
    void display() {
        System.out.println( bufr );
    }
    int bufrlen() {
        return bufr.length();
    }
}
////////////////////////////////////////////////////////////////
interface Command {
    void execute();
    void undo();
}
////////////////////////////////////////////////////////////////
class AppendCommand implements Command {
    private App edjtor;
    private String text;
    AppendCommand( App edjtor, String text ){
        this.edjtor = edjtor;
        this.text = text;
    }
    @Override
    public void execute() {
        edjtor.append( text );
    }
    @Override
    public void undo() {
        int n = edjtor.bufrlen();
        edjtor.delete( n - text.length(), n );
    }
}
////////////////////////////////////////////////////////////////
class ComSat { // The Invoker
    private Stack <Command> history = new Stack <> ();
    private App app = new App();
    private static String[] split( String s ){
        return s.split( "\\s+" );
    }
    private static String merge( int off, String a[]){
        int n = a.length;
        return String.join(" ", Arrays.copyOfRange( a, off, n ));
    }
    void launch( String command ){
        String[] argv = split( command );
        if( argv[ 0 ].equals( "append" )){
            String text = merge( 1, argv );
            Command append = new AppendCommand( app, text );
            append.execute();
            history.push( append );
        } else {
            System.out.println( "SIGSEGV segmentation violation" );
        }
    }
    void undo() {
        if( history.isEmpty() ){
            System.out.println( "Pure virtual function call" );
        } else {
            Command command = history.pop();
            command.undo();
        }
    }
    void display() {
        app.display();
    }
}
////////////////////////////////////////////////////////////////
// SIGSEGV segmentation violation
// Hello, World
// Hello, World!
// Hello, World
//
// Pure virtual function call
////////////////////////////////////////////////////////////////
class Client {
    public static void main( String args[]) {
        ComSat station = new ComSat();
        station.launch( "boom" );
        station.launch( "append Hello, World" );
        station.display();
        station.launch( "append !" );
        station.display();
        station.undo();
        station.display();
        station.undo();
        station.display();
        station.undo();
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
