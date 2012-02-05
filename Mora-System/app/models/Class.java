package models;

import java.sql.Date;
import java.util.LinkedList;

import javax.persistence.Entity;

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
	@Required
	String sector;
	/*
	 * The teacher responsible of this class
	 */
	@Required
	Student teacher;
	/*
	 * The teaching assistants in this class 
	 */
	@Required
	LinkedList<Student> teachingAssistants = new LinkedList<Student>();
	/*
	 * The students of this class
	 */
	@Required
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
	
	public static Class getClassByTeacherEmail(String teacherEmail) {
		return find("teacher", Student.find("byEmail", teacherEmail)).first();
	}
	
	public Student getTeacher() {
		return teacher;
	}

	public void setTeacher(Student teacher) {
		this.teacher = teacher;
	}
	
	
	
	
	
}