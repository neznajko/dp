# GoF Definition
Winter winds whisper,  
bare branches reach for the moon,  
stillness blankets all  

# DiDP Definition
***Prototype*** is a *creational design pattern* that lets you copy
existing objects without making your code dependent on their classes

In ***Python*** there is a module *copy* that lets you make shallow
or deep copies, like:

```python
    shallow_copy = copy.copy( obj )
    deep_copy = copy.deepcopy( obj )
```

With the *prototype pattern*, the object *obj*( the fyorst name of
Obj One Kenobi ), by the way I was watching for nth time Star Wars
New Hope, and was thinking that it will be nice having some scenes
played with drunk actors:)

 -Dee ree Imperial Senate will no longer be ...

Anyway, with the *prototype* we let objects implement a *clone*
method, which not always is a straightforward copy, for example in
case of circular links, so the above code will look like:

```java
    var copy = obj.clone();
```

Also with this pattern one is able to create prototype factories
like the *Spawner* class from the book *Game Programming Patterns*:


```
    _---------------_          _----------_
    _ <<interface>> _          _  Ghost   _
    _    Monster    _ << - - - _----------_
    _---------------_          _ +clone() _
    _ +clone()      _          _----------_
    _---------------_

    _------------------------_
    _        Spawner         _
    _------------------------_
    _ -prototype: Monster    _
    _------------------------_
    _ +Spawner(Monster)      _
    _ +spawnMonster: Monster _
    _------------------------_
    
```
