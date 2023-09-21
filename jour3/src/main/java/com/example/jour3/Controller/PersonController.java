package com.example.jour3.Controller;

import com.example.jour3.Entities.Person;
import com.example.jour3.Interfaces.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    PersonRepository repo;

    public void createPerson(){
        Person person = new Person("Ibrah", 21);
        repo.save(person);
        return;
    }

    @GetMapping("/person")
    public String findAllPerson(Model model){
        createPerson();
        List<Person> listPersonnes = repo.findAll();
        model.addAttribute("listPersonnes", listPersonnes);
        return "person";

    }
}
