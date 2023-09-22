package com.example.jour4.Controller;

import com.example.jour4.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jour4.Models.Person;

import java.util.List;

@Controller
public class PersonController {

   private PersonService service;

    @Autowired
    public PersonController(PersonService personService) {
        this.service = personService;
    }

    @GetMapping("/person")
    public String findAllUser(Model model){
        List<Person> listPersonnes = service.findAllPerson();
        if(listPersonnes.isEmpty()){
            service.createPerson("Ibrah", 21);
            service.createPerson("Thibault", 21);
            service.createPerson("Cyril", 34);
//            service.createPerson("Mylan", 26);
//            service.createPerson("Rodolphe", 100);
        }
        model.addAttribute("listPersonnes", listPersonnes);
        return "person";

    }

    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }

    @PostMapping("/registerUser")
    public String registerUser(
        @RequestParam("name") String name,
        @RequestParam("age") int age
    ){
        service.createPerson(name, age);
        return "redirect:/person";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id){
        service.deletePerson(id);
        return "redirect:/person";
    }

    @PostMapping("/modifier")
    public String updateUser(
        @RequestParam("id") Long id,
        @RequestParam("name") String name,
        @RequestParam("age") int age
    ){
        service.updatePerson(id, name, age);
        return "redirect:/person";
    }
}
