package com.github.itsAkshayDubey.aopwithspringpart1.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
	
	 @Id
	 private Integer employeeID;
	 private String firstName;
	 private String lastName;
	 private String email;
 
}
