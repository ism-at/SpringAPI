package com.example.Axians.service;

import com.example.Axians.dao.PersonDao;
import com.example.Axians.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// We can use @Service OR @Component
@Service
public class PersonService {

    // This a reference!
    private final PersonDao personDao;

    // To Inject we use
    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao){ // we use multiple Instance-Variables. @Qualifier will be needed
        this.personDao = personDao;
    }
    // Method to add a person
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
    public List<Person> getAllPeople(){
        return personDao.selectAllPepole();
    }
    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }
    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }
    public int updatePerson(UUID id, Person newPerson){
        return personDao.updatePersonById(id, newPerson);
    }
}
