package	 ca.ubc.cpsc210.fobsystem;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** 
 * This class represents a box that can be attached to a resource, such
 * as a door, and used to grant or deny access to a user with a fob.
 * 
 * @author Gail Murphy
 */

public class FobControlUnit {
	
	// Information about which user is associated with which fob.
	// If a fob and user appears in this map, the fob has access
	// to the protected resource.
	private Map<Fob, User> userMap; 
	
	/**
	 * Constructor
	 */
	public FobControlUnit() {
		userMap = new HashMap<Fob, User>();
	}

	/**
	 * Initialize which fobs have access to the protected resource.
	 * In a real implementation of such a system, this method would
	 * likely be called from the constructor and might read from
	 * a web service. We'll just pass the information for simplicity
	 * and ease of testing.
	 * 
	 * @param fobs the fobs to grant access
	 * @param users the user of each fob
	 * 
	 * Requires: the size of the fobs and users lists to be the same
	 * Modifies: initializes userMap
	 * Effects: userMap is loaded with fobs and users. Throws an
	 *   exception if the fobs and users lists are not the same size
	 */
	public void initializeFobs(List<Fob> fobs, List<User> users) throws IllegalValuesException {
		if ( fobs != null && users != null ) {
			if ( fobs.size() != users.size() ) 
				throw new IllegalValuesException();
			else {
				for ( int i = 0; i < fobs.size(); i++ ) {
					// Put returns the value replaced in the map for this key.
					// We will ignore this return value.
					userMap.put(fobs.get(i), users.get(i));
				}
			}
		}
	}
	
	/**
	 * Does this fob have access? If so, record having granted access.
	 * 
	 * @param fob The fob to check
	 * @return true if the fob has access and false otherwise
	 */
	public boolean hasAccess(Fob fob) {
		if ( fob != null ) {
			if ( userMap.containsKey(fob) ) {
				User fobUser = userMap.get(fob);
				fobUser.recordAccess(Calendar.getInstance().getTime());
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Produce a report about the data loaded and recorded by this unit
	 * @return a report as a string
	 */
	public String produceReport() {
		
		String report = new String();

		Set<Fob> fobs = userMap.keySet();
		for (Fob aFob: fobs) {
			User fobUser = userMap.get(aFob);
			report = report.concat(aFob.getReportString());
			report = report.concat(fobUser.getReportString());
		}
		
		return report;
	}
}
