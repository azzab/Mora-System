package models;

import java.sql.Date;
import java.util.LinkedList;

import javax.persistence.Entity;
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
	LinkedList<Student> TAs = new LinkedList<Student>();
	/*
	 * The academic level at which this class currently stands
	 */
	@Required
	int level;
}