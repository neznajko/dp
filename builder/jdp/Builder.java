////////////////////////////////////////////////////////////////
package builder.jdp;
////////////////////////////////////////////////////////////////
abstract class Builder {
    String brand;
    Product product;
    Builder( String brand ){
        this.brand = brand;
        product = new Product();
    }
    abstract void startUpOperations();
    abstract void buildBody();
    abstract void insertWheels();
    abstract void addHeadlights();
    abstract void endOperations();
    Product create(){
        startUpOperations();
        buildBody();
        insertWheels();
        addHeadlights();
        endOperations();
        return product;
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
class Car extends Builder {
    Car( String brand ){
        super( brand );
    }
    @Override
    void startUpOperations() {
        product.add( String.format( "Car model: %s", brand ));
    }
    @Override
    void buildBody() {
        product.add ( "Constructing body......" );
    }
    @Override
    void insertWheels() {
        product.add ( "4x4" );
    }
    @Override
    void addHeadlights() {
        product.add ( "lights on" );
    }
    @Override
    void endOperations() {
        product.add ( "Ok, finished!" );
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
class Motorcycle extends Builder {
    Motorcycle( String brand ){
        super( brand );
    }
    @Override
    void startUpOperations() {
        // nope
    }
    @Override
    void buildBody() {
        product.add ( "mbody, mbody" );
    }
    @Override
    void insertWheels() {
        product.add ( "2 wheels added" );
    }
    @Override
    void addHeadlights() {
        product.add ( "turn off the lights" );
    }
    @Override
    void endOperations() {
        product.add ( String.format( "Motorcycle: %s", brand ));
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
