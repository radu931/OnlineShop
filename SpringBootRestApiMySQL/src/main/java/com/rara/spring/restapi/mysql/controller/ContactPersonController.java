package com.rara.spring.restapi.mysql.controller;

import com.rara.spring.restapi.mysql.model.ContactPerson;
import com.rara.spring.restapi.mysql.model.Customer;
import com.rara.spring.restapi.mysql.repo.ContactPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ContactPersonController {

    @Autowired
    ContactPersonRepository repository;

    @GetMapping("/contactPerson")
    public ResponseEntity<List<ContactPerson>> getAllContactPersons() {
        List<ContactPerson> contactPersons = new ArrayList<>();
        try {
            repository.findAll().forEach(contactPersons::add);

            if (contactPersons.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(contactPersons, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/contactPerson/{id}")
    public ResponseEntity<ContactPerson> getContactPersonById(@PathVariable("id") long id) {
        Optional<ContactPerson> contactPersonData = repository.findById(id);

        if (contactPersonData.isPresent()) {
            return new ResponseEntity<>(contactPersonData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/contactPerson")
    public ResponseEntity<ContactPerson> postContactPerson(@RequestBody ContactPerson contactPerson) {
        try {
            ContactPerson _contactPerson = repository.save(new ContactPerson(contactPerson.getName(), contactPerson.getPhoneNr(), contactPerson.getEmail()));
            return new ResponseEntity<>(_contactPerson, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/contactPerson/{id}")
    public ResponseEntity<HttpStatus> deleteContactPerson(@PathVariable("id") long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/contactPerson")
    public ResponseEntity<HttpStatus> deleteAllContactPersons() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }

    @GetMapping(value = "contactPerson/name/{name}")
    public ResponseEntity<List<ContactPerson>> findByName(@PathVariable String name) {
        try {
            List<ContactPerson> contactPersons = repository.findByName(name);

            if (contactPersons.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(contactPersons, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/contactPerson/{id}")
    public ResponseEntity<ContactPerson> updateCustomer(@PathVariable("id") long id, @RequestBody ContactPerson contactPerson) {
        Optional<ContactPerson> contactPersonData = repository.findById(id);

        if (contactPersonData.isPresent()) {
            ContactPerson _contactPerson = contactPersonData.get();
            _contactPerson.setName(contactPerson.getName());
            _contactPerson.setPhoneNr(contactPerson.getPhoneNr());
            _contactPerson.setEmail(contactPerson.getEmail());
            return new ResponseEntity<>(repository.save(_contactPerson), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
