package controllers;

import models.Student;
import controllers.CRUD.ObjectType;
import play.*;
import play.data.binding.Binder;
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

	public static void save(String id) throws Exception {
		ObjectType type = ObjectType.get(getControllerClass());
		notFoundIfNull(type);
		Model object = type.findById(id);
		notFoundIfNull(object);
		Binder.bindBean(params.getRootParamNode(), "object", object);
		validation.valid(object);
		if (validation.hasErrors()) {
			renderArgs.put("error", play.i18n.Messages.get("crud.hasErrors"));
			try {
				render(request.controller.replace(".", "/") + "/show.html",
						type, object);
			} catch (TemplateNotFoundException e) {
				render("CRUD/show.html", type, object);
			}
		}
		object._save();
		flash.success(play.i18n.Messages.get("crud.saved", type.modelName));
		if (params.get("_save") != null) {
			redirect(request.controller + ".list");
		}
		redirect(request.controller + ".show", object._key());
	}

	public static void edit() throws Exception {
		Student s = Student.find("byEmail", Security.connected()).first();
		ObjectType type = ObjectType.get(getControllerClass());
		notFoundIfNull(type);
		Model object = type.findById(s.id + "");
		notFoundIfNull(object);
		try {
			render(s);
		} catch (TemplateNotFoundException e) {
			render("CRUD/show.html");
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
