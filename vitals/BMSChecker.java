package vitals;

import static vitals.MonitorStates.*;

public interface BMSChecker {
	
	static String separator = new String(new char[40]).replace("\0", "-")+"\n";
		
	static void print(String text) {
		System.out.println(text);
	}
	
	static void checkWarning(MonitorParams param, float value,Validator validator, int language) {
		if(value<=validator.getLowerWarning()) {
			print(WARNING.toString(language) + param.toString(language) + IS_IN_LOWER_WARNING.toString(language));
			return;
		}
		if(value>=validator.getUpperWarning()) {
			print(WARNING.toString(language) + param.toString(language) + IS_IN_UPPER_WARNING.toString(language));
			return;
		}
		print(param.toString(language) + IS_WITHIN_LIMIT.toString(language));
	}
	
	static Boolean checkInRange(MonitorParams param, float value,Validator validator, int language) {
		if(value<validator.getLowerLimit()) {
			print(BREACH.toString(language) + param.toString(language) + IS_BELOW_ALLOWED_LIMIT.toString(language));
			return false;
		}
		if(value>validator.getUpperLimit()) {
			print(BREACH.toString(language) + param.toString(language) + IS_ABOVE_ALLOWED_LIMIT.toString(language));
			return false;
		}
		checkWarning(param,value,validator,language);
		return true;
	}
}