package com.nocodenolife.ecommerce.dao;


import com.nocodenolife.ecommerce.dto.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "countries", path = "countries") // makes the endpoints countries
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
