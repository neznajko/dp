////////////////////////////////////////////////////////////////
package visitor;
////////////////////////////////////////////////////////////////
import java.util.Map;
import java.util.HashMap;
////////////////////////////////////////////////////////////////
interface Node {
    void accept( Visitor visitor );
}
////////////////////////////////////////////////////////////////
class Directory implements Node {
    private Map <String,Node> map;
    Directory() {
        map = new HashMap <> ();
    }
    Node put( String name, Node node ){
        map.put( name, node );
        return node;
    }
    @Override
    public void accept( Visitor visitor ){
        visitor.visit( this );
        for( Node node: map.values()){
            node.accept( visitor );
        }
    }
}
////////////////////////////////////////////////////////////////
class File implements Node {
    private int fileSize;
    File( int fileSize ){
        this.fileSize = fileSize;
    }
    @Override
    public void accept( Visitor visitor ){
        visitor.visit( this );
    }
    int getFileSize() {
        return fileSize;
    }
}
////////////////////////////////////////////////////////////////
interface Visitor {
    void visit( Directory directory );
    void visit( File file );
}
////////////////////////////////////////////////////////////////
class SizeVisitor implements Visitor {
    private int size = 0;
    @Override
    public void visit( Directory directory ){
        // do nothing
    }
    @Override
    public void visit( File file ){
        size += file.getFileSize();
    }
    int getSize() {
        return size;
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// + root/
//   - log( 15 )
//   + sounds/
//     - space_adventure.wav( 36 )
//     + ambience/
//       - glitch.mp3( 65 )
class VisitorPattern {
    public static void main( String args[] ){
        Directory root = new Directory();
        root.put( "log", new File( 15 ));
        Directory sounds = (( Directory )root
                            .put( "sounds", new Directory()));
        sounds.put( "space_adventure.wav", new File( 36 ));
        Directory ambience = (( Directory )sounds
                              .put( "ambience", new Directory()));
        ambience.put( "glitch.mp3", new File( 65 ));
        //
        SizeVisitor visitor = new SizeVisitor();
        root.accept( visitor );
        System.out.println( "Total size: " + visitor.getSize());
        // Total size: 116
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
