package shopizer.tools;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericPage {

	
	protected final WebDriver driver;

	public GenericPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	@FindBy(xpath="//div[@class='mainmenu hidden-xs']//li[@class]//a[@href='/shopizer/shop/category/tables.html/ref=c:1']")
	WebElement bouton_table;
	
	@FindBy(xpath="//div[@class='mainmenu hidden-xs']//li[@class]//a[@href='/shopizer/shop/category/bedroom.html/ref=c:50']")
	public WebElement bouton_bedroom;
	
	@FindBy(xpath="//div[@class='mainmenu hidden-xs']//li[@class]//a[@href='/shopizer/shop/category/night-tables.html/ref=c:100']")
	public WebElement night_tables;
	
	@FindBy(xpath="//div[@class='mainmenu hidden-xs']//li[@class]//a[@href='/shopizer/shop/category/bedroom.html/ref=c:50,50']")
	public WebElement bouton_bedroom_hover;
	
	@FindBy(xpath="//span[@class='lnr lnr-cart']/..")
	WebElement panier_d_achat;
	
	@FindBy(xpath="//a[@onclick='viewShoppingCartPage();']")
	WebElement bouton_paiement;
	
	@FindBy(xpath="//span[@class='lnr lnr-cart']/following-sibling::*/strong")
	WebElement nombre_article_panier;
	
	
	
	public PageTable goPageTable(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		bouton_table.click();
		return PageFactory.initElements(driver, PageTable.class);
	}
	
	public PageBedroom goPageBedroom(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		bouton_bedroom.click();
		return PageFactory.initElements(driver, PageBedroom.class);
	}
	
	
	public ShoppingCartPage paiement(WebDriver driver) throws InterruptedException {
		Actions hover = new Actions(driver);
		hover.moveToElement(panier_d_achat).build().perform();
	//	Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 120);
	//	Thread.sleep(3000);
		WebElement bouton_paiement1 = wait.until(ExpectedConditions.elementToBeClickable(bouton_paiement));
		//Thread.sleep(3000);
		bouton_paiement1.click();
	//	bouton_paiement1.click();
		Thread.sleep(1000);
		return PageFactory.initElements(driver, ShoppingCartPage.class);
	}
	
	public void checkNombreArticlePanier(String nombreArticle) throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Nombre panier : "+ nombre_article_panier.getText());
		Assert.assertTrue("Total article",nombre_article_panier.getText().equals(nombreArticle));
	}

	
}
