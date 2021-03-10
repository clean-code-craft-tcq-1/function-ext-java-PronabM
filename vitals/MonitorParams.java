package vitals;

public enum MonitorParams {
	TEMP("Temperature", "Temperatur"),
	SOC("State of Charge", "Ladezustand"),
	CR("Charge Rate", "Ladestrom");
	
	private String[] displayText;
	
	private MonitorParams(String... displayText) {
		this.displayText = displayText;
	}
	
	public String toString(int language) {
		return this.displayText[language];
	}
}
