////////////////////////////////////////////////////////////////
package proxy;
////////////////////////////////////////////////////////////////
import java.util.Map;
import java.util.HashMap;
////////////////////////////////////////////////////////////////
interface KeyValueStore {
    void put( String key, int value );
    Integer get( String key );
}
////////////////////////////////////////////////////////////////
class DynamoDB implements KeyValueStore {
    Map <String,Integer> store = new HashMap <> ();
    @Override
    public void put( String key, int value ){
        // simulate some delay
        try {
            Thread.sleep( 1500 );
        } catch( InterruptedException e ){
            e.printStackTrace();
        }
        store.put( key, value );
    }
    @Override
    public Integer get( String key ){
        try {
            Thread.sleep( 1000 );
        } catch( InterruptedException e ){
            e.printStackTrace();
        }
        return store.get( key );
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
class Proxy implements KeyValueStore {
    DynamoDB dynamo = new DynamoDB();
    Map <String,Integer> cache = new HashMap <> ();
    @Override
    public void put( String key, int value ){
        long start = System.currentTimeMillis();
        dynamo.put( key, value );
        long finish = System.currentTimeMillis();
        System.out.println( "> " + ( finish - start ));
    }
    @Override
    public Integer get( String key ){
        long start = System.currentTimeMillis();
        Integer value;
        if( cache.containsKey( key )){
            value = cache.get( key );
        } else {
            value = dynamo.get( key );
            cache.put( key, value );
        }
        long finish = System.currentTimeMillis();
        System.out.println( "< " + ( finish - start ));
        return value;
    }
    public static void main( String [] args ){
        Proxy proxy = new Proxy();
        proxy.put( "boom", 2 );
        proxy.get( "boom" );
        proxy.put( "haha", 4 );
        proxy.get( "boom" );
        // Output:
        // > 1500
        // < 1000
        // > 1501
        // < 0
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
