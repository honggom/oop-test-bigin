package util;

public class DelayUtil {
	
	private static final long BASE_DELAY = 3000;
	
	public static void delay(double attackSpeed) {
		long delay = (long) (BASE_DELAY / attackSpeed);
		
		try {
			System.out.println("delay : " + delay);
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
