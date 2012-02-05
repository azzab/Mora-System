package models;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.*;

import play.data.validation.*;
import play.db.jpa.Model;

/**
 * 
 * @author Ahmed El Hadi
 * 
 */
@Entity
public class Student extends Model {

	/*
	 * Student's name
	 */
	@Required
	public String name;

	/*
	 * Student's Email address
	 */
	@Required
	@Email
	public String email;

	/*
	 * Student's Email address
	 */
	@Required
	@Password
	public String password;

	/*
	 * Student's home address
	 */
	public String address;

	/*
	 * Student's gender
	 */
	@Required
	public boolean gender;

	/*
	 * The Student is an Admin or not
	 */
	@Required
	public boolean isAdmin;
	public String maritalStatus;
	public String phoneNumber;
	public String work;
	public Date birthDate;
	@ManyToOne
	public Class myClass;
	
	public Student(String name, String email, String password, boolean gender,
			boolean isAdmin) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.isAdmin = isAdmin;
	}

	public static Student connect(String email, String password) {
		return find("byEmailAndPassword", email, password).first();
	}

	public String toString() {
		return this.email;
	}

}
