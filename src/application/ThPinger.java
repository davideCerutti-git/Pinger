package application;

import java.io.IOException;

public class ThPinger implements Runnable {

	private String ipAddress;
	private boolean isAlive;

	public ThPinger(String ip) {
		this.ipAddress = ip;
	}

	@Override
	public void run() {
		int returnVal = 0;
		boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");
		try {
		ProcessBuilder processBuilder = new ProcessBuilder("ping", isWindows ? "-n" : "-c", "1", ipAddress);
		System.out.println("Sending Ping Request to " + ipAddress);
		Process proc;
	
			proc = processBuilder.start();
			returnVal = proc.waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		if (returnVal != 0)
			isAlive = true;
		else
			isAlive = false;
	}

}
