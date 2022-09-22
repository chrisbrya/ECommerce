package com.nocodenolife.ecommerce.dao;


import com.nocodenolife.ecommerce.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "countries", path = "countries") // makes the endpoints countries
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
