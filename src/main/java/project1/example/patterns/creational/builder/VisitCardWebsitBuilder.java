package project1.example.patterns.creational.builder;

/**
 * VisitCardWebsitBuilder
 *
 * @author "Andrei Prokofiev"
 */
public class VisitCardWebsitBuilder extends WedbsiteBuilder {

    @Override
    void buildName() {
        website.setName("Visit card");

    }

    @Override
    void buildCms() {
        website.setCms(Cms.WORDPRESS);
    }

    @Override
    void buildPrice() {
        website.setPrice(100);
    }
}
