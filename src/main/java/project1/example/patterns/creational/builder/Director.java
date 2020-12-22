package project1.example.patterns.creational.builder;

import java.util.Objects;

/**
 * Director
 *
 * @author "Andrei Prokofiev"
 */
public class Director {
    WedbsiteBuilder builder;

    public void setBuilder(WedbsiteBuilder builder) {
        this.builder = builder;
    }

    Website buildWebsite(){
        builder.creatWebsite();
        builder.buildName();
        builder.buildCms();
        builder.buildPrice();
        Website website = builder.getWebsite();
        return website;
    }



    public Director() {
        super();
    }
}
