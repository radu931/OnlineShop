package com.rara.spring.restapi.mysql.controller;

import com.rara.spring.restapi.mysql.model.DeliveryCompany;
import com.rara.spring.restapi.mysql.repo.DeliveryCompanyRepository;
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
public class DeliveryCompanyController {

    @Autowired
    DeliveryCompanyRepository repository;

    @GetMapping("/deliveryCompany")
    public ResponseEntity<List<DeliveryCompany>> getAllDeliveryCompanies() {
        List<DeliveryCompany> deliveryCompanies = new ArrayList<>();
        try {
            repository.findAll().forEach(deliveryCompanies::add);

            if (deliveryCompanies.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(deliveryCompanies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/deliveryCompany/{id}")
    public ResponseEntity<DeliveryCompany> getCompanyById(@PathVariable("id") long id) {
        Optional<DeliveryCompany> productData = repository.findById(id);

        if (productData.isPresent()) {
            return new ResponseEntity<>(productData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/deliveryCompany")
    public ResponseEntity<DeliveryCompany> postCompany(@RequestBody DeliveryCompany deliveryCompany) {
        try {
            DeliveryCompany _deliveryCompany = repository.save(new DeliveryCompany(deliveryCompany.getName(),deliveryCompany.getCompanyLocation()));
            return new ResponseEntity<>(_deliveryCompany, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/deliveryCompany/{id}")
    public ResponseEntity<HttpStatus> deleteCompany(@PathVariable("id") long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/deliveryCompany")
    public ResponseEntity<HttpStatus> deleteAllCompanies() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }

    @GetMapping(value = "deliveryCompany/name/{name}")
    public ResponseEntity<List<DeliveryCompany>> findByName(@PathVariable String name) {
        try {
            List<DeliveryCompany> deliveryCompanies = repository.findByName(name);

            if (deliveryCompanies.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(deliveryCompanies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/deliveryCompanies/{id}")
    public ResponseEntity<DeliveryCompany> updateCompany(@PathVariable("id") long id, @RequestBody DeliveryCompany company) {
        Optional<DeliveryCompany> companyData = repository.findById(id);

        if (companyData.isPresent()) {
            DeliveryCompany _company = companyData.get();
            _company.setName(company.getName());
            _company.setCompanyLocation(company.getCompanyLocation());

            return new ResponseEntity<>(repository.save(_company), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
