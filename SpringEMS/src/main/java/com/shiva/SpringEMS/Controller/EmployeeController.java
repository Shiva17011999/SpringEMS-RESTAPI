package com.shiva.SpringEMS.Controller;

import com.shiva.SpringEMS.Exception.ResourceNotFoundException;
import com.shiva.SpringEMS.Model.Employee;
import com.shiva.SpringEMS.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //used when building APIs where the response data is directly sent back to the client as JSON or other formats.
@RequestMapping("/api/v1/employees")
//@RequestMapping is used to map a URL pattern to a method in a controller class. It defines which HTTP requests (GET, POST, PUT, DELETE, etc.) should be routed to which methods in the controller to handle those requests.
public class EmployeeController {

    @Autowired
    //@Autowired annotation is to automatically inject an instance of the EmployeeRepository interface into the EmployeeController class.
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //Build CREATE Employee REST API
    @PostMapping //To create the resource
    public Employee createEmployee(@RequestBody Employee employee){
        //@RequestBody converts JSON into Java Object
        return employeeRepository.save(employee);
    }


    //build get employee by ID Rest API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){ //@PathVariable is used to extract values from the URI (Uniform Resource Identifier) template and map them to method parameters in a controller handler method. It's commonly used when you need to capture dynamic values from the URL path, such as IDs or other parameters.
        //ResponseEntity used in Spring MVC controllers to provide more control over the HTTP response that is sent back to the client.
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(employee);
    }

    //build update employee REST API
    @PutMapping("{id}") //To update the resource
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not exist with id: " +id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    //build DELETE Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:" + id));

        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
