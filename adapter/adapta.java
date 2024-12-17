////////////////////////////////////////////////////////////////
package adapter;
////////////////////////////////////////////////////////////////
import static java.lang.System.out;
////////////////////////////////////////////////////////////////
import java.util.Map;
import java.util.HashMap;
////////////////////////////////////////////////////////////////
// So the idea of this pattern is to make a comunication between
// interfaces that don't know anything about each other, so lets
// try to build separately REST and SOAP applications
////////////////////////////////////////////////////////////////
interface RestService {
    void get( String body );
    void put( String body );
}
////////////////////////////////////////////////////////////////
class GoogleTranslate implements RestService {
    String translate( String text ){
        return new StringBuilder( text ).reverse().toString();
    }
    @Override
    public void get( String body ){
        out.println( "ONE CAN NOT SIMPLY USE GOOGLE TRANSLATE!" );
        out.println( translate( body ));
    }
    @Override
    public void put( String body ){
        out.println( "SERVICE NOT IMPLEMENTED!" );
    }
}
////////////////////////////////////////////////////////////////
interface RestClient {
    void connect( RestService service );
    void request( String method, String body );
}
////////////////////////////////////////////////////////////////
class Firefox implements RestClient {
    RestService service;
    @Override
    public void connect( RestService service ){
        this.service = service;
    }
    @Override
    public void request( String method, String body ){
        if( method == "get" ){
            service.get( body );
        } else
        if( method == "put" ){
            service.put( body );
        }
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// ONE CAN NOT SIMPLY USE GOOGLE TRANSLATE!
// aHah
// SERVICE NOT IMPLEMENTED!
class RestTest {
    public static void main( String args[]) {
        GoogleTranslate googleTranslate = new GoogleTranslate();
        Firefox firefox = new Firefox();
        firefox.connect( googleTranslate );
        firefox.request( "get", "haHa" );
        firefox.request( "put", "boom" );
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
interface SoapService {
    void send( String msg );
}
////////////////////////////////////////////////////////////////
class Microsoft implements SoapService {
    @Override
    public void send( String msg ){
        out.printf( "<check>%s</check>\n", msg );
        out.println( "Microsoft check 1 2 3 ..." );
    }
}
////////////////////////////////////////////////////////////////
interface SoapClient {
    void establishConnection( SoapService service );
    void makeRequest( String request );
}
////////////////////////////////////////////////////////////////
class Opera implements SoapClient {
    SoapService service;
    @Override
    public void establishConnection( SoapService service ){
        this.service = service;
    }
    @Override
    public void makeRequest( String request ){
        service.send( "<Opera>" + request + "</Opera>" );
    }
}
////////////////////////////////////////////////////////////////
// <check><Opera><download>Game Of Thrones</download></Opera></check>
// Microsoft check 1 2 3 ...
class SoapTest {
    public static void main( String args[]) {
        Microsoft microsoft = new Microsoft();
        Opera opera = new Opera();
        opera.establishConnection( microsoft );
        opera.makeRequest( "<download>Game Of Thrones</download>" );
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// Now we want to make a comunication between Firefox and
// Microsoft
////////////////////////////////////////////////////////////////
class MCAdapta implements SoapClient {
    SoapService service;
    @Override
    public void establishConnection( SoapService service ){
        this.service = service;
    }
    @Override
    public void makeRequest( String request ){
        service.send( "<firefox>" + request + "</firefox>" );
    }
}
////////////////////////////////////////////////////////////////
class MCFirefox extends Firefox {
    MCAdapta mcadapta = new MCAdapta();
    void connect( SoapService service ){
        mcadapta.establishConnection( service );
    }
    @Override
    public void request( String method, String body ){
        if( method == "get" ){
            mcadapta.makeRequest( "<mbody>"+body+"</mbody>" );
        } else
        if( method == "put" ){
            mcadapta.makeRequest( "<wow>THUS US!</wow>" );
        }           
    }
}
////////////////////////////////////////////////////////////////
// <check><firefox><mbody>what?</mbody></firefox></check>
// Microsoft check 1 2 3 ...
// <check><firefox><wow>THUS US!</wow></firefox></check>
// Microsoft check 1 2 3 ...
class AdaptaTest {
    public static void main( String args[]) {
        Microsoft microsoft = new Microsoft();
        MCFirefox firefox = new MCFirefox();
        firefox.connect( microsoft );
        firefox.request( "get", "what?" );
        firefox.request( "put", "oo" );
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
