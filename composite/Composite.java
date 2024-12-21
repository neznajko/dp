////////////////////////////////////////////////////////////////
package composite;
////////////////////////////////////////////////////////////////
import java.util.Map;
import java.util.HashMap;
////////////////////////////////////////////////////////////////
interface Node {
    int size();
}
////////////////////////////////////////////////////////////////
class Directory implements Node {
    private Map <String,Node> map;
    Directory() {
        map = new HashMap <> ();
    }
    Node put( String name, Node node ){
        map.put( name, node );
        return node;
    }
    @Override
    public int size() {
        int directorySize = 0;
        for( Node node: map.values()){
            directorySize += node.size();
        }
        return directorySize;
    }
}
////////////////////////////////////////////////////////////////
class File implements Node {
    private int fileSize;
    File( int fileSize ){
        this.fileSize = fileSize;
    }
    @Override
    public int size() {
        return fileSize;
    }
}
////////////////////////////////////////////////////////////////
// + root/
//   - log( 15 )
//   + sounds/
//     - space_adventure.wav( 36 )
//     + ambience/
//       - glitch.mp3( 65 )
class Composite {
    public static void main( String args[] ){
        Directory root = new Directory();
        root.put( "log", new File( 15 ));
        Directory sounds = (( Directory )root
                            .put( "sounds", new Directory()));
        sounds.put( "space_adventure.wav", new File( 36 ));
        Directory ambience = (( Directory )sounds
                              .put( "ambience", new Directory()));
        ambience.put( "glitch.mp3", new File( 65 ));
        System.out.println( root.size() ); // 116
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// Q: メアリーさんは 火曜日に 音楽を 聞きましたか。
// A: いいえ、聞きませでした。
////////////////////////////////////////////////////////////////
// Q: メアリーさんは 水曜日に 手紙を 書きましたか。
// A: いいえ、書きませんでした。
////////////////////////////////////////////////////////////////
// Q: メアリーさんは 木曜日に 日本人の 友だちに 会いましたか。
// A: はい、会いました。
////////////////////////////////////////////////////////////////
// Q: メアリーさんは 金曜日に お寺に 行きましたか。
// A: いいえ、行きませんでした。
////////////////////////////////////////////////////////////////
// Q: メアリーさんは 土曜日に テニスを しましたか。 
// A: いいえ、しませんでした。
////////////////////////////////////////////////////////////////
// Q: メアリーさんは 日曜日に 買い物を しましたか。
// A: はい、しました。
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// 2.1.7. To measure the mass of an astronaut on an orbital
// station, a movable seat of known mass m0, attached to a
// spring, is used. With the same initial deformation
// (compression) of the spring, the empty seat returns to its
// original position after a time t0, but if there is an
// astronaut on the seat, after a time t > t0. What is the mass
// of the astronaut?
////////////////////////////////////////////////////////////////
// This looks quite complicated, if we have a spring in ideal
// scenario it will oscillate forever, but because of friction
// eventually it will return to the initial undeformed state.
// But I don't think this is meant here, we don't need even to
// consider friction or whatever, not to mention that it
// depends on the mass, t here is simply the time of travel from
// point B to point A:                /              .
//                          *        /             * 
//  .   *                           /                        .
//                    .            /            
// ==========|            A       /     B/\/\/\/\|==============
// -------------------------------------------------------------
//    S    P    A    C    E    S    T    A    T    I    O    N
// 
// They don't say what is happening with the astronaut after
// point A, but let's hope everything is Ok. The motion between
// B and A is not simple because the force of the spring is
// changing with the compression and is not constant, same goes
// for the acceleration. Let's have thus motion:
//
// v                            Here the acceleration in the
// e       V2               `   intervals [t0,t1] and [t1,t2] is
// l                       `    constant and equal respectively
// o                      `     to a1 = (V1-V0)/(t1-t0) and         
// c                     `      a2 = (V2-V1)/(t2-t1), if t2-t1 =   
// i                    `       t1-t0 =: dt we can consider a
// t                   `        motion with same acceleration in
// y       V1        .`         the whole interval [t0,t2]:
//                . `           a = V2-V0/t2-t0 = V2-V1+V1-V0/2dt 
//         V0 . `               = (a1+a2)/2, that is the mean
//                              acceleration                    
//   ---------t0-----t1-----t2------------------------time------
////////////////////////////////////////////////////////////////
// For certain questions like time of travel we can effectively
// replace complex motion having acceleration changing with time
// with a simple motion having constant acceleration equal to
// its mean. So here cos in both cases we have same compression
// the force of the spring will be the same and we can write:
// m0a0 = (m + m0)a ~ x, where a0 and a are the mean
// accelerations, m is the mass of the astronaut and x is the
// compression, also cos a0 and a are constant, we have:
// x = a0t0^2/2 = at^2/2, zoooooo
// a0/a = (m + m0)/m0 = m/m0 + 1
// a0/a = t^2/t0^2, from here we can write for the mass of the
// astronaut: m = m0((t/t0)^2 - 1)                             «
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
