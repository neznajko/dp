# GoF Definition
Allow an object to alter its behavior
when its internal state changes.
The object will appear to change its class.

This is kind of an important pattern, and I'm pretty sure that
every programmer if never had heard about it, has discovered it
the hard way. We basically have a system with finite states,
and have to take decisions depending on the state we currently
are and the context.

Let' look at a simple football simulation, teams can play in
three different formations: attacking, balanced and defensive,
whenever the score changes the teams regroup depending if they
are winning or not, so the first thing is to draw a diagram how
we transition from states:
```c++
    A - Attacking Formation
    B - Balanced Formation
    D - Defensive Formation

    W - Winning
    L - Losing or Draw
    
    << Man United Strategy >>
    +----------+---+---------+   B to A if L
    |          | B |         |   B to D if W
    |   +------W---+         |
    |   |                    |   D to A if L
    |   |                    |   D to B if W
    W---+----------------L---L
    | D |                | A |   A to A if L
    +---W----------------+---L   A to D if W
                         |   |
                         +---+

    << Barcelona Strategy >>
           +---+---+---------+   B to A if L
           |   | B |         |   B to B if W
           +---W---L         |
    +--------------+         |   D to B if L
    |                        |   D to A if W
    +---+----------------W---L
    | D |                | A |   A to A if L
    +---W----------------+---L   A to D if W
                         |   |
                         +---+
```
A sample regroup function will look like thus:
```bash
    regroup( winning ):
       if( state = A ):
           if( winning ):
               state = B
           else
               state = D
           ...  
```
This can start looking pretty ugly, with the *State Pattern*
we define a State object for each if clause that is
State_A, State_B etc. whit its own logic of the regroup method.
This will decouples the code and allow more easily to add new states,
now the above code will look something like this:
```java
    regroup( winning ):
        state = state.regroup( winning )
```
