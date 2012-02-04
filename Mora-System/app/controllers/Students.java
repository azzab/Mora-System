package controllers;

import models.Student;
import controllers.CRUD.ObjectType;
import play.*;
import play.db.Model;
import play.exceptions.TemplateNotFoundException;
import play.mvc.*;

@With(Secure.class)
public class Students extends CRUD {

	public static void view(String id) throws Exception {
		ObjectType type = ObjectType.get(getControllerClass());
		notFoundIfNull(type);
		Model object = type.findById(id);
		notFoundIfNull(object);
		Student s = Student.find("byEmail", Security.connected()).first();
		try {
			render(type, object, s);
		} catch (TemplateNotFoundException e) {
			render("CRUD/show.html", type, object);
		}
	}

	public static void show(String id) throws Exception {
		ObjectType type = ObjectType.get(getControllerClass());
		notFoundIfNull(type);
		Model object = type.findById(id);
		notFoundIfNull(object);
		Student s = Student.find("byEmail", Security.connected()).first();
		try {
			render(type, object, s);
		} catch (TemplateNotFoundException e) {
			render("CRUD/show.html", type, object);
		}
	}

}
