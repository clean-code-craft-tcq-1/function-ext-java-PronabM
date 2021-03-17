package vitals;

public enum MonitorParams {
	TEMP,
	SOC,
	CR;
	
	public String toString() {
		return this.name()+"::";
	}
}
