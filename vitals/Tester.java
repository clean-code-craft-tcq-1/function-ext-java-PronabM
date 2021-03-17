package vitals;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import static vitals.MonitorParams.*;

public class Tester {
	
	private BatteryManagementSystem bms;
	private float maxTemp;
	private float minTemp;
	private float tempTolerance;
	private float maxSoc;
	private float minSoc;
	private float socTolerance;
	private float maxCR;
	private float crTolerance;
	private Random random = new Random();
	
	public Tester(BatteryManagementSystem bms) {
		this.bms = bms;
		this.maxTemp = bms.getValidator(TEMP).getUpperLimit();
		this.minTemp = bms.getValidator(TEMP).getLowerLimit();
		this.tempTolerance = bms.getValidator(TEMP).getTolerance();
		this.maxSoc  = bms.getValidator(SOC).getUpperLimit();
		this.minSoc  = bms.getValidator(SOC).getLowerLimit();
		this.socTolerance = bms.getValidator(SOC).getTolerance();
		this.maxCR   = bms.getValidator(CR).getUpperLimit();
		this.crTolerance = bms.getValidator(CR).getTolerance();
	}

	public void tempAboveLimit_Failure() {
		Map<MonitorParams, Float> params = new HashMap<MonitorParams, Float>();
		params.put(TEMP, maxTemp+1);
		params.put(CR, maxCR);
		params.put(SOC,maxSoc);
		assert(bms.checkBattery(params)==false);
	}
	
	public void tempBelowLimit_Failure() {
		Map<MonitorParams, Float> params = new HashMap<MonitorParams, Float>();
		params.put(TEMP, minTemp-1);
		params.put(CR, maxCR);
		params.put(SOC,maxSoc);
		assert(bms.checkBattery(params)==false);
	}
	
	public void tempWithinLimit_Success() {
		float randomTempWithinRange = minTemp + tempTolerance + random.nextFloat() * (maxTemp - minTemp - 2*tempTolerance);
		Map<MonitorParams, Float> params = new HashMap<MonitorParams, Float>();
		params.put(TEMP, randomTempWithinRange);
		params.put(CR, maxCR);
		params.put(SOC,maxSoc);
		assert(bms.checkBattery(params)==true);
	}
	
	public void socAboveLimit_Failure() {
		Map<MonitorParams, Float> params = new HashMap<MonitorParams, Float>();
		params.put(TEMP, maxTemp);
		params.put(CR, maxCR);
		params.put(SOC,maxSoc + 1);
		assert(bms.checkBattery(params)==false);
	}
	
	public void socBelowLimit_Failure() {
		Map<MonitorParams, Float> params = new HashMap<MonitorParams, Float>();
		params.put(TEMP, maxTemp);
		params.put(CR, maxCR);
		params.put(SOC,minSoc - 1);
		assert(bms.checkBattery(params)==false);
	}
	
	public void socWithinLimit_Success() {
		float randomSocWithinRange = minSoc + socTolerance + random.nextFloat() * (maxSoc - minSoc - 2*socTolerance);
		Map<MonitorParams, Float> params = new HashMap<MonitorParams, Float>();
		params.put(TEMP, maxTemp);
		params.put(CR, maxCR);
		params.put(SOC,randomSocWithinRange);
		assert(bms.checkBattery(params)==true);
	}
	
	public void crAboveLimit_Failure() {
		Map<MonitorParams, Float> params = new HashMap<MonitorParams, Float>();
		params.put(TEMP, maxTemp);
		params.put(CR, maxCR+1);
		params.put(SOC,maxSoc);
		assert(bms.checkBattery(params)==false);
	}
	
	public void crWithinLimit_Success() {
		float randomCRWithinRange = crTolerance + random.nextFloat() * (maxCR - 2*crTolerance);
		Map<MonitorParams, Float> params = new HashMap<MonitorParams, Float>();
		params.put(TEMP, maxTemp);
		params.put(CR, randomCRWithinRange);
		params.put(SOC,maxSoc);
		assert(bms.checkBattery(params)==true);
	}
	
	public void allParamOutsideLimit_Failure() {
		Map<MonitorParams, Float> params = new HashMap<MonitorParams, Float>();
		params.put(TEMP, maxTemp + 1);
		params.put(CR, maxCR + 1);
		params.put(SOC,minSoc - 1);
		assert(bms.checkBattery(params)==false);
	}
	
	public void allParamWarning_Success() {
		Map<MonitorParams, Float> params = new HashMap<MonitorParams, Float>();
		params.put(TEMP, maxTemp);
		params.put(CR, maxCR);
		params.put(SOC,minSoc);
		assert(bms.checkBattery(params)==true);
	}
	
	public void allParamInsideLimit_Success() {
		float randomTempWithinRange = minTemp + tempTolerance + random.nextFloat() * (maxTemp - minTemp - 2*tempTolerance);
		float randomSocWithinRange = minSoc + socTolerance + random.nextFloat() * (maxSoc - minSoc - 2*socTolerance);
		float randomCRWithinRange = crTolerance + random.nextFloat() * (maxCR - 2*crTolerance);
		Map<MonitorParams, Float> params = new HashMap<MonitorParams, Float>();
		params.put(TEMP, randomTempWithinRange);
		params.put(CR, randomCRWithinRange);
		params.put(SOC,randomSocWithinRange);
		assert(bms.checkBattery(params)==true);
	}
}