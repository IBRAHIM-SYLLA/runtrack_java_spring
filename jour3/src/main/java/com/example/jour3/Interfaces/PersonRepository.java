package com.example.jour3.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jour3.Models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
