package genericutilities;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebdriverUtilities {
	
	
	
	public void Visibilityelement(WebDriver driver,WebElement element){
		
		WebDriverWait wait =new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element)).click();
		}
	
	public void ElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait =new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	
	public void selectbyvisibletext(WebElement element,String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void SelectByIndex(WebElement element,int index)
	{
		Select select =new Select(element);
		select.selectByIndex(index);
	}
	
	
	//to load the page
	public void waitforpageload(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
	}
	
	/**
	 * used to wait & click for expected element in GUI
	 * 
	 * @param element
	 * @throws Throwable
	 */
	public void waitAndClick(WebElement element) throws Throwable {
		int count = 0;
		while (count < 50) {
			try {
				element.click();
				break;
			} catch (Throwable e) {
				Thread.sleep(500);
				count++;
			}
		}
	}
	
	
	
	 
		
	public void switchtochildwindow1(WebDriver driver) {
		Set<String> winid = driver.getWindowHandles();
		Iterator<String> iterator = winid.iterator();
		String parentwin = iterator.next();
		String childwin = iterator.next();
		driver.switchTo().window(childwin);
	}

	public void switchtoparentwindow(WebDriver driver) {
		Set<String> winid = driver.getWindowHandles();
		Iterator<String> iterator = winid.iterator();
		String parentwin = iterator.next();
		driver.switchTo().window(parentwin);
	}
	
	
	public void scroll(WebDriver driver,WebElement scrollbypixels)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,scrollbypixels)");
		
	}	
			
public void MoveTElement(WebDriver driver,WebElement element)
{
	Actions action =new Actions(driver);
	action.moveToElement(element).perform();
	
}
public void DoubleClick(WebDriver driver,WebElement element)
{
	Actions action =new Actions(driver);
	action.doubleClick().perform();
	
}
public void SwitchToFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}

public void SwitchToFrameByEle(WebDriver driver,WebElement element)
{
	/**
	 * to switchtoframe
	 */
	driver.switchTo().frame(element);
}


public  void takescreenshot(WebDriver driver) throws IOException
{
	JavaUtilities java=new JavaUtilities();
	int ranum = java.RandomNum();
	/**
	 * 
	 * to takescreenshot
	 */try{
	TakesScreenshot scrshot=(TakesScreenshot)driver;
	File scrFile = scrshot.getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(scrFile,new File("E:\\selenium\\Project\\screenshot"+ranum+".png"));
	
	
}catch(Exception e){
	System.out.println("Exception while taking screenshot"+e.getMessage());
}
	
}

public void accpetallert(WebDriver driver) {
	/**
	 * 
	 * used to Switch to Alert Popup & click on OK button
	 */
	driver.switchTo().alert().accept();
}

public void dismisallert(WebDriver driver) {
	/**
	 * used to Switch to Alert Popup & click on cancel button
	 */
	driver.switchTo().alert().dismiss();
}


}






