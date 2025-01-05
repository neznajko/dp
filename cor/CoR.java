////////////////////////////////////////////////////////////////
package cor;
////////////////////////////////////////////////////////////////
abstract class Node {
    Node next = null;
    void log( String msg ){
        System.out.print( msg );
    }
    void handle( String request ){
        if( next != null ){
            next.handle( request );
        }
    }
}
////////////////////////////////////////////////////////////////
class Ahead extends Node {
    void push( Node node ){
        node.next = next;
        next = node;
    }
}
////////////////////////////////////////////////////////////////
class Boom extends Node {
    @Override
    void handle( String request ){
        if( request == "check" ){
            log( "[ " + request + " ]" );
        } else {
            super.handle( request );
        }
    }
}
////////////////////////////////////////////////////////////////
class Haha extends Node {
    @Override
    void handle( String request ){
        if( request == "this" ){
            log( "/ " + request + " /" );
        } else {
            super.handle( request );
        }
    }
}
////////////////////////////////////////////////////////////////
class Vrooom extends Node {
    @Override
    void handle( String request ){
        if( request == "out!" ){
            log( "( " + request + " )\n" );
        } else {
            super.handle( request );
        }
    }
}
////////////////////////////////////////////////////////////////
// [ check ]/ this /( out! )
class CoR {
    public static void main( String args[]) {
        Ahead ahead = new Ahead();
        ahead.push( new Vrooom());
        ahead.push( new Haha());
        ahead.push( new Boom());
        ahead.handle( "check" );
        ahead.handle( "this" );
        ahead.handle( "out!" );
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
