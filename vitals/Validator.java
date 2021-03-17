package vitals;

public class Validator {
	private float upperLimit = Float.MAX_VALUE;
	private float lowerLimit = Float.MIN_VALUE;
	private float tolerance = 5;
	private float upperWarning;
	private float lowerWarning;
	private String message;

	public Validator(float upperLimit, float lowerLimit, float tolerance) {
		this.upperLimit = upperLimit;
		this.lowerLimit = lowerLimit;
		this.tolerance = (upperLimit * tolerance)/100;
		this.upperWarning = upperLimit - this.tolerance;
		this.lowerWarning = lowerLimit + this.tolerance;
	}

	public float getUpperLimit() {
		return upperLimit;
	}

	public float getLowerLimit() {
		return lowerLimit;
	}

	public float getTolerance() {
		return tolerance;
	}
	
	public float getUpperWarning() {
		return upperWarning;
	}

	public float getLowerWarning() {
		return lowerWarning;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
