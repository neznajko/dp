# GoF Definition
Whispers of the breeze,   
Soft leaves dance in golden light,  
Time flows like a stream.  

In *Factory Pattern* we had an *Animal* interface representing the
product of our factory, so we were able to produce cats and dogs,
but what if we want to create a Circus for example, if we were to
create a Zoo we might get away with *AnimalFactory* only, but here
we need other factories as well, for example *ClownFactory* which
can create concrete implementations like comedians or politicians

So basically *Abstract Factory* is a group of related factories,
that produce a composite product. Let's try to create a desktop
computer or something similar. For simplicity let it consist of
CPU and Memory only:

```bash
    +---------------+         +-------+
    | <<interface>> |<< - - - | Intel |
    |      CPU      |         +-------+
    +---------------+         +-----+
    | +clock()      |<< - - - | AMD |
    +---------------+         +-----+

    +---------------+         +---------+
    | <<interface>> |<< - - - | CORSAIR |
    |    Memory     |         +---------+
    +---------------+         +---------+
    | +capacity()   |<< - - - | Crucial |
    +---------------+         +---------+
```

Note that we don't create separate CPU and Memory factories, but
instead a composite ComputerFactory, that has createCPU and
createMemory methods:

```javascript
    +-----------------+         +------+
    |  <<interface>>  |<< - - - | Acer |
    | ComputerFactory |         +------+
    +-----------------+
    | +createCPU()    |         +--------+
    | +createMemory() |<< - - - | Lenovo |
    +-----------------+         +--------+
    
```

Of course there is an alternative to create actual factories for each
CPU and Memory and then encapsulate them into a ComputerFactory,
which gives more flexibility cos one can make different combinations,
but let's stick to the books examples

Now we can create the final product by passing a factory to its
constructor, like:

```ruby
    +----------------------------+
    | Computer                   |
    +----------------------------+
    | -cpu                       |
    | -memory                    |
    +----------------------------+
    | +Computer(ComputerFactory) |
    | +info()                    |
    +----------------------------+
```

here in the constructor we initialize the cpu and memory fields by
calling createCPU and createMemory methods
