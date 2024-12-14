////////////////////////////////////////////////////////////////
package prototype.didp;
////////////////////////////////////////////////////////////////
abstract class Shape {
    int x;
    int y;
    String color;
    Shape( int x, int y, String color ){
        this.x = x;
        this.y = y;
        this.color = color;
    }
    abstract public Shape clone();
}
////////////////////////////////////////////////////////////////
class Rectangle extends Shape {
    int w;
    int h;
    Rectangle( int x, int y, String color, int w, int h ){
        super( x, y, color );
        this.w = w;
        this.h = h;
    }
    public Rectangle clone() {
        return new Rectangle( x, y, color, w, h );
    }
}
////////////////////////////////////////////////////////////////
class Circle extends Shape {
    int r;
    Circle( int x, int y, String color, int r ){
        super( x, y, color );
        this.r = r;
    }
    public Circle clone() {
        return new Circle( x, y, color, r );
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
