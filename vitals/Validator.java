package vitals;

public class Validator {
	private float upperLimit = Float.MAX_VALUE;
	private float lowerLimit = Float.MIN_VALUE;
	private float tolerance = 5;
	private float upperWarning;
	private float lowerWarning;

	public Validator(float upperLimit, float lowerLimit, float tolerance) {
		this.upperLimit = upperLimit;
		this.lowerLimit = lowerLimit;
		this.tolerance = (upperLimit * tolerance)/100;
		this.upperWarning = upperLimit - tolerance;
		this.lowerWarning = lowerLimit + tolerance;
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
}
