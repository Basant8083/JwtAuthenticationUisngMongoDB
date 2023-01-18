package com.jwt.auth.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jwt.auth.model.Employee;

public interface EmployeeRepo extends MongoRepository<Employee, Integer>{

}
