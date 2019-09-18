package commonUtil;

import org.apache.commons.lang3.time.StopWatch;

/**
 * A simpler version of Apache's StopWatch.
 * Exposing methods to start, stop, and get the duration. 
 *
 */
public class StopWatchUtil {

	private StopWatch stopWatch = null;
	
	private StopWatchUtil() {
		stopWatch = new StopWatch();
	}
	
	public StopWatchUtil start() {
		this.stopWatch.start();
		return this;
	}
	
	public StopWatchUtil stop() {
		this.stopWatch.stop();
		return this;
	}
	
	public long getDurationInSeconds() {
		long time_ms = this.stopWatch.getTime();
		long durationInSeconds = time_ms / 1000;
		return durationInSeconds;
	}

	public static StopWatchUtil getInstance() {
		return new StopWatchUtil();		
	}

	public String printTotalDuration() {
		return this.printTotalDuration("");	
	}
	
	public String printTotalDuration(String userName) {
		String name = "";
		if (userName.length() > 1) {
			name = "for user '"+userName+"' ";
		}
		String durationString = name +"- duration in milliseconds: '"+this.getDurationInMillseconds()+"', duration is seconds: '"+this.getDurationInSeconds()+"'";
		System.out.println(durationString);	
		return durationString;
	}

	private long getDurationInMillseconds() {
		return this.stopWatch.getTime();		
	}
	
}
