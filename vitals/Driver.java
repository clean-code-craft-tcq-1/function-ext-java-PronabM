package vitals;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import vitals.logger.ConsoleLogger;

import static vitals.MonitorParams.*;

public class Driver {
	
	static final int LANG_EN = 0;
	static final int LANG_DE = 1;
	
	public static void main(String[] args) {
		Map<MonitorParams,Validator> validators = new HashMap<MonitorParams, Validator>();
		validators.put(TEMP, new Validator(45, 0, 5));
		validators.put(SOC, new Validator(80, 20, 5));
		validators.put(CR, new Validator(0.8f, Float.MIN_VALUE, 5));
		Tester tester = new Tester(new BatteryManagementSystem(validators,
								   new ConsoleLogger(),
								   Locale.GERMAN));
		
		tester.tempAboveLimit_Failure();
		tester.tempBelowLimit_Failure();
		tester.tempWithinLimit_Success();
		tester.socAboveLimit_Failure();
		tester.socBelowLimit_Failure();
		tester.socWithinLimit_Success();
		tester.crAboveLimit_Failure();
		tester.crWithinLimit_Success();
		tester.allParamOutsideLimit_Failure();
		tester.allParamWarning_Success();
		tester.allParamInsideLimit_Success();
    }
}