package vitals;

import static vitals.MonitorStates.*;

public interface CheckerUtility {
	
	static Boolean checkLowerWarning(MonitorParams param, float value,Validator validator) {
		if(value<=validator.getLowerWarning()) {
			validator.setMessage(WARNING.toString() + param.toString() + IS_IN_LOWER_WARNING.toString());
			return true;
		}
		return checkHigherWarning(param,value,validator);
	}
	
	static Boolean checkHigherWarning(MonitorParams param, float value, Validator validator) {
		if(value>=validator.getUpperWarning()) {
			validator.setMessage(WARNING.toString() + param.toString() + IS_IN_UPPER_WARNING.toString());
			return true;
		}
		return statusOk(validator,param);
	}

	static Boolean statusOk(Validator validator, MonitorParams param) {
		validator.setMessage(SUCCESS.toString() + param.toString() + IS_WITHIN_LIMIT.toString());
		return true;
	}

	static Boolean checkInRange(MonitorParams param, float value,Validator validator) {
		if(value<validator.getLowerLimit()) {
			validator.setMessage(BREACH.toString() + param.toString() + IS_BELOW_ALLOWED_LIMIT.toString());
			return false;
		}
		return checkUpperRange(param,value,validator);
	}

	static Boolean checkUpperRange(MonitorParams param, float value, Validator validator) {
		if(value>validator.getUpperLimit()) {
			validator.setMessage(BREACH.toString() + param.toString() + IS_ABOVE_ALLOWED_LIMIT.toString());
			return false;
		}
		return checkLowerWarning(param,value,validator);
	}
}