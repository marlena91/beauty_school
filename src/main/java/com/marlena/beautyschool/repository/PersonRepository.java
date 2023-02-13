package com.marlena.beautyschool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.marlena.beautyschool.model.Person;

import javax.persistence.Id;


@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    Person readByEmail(String email);
}
