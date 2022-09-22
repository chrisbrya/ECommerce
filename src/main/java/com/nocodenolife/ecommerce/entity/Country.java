package com.nocodenolife.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="country")
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="code")
    private String code;
    @Column(name="name")
    private String name;

    // one-to-many with states
    @OneToMany(mappedBy = "country")
    @JsonIgnore // makes it where the states do not populate with the country we only retrieve country
    private List<State> states;


}
