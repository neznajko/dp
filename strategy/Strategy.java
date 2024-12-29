////////////////////////////////////////////////////////////////
package strategy;
////////////////////////////////////////////////////////////////
interface Skill {
    void themAll();
}
////////////////////////////////////////////////////////////////
abstract class Singer implements Skill {
    abstract void sing();
    @Override
    public void themAll() {
        sing();
    }        
}
////////////////////////////////////////////////////////////////
class OperaSinger extends Singer {
    @Override
    public void sing() {
        System.out.println( "O-o-o..." );
    }
}
////////////////////////////////////////////////////////////////
abstract class Dancer implements Skill {
    abstract void dance();
    @Override
    public void themAll() {
        dance();
    }        
}
////////////////////////////////////////////////////////////////
class WaltzDancer extends Dancer {
    @Override
    public void dance() {
        System.out.println( "1-2-3 1-2-3 ..." );
    }
}
////////////////////////////////////////////////////////////////
class Artist {
    Skill skill;
    void setSkill( Skill skill ){
        this.skill = skill;
    }
    void perform() {
        skill.themAll();
    }
    // O-o-o...
    // 1-2-3 1-2-3 ...
    public static void main( String args[]) {
        Artist artist = new Artist();
        artist.setSkill( new OperaSinger());
        artist.perform();
        artist.setSkill( new WaltzDancer());
        artist.perform();
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////