package genericreporistory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Quantiydrop {
	
	WebDriver driver;
	
	public Quantiydrop(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
		@FindBy(xpath="//select[@aria-label='Quantity']")
		private WebElement dropdown;

		public WebElement getDropdown() {
			return dropdown;
		}
		
		
	

}
