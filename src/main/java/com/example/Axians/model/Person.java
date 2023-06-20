package com.example.Axians.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

import java.util.UUID;

public class Person {
    private final UUID id;
    /*
    It should be her for name @NotBlank, but I have to install the dependency in pom.xml
    So before name we have to give @NotBlank, inorder the user cannot Update something empty String
    In the PersonController class we have to add @Valid && @NonNull

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person personToUpdate){
        personService.updatePerson(id, personToUpdate);
    }

    And the same to create a new person

    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person person){
        personService.addPerson(person);
    }
    */
    @NotBlank
    private final String name;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
