package project1.lesson15.catalog;

/**
 * Catalog
 *
 * @author "Andrei Prokofiev"
 */
public class Catalog {
    private Integer productId;
    private String nameProduct;
    private Integer price;
    private String prodСountry;

    public Catalog(Integer productId, String nameProduct, Integer price, String prodСountry) {
        this.productId = productId;
        this.nameProduct = nameProduct;
        this.price = price;
        this.prodСountry = prodСountry;
    }

    public Integer getProductId() {
        return productId;
    }


    public String getNameProduct() {
        return nameProduct;
    }


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProdСountry() {
        return prodСountry;
    }


    @Override
    public String toString() {
        return "Catalog{" +
                "productId=" + productId +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", prodСountry='" + prodСountry + '\'' +
                '}';
    }
}



