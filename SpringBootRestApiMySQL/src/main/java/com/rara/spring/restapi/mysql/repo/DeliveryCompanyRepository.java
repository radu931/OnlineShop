package com.rara.spring.restapi.mysql.repo;

import com.rara.spring.restapi.mysql.model.DeliveryCompany;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeliveryCompanyRepository extends CrudRepository<DeliveryCompany, Long> {
    List<DeliveryCompany> findByName(String name);
}
