package shopizer.tools;

import org.junit.Assert;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAccueil extends GenericPage{
	
public PageAccueil(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		
		@FindBy(xpath="//img[@src='https://s3.ca-central-1.amazonaws.com/shopizer-lightsail/files/DEFAULT/banner.jpg']")
		WebElement image_accueil;
        public void CheckImagePageAccueil() {
    	  
    	  Assert.assertEquals(true, image_accueil.isDisplayed()); 
    	  }

		public void CheckProductsPricesAccueil() throws FileNotFoundException {
			List<String> Liste1 = Outils.loadFile("src/main/resources/FichiersProduits/ObjetsPagePrincipale.txt");
			List<WebElement> Liste2 = driver.findElements(By.xpath("//div[@class='product-content text-center']//h3 | //div[@class='product-content text-center']//span"));
			List<String> Liste3 = new ArrayList<String>();
			Liste2.stream().map(WebElement::getText).forEach(Liste3::add);
			assertEquals(Liste1, Liste3);
		}
}
