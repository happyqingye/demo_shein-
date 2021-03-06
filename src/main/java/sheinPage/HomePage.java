package sheinPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;



public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		if (!driver.getTitle().contains("Shop Women's Clothing, Shoes, Bags & more online | SHEIN IN"))
		{
		      throw new IllegalStateException("Not on Home page");
		 }
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath ="//*[@class='iconfont-critical icon-sheinlogo']")
	protected WebElement HomeLogo;
	
	@FindBy(xpath = "//i[@class='iconfont-critical icon-yonghuicon-']")
	protected WebElement LoginButton;
	
	@FindBy(xpath = "//i[@class='iconfont-critical icon-yonghuicon-']")
	protected WebElement options;
	
	public boolean islogopresent() 
	{
		Boolean logo= HomeLogo.isDisplayed();
		return  logo;
	}
	
	public boolean isloginpresent() 
	{
		return LoginButton.isDisplayed();
		
	}
	
	public boolean verifyOptions()
	{
		Actions act = new Actions(pageDriver);
		act.moveToElement(options).perform();
			
		String expected1 = "Sign in/Register;My Orders;My Message;My Tickets;My Wallet;My Wishlist;My Address Book;My Design;Free Trial Report;Gift Card;My Points";
		List<String> expected2 = new ArrayList<>(Arrays.asList(expected1.split(";")));
		
		List<WebElement> actualallOptions = pageDriver.findElements(By.xpath("//div[contains(@class,'nologin-user-dropdown')]//a"));
		List<String> actualdropdownvalues=new ArrayList<>();
		for(WebElement eachdropdownvalue: actualallOptions)
		{
			actualdropdownvalues.add(eachdropdownvalue.getText());
		}
		
		actualdropdownvalues.removeAll(Arrays.asList(null,""));
		
		for(int i = 0; i<actualdropdownvalues.size();i++)
		{
			
			Assert.assertEquals(actualdropdownvalues, expected2);
		}
		return true;
				
	}
	
	public LoginPage clickloginbutton()	
	{ 
			LoginButton.click();
			return new LoginPage(pageDriver);
	}
	
}
