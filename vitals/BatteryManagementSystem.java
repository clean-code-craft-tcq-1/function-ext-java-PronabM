package vitals;

import java.util.Map;
import vitals.logger.ILogger;
import static vitals.CheckerUtility.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class BatteryManagementSystem {
	private Map<MonitorParams,Validator> validators;
	private ILogger logger;
	private ResourceBundle bundle;
	
	public BatteryManagementSystem(Map<MonitorParams,Validator> validators, ILogger logger, Locale language) {
		this.validators = validators;
		this.logger = logger;
		Locale.setDefault(language);
		this.bundle = ResourceBundle.getBundle("vitals/messages/messages");
	}
	
	public String getMessage(String keys) {
		String msg = "";
		for(String key: keys.split("::"))
			msg += bundle.getString(key);
		return msg;
	}
	
	public Validator getValidator(MonitorParams state) {
		return this.validators.get(state);
	}

	public boolean checkBattery(Map<MonitorParams, Float> params){
		boolean status = true;
		for(Map.Entry<MonitorParams, Validator> validator: validators.entrySet()) {
			status = checkInRange(validator.getKey(),params.get(validator.getKey()),validator.getValue()) && status;
			logger.print(getMessage(validator.getValue().getMessage()));
		}
		logger.separate();
		return status;
	}
}
