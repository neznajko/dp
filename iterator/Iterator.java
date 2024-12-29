////////////////////////////////////////////////////////////////
package iterator;
////////////////////////////////////////////////////////////////
interface Iterator <T> {
    boolean hasNext();
    T next();
}
////////////////////////////////////////////////////////////////
interface Collection <T> {
    Iterator <T> createIterator();
}
////////////////////////////////////////////////////////////////
class Node {
    int data;
    Node next = null;
    Node( int data ){
        this.data = data;
    }
}
////////////////////////////////////////////////////////////////
class LinkedListIterator implements Iterator <Integer> {
    private Node curr = null;
    LinkedListIterator( Node curr ){
        this.curr = curr;
    }
    @Override
    public boolean hasNext() {
        return curr.next != null;
    }
    @Override
    public Integer next() {
        curr = curr.next;
        return curr.data;
    }
}
////////////////////////////////////////////////////////////////
class LinkedList implements Collection <Integer> {
    private Node ahead = new Node( 0 );
    void insert( int data ){
        Node node = new Node( data );
        node.next = ahead.next;
        ahead.next = node;        
    }
    @Override
    public Iterator <Integer> createIterator() {
        return new LinkedListIterator( ahead );
    }
}
////////////////////////////////////////////////////////////////
class std {
    static int accumulate( Iterator <Integer> it ){
        int total = 0;
        while( it.hasNext()){
            total += it.next();
        }
        return total;
    }
    public static void main( String[] args ){
        var sll = new LinkedList();
        sll.insert( 5 );
        sll.insert( 4 );
        sll.insert( 1 );
        sll.insert( 2 );
        System.out.println( accumulate( sll.createIterator()));
        // 12
    }
}
////////////////////////////////////////////////////////////////
