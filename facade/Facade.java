////////////////////////////////////////////////////////////////
package facade;
////////////////////////////////////////////////////////////////
class Subsystem {
    void log( String msg ){
        System.out.println( msg );
    }
}
////////////////////////////////////////////////////////////////
class FileIO extends Subsystem {
    void newfile() {
        log( "Creating new file" );
    }
    void open( String path ){
        log( "Opening " + path );
    }
    void save() {
        log( "Saving file" );
    }
    void saveAs( String name ){
        log( "Saving file as " + name );
    }
    void export( String type) {
        log( "Exporting to " + type + " file" );
    }
    // ...
}
////////////////////////////////////////////////////////////////
class ColorAdjustments extends Subsystem {
    void brightness( int value ){
        log( "brightnes = " + value );
    }
    void saturation( int r, int g, int b ){
        log( String.format( "saturation = (%d,%d,%d)", r, g, b ));
    }
    void levels( String range ){
        log( "Adjusting colors range: " + range );
    }
    void curves( String curve ){
        log( "Adjusting colors curve: " + curve );
    }
    void invert() {
        log( "Inverting colors" );
    }
    // ...
}
////////////////////////////////////////////////////////////////
class Transform extends Subsystem {
    void scale( int value ){
        log( "[ " + value + " ]" );
    }
    void mirror() {
        log( "(:" );
    }
    void rotate( int deg ){
        log( "( " + deg + " )" );
    }
    void skew() {
        log( "utf-8" );
    }
    // ...
}
////////////////////////////////////////////////////////////////
class Tools extends Subsystem {
    void brush( String stroke ){
        log( "Brushing " + stroke + " ..." );
    }
    void fill( String color ){
        log( "Filling " + color + " ..." );
    }
    void heal( String thus ){
        log( "Healing " + thus + " ..." );
    }
    void pencil( String stroke ){
        log( "2B " + stroke );
    }
    void text( String msg ){
        log( msg );
    }
    // ...
}
////////////////////////////////////////////////////////////////
// (1) メアリーさんは　火曜日に　家で　手紙を　書きました。
////////////////////////////////////////////////////////////////
// (2) メアリーさんは　水曜日に　学校で　テニスを　しました。
////////////////////////////////////////////////////////////////
// (3) メアリーさんは　木曜日に　喫茶店で　日本人の　友だちに　会いました。
////////////////////////////////////////////////////////////////
// (4) メアリさんは　金曜日に　友だちの　うちで　晩ご飯を　食べました。
////////////////////////////////////////////////////////////////
// (5) メアリさんは　土曜日に　京都で　映画を　見ました。
////////////////////////////////////////////////////////////////
// (6) メアリさんは　日曜日に　デパートで　買い物を　しました。
////////////////////////////////////////////////////////////////
// 2.1.6. Two bodies of mass m1 and m2 are connected by a thread
// that can withstand a tension force T. Forces F1 = at and
// F2 = 2at are applied to the bodies, where a is a constant
// coefficient, t is the time of action of the force. Determine
// at what moment in time the thread will break
////////////////////////////////////////////////////////////////
//               +----+         +----+
//     F2 <------| m2 |---------| m1 |------> F1
//---------------+----+---------+----+------------------------->
// F1(t) - T(t) = m1a(t), a(t) = [F1(t) - T(t)]/m1
// T(t) - F2(t) = m2a(t), a(t) = [T(t) - F2(t)]/m2
// F1(t)m2 - T(t)m2 = T(t)m1 - F2(t)m1 
// F1(t)m2 + F2(t)m1 = T(t)(m1 + m2)
// T(t) = [F1(t)m2 + F2(t)m1]/(m1 + m2) =
//      = (atm2 + 2atm1)/(m1 + m2) = at(m2 + 2m1)/(m1 + m2),
// t = T(m1 + m2)/a(2m1 + m2)                                  «
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
class Facadeshop {
    FileIO fileIO;
    ColorAdjustments colorAdjustments;
    Transform transform;
    Tools tools;
    Facadeshop( FileIO fileIO,
                ColorAdjustments colorAdjustments,
                Transform transform,
                Tools tools ){
        this.fileIO = fileIO;
        this.colorAdjustments = colorAdjustments;
        this.transform = transform;
        this.tools = tools;
    }
    void newfile() {
        fileIO.newfile();
    }
    void open( String path ){
        fileIO.open( path );
    }
    void save() {
        fileIO.save();
    }
    void levels( String range ){
        colorAdjustments.levels( range );
    }
    void scale( int value ){
        transform.scale( value );
    }
    void fill( String color ){
        tools.fill( color );
    }
    void enhance( int factor ){
        transform.scale( factor );
        colorAdjustments.invert();
        colorAdjustments.curves( "~" );
        colorAdjustments.saturation( 10,20,30 );
    }
    void reduce( int factor ){
        colorAdjustments.levels("(25,75)");
        colorAdjustments.brightness( 50 );
        transform.scale( factor );
    }
    void makeFrenchCheese() {
        tools.brush( "Buy cheap Bulgarian cheese" );
        tools.fill( "Forget about it" );
        tools.pencil( "After 2 or 3 weeks it starts smelling" );
        tools.brush( "It's ready!" );
        tools.text( "Voila" );
    }
    public static void main( String args[] ){
        FileIO fileIO = new FileIO();
        ColorAdjustments colorAdjustments = new ColorAdjustments();
        Transform transform = new Transform();
        Tools tools = new Tools();
        Facadeshop facadeshop = new Facadeshop( fileIO,
                                                colorAdjustments,
                                                transform,
                                                tools );
        facadeshop.makeFrenchCheese();
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
