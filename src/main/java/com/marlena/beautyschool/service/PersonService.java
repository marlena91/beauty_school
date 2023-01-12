package com.marlena.beautyschool.service;

import com.marlena.beautyschool.constants.BeautySchoolConstants;
import com.marlena.beautyschool.model.Person;
import com.marlena.beautyschool.model.Roles;
import com.marlena.beautyschool.repository.PersonRepository;
import com.marlena.beautyschool.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public boolean createNewPerson(Person person) {
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(BeautySchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person = personRepository.save(person);
        if(null!=person && person.getPersonId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }
}
