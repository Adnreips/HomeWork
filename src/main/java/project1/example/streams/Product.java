package project1.example.streams;

/**
 * Product
 *
 * @author "Andrei Prokofiev"
 */
public class Product {
    Integer price;
    String name;

    public Product(Integer price, String name) {
        this.price = price;
        this.name = name;
    }


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "number=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
