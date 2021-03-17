package vitals.logger;

public interface ILogger {
	static String separator = new String(new char[40]).replace("\0", "-")+"\n";
	
	public void separate();
	
	public void print(String msg);
	
}
