package models;

import java.sql.Date;
import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.*;

import controllers.Security;
import play.data.validation.*;
import play.db.jpa.Model;

/**
 * 
 * @author Zein
 * 
 */
@Entity
public class Class extends Model {
	/*
	 *sector to which this class belongs
	 */
	String sector;
	/*
	 * The teacher responsible of this class
	 */
	@Required
	Student teacher;
	/*
	 * The students of this class
	 */
	@OneToMany(mappedBy="myClass")
	LinkedList<Student> students = new LinkedList<Student>();
	/*
	 * The academic level at which this class currently stands
	 */
	@Required
	int level;
	/*
	 * The date of the first session for this class
	 */
	@Required
	public Date startDate;
	
	public Class(String sector, Student teacher, int level, Date startDate){
		this.sector = sector;
		this.teacher = teacher;
		this.level = level;
		this.startDate = startDate;
	}
	
	public Student getTeacher() {
		return teacher;
	}

	public void setTeacher(Student teacher) {
		this.teacher = teacher;
	}
	
	
	
	
	
}