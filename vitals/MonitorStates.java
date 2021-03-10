package vitals;

public enum MonitorStates {
	SUCCESS("SUCCESS:: ", "ERFOLG:: "),
	WARNING("WARNING:: ", "WARNUNG:: "),
	BREACH("BREACH:: ", "BRUCH:: "),
	IS_ABOVE_ALLOWED_LIMIT(" is above the allowed limit.", " liegt uber dem zulassigen Grenzwert."),
	IS_BELOW_ALLOWED_LIMIT(" is below the allowed limit.", " liegt unter dem zulassigen Grenzwert."),
	IS_IN_LOWER_WARNING(" is reaching the lower limit.", " erreicht die Untergrenze."),
	IS_IN_UPPER_WARNING(" is reaching the upper limit.", " erreicht die Obergrenze."),
	IS_WITHIN_LIMIT(" is within the limit.", " ist innerhalb der Grenze.");
	
	private String[] displayText;
	
	private MonitorStates(String... displayText) {
		this.displayText = displayText;
	}
	
	public String toString(int language) {
		return this.displayText[language];
	}
}