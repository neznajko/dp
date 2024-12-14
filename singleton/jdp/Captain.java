////////////////////////////////////////////////////////////////
package singleton.jdp;
////////////////////////////////////////////////////////////////
class Captain {
    private static final Captain CAPTAIN = new Captain();
    private Captain() {
        System.out.println( "Early Initialization" );
    }
    static Captain getCaptain() {
        System.out.println( "You've got a Captain" );
        return CAPTAIN;
    }
}
////////////////////////////////////////////////////////////////
class LazyCaptain {
    private static LazyCaptain LAZYCAPTAIN = null;
    private LazyCaptain() {
        System.out.println( "Lazy Initialization" );
    }
    static LazyCaptain getLazyCaptain() {
        if( LAZYCAPTAIN == null ){
            LAZYCAPTAIN = new LazyCaptain();
        }
        System.out.println( "You've got a Lazy Captain" );
        return LAZYCAPTAIN;
    }
}
////////////////////////////////////////////////////////////////
class Singleton {
    public static void main( String [] args ){
        var captain = Captain.getCaptain();
        var lazyCaptain = LazyCaptain.getLazyCaptain();
    }
}
////////////////////////////////////////////////////////////////
