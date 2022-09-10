package com.nocodenolife.ecommerce.config;

import com.nocodenolife.ecommerce.entity.Country;
import com.nocodenolife.ecommerce.entity.Product;
import com.nocodenolife.ecommerce.entity.ProductCategory;
import com.nocodenolife.ecommerce.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnsupportedActions = {HttpMethod.DELETE, HttpMethod.POST, HttpMethod.PUT};

        //disable HTTP methods for Product: Put, POST, DELETE
        disableHttpMethod(Product.class, config, theUnsupportedActions);
        //disable HTTP methods for ProductCategory: Put, POST, DELETE
        disableHttpMethod(ProductCategory.class, config, theUnsupportedActions);
        //disable HTTP methods for CountryCategory: Put, POST, DELETE
        disableHttpMethod(Country.class, config, theUnsupportedActions);
        //disable HTTP methods for StateCategory: Put, POST, DELETE
        disableHttpMethod(State.class, config, theUnsupportedActions);
        // call an internal helper method
        exposeIds(config);
    }

    private void disableHttpMethod(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
        config.getExposureConfiguration().forDomainType(theClass)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)));
    }

    private void exposeIds(RepositoryRestConfiguration config) {

        // expose entity ids

        // get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        //create an array of the entity types
        List<Class> entityClasses = new ArrayList<>();

        // get the entity types for the entites
        for (EntityType temoEntityType: entities) {
            entityClasses.add(temoEntityType.getJavaType());
        }
        //expose the entity ids for the array of the entity domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);

    }
}
