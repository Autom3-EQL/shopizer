package shopizer.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBedroom extends GenericPage {

	public PageBedroom(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@id='productsContainer']//a[@productid='50']")
	WebElement compact_night_table;
	
	@FindBy(xpath="//div[@id='productsContainer']//a[@productid='152']")
	WebElement antique_recycle_wood_storage;
	

	public PageBedroom addCompactNightTable(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		compact_night_table.click();
		Thread.sleep(1000);
		return PageFactory.initElements(driver, PageBedroom.class);
	}
	
	public PageBedroom addAntiqueRecycleWoodStorage(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		antique_recycle_wood_storage.click();
		return PageFactory.initElements(driver, PageBedroom.class);
	}
	


}
