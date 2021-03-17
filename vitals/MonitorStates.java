package vitals;

public enum MonitorStates {
	SUCCESS,
	WARNING,
	BREACH,
	IS_ABOVE_ALLOWED_LIMIT,
	IS_BELOW_ALLOWED_LIMIT,
	IS_IN_LOWER_WARNING,
	IS_IN_UPPER_WARNING,
	IS_WITHIN_LIMIT;
	
	public String toString() {
		return this.name()+"::";
	}
}