////////////////////////////////////////////////////////////////
package memento;
////////////////////////////////////////////////////////////////
import java.util.Stack;
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
class Memento {
    private String state;
    Memento( String state ){
        this.state = state;
    }
    String getState() {
        return state;
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
class Originator {
    private String content = "";
    void setContent( String content ){
        this.content = content;
    }
    String getContent() {
        return content;
    }
    Memento backup() {
        return new Memento( content );
    }
    public void restore( Memento memento ){
        this.content = memento.getState();
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
class Caretaker {
    private Stack <Memento> history = new Stack <> ();
    void push( Memento memento ){
        history.push( memento );
    }
    Memento pop() {
        if( history.isEmpty()) {
            System.out.println( "Nothing to pop!" );
            return null;
        } else {
            return history.pop();
        }
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
class FIFAManager {
    private Originator orig = new Originator();
    private Caretaker caretaker = new Caretaker();
    void write( String content ){
        caretaker.push( orig.backup());
        orig.setContent( content );
    }
    void undo() {
        Memento memento = caretaker.pop();
        if( memento != null ){
            orig.restore( memento );
        }
    }
    void printContent() {
        System.out.println( "Content: " + orig.getContent());
    }
    // Content: HA
    // Content: Ha
    // Content: ha
    public static void main( String[] args ){
        FIFAManager manager = new FIFAManager();
        manager.write( "ha" );
        manager.write( "Ha" );
        manager.write( "HA" );
        manager.printContent();
        manager.undo();
        manager.printContent();
        manager.undo();
        manager.printContent();
        manager.undo();
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
