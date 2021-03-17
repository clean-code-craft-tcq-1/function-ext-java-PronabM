package vitals.logger;

public class ConsoleLogger implements ILogger {

	public void print(String msg) {
		System.out.println(msg);
	}

	public void separate() {
		print(ILogger.separator);
	}
}
