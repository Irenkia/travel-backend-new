package com.example.travelbackendnew.repository;

import com.example.travelbackendnew.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
//    List<Person> findByNameContaining(String surname);

    @Query("SELECT p FROM Person p WHERE p.surname like %?1%")
    List<Person> findByLike(String surname);

//    List<Person> findBySurname(String surname);

//    Optional<Person> findByName(String Name);
}
