////////////////////////////////////////////////////////////////
package prototype.didp;
////////////////////////////////////////////////////////////////
class Prototype {
    public static void main( String args[] ){
        Circle circ = new Circle( 1, 2, "red", 8 );
        System.out.println( circ.x + " " + circ.clone().x );
        Rectangle rect = new Rectangle( 0, 0, "blue", 5, 4 );
        System.out.println( rect.w + " " + rect.clone().w );
    }
    // Output: 1 1
    //         5 5
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
