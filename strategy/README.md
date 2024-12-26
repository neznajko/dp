# GoF Definition
Gray skies softly snow,  
Flakes encapsulate the ground,  
Cold yet full of warmth.  
#
In the art of surviving one of the most valuable skills is to be
adaptable, as we all know it's not good to be static in a dynamic
environment. If we want to model a realistic scenario using *OOP*,
we might have a problem, becos whenever we define our objects to 
implement a given interface, their bahaviour is fixed and can never
change; the dog will always bark and the bird will always sing

Le'ts look at the scenario of *the traveling artist* aka ***TTA***.
An artist travels from town to town and gives performances. We can
start modeling this example by first writing its interface:
```c#
    interface Artist {
        void perform();
    }
```
Next, there are many different talents, an artist can have,
like singing, dancing, playing music etc., so we might need to
define a bunch of additional interfaces as well:
```java
    interface Singer {
        void sing();
    }
    interface Dancer {
        void dance();
    }
    // ...
```
Having the above stuff, we would describe an artist who sing songs,
with something like thus:
```java
    abstract class SingingArtist implements Singer, Artist {
        abstract void sing();
        @Override
        void perform() {
            sing();
        }
    }
    class OperaArtist extends SingingArtist {
        @Override
        void sing() {
            System.out.println( "O-o-o..." );
        }
    }
```

Everything at the moment works well, but it might turns out
however, that some towns, in our Kingdom, prefer dancing than
singing performances, or there are too many singers out there,
or whatever, so people start developing multiple skills, and
depending on the town make different performances. With the
above approach we can handle couple of skills by presenting an
interface like SingingAndDancingArtist, but if the artist is
very ambitious and start preaching and telling jokes, the things
might get out of control very fast.

Q: Is it the same saying *the bird can fly* and *the bird has the
ability to fly*?

A: Probably yes, if we want to describe or characterize a bird,
but in terms of class representation it's very different. A class
describes an object as number of features, that defines it's state,
and behaviors or methods that change that state. For example a point
has coordinates *x* and *y* and method *translate* that changes them.
In the first case fly is a behavior, a method that can change
bird's location, in the second case the ability to fly is a feature,
a part of the state that can be changed.

So if we want to change behaviors we have to represent them
as features. And instead of having a
SingingAndDancingArtistThatPreachesAndTellsJokes from town to town
depending on the circumstances, we can define an ability interface
say:
```java
    interface Skill {
        void themAll();
    }
    // with concrete Skills:
    abstract class Singer implements Skill {
        abstract void sing();
        @Override
        void themAll() {
            sing();
        }
    }
    abstract class Dancer implements Skill {
        abstract void dance();
        @Override
        void themAll() {
            dance();
        }
    }
    // ..
```
Now we can modify the Artist interface into an Artist class that will
own a Skill object:
```c#
    class Artist {
        Skill skill;
        void setSkill( Skill skill ){
            this.skill = skill;
        }
        void perform() {
            skill.themAll();
        }
    }            
```
Then moving from town to town the artist can change its performance
dynamically by using the method *setSkill*
