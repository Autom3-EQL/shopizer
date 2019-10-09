package shopizer.tools;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends GenericPage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="(//input[@type='number'])[1]")
	WebElement quantite_compact_night_table;
	
	@FindBy(xpath="(//input[@type='number'])[2]")
	WebElement antique_recycled_wood_storage;
	
	@FindBy(xpath="(//span[@class='amount'])[2]")
	WebElement total_price;
	
	@FindBy(xpath="//a[text()='Recalculer']")
	WebElement recalculer;
	
	@FindBy(xpath="//h1")
	WebElement label_revoir_votre_commande;
	
	
	public void changePriceCompact(String quantite) throws InterruptedException {
		Thread.sleep(2000);
		quantite_compact_night_table.clear();
		Thread.sleep(2000);
		quantite_compact_night_table.sendKeys(quantite);
		Thread.sleep(1000);
	}
	public void changePriceAntique(String quantite) throws InterruptedException {
		Thread.sleep(2000);
		antique_recycled_wood_storage.clear();
		Thread.sleep(2000);
		antique_recycled_wood_storage.sendKeys(quantite);
		Thread.sleep(1000);
	}
	
	public void checkTotalPrice(String price) throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Prix total : "+total_price.getText());
		Thread.sleep(2000);
		Assert.assertTrue("Prix total", total_price.getText().equals(price));
	}
	
	public void recalculer() throws InterruptedException {
		Thread.sleep(1000);
		recalculer.click();
	}
	
	public void checkRevoirVotreCommande() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue("Label : revoir votre commande - text", label_revoir_votre_commande.getText().equals("Revoir votre commande"));
		Thread.sleep(3000);
		Assert.assertTrue("Label : revoir votre commande - affichage",label_revoir_votre_commande.isDisplayed());
	}
}
