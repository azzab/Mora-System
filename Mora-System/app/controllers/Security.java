package controllers;

import models.*;

public class Security extends Secure.Security {

	static boolean check(String profile) {
		if ("admin".equals(profile)) {
			return Student.find("byEmail", connected()).<Student> first().isAdmin;
		}
		return false;
	}

	static boolean authenticate(String username, String password) {
		return Student.connect(username, password) != null;
	}

	public static Student getConnected() {
		String id = session.get("user_id");
		return Student.findById(Long.parseLong(id == null ? "0" : id));
	}

	static void onDisconnected() {
		Application.index();
	}

	static void onAuthenticated() {
		Student s = Student.find("byEmail", Security.connected()).first();
		if (s.isAdmin)
			Admin.index();
		else {
			try {
				Students.view(s.id + "");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}