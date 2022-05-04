package com.ems.in.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "user_table")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  String userId;
 
    @Column(name="password")
    @NotEmpty(message = "please provide password")
    private  String password;

   
    
    

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	@JsonIgnore
    private Employee employee;


    public User() {
    }

    public User(String userId,String password,String roles) {
        this.userId=userId;
        this.password=password;
       
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    


}
