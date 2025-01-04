# GoF Definition
**Define an object that encapsulates how a set of objects interact. 
Mediator promotes loose coupling by keeping objects from referring 
to each other explicitly, and it lets you vary their interaction 
independently.**

In *OOP* except *Design Patterns* there are also Object-Oriented
Design (*OOD*) Principles. Five of them are grouped in the acronym
***SOLID***. Previously in the *Decorator Pattern* we have covered
the ***O**pen-Closed* principle, now we are about to cover the
***D**ependency Inversion* principle. Don't know why they pick
such names, not to mention that ***I*** stands for
***I**nversion Segregation Principle!*

Let's consider a simple relation between objects:
```c++
    +---+ has reference to +---+
    | A |----------------->| B |
    +---+                  +---+

    class B {
    }
    class A {
        B ref;
    }
```
In a system of many objects this dependencies can be represented as
a graph:
```java
   +---+---------->---+     A has references to B and C
   |   |          | B |     B has reference to C
   | A |          +---+
   |   |          |
   +---+------>---V
              | C |
              +---+
```
The *Dependency Inversion Principle*, states that classes should
depend on interfaces rather than concrete implementations, cos
relying on specific classes makes the code harder to reuse in
different contexts, and challenging to extend without modifying it

So having references to concrete classes violates this principle,
and the *Mediator Pattern* solves this, by introducing a *controller*
interface that mediates the relationships between elements in a
system. Now every element has a reference to only one mediator
object:
```c++
    +---------------+   The concrete Controller has references
    |  Controller   |   to all A, B and C. All A, B and C have
    ^---+-^---+-^---+   only one reference to the Controller
    |   | |   | |   |
    |   | |   | |   |
    +---v +---v +---v
    | A | | B | | C |
    +---+ +---+ +---+
```
The *Mediator* interface will look something like this:
```java
    interface Mediator {
        void notify( Event e );
    }
```
And it looks much like the *Observer Pattern*. The one difference
I can think of is that in a system without *Mediator Pattern* the
elements have many-to-many relations, and the mediator establishes
one-to-many relations, which is the *Observer Pattern*, but in the
*Observer Pattern* the observers might not be part of a system and
in general independent of each other
