////////////////////////////////////////////////////////////////
package mediator;
////////////////////////////////////////////////////////////////
class Event {
    private String key;
    private int value;
    Event( String key, int value ){
        this.key = key;
        this.value = value;
    }
    Event( String key ){
        this( key, 0 );
    }
    String key() {
        return key;
    }
    int value() {
        return value;
    }
}
////////////////////////////////////////////////////////////////
interface Controller {
    void notify( Event event );
}
////////////////////////////////////////////////////////////////
// Bumper hit gives 10 points, if three Bumpers are hit, Chute's
// flag is raised. Chute loop gives 200 points if the flag is
// raised, otherwise 100.
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
class Flipper implements Controller {
    private Bumper bumper;
    private Chute chute;
    private Score score;
    Flipper(){
        bumper = new Bumper( this );
        chute = new Chute( this );
        score = new Score();
    }
    @Override
    public void notify( Event event ){
        if( event.key() == "activate" ){
            chute.activate();
        } else
        if( event.key() == "score" ){
            score.inc( event.value());
        }
    }
    void play() {
        bumper.hit(); // Bumper hit 1     Score 10
        bumper.hit(); // Bumper hit 2     Score 20
        chute.loop(); // Chute loop       Score 120
        bumper.hit(); // Bumper hit 3     Score 130
        chute.loop(); // Chute loop *     Score 330
    }
}
////////////////////////////////////////////////////////////////
class Bumper {
    private Controller controller;
    private int counter;
    private void inc() {
        counter += 1;
        counter %= 3;
    }
    Bumper( Controller controller ){
        this.controller = controller;
        counter = 0;
    }
    void hit() {
        System.out.print( "Bumper hit " + ( counter + 1 ));
        inc();
        if( counter == 0 ){
            controller.notify( new Event( "activate" ));
        }
        controller.notify( new Event( "score", 10 ));
    }
}
////////////////////////////////////////////////////////////////
class Chute {
    private Controller controller;
    private boolean flag;
    Chute( Controller controller ){
        this.controller = controller;
        flag = false;
    }
    void activate() {
        flag = true;
    }
    void loop() {
        System.out.print( "Chute loop" );
        int score = 100;
        if( flag ){
            System.out.print( " *" );
            flag = false;
            score *= 2;
        }
        controller.notify( new Event( "score", score ));
    }
}
////////////////////////////////////////////////////////////////
class Score {
    private int value = 0;
    void inc( int value ){
        this.value += value;
        System.out.println( "\t Score " + this.value );
    }
}
////////////////////////////////////////////////////////////////
class Mediator {
    public static void main( String args[]){
        Flipper flipper = new Flipper();
        flipper.play();
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////

