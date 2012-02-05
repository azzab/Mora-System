package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Teacher extends Student {

	public Teacher(String name, String email, String password, boolean gender,
			boolean isAdmin) {
		super(name, email, password, gender, isAdmin);
		// TODO Auto-generated constructor stub
	}

}
