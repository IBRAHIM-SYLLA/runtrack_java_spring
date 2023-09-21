package com.example.jour4.Services;

import com.example.jour4.Interfaces.PersonRepository;
import com.example.jour4.Models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository repo;

    @Autowired
    public PersonService(PersonRepository repository){
        this.repo = repository;
    }

    public List<Person> findAllPerson(){
        return repo.findAll();
    }

    public void createPerson(String name, Integer age){
        Person person = new Person(name, age);
        repo.save(person);
    }

    public void deletePerson(Long id) {
        repo.deleteById(id);
    }

    public void updatePerson(Long id, String name, int age) {
        Person onePerson = repo.findById(id).orElse(null);
        if (onePerson != null) {
            onePerson.setName(name);
            onePerson.setAge(age);
            repo.save(onePerson);
        }
    }
}
