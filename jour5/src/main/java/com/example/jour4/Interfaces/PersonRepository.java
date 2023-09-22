package com.example.jour4.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jour4.Models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
