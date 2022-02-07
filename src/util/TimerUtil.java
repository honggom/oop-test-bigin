package util;

import java.util.Timer;
import java.util.TimerTask;

public class TimerUtil {

	public static void doAfter(long after, Runnable function) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				function.run();
			}
		};
		timer.schedule(task, after);
	}
}
