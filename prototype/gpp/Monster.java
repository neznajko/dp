////////////////////////////////////////////////////////////////
package prototype.gpp;
////////////////////////////////////////////////////////////////
interface Monster {
    Monster clone();
}
////////////////////////////////////////////////////////////////
class Ghost implements Monster {
    int health;
    Ghost( int health ){
        this.health = health;
    }
    public Ghost clone() {
        return new Ghost( health );
    }
}
////////////////////////////////////////////////////////////////
class Spawner {
    Monster prototype;
    Spawner( Monster prototype ){
        this.prototype = prototype;
    }
    Monster spawn() {
        return prototype.clone();
    }    
}
////////////////////////////////////////////////////////////////
class Prototype {
    public static void main( String args[] ){
        Spawner spawner = new Spawner( new Ghost( 50 ));
        Ghost ghost = ( Ghost )spawner.spawn();
        System.out.println( ghost.health );
    }
    // Output: 50
}
////////////////////////////////////////////////////////////////
