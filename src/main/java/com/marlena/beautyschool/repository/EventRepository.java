package com.marlena.beautyschool.repository;

import com.marlena.beautyschool.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, String> {



}
