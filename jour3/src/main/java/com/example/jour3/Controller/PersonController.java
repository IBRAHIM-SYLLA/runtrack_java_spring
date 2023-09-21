package com.example.jour3.Controller;

import com.example.jour3.Entities.Person;
import com.example.jour3.Interfaces.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    PersonRepository repo;

    public void createPerson(String name, Integer age){
        Person person = new Person(name, age);
        repo.save(person);
        return;
    }

    @GetMapping("/person")
    public String findAllPerson(Model model){
        List<Person> listPersonnes = repo.findAll();
        if(listPersonnes.size() == 0){
            createPerson("Ibrah", 21);
            createPerson("Thibault", 21);
            createPerson("Cyril", 34);
            createPerson("Mylan", 26);
            createPerson("Rodolphe", 100);
        }
        model.addAttribute("listPersonnes", listPersonnes);
        return "person";

    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id){
        repo.deleteById(id);
        return "redirect:/person";
    }

    @PostMapping("/modifier")
    public String updateUser(
        @RequestParam("id") Long id,
        @RequestParam("name") String name,
        @RequestParam("age") int age
    ){
        Person onePerson = repo.findById(id).get();
        onePerson.setName(name);
        onePerson.setAge(age);
        repo.save(onePerson);
        return "redirect:/person";
    }
}
