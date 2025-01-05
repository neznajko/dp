# GoF Definition
**Avoid coupling the sender of a request to its receiver by giving
more than one object a chance to handle the request. Chain the
receiving objects and pass the request along the chain until an
object handles it.**

In the previous pattern for simplicity I have omitted, the
*Component* from the *Mediator* interface definition:
```java
    interface Mediator {
        void notify( Event e );
    }
```
it is actually:
```c++
   interface Mediator {
        void notify( Component sender, Event event);
   }
```
so every component has a mediator and interacts with the system
by calling:
```bash
    mediator.notify( this, "boom" );
```
the *notify* body will look something like:
```python
    if( sender instanceof CheckThisOut and event = "boom" ):
        // do some stuff
    elif( sender instance of MuaHaHaHa and event = "haha" ):
        // ...
    ...
```
With or without notify having a sender as an argument the mediator
is not aware to which receiver it should handle the transaction so
it goes in a long list of if else statements. The *Chain of
Responsibility Pattern( CoR )* replaces the if .. else statements
with *oneliner*, something like:
```c#
    ahead.handle( request )
```
where each if else block is replaced with a linked list node
implementing the handle method. From that point of view *CoR* is
an improved version of the *Mediator Pattern*, which might be an
overstatement of course, cos with the design patterns you always
have these philosophical nuances, what is the intend, what is the
context; whatever here is the *Handler* class:
```java
    abstract class Handler {
        protected Handler next;
        void setNextHandler( Handler next ){
            this.next = next;
        }
        abstract void handleRequest( Request request );
    }
```
