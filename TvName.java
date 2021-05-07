package genericreporistory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class TvName {
	
	WebDriver driver;
	
public	TvName(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//a[contains(.,'onn. 70 Class 4K UHD (2160P) LED Roku Smart TV HDR (100012588)')]")
private WebElement Tvname;

public WebElement getTvname() {
	return Tvname;
}
}



