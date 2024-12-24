# GoF Definition
Leaves float in the breeze,  
The autumn song notifies,  
Nature's soft retreat.  
#
```java
    interface Observer {
        void update( Event event );
    }
```
```c#
    interface Subject {
        void subscribe( Observer observer );
        void unsubscribe( Observer observer );
        void notifyAll( Event event );
    }
```
This is the famous **Observer Pattern**, having the *Observer
Pattern* in your arsenal is like having a blaster! It doesn't need
a lot of explanation, cos everybody are aware of it, but usually
the *Subject* is a figure of some importance, and the states of
many *Observers*, depend on it. Think about *YouTube* or *Instagram*,
where you have subscribed to some famous pop star, and whenever she
post some sexy picture your feed has been updated

*Subject* and *Observer* are usually interfaces that allow an
observer to subscribe to a subject and the subject to update the
state of the observers. The concrete implementation of Subject
will have an internal list of subscribers, pushing and popping
them in the *subscribe/unsubscribe* methods, while *notify*
will call the *update* method of all subscribers

Let's as an example look at the game of Chess, we can think of board
squares as subjects and at chess pieces as observers. If we have a
Black Rook on e4,
```ruby
 +---+---+---+---+---+---+---+---+
 |   |   |   |   | + |   |   |   | 8
 +---+---+---+---+---+---+---+---+
 |   |   |   |   | + |   |   |   | 7 
 +---+---+---+---+---+---+---+---+
 |   |   |   |   | + |   |   |   | 6
 +---+---+---+---+---+---+---+---+
 |   |   |   |   | + |   |   |   | 5
 +---+---+---+---+---+---+---+---+
 | + | + | + | + | r | + | + | + | 4
 +---+---+---+---+---+---+---+---+
 |   |   |   |   | + |   |   |   | 3
 +---+---+---+---+---+---+---+---+
 |   |   |   |   | + |   |   |   | 2
 +---+---+---+---+---+---+---+---+
 |   |   |   |   | + |   |   |   | 1
 +---+---+---+---+---+---+---+---+
   a   b   c   d   e   f   g   h
 ```

it controls all squares marked with +, but if a White Bishop lands
on c4,

```c++
 +---+---+---+---+---+---+---+---+
 |   |   |   |   | + |   |   |   | 8
 +---+---+---+---+---+---+---+---+
 |   |   |   |   | + |   |   |   | 7 
 +---+---+---+---+---+---+---+---+
 |   |   |   |   | + |   |   |   | 6
 +---+---+---+---+---+---+---+---+
 |   |   |   |   | + |   |   |   | 5
 +---+---+---+---+---+---+---+---+
 |   |   | B | + | r | + | + | + | 4
 +---+---+---+---+---+---+---+---+
 |   |   |   |   | + |   |   |   | 3
 +---+---+---+---+---+---+---+---+
 |   |   |   |   | + |   |   |   | 2
 +---+---+---+---+---+---+---+---+
 |   |   |   |   | + |   |   |   | 1
 +---+---+---+---+---+---+---+---+
   a   b   c   d   e   f   g   h
 ```

the rook will loose control over a4 and b4 squares, so pieces can
subscribe to all squares they control, and whenever something lands
on them, the corresponding square will notify all subscribed pieces
to update their states

