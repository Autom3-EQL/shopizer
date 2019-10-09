package shopizer.test;

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


public class TestObjectTable {

		
		//private String BROWSER=System.getProperty("browser");
		WebDriver driver;
		String url= "http://192.168.102.185:8091/shopizer/shop";
		String BROWSER = System.getProperty("browser");
		
		@Before
		public void setUp() {
			System.out.println("\n@Before");
			driver = Outils.choisirNavigateur("firefox");
			driver.manage().window().maximize();
			driver.get(url);
			
		}
		
		@Test
		public void test() throws FileNotFoundException, InterruptedException {
		
		PageAccueil pageAccueil = PageFactory.initElements(driver, PageAccueil.class);
		pageAccueil.CheckImagePageAccueil();
		pageAccueil.goPageTable(driver);
		PageTable pageTable = PageFactory.initElements(driver, PageTable.class);
		//Verif du fil d'arianne
		driver.findElements(By.xpath("//ol[@class='breadcrumb']"));
		
		//Verif des 4 éléments
		PageTable pagetable = new PageTable(driver);
		pagetable.CheckProductsPrices();
		//Verif filtre default
		Thread.sleep(3000);
		pagetable.ClickFiltreDefault();
		pagetable.CheckProductsPricesDefault();
		//Verif filtre Asian Wood
		Thread.sleep(3000);
		pagetable.ClickFiltreAsianWood();
		//Verif filtre default
		Thread.sleep(3000);
		pagetable.ClickFiltreRoots();
		pagetable.CheckProductsPricesRoot();
		
		}
		@After
		public void tearDown(){
			System.out.println("\n@After");
			driver.close();
		}
}


