package model;

public class GuestUser {
	private long generatedID;
	private static long idCounter = 1;

	public long getGeneratedID() {
		return generatedID;
	}
	public void setGeneratedID() {
		generatedID = idCounter++;
	}
	
	public GuestUser() {
		setGeneratedID();
	}

	public String toString() {
		return "GUESTUSER: " + generatedID;
	}
	
	
}
