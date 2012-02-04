package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class Admin extends Controller {

	@Before
	static void setConnectedUser() {
		if (Security.isConnected()) {
			Student student = Student.find("byEmail", Security.connected())
					.first();
			renderArgs.put("user", student.isAdmin);
		}
	}

	public static void checkLogin() {
		Student s = Student.find("byEmail", Security.connected()).first();
		if (s.isAdmin)
			index();
		else {
			try {
				Students.view(s.id + "");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void index() {
		Student s = Student.find("byEmail", Security.connected()).first();
		render(s);
	}

	public static void view() {
		Student s = Student.find("byEmail", Security.connected()).first();
		render(s);
	}
}