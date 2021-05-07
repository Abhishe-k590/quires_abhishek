package genericreporistory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cartnam {
	
	WebDriver driver;
	
public Cartnam(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}



@FindBy(xpath="//a[@class='PACModal-total-items-count']")
private WebElement addcart;

public WebElement getAddcart() {
	return addcart;
}
}
