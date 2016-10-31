package ca.ubc.cpsc210.fobsystem;

/**
 * A fob used to grant access to locked resources, such as doors in a building.
 * A fob includes a small LCD that can display a twelve digit alphanumeric
 * sequence. The alphanumeric sequence can be set by a user at a special kiosk.
 * One use of the LCD is to load and display a phone number of the owner of the
 * fob so the owner can be contacted if the fob is lost.
 * 
 * @author Gail Murphy
 * 
 */

public class Fob {

	// invariant:
	// displaySequence == null ||
	// (displaySequence != null && displaySequence.length() <= 12)
	// &&
	// uniqueId > 0

	// Each fob has a unique identifier assigned to it.
	private int uniqueId;

	// The alphanumeric sequence that can be loaded onto the
	// fob and displayed through the fob's LCD. 
	private String displaySequence;
	
	// Maximum length of displaySequence
	private final int MAX_LENGTH_OF_DISPLAY_SEQUENCE = 12;
	
	/**
	 * Constructor
	 * @param id is identifier of fob
	 * 
	 * Requires: id > 0
	 */
	public Fob(int id) {
		uniqueId = id;
	}
	
	/**
	 * Set the alphanumeric character sequence
	 * @param s The string to set the alphanumeric sequence for display
	 */
	public void setDisplaySequence(String s) {
		if ( (s != null) && ( s.length() <= MAX_LENGTH_OF_DISPLAY_SEQUENCE )) {
			displaySequence = s;
		}
		else if ( s != null ) {
			displaySequence = s.substring(0, 9);
		}
	}
	
	/**
	 * Get the current alphanumeric character sequence
	 * @return The alphanumeric character sequence.	
	 */
	public String getDisplaySequence() {
		return displaySequence;
	}
	

	/**
	 * Format a string with the most important information about a fob
	 * @return String formatted with fob information
	 */
	public String getReportString() {
		return new String("==Fob: <" + uniqueId + "> with LCD <" + displaySequence + ">\n");
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fob fob = (Fob) o;

        if (uniqueId != fob.uniqueId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return uniqueId;
    }
}
