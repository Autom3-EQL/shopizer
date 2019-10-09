package shopizer.test;
import shopizer.tools.Outils;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import shopizer.tools.Outils;
import shopizer.tools.PageAccueil;
import shopizer.tools.PageTable;

public class TestObjectAccueil {

		
		//String b = "firefox";
		//private String BROWSER=System.getProperty("browser");
		WebDriver driver;
		String BROWSER = System.getProperty("browser");
		String url= "http://192.168.102.185:8091/shopizer/shop";
		
		@Before
		public void setUp() {
			System.out.println("\n@Before");
			driver = Outils.choisirNavigateur("firefox");
			//driver= Outils.choisirNavigateur(b);
			//driver= Outils.choisirNavigateur(BROWSER);
			driver.manage().window().maximize();
			driver.get(url);
		}
		
	

		@Test
		
		public void test() throws FileNotFoundException, InterruptedException {
		PageAccueil pageAccueil = PageFactory.initElements(driver, PageAccueil.class);
		pageAccueil.CheckImagePageAccueil();
		pageAccueil.CheckProductsPricesAccueil();
		
}
		
		@After
		public void tearDown(){
			System.out.println("\n@After");
			driver.close();
		}
}


