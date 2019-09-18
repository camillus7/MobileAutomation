package com.webautomation.validation;


import java.awt.event.KeyEvent;
import java.awt.AWTException;
import java.awt.Robot ;


public class DelayedPressEnterThread implements Runnable{
	
	Thread runner;
	private int delay ;
		
	public DelayedPressEnterThread() {
	}
	public DelayedPressEnterThread(String threadName) {
		this.delay = 10000 ;
		init (threadName) ;
			
	}
	public DelayedPressEnterThread(String threadName, int delay) {
		this.delay = delay ;
		init (threadName) ;
	}
	private void init(String threadName) {
		runner = new Thread(this, threadName); // (1) Create a new thread.
		runner.start(); // (2) Start the thread.
	}
	public void run() {
		
		Robot robot = null ;
		try {
			robot = new Robot();
			System.out.println("Trying new robot");
			robot.delay(200);
			System.out.println("Trying delay");
		} catch (AWTException e) {
			e.printStackTrace();
		}
		//robot.delay(delay) ;
		robot.delay(2000);
	    robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.delay(500);
	    robot.keyRelease(KeyEvent.VK_ESCAPE);  
	}

}
