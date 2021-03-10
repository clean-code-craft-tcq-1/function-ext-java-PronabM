package vitals;

import static vitals.BMSChecker.*;

import java.util.Map;

public class BMS {
	private Map<MonitorParams,Validator> validators;
	private int language = 0;
	
	public BMS(Map<MonitorParams,Validator> validators, int language) {
		this.validators = validators;
		this.language = language;
	}
	
	public Validator getValidator(MonitorParams state) {
		return this.validators.get(state);
	}

	public boolean checkBattery(Map<MonitorParams, Float> params){
		boolean status = true;
		for(Map.Entry<MonitorParams, Validator> validator: validators.entrySet())
			status = checkInRange(validator.getKey(),params.get(validator.getKey()),validator.getValue(), language) && status;
		print(separator);
		return status;
	}
}