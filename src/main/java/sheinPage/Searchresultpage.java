package sheinPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Searchresultpage extends BasePage{

	public Searchresultpage(WebDriver driver) {
		super(driver);
		if (!driver.getTitle().contains("Search"))
		{
		      throw new IllegalStateException("Not on Search page");
		 }
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(product));
		
		}

	
	@FindBy(xpath ="//div[contains(@class,'gds-li-ratiowrap')]//img[contains(@class,'j-verlok-lazy loaded')]")
	protected WebElement itemImage;
	
	@FindBy(xpath="//input[@type='search']")
	protected WebElement search;
	
	@FindBy(xpath="//i[@class='iconfont-critical icon-tubiaozhizuomoban header2-icon-search']")
	protected WebElement submitsearch;
	
	@FindBy(xpath ="//button[contains(@class,'btn-add-to-bag-375255')]")
	protected WebElement item;
	
	@FindBy(xpath ="//label[3]//span[1]")
	protected WebElement size;
	
	@FindBy(xpath ="//button[contains(@class,'add-bag-submit-375255')]")
	protected WebElement selectitem;
	
	
	@FindBy(xpath ="//i[contains(@class,'iconfont-critical icon-gouwudai')]")
	protected WebElement addcartbutton;
	
	@FindBy(xpath ="//span[@class='header-sum']")
	protected WebElement product;
		
	
	@FindBy(xpath ="//i[contains(@class,'iconfont-critical icon-gouwudai')]")
	protected WebElement Cartbutton;
	
	
	public void searchItem(String itemID)
	{
		search.clear();
		search.sendKeys(itemID);
		submitsearch.click();
	}
	
	public void addtocart()
	{
		
		Actions act = new Actions(pageDriver);
		act.moveToElement(itemImage).perform();
		item.click();
		size.click();
		selectitem.click();
		System.out.println("Item submitted");
		
	}

	public CartPage navigateToCart()
	{
		Cartbutton.click();
		return new CartPage(pageDriver);
		
	}
		
}
