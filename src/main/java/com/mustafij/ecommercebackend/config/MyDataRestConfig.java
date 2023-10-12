package com.mustafij.ecommercebackend.config;

import com.mustafij.ecommercebackend.entity.Country;
import com.mustafij.ecommercebackend.entity.Product;
import com.mustafij.ecommercebackend.entity.ProductCategory;
import com.mustafij.ecommercebackend.entity.State;
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
        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        //disable HTTP methods for Product: PUT, POST and DELETE

        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withAssociationExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

        //disable HTTP methods for Product, ProductCategory, Country, State: PUT, POST and DELETE

        disabledHttpMethods(ProductCategory.class, config, theUnsupportedActions);
        disabledHttpMethods(Product.class, config, theUnsupportedActions);
        disabledHttpMethods(Country.class, config, theUnsupportedActions);
        disabledHttpMethods(State.class, config, theUnsupportedActions);

        // call an internal helper method
        exposeIds(config);

    }

    private void disabledHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withAssociationExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }

    private void exposeIds(RepositoryRestConfiguration config) {

        //expose entity ids

        // get a list of all entity classes from the entity manager

        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // create an array of the entity types

        List<Class> entityClasses = new ArrayList<>();

        // get the entity types for the entities

        for (EntityType tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }

        // expose the entity ids for the array of entity/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);


    }
}

