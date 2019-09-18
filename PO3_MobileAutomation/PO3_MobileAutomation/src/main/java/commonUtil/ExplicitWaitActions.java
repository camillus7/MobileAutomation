package commonUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitActions {
	
	public WebElement ExplicitWaitClick(WebDriver driver , WebElement element)  {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
		
		}

}
