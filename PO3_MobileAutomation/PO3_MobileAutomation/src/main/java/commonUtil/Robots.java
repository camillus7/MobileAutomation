package commonUtil;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

public class Robots {
	
	public void robotOffsetEscape( ) throws InterruptedException, AWTException {

	  Robot robot = new Robot();
	  robot.mouseMove(50, 500);
	  robot.mousePress(InputEvent.BUTTON1_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_MASK);
	  robot.keyPress(KeyEvent.VK_ESCAPE);
	  robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	public void closeWindow(WebDriver driver) throws Exception{
		Robot robot = new Robot();
		// A short pause, just to be sure that OK is selected
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		   
	}

}
