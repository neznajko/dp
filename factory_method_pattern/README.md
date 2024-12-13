# GoF Definition
Silent snow falls down,  
Soft whispers in the still night,  
Dreams of spring arise.  

So we have, say interface *Animal*, and some concrete
implementations like *Cat* and *Dog*:

```bash
    +---------------+
    | <<interface>> |          +-----+
    |    Animal     |⏴ - - - - | Dog |
    +---------------+          +-----+
    | +speak()      |          +-----+  
    | +action()     |⏴ - - - - | Cat |  
    +---------------+          +-----+
```

Then we have an interface *AnimalFactory* with concrete 
implementations *CatFactory* and *DogFactory*:

```ruby
    +---------------+         +------------+
    | <<interface>> | ⏴ - - - | DogFactory |
    | AnimalFactory |         +------------+
    +---------------+
    | +create()     |
    +---------------+         
         ⏶         +------------+
         + - - - - | CatFactory |
                   +------------+
```
Recall that in *Simple Factory Pattern* we'll have something
like:

```java
Animal cat = SimpleFactory.create( "cat" );
```

The main issues here is that if we want to extend the
SimpleFactory by adding another animal, we'll have to 
modify the *create* code, which violates one of the **SOLID**
principles, namely the **O** principle. With the factory
pattern one is able not only to extend without modification,
but also to encapsulate a factory in the *Client* code and 
then initialize or change it dynamically
