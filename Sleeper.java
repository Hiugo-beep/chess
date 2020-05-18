package Interface;
import java.util.concurrent.TimeUnit;
public class Sleeper extends Thread{
	int duration;
	public Sleeper(String name, int sleepTime) {
		super(name);
		duration = sleepTime;
		
	}
	public void run() {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			return;
		}
	}
}
