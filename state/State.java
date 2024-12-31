////////////////////////////////////////////////////////////////
package state;
////////////////////////////////////////////////////////////////
class TV {
    static void stream( String video ){
        System.out.println( video );
    }
}
////////////////////////////////////////////////////////////////
interface Formation {
    String name();
    Formation regroup( boolean winning );
}
////////////////////////////////////////////////////////////////
class ManUnited_A implements Formation {
    @Override
    public String name() {
        return "Attacking formation Red Blade";
    }
    @Override
    public Formation regroup( boolean winning ){
        if( winning ){
            return new ManUnited_D();
        } else {
            return this;
        }
    }
}
////////////////////////////////////////////////////////////////
class ManUnited_B implements Formation {
    @Override
    public String name() {
        return "Balanced formation The Shield Wall";
    }
    @Override
    public Formation regroup( boolean winning ){
        if( winning ){
            return new ManUnited_D();
        } else {
            return new ManUnited_A();
        }
    }
}
////////////////////////////////////////////////////////////////
class ManUnited_D implements Formation {
    @Override
    public String name() {
        return "Defensive formation The Fortress";
    }
    @Override
    public Formation regroup( boolean winning ){
        if( winning ){
            return new ManUnited_B();
        } else {
            return new ManUnited_A();
        }
    }
}
////////////////////////////////////////////////////////////////
class Barcelona_A implements Formation {
    @Override
    public String name() {
        return "Attacking formation The Symphony";
    }
    @Override
    public Formation regroup( boolean winning ){
        if( winning ){
            return new Barcelona_D();
        } else {
            return this;
        }
    }
}
////////////////////////////////////////////////////////////////
class Barcelona_B implements Formation {
    @Override
    public String name() {
        return "Balanced formation The Chessboard";
    }
    @Override
    public Formation regroup( boolean winning ){
        if( winning ){
            return new Barcelona_D();
        } else {
            return new Barcelona_A();
        }
    }
}
////////////////////////////////////////////////////////////////
class Barcelona_D implements Formation {
    @Override
    public String name() {
        return "Defensive formation The Wall of Camp Nou";
    }
    @Override
    public Formation regroup( boolean winning ){
        if( winning ){
            return new Barcelona_B();
        } else {
            return new Barcelona_A();
        }
    }
}
////////////////////////////////////////////////////////////////
class Team {
    private final String name;
    private Formation formation;
    Team( String name, Formation formation ){
        this.name = name;
        this.formation = formation;
    }
    String getName() {
        return name;
    }
    void play() {
        TV.stream( name + " playing " + formation.name());
    }
    void regroup( boolean winning ){
        formation = formation.regroup( winning );
    }
}
////////////////////////////////////////////////////////////////
class ManUnited extends Team {
    ManUnited() {
        super( "Man United", new ManUnited_B());
    }
}
////////////////////////////////////////////////////////////////
class Barcelona extends Team {
    Barcelona() {
        super( "Barcelona", new Barcelona_A());
    }
}
////////////////////////////////////////////////////////////////
class Game {
    private int time;
    private Team home;
    private Team away;
    private int score[];
    private int rand( int min, int max ){
        return ( int )( Math.random() * ( max - min + 1 )) + min;
    }
    private int nextGoal() {
        return rand( 10, 45 );
    }
    Game( Team home, Team away ){
        time = 0;
        this.home = home;
        this.away = away;
        score = new int[] { 0, 0 };
    }
    String getMinute() {
        return time + " min: ";
    }
    void scoreGoal() {
        ++score[( int )( Math.random() * 2 )];
    }
    String getScore() {
        return String.format( "%d - %d", score[ 0 ], score[ 1 ]);
    }
    void play() {
        TV.stream( home.getName() + " vs " + away.getName());
        try {
            while( true ){
                home.play();
                away.play();
                int sleep = nextGoal();
                time += sleep;
                if( time > 90 ){
                    break;
                }
                Thread.sleep( sleep * 10 );
                scoreGoal();
                boolean winning = score[ 0 ] > score[ 1 ];
                home.regroup( winning );
                away.regroup( !winning );
                TV.stream( "Goal! " + getMinute() + getScore());
            }
        } catch( InterruptedException e ){
        }
        TV.stream( "Final Score " + getScore());
    }        
}
////////////////////////////////////////////////////////////////
// Man United vs Barcelona
// Man United playing Balanced formation The Shield Wall
// Barcelona playing Attacking formation The Symphony
// Goal! 32 min: 0 - 1
// Man United playing Attacking formation Red Blade
// Barcelona playing Defensive formation The Wall of Camp Nou
// Goal! 60 min: 1 - 1
// Man United playing Attacking formation Red Blade
// Barcelona playing Balanced formation The Chessboard
// Goal! 89 min: 1 - 2
// Man United playing Attacking formation Red Blade
// Barcelona playing Defensive formation The Wall of Camp Nou
// Final Score 1 - 2
class State {
    public static void main( String args[] ){
        var ManUnited = new ManUnited();
        var Barcelona = new Barcelona();
        var game = new Game( ManUnited, Barcelona );
        game.play();
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
