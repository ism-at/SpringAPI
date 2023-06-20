package com.example.Axians.api;

import com.example.Axians.model.Person;
import com.example.Axians.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController //This class can have some methods and expose Endpoints, that client can consume it.
public class PersonController {

    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    // With @PostMapping, This Method will be served as CRUD[POST/Create],and we need to make our class as @RestController!
    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person person){
        personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }
    @GetMapping(path = "{id}") // So we can call = localhost:8080/api/v1/person/25c3d770-8ff7-495b-9c9f-02fd1879293c
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deletePersonByID(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }
    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person personToUpdate){
        personService.updatePerson(id, personToUpdate);
    }
}
