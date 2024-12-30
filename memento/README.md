# GoF Definition
Frost on the window,  
"ILoYeU" drawn in shaky lines,  
Hands pause, then fall.  
#
In the *Command Pattern* we've mentioned about *snapshots* as an
alternative solution for undoing commands. But if you've made
one brush stroke, why should remember the state of the whole
system? However we may take individual snapshots only to elements
being changed, like the current Layer object and use the *Memento
**aka** Snapshot* pattern to save and restore their states

The difference between this pattern and the *Prototype **aka**
Clone* pattern, is that here we don't create new objects, just
restoring objects' states. This is not always possible thought, cos
there might be cases, when we deal with very complex objects,
consisting of other complex objects, with cycle links and .. I mean
complicated stuff. In this scenarios saving and restoring states
is basically impractical if not impossible

Tha-dha-mmm, here are the actors:
 1. *Originator*, what a name, this is the object whose state
 have to be restored
 2. *Memento*, aka *Snapshot*, << this is it
 3. *Caretaker*, takes care
 4. *FIFA Manager*, not presented originaly in the pattern,
 its purpose is to synchronyse the *Originator* and the *Caretaker*

```c++
   +------------+------+---------+---------+-----------+
   | Originator |      | Memento |         | Caretaker |
   +------------+      +---------+--------<>-----------+
   | +backup()  |      +-------------+     | +push()   |
   | +restore() |      | FIFAManager |     | +pop()    |
   +------------+-----<>-------------<>----+-----------+
```