package com.shiva.SpringEMS.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter // Lombok annotation to create Getter methods
@Setter // Lombok annotation to create Setter methods
@NoArgsConstructor //useful when you want to create instances of a class without providing any constructor arguments. It's commonly used when dealing with frameworks like Hibernate that require a default constructor to create instances through reflection.
@AllArgsConstructor //This annotation generates a constructor that includes parameters for all the fields of the class. It's useful to quickly create instances of the class with all the necessary data without writing a lengthy constructor with all the field assignments.
@Entity // JPA Annotation to make this class a JPA Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //To provide primary key generation strategy
    private long id; //A primary key for Employees Table

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name = "email_id")
    private String emailId;
}
