package model;

public class Rule {

	boolean active;
	boolean mutable;
	int id;
	String theRule;
	
	Rule(int id, String theRule){
		this.id = id;
		this.theRule = theRule;
		active = false;
		mutable = true;
	}
	
	public String toString(){
		return(id + ".\n" + theRule);
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		
		this.active = active;
	}

	public boolean isMutable() {
		return mutable;
	}

	public void setMutable(boolean mutable) {
		this.mutable = mutable;
	}

	public int getId() {
		return id;
	}	
}
