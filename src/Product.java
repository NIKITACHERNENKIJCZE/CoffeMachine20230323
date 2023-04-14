public class Product {
    public int price;
    public String name;

    public Product(int price, String name){
        this.price = price;
        this.name = name;
    }

    public int getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }
}
