package com.amdocs.jpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.Entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
