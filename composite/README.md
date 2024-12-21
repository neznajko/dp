# GoF Definition
Mountains meet the sky,  
Roots entwine with earth below,  
Life flows as part-whole.
#
This is basically a tree structure, where each node implements a
common interface. It simplifies certain tasks, for example let's
consider a *File Structure* like thus:
```bash
 + root/
   - log( 15 )
   + sounds/
     - space_adventure.wav( 36 )
     + ambience/
       - glitch.mp3( 65 )
```

It consist of directories and files, in the parenthesis we have the
file sizes, and we want to compute the total size of the root
directory. This is a tree structure where every file is a *leaf* and
every directory is a root of a sub-tree. Let's define the common
interface that both files and directories have to implement:

```c++
    +---------------<<-------+--------+
    | <<interface>> |        |  File  | 
    |      Node     |        +--------+
    +---------------+        +-----------+
    | +size()       |        | Directory |
    +---------------<<-------+-----------+
```

For *File* class the implementation is quite simple it will just
return the size of the file. Directories on the other hand being
roots to sub-trees have branches that leads to files or other
directories, but the common interface allows us to calculate
recursively directory size  without explicitly writing a recursive
function, something like thus:

```java
    total <- 0
    for node in directory.branches:
        total += node.size()
    return total
```
