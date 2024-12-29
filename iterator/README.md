# GoF Definition
Far beacons in sequence,  
Flowing streams of weary souls,  
Night’s tide pulls them home.  
#
```java
    interface Iterator <T> {
        boolean hasNext();
        T next();
    }
    interface Collection <T> {
        Iterator <T> createIterator();
    }
```
This pattern allows to iterate over a collection of items in
uniform way regardless of whether the collection is a tree,
array, linked list or something else.

One of the benefits of this approach is that it allows to write
functions that depends on the iterators only, so instead of writing
different functions for different structures, we write only one:
```java
    int getTotalSum( Iterator <Integer> it ){
        int total = 0;
        while( it.hasNext()){
            total += it.next();
        }
        return total;
    }
```
