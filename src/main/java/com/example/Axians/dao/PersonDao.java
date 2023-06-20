package com.example.Axians.dao;

import com.example.Axians.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    // This Method allows us to add an ID
    int insertPerson(UUID id, Person person);

    // This generates a random ID
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return  insertPerson(id, person);
    }

    List<Person> selectAllPepole();

    Optional<Person> selectPersonById(UUID id);

    int updatePersonById(UUID id, Person person);

    int deletePersonById(UUID id);


}
