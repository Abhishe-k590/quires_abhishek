package ecommerce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericreporistory.Cartnam;
import genericreporistory.Quantiydrop;
import genericreporistory.TvName;
import genericutilities.Excelutilities;
import genericutilities.WebdriverUtilities;

public class Testcase_01 {


	
	public static void main(String[] args) throws Throwable {
		WebdriverUtilities file=new WebdriverUtilities();
		Excelutilities excel=new Excelutilities();
		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
WebDriver driver=new FirefoxDriver();
driver.get("https://www.walmart.com/");
driver.manage().window().maximize();
//to load the page
file.waitforpageload(driver);
 String title = driver.getTitle();
// System.out.println(title);
 
 if(title.equals("Walmart.com | Save Money. Live Better."))
 {
	 System.out.println("Homepage is validated");
 }
 else
 {
	 System.out.println(" Homepage is not validated");
 }
file.takescreenshot(driver);


driver.findElement(By.xpath("//button[@id='global-search-dropdown-toggle']")).click();



List<WebElement> List= driver.findElements(By.xpath("//button[@class='g_a p_a p_aw p_l p_b bf_c']"));

for(WebElement value:List)
{
	String text = value.getText();
	

if(text.equals("Electronics"))
{
value.click();
}}

driver.findElement(By.xpath("//button[@id='global-search-submit']")).click();

WebElement ele16 = driver.findElement(By.xpath("//div[@class='LinesEllipsis  'and@style='white-space: pre-wrap;'and text()='TVs'and .='TVs']"));

file.ElementToBeClickable(driver, ele16);


String tvtitle = driver.getTitle();
//System.out.println(tvtitle);
if(tvtitle.equals("TVs, 4K HDTV, Smart TVs, LCD TVs | Walmart.com - Walmart.com"))
{
	System.out.println("All tvs page is visible");
}
else
{
	System.out.println("All tvs page is not visible");
}
file.takescreenshot(driver);

//select "70"&larger" filter option from screensize

WebElement ele12 = driver.findElement(By.id("70--&-Larger-0-tv_screen_size_range_new"));
file.ElementToBeClickable(driver, ele12);

TvName tv=new TvName(driver);
 WebElement ele3 = tv.getTvname();

JavascriptExecutor executor = (JavascriptExecutor)driver;
executor.executeScript("arguments[0].click();", ele3);
String text3 = ele3.getText();
System.out.println(text3);
/*ele3.click();*/
if(text3.contains("70"))
{
	System.out.println("First tv name is equal to 70");
	
}else
{
	System.out.println("First tv name is greater than  70");
}

	

	WebElement ele4 = driver.findElement(By.xpath("//h1[@class='prod-ProductTitle prod-productTitle-buyBox font-bold']"));
	String tex = ele4.getText();
	System.out.println(tex);
	excel.setExcelData("sheet2", 0, 0, tex);
	
	
	WebElement amt = driver.findElement(By.xpath("//h1[text()='onn. 70” Class 4K UHD (2160P) LED Roku Smart TV HDR (100012588)']/..//span[@class='price-characteristic']"));
String amttext = amt.getText();
//System.out.println(amttext);
excel.setExcelData("sheet2", 1, 0, amttext);


Thread.sleep(3000);


 Quantiydrop drop=new Quantiydrop(driver);
 WebElement ele5 = drop.getDropdown();
file.selectbyvisibletext(ele5,"2");



WebElement ele9 = driver.findElement(By.xpath("//span[@class='spin-button-children']"));
ele9.click();

WebElement ele6 = driver.findElement(By.xpath("//a[@class='PACModal-total-items-count']"));
Cartnam cart=new Cartnam(driver);
String carttest = cart.getAddcart().getText();

//System.out.println(carttest);

if(carttest.equals("2 items in cart"))
{
	System.out.println("items added to cart");
}else
{
	System.out.println("items not added to cart");
}
file.takescreenshot(driver);
Thread.sleep(3000);
 driver.findElement(By.xpath("(//span[text()='View cart'])[1]")).click();



WebElement ele7 = driver.findElement(By.xpath("//a[@class='js-btn-product btn-fake-link cart-item-name-link']"));
String text7 = ele7.getText();

String TvFullnam = excel.getdata("sheet2", 0,0 );

if(TvFullnam.equals(tex))
{
	System.out.println("TvFullnameis same");
}
else{
	System.out.println("Tv FUllName is not same");
}
file.takescreenshot(driver);

WebElement ele11 = driver.findElement(By.xpath("//span[.='Subtotal']/../following-sibling::span[@class='Discount order-summary-price text-right']"));

 String subtotal = ele11.getText();
 
System.out.println(subtotal);


String s = subtotal.substring(1, 6);

char[] ch = s.toCharArray();
 String amt1 = "";

for(int i=0;i<ch.length;i++)
	
{
	subtotal.substring(1, 6);
	if(ch[i]>='0'&&ch[i]<='9')
	{
		amt1=amt1+ch[i];
	}
}
int subamt = Integer.parseInt(amt1);


String onetvamt = excel.getdata("sheet2", 1, 0);

int amtmt = Integer.parseInt(onetvamt);
int amountoftv = amtmt+amtmt;

if(amountoftv==subamt)
{
	System.out.println("subtotal is validated");
}else
{
	System.out.println("subtotal is not validated");
}
file.takescreenshot(driver);

// Launch the google URL
driver.get("https://www.google.com/");

//click on Google apps button
driver.findElement(By.xpath("//*[name()='svg'and@class='gb_Xe']")).click();


WebElement ele13 = driver.findElement(By.xpath("//iframe[@role='presentation']"));

file.SwitchToFrameByEle(driver, ele13);

//Select youtube app
driver.findElement(By.xpath("//span[.='YouTube']")).click();

driver.navigate().refresh();


//Read TV name from exceland Enter tv name in search textbox
driver.findElement(By.xpath("//input[@id='search']")).sendKeys(TvFullnam);

//click on search button
driver.findElement(By.id("search-icon-legacy")).click();
//Screenshot
file.takescreenshot(driver);
 
	}

	



	}


