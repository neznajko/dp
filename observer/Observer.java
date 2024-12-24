////////////////////////////////////////////////////////////////
package observer;
////////////////////////////////////////////////////////////////
import java.util.HashSet;
import java.util.Set;
////////////////////////////////////////////////////////////////
interface Observer {
    void update( String event );
}
////////////////////////////////////////////////////////////////
interface Subject {
    void subscribe( Observer observer );
    void unsubscribe( Observer observer );
    void notifyall( String event );
}
////////////////////////////////////////////////////////////////
class Times implements Subject {
    Set <Observer> observers = new HashSet <> ();
    @Override
    public void subscribe( Observer observer ){
        observers.add( observer );
    }
    @Override
    public void unsubscribe( Observer observer ){
        observers.remove( observer );
    }
    @Override
    public void notifyall( String news ){
        for( Observer observer: observers ){
            observer.update( news );
        }
    }
    void publish( String headline, String text ){
        String news = String.format( " %s\n%s", headline, text );
        notifyall( news );
    }
}
////////////////////////////////////////////////////////////////
class DoctorWatson implements Observer {
    public void update( String news ){
        System.out.println( "Holmes, you must hear this..." );
        System.out.println( news );
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// Holmes, you must hear this...
//  Murder in West Kensington
// [E]duardo Lucas, a 34-year-old married man and well-known
// businessman, was found dead in his home in West Kensington
// last night... Inspector Lestrade has been appointed to
// lead the investigation, authorities are looking into both
// personal and professional motives.
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
class SherlockHolmes {
    public static void main( String args[] ){
        Times times = new Times();
        times.subscribe( new DoctorWatson());
        times.publish( "Murder in West Kensington", """
        [E]duardo Lucas, a 34-year-old married man and well-known 
        businessman, was found dead in his home in West Kensington 
        last night... Inspector Lestrade has been appointed to
        lead the investigation, authorities are looking into both 
        personal and professional motives.""" );
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
