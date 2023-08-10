package com.shiva.SpringEMS.Repository;

import com.shiva.SpringEMS.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //used to indicate that a class is a Data Access Object (DAO) and should be eligible for Spring's component scanning to be automatically detected and registered as a bean in the application context.
public interface EmployeeRepository extends JpaRepository <Employee, Long>{
    //Employee Repository will get all crud database methods

}
