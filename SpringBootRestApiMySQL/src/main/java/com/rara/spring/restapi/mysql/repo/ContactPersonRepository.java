package com.rara.spring.restapi.mysql.repo;

import com.rara.spring.restapi.mysql.model.ContactPerson;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactPersonRepository extends CrudRepository<ContactPerson, Long> {
    List<ContactPerson> findByName(String name);
}
