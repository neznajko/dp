////////////////////////////////////////////////////////////////
package bridge;
////////////////////////////////////////////////////////////////
import static java.lang.System.out;
////////////////////////////////////////////////////////////////
interface Platform {
    void fillRect( int x, int y, int w, int h, String color );
    void renderText( String text );
    // ..
}
////////////////////////////////////////////////////////////////
class X11 implements Platform {
    @Override
    public void fillRect( int x, int y, int w, int h, String color ){
        String rect = String.format
            ( "{%d,%d,%d,%d}:%s", x, y, w, h, color );
        out.println( rect );
    }
    @Override
    public void renderText( String text ){
        out.println( "[" + text + "]" );
    }
    // ..
}
////////////////////////////////////////////////////////////////
class Qt implements Platform {
    @Override
    public void fillRect( int x, int y, int w, int h, String color ){
        String rect = String.format
            ( "%s: [%d,%d] @ [%d,%d]", color, w, h, x, y );
        out.println( rect );
    }
    @Override
    public void renderText( String text ){
        out.println( "(" + text + ")" );
    }
    // ..
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
abstract class DesktopEnvironment {
    protected Platform platform;
    DesktopEnvironment( Platform platform ){
        this.platform = platform;
    }
    void closeWindow() {
        platform.renderText( "X" );
    }
    abstract void launchStartMenu();
    abstract void openFileBrowser();
}
////////////////////////////////////////////////////////////////
class GNOME extends DesktopEnvironment {
    GNOME( Platform platform ){
        super( platform );
    }
    @Override
    public void launchStartMenu() {
        platform.renderText( "GNOME Start Menu" );
        platform.fillRect( 0, 100, 10, 40, "dark gray");
    }
    @Override
    public void openFileBrowser() {
        platform.renderText( "Nautilus" );
        platform.fillRect( 10, 20, 50, 30, "gray");
        platform.fillRect( 20, 20, 20, 30, "light gray");
    }
}
////////////////////////////////////////////////////////////////
class KDE extends DesktopEnvironment {
    KDE( Platform platform ){
        super( platform );
    }
    @Override
    public void launchStartMenu() {
        platform.renderText( "KDE Start Menu" );
        platform.fillRect( 10, 80, 20, 60, "light blue");
    }
    @Override
    public void openFileBrowser() {
        platform.renderText( "Dolphin" );
        platform.fillRect( 18, 25, 60, 30, "light gray");
        platform.fillRect( 25, 25, 70, 40, "dark blue");
    }
}
////////////////////////////////////////////////////////////////
// [GNOME Start Menu]
// {0,100,10,40}:dark gray
// [Nautilus]
// {10,20,50,30}:gray
// {20,20,20,30}:light gray
// [X]
// (KDE Start Menu)
// light blue: [20,60] @ [10,80]
// (Dolphin)
// light gray: [60,30] @ [18,25]
// dark blue: [70,40] @ [25,25]
// (X)
////////////////////////////////////////////////////////////////
class Debian {
    DesktopEnvironment desktop;
    Debian( DesktopEnvironment desktop ){
        this.desktop = desktop;
    }
    void startup() {
        desktop.launchStartMenu();
        desktop.openFileBrowser();
    }
    void shutdown() {
        desktop.closeWindow();
    }
    public static void main( String args[] ){
        Debian debian = new Debian( new GNOME( new X11()));
        debian.startup();
        debian.shutdown();
        debian = new Debian( new KDE( new Qt()));
        debian.startup();
        debian.shutdown();
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
