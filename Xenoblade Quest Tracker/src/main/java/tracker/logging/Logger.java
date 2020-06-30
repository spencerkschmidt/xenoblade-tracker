package tracker.logging;

public class Logger
{
	private static LogLevel loggingLevel = LogLevel.HIGH;
	private final String name;

	public Logger(String name)
	{
		this.name = name;
	}

	public void log(Object message)
	{
		if (loggingLevel != LogLevel.NONE)
			System.out.println(String.format("[INFO] [%s]: %s", this.name, message));
	}

	public void warn(String message)
	{
		if (loggingLevel == LogLevel.HIGH || loggingLevel == LogLevel.MEDIUM)
			System.out.println("[WARN] [" + this.name + "]: " + message);
	}

	public void error(String message)
	{
		if (loggingLevel == LogLevel.HIGH)
			System.err.println("[ERROR] [" + this.name + "]: " + message);
	}

	public static void setLogLevel(LogLevel level)
	{
		loggingLevel = level;
	}

	public static enum LogLevel
	{
		HIGH,
		MEDIUM,
		LOW,
		NONE
	}
}