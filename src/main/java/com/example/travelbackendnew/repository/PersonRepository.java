package com.example.travelbackendnew.repository;

import com.example.travelbackendnew.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByNameContaining(String lastName);

    //    @Query("SELECT p FROM Person p WHERE p.lastName like %?1%")
    //    List<Person> findByLike(String lastName);

    List<Person> findBylastName(String lastName);

//    Optional<Person> findByName(String lastName);
}
