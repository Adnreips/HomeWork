package project1.example.patterns.creational.builder;

/**
 * EnterpriseWebsiteBuilder
 *
 * @author "Andrei Prokofiev"
 */
public class EnterpriseWebsiteBuilder extends WedbsiteBuilder {


    @Override
    void buildName() {
        website.setName("Enterpise web site");
    }

    @Override
    void buildCms() {
        website.setCms(Cms.ALIFRESCO);
    }

    @Override
    void buildPrice() {
        website.setPrice(1000);
    }
}
