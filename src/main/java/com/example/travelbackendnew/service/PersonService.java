package com.example.travelbackendnew.service;

import com.example.travelbackendnew.model.Person;
import com.example.travelbackendnew.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;


    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Integer id) {
        return personRepository.findById(id);
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }

    public void deleteAllPersons() {
        personRepository.deleteAll();
    }
}
