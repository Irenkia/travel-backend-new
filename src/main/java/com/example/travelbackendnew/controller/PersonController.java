package com.example.travelbackendnew.controller;

import com.example.travelbackendnew.model.Person;
import com.example.travelbackendnew.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/sign-up")
@RequiredArgsConstructor
public class PersonController {
    @Autowired
    private final PersonRepository personRepository;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons () {
        try {
            List<Person> persons = new ArrayList<Person>();
            personRepository.findAll().forEach(persons::add);
            if (persons.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(persons, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Integer id) {
        Optional<Person> personData = personRepository.findById(id);

        if (personData.isPresent()) {
            return new ResponseEntity<>(personData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        try {
            Person _person = personRepository
                    .save(new Person(person.getName(), person.getSurname(), person.getEmail(), person.getPassword()));
            return new ResponseEntity<>(_person, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Integer id, @RequestBody Person person) {
        Optional<Person> personData = personRepository.findById(id);

        if (personData.isPresent()) {
            Person _person = personData.get();
            _person.setName(person.getName());
            _person.setSurname(person.getSurname());
            _person.setEmail(person.getEmail());
            _person.setPassword(person.getPassword());
            return new ResponseEntity<>(personRepository.save(_person), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable("id") Integer id) {
        try {
            personRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/persons")
    public ResponseEntity<HttpStatus> deleteAllPersons() {
        try {
            personRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/persons/surname")
    public ResponseEntity<List<Person>> findByLike(@RequestParam String surname) {
        try {
            List<Person> persons = personRepository.findByLike(surname);

            if (persons.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(persons, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/persons/surname")
//    public ResponseEntity<List<Person>> findBySurname(@RequestParam String surname) {
//        try {
//            List<Person> persons = personRepository.findBySurname(surname);
//
//            if (persons.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(persons, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
