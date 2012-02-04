import play.*;
import play.jobs.*;
import play.test.*;

import models.*;

@OnApplicationStart
public class Bootstrap extends Job {

	public void doJob() {
		// Check if the database is empty
		if (Student.count() == 0) {
			// Fixtures.load("initial-data.yml");
			Student s = new Student("Ahmed", "elhadiahmed3@gmail.com", "123",
					true, true);
			s.save();
			Student s2 = new Student("hadi", "e@gmail.com", "123",
					false, false);
			s2.save();
		}
	}

}