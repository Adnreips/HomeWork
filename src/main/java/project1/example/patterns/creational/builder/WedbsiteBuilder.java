package project1.example.patterns.creational.builder;

/**
 * WedbsitBuilder
 *
 * @author "Andrei Prokofiev"
 */
public abstract class WedbsiteBuilder {
    Website website;
    void creatWebsite(){
        website = new Website();
    }
    abstract void buildName();
    abstract void buildCms();
    abstract void buildPrice();

    Website getWebsite(){
        return website;
    }

}
