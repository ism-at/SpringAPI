package com.example.Axians.dao;

import com.example.Axians.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// with @Repository OR @Component. We tell Spring, this class is instantiated as @Bean so we can inject all classes
@Repository("fakeDao")
public class FakePersonAccessService implements PersonDao{

    private static List<Person> DB = new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }
    @Override
    public List<Person> selectAllPepole() {
        return DB;
    }
    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }
    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonById(id).
                map(person -> {
                    int indexOfPersonToUpdate = DB.indexOf(person);
                    if(indexOfPersonToUpdate >= 0){
                        DB.set(indexOfPersonToUpdate, new Person(id, update.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if(personMaybe.isEmpty()){
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }
}
