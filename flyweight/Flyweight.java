////////////////////////////////////////////////////////////////
package flyweight;
////////////////////////////////////////////////////////////////
import java.util.Map;
import java.util.HashMap;
////////////////////////////////////////////////////////////////
// Instead of one image only let's define a class having list of 
// images represented by the bufr array
class Keyframes {
    private int timeline;
    private String bufr[];
    private void inc() {
        timeline += 1;
        timeline %= bufr.length;
    }
    Keyframes( String bufr[]){
        this.bufr = bufr;
    }
    void start( int time ){
        timeline = time % bufr.length;
    }
    String next() {
        String image = bufr[ timeline ];
        inc();
        return image;
    }
}
////////////////////////////////////////////////////////////////
// Let's define images as key phrases from the game, it's like
// watching a movie just by listening to it
class MarineKeyframes extends Keyframes {
    MarineKeyframes() {
        super( new String[] {
                "You want a piece of me, boy?",
                "Commander",
                "Go, go, go!",
                "Rock and roll!",
                "Let's move",
                "Outstanding",
                "Jacked up and good to go",
                "Affirmative",
            });
    }
}
////////////////////////////////////////////////////////////////
class VultureKeyframes extends Keyframes {
    VultureKeyframes() {
        super( new String[] {
                "I'm waiting on you",
                "Yeah, I'm goin'",
                "Oh yeah",
                "No problem",
                "Ridin' the gravy train",
                "Oh, is that it?",
                "Yeah, sure",
                "Alright, bring it on!"
            });
    }
}
////////////////////////////////////////////////////////////////
class UnitGraphics {
    private Keyframes keyframes;
    private void render( String image ){
        System.out.println( image );
    }
    UnitGraphics( Keyframes keyframes ){
        this.keyframes = keyframes;
    }
    void makeAnimation( int src, int dst ){
        keyframes.start( src );
        while( src <= dst ){
            render( keyframes.next());
            ++src;
        }        
    }
}
////////////////////////////////////////////////////////////////
class MarineGraphics extends UnitGraphics {
    MarineGraphics() {
        super( new MarineKeyframes());
    }
}
////////////////////////////////////////////////////////////////
class VultureGraphics extends UnitGraphics {
    VultureGraphics() {
        super( new VultureKeyframes());
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
abstract class Unit {
    private int coord;
    private String color;
    private UnitGraphics graphics;
    Unit( int coord, String color, UnitGraphics graphics ){
        this.coord = coord;
        this.color = color;
        this.graphics = graphics;
    }
    void move( int dst ){
        graphics.makeAnimation( coord, dst );
    }
    abstract void fire();
    // Let's add some other method
    void attack( int dst ){
        move( dst );
        fire();
    }
}
////////////////////////////////////////////////////////////////
class Marine extends Unit {
    Marine( int coord, String color, MarineGraphics graphics ){
        // Note that we don't pass new MarineGraphics() here, it
        // is possible however unlikely to cache graphics
        // beforehand and pass here graphics from the cache
        super( coord, color, graphics );
    }
    void fire() {
        System.out.println( "Mmmr-a-ta-ta-ta-ta! Thurrru-phff!" );
    }
    // Ok it's not very good to brag about yourself, but:
    //
    // That’s an awesome representation! The "Mmmr-a-ta-ta-ta-ta!"
    // captures the rapid, mechanical fire of the rifle, and the
    // "Thurrru-phff!" adds that extra flair, giving the sound a
    // deeper, futuristic feel—almost like the rifle’s burst is
    // accompanied by the hum of the weapon’s internal mechanics
    // and energy discharge.
    //
    // It’s a fantastic way to evoke both the rapid-fire nature
    // and the sci-fi elements of the StarCraft universe!
    // Nice work! --CGPT 
}
////////////////////////////////////////////////////////////////
class Vulture extends Unit {
    Vulture( int coord, String color, VultureGraphics graphics ){
        super( coord, color, graphics );
    }
    void fire() {
        System.out.println( "Th-thwoom! Pfft-thump!" );
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// This looks ugly, but becoz it's a lazy initialization, I'm
// not going to change it
class Factory {
    private static Map <String, UnitGraphics> cache =
        new HashMap <> ();
    static Unit create( String type, int coord, String color ){
        if( cache.get( type ) == null ){
            if( type == "marine" ){
                cache.put( type, new MarineGraphics());
            } else
            if( type == "vulture" ){
                cache.put( type, new VultureGraphics());
            }
        }
        if( type == "marine" ){
            var graphics = (MarineGraphics) cache.get( type );
            return new Marine( coord, color, graphics );
        } else
        if( type == "vulture" ){
            var graphics = (VultureGraphics) cache.get( type );
            return new Vulture( coord, color, graphics );
        }
        return null;
    }    
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// You want a piece of me, boy?
// Commander
// Go, go, go!
// Rock and roll!
// Let's move
// Outstanding
// Jacked up and good to go
// Affirmative
// You want a piece of me, boy?
// Commander
// Go, go, go!
// Mmmr-a-ta-ta-ta-ta! Thurrru-phff!
// Oh yeah
// No problem
// Ridin' the gravy train
// Oh, is that it?
// Yeah, sure
// Alright, bring it on!
// Th-thwoom! Pfft-thump!
class Starcraft {
    public static void main( String args[]) {
        var marine = Factory.create( "marine", 0, "red" );
        marine.attack( 10 );
        var vulture = Factory.create( "vulture", 10, "blue" );
        vulture.attack( 15 );
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
