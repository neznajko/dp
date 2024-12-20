# GoF Definition
Silent paths align,  
Shadows cast by fleeting time,  
We are but objects.
#
In general objects from same class share common behavior, but what
if they also share common data? Then we can use the *Flyweight*
pattern. Ok let's take as an example *Marine Unit* from **Starcraft**
```c++
 +----------------+ Here image is an image file loaded into memory,
 |  Marine        | something like BufferedImage in Java. All marines
 +----------------+ from a team have same color, and all marines 
 | -coord         | have same images. Replicating same color usually
 | -color         | is not a problem, but loading same image for 50
 | -image         | marines might be problematic. 
 +----------------+ The simplest solution is to declare image as a
 | +move( dst )   | static immutable field, but in general we want a
 | +fire()        | more structural approach
 +----------------+ 
```

The basic idea is to identify data that is common to all objects,
and split the class into one having unique data and the other having
common stuff. Usually behavior of a class modifies its state, so
if we have an immutable state, why we should put behavior in the
common class, but it might be more convenient to define also some
methods that operate on the common data as well

If we want to introduce other units like a *Vulture*, it might be
better to put all the stuff into interfaces or base classes. Also
this pattern is known as *Cache*, that holds the shared data, so it
might be handy to create a **Factory** as well, say *simple factory*
that holds the cache and creates different units

```java
 +-------------------------+ Here Unit is an abstract class, cos 
 |     <<abstract>>        | move depends only on graphics and is
 |     Unit(Flyweight)     | same for all units. graphics on its
 +-------------------------+ own is a reference to the Heavyweight
 | -coord: int             | object that holds the actual images and
 | -color: String          | methods for rendering the animation
 | -graphics: UnitGraphics |
 +-------------------------+
 | +move( dst )            |
 | +fire()                 |
 +-------------------------+

 +----------------------------+ Let's say here UnitGraphics is a
 |      UnitGraphics          | simple base class, it has a list of 
 +----------------------------+ images and functions for rendering 
 | -images: Image[]           | the animation
 | -render()                  |
 +----------------------------+
 | +makeAnimation( src, dst ) |
 +----------------------------+

 Now we want to have a simple factory that works something like thus:
 Unit marine = Factory.create( "marine", 15, "red" );, where we pass
 unit type, the initial coordinates and the team color. The factory
 will own a cache with UnitGraphics objects, initialized on demand,
 that is a lazy initialization, and will pass them in the concrete
 Unit constructor

 +------------------------+
 |       UnitFactory      |
 +------------------------+
 | -cache: UnitGraphics[] |
 +------------------------+
 | +create()              |
 +------------------------+,

 so basically we have this relationships:

 +-------------+        +--------------+          +------+
 | UnitFactory |<>------| UnitGraphics |<---------| Unit |
 +-------------+        ^--------------^          ^------^
                        |              |          |      |
 +----------------+-----+              |          |      |
 | MarineGraphics |                    |        +---+  +---+
 +----------------++-------------------+        | M |  | V |
 | VultureGraphics |                            | a |  | u |
 +-----------------+                            | r |  | l |
                                                | i |  | t |
                                                | n |  | u |
                                                | e |  | r |
                                                +---+  | e |
                                                       +---+
```