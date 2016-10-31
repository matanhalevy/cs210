package ca.ubc.cpsc210.fobsystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * A user of a fob. Records recent access granted to this user.
 * 
 * @author Gail Murphy
 */

public class User {

	// Customer name
	private String lastName;
	private String firstName;

	// A memory of recent access to a bound
	private List<Date> recentAccesses;

	/**
	 * Constructor
	 * 
	 * @param lName the last name of the user
	 * @param fName the first name of the user
	 */
	public User(String lName, String fName) {
		lastName = lName;
		firstName = fName;
		recentAccesses = new ArrayList<Date>();
	}

	/**
	 * Record a user's access using a fob
	 * 
	 * @param time the time the access occurred
	 */
	public void recordAccess(Date time) {
		recentAccesses.add(time);
	}

	/**
	 * Return a string formatted with user name and list of recent fob
	 * accesses in chronological order
	 * 
	 * @return a report as a formatted string 
	 */
	public String getReportString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String report = new String("\t" + lastName + ", " + firstName + "\n");
		Collections.sort(recentAccesses);
		for (Date d : recentAccesses) {
			report = report.concat("\t" + sdf.format(d) + "\n");
		}
		return report;
	}
}
