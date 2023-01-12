package com.marlena.beautyschool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.marlena.beautyschool.model.Person;


@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Person readByEmail(String email);
}
