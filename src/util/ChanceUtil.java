package util;

import java.util.concurrent.ThreadLocalRandom;

public class ChanceUtil {
	
	public static boolean percent(double percent) {
		return percent > ThreadLocalRandom.current().nextDouble(0, 1);
	}
}
