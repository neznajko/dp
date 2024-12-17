# GoF Definition
Tasks flow like rivers,  
The delegee bears the load,  
Calm waters prevail.  

# DiDP Definition
Adapter is a structural design pattern that allows objects 
with incompatible interfaces to collaborate.

Here we go again ***mc adapta*** *vs* **dj selecta**, the
diff between *Proxy*, *Decorator*, and *Adapter* all seems
quite philosophical to me. What association spring into 
your mind the word delegee:), cos in all cases we are messing 
with a delegee here, which is doing the actual work, but in 
different contexts or scenarios

I'm not very good at this stuff, but let's say we have a web 
service based on the SOAP protocol, and a client application 
like a web browser which can send and receives HTTP messages, 
so we want to use a translator that speaks Bochi to handle 
the transaction

```java
////////////////////////////////////////////////////////////////
    Let we have two incompatible   +----------------------+
    interfaces, if we have a REST  |     <<interface>>    |
    client like Firefox, and a     |          SOAP        |
    REST service like              +----------------------+
    Google Translate, we can make  | +ask(client:SOAP,    | rqet
    the transaction, similarly if  |      req:String)     | eus
    we have a SOAP client like     +----------------------+
    Opera( Soap Opera you know ),  | +replay(server:SOAP, | rsos
    and SOAP service like, say     |        (res:String)  | epne
    Microsoft, we have no          +----------------------+
    problems ...
    +----------------------+    , but what if we want to connect
    |    <<interface>>     |    Firefox with Microsoft, then we
    |         REST         |    have a problem cos Microsoft
    +----------------------+    request expect a SOAP client,
    | +get(client:REST,    | rt guess what! of course a delegee
    |      header:String,  | e  on the rescue, we can create an
    |      body:String)    | q  adapter which implements both
    | +post(client:REST,   | u  interfaces and holds a reference
    |       header:String, | e  to the Microsoft service, then on
    |       body:String)   | s  its own Firefox holds a reference
    +----------------------+    to the adapter, and delegates
    | +ok(server:REST,     | ro all requests to it, cos its first
    |     body:String)     | en job was programming binary 
    | +nope(server:REST,   | ss vaporators, and Bochi is like a
    |       body:String)   | pe second language to it
    +----------------------+            
```
