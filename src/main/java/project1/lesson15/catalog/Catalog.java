package project1.lesson15.catalog;

/**
 * Catalog
 *
 * @author "Andrei Prokofiev"
 */
public class Catalog {
    private Integer id;
    private String nameProduct;
    private Integer price;
    private String manufacturer;

    public Catalog() {
    }

    public Catalog(Integer id, String nameProduct, Integer price, String manufacturer) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}



