package seleniumtest.enes;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;


public class hw {

	public static void main(String[] args) throws InterruptedException{
		
		//bu asil proje degildir test amaclidir
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        
        options.setExperimentalOption("excludeSwitches", new String[]{"disable-automation"});
        options.setExperimentalOption("useAutomationExtension", new String[]{"False"});
        //options.addArguments("excludeSwitches",['enable-automation']);
        //options.addArguments("'useAutomationExtension',False");
		
	    System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");  
	    WebDriver driver=new ChromeDriver(options);  
	      
	    // websiteye git 
	    driver.navigate().to("https://www.gittigidiyor.com/");  
	       
	    // sayfa acıldı mı kontrol 
	    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	    
	    //login sayfasına git
	    WebElement signbtn= driver.findElement(By.cssSelector("div[data-cy='header-user-menu']"));
        signbtn.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
        
	    WebElement signbtn2= driver.findElement(By.cssSelector("div[data-cy='guest-panel-container']"));
        signbtn2.click(); 
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    
        //Login yap
         String email= "ginike9719@carpetd.com";
         String password	="patpatpatp1334";
         WebElement userNameField= driver.findElement(By.id("L-UserNameField"));
         WebElement passwordField= driver.findElement(By.id("L-PasswordField"));
         userNameField.click();
         userNameField.sendKeys(email);
         passwordField.click();
         passwordField.sendKeys(password);
         Thread.sleep(1000);
         
 		 driver.findElement(By.id("L-PasswordField")).sendKeys(password);

         Thread.sleep(1000);
         WebElement loginEnter= driver.findElement(By.xpath("//*[@id=\"gg-login-enter\"]"));
         
         loginEnter.click();
         System.out.println("rqrqrqrqw");
         
         //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String result= driver.getCurrentUrl();
        System.out.println(result);

        
        


		//Login kontrol
		WebElement webElement = driver.findElement(By.cssSelector("div[data-cy='header-user-menu']"));
		String text = webElement.getText();
		System.out.println(webElement.getText());
		if (text.equals("asasdasdasdasdasdd")) {
			System.out.println("Login is correct" + webElement.getText());
		}

		//bilgisayar gir
		WebElement search = driver.findElement(By.xpath("//input[@data-cy='header-search-input']"));
		search.sendKeys("bilgisayar");
		Thread.sleep(1000);
		WebElement searchButton = driver.findElement(By.xpath("//button[@data-cy='search-find-button']"));
		searchButton.click();
		Thread.sleep(1000);
		WebElement productsUL = driver.findElement(By.className("products-container"));

		List<WebElement> productList = productsUL.findElements(By.className("srp-item-list"));

		//sergilenenlerden rastgele urun sec
		Random rand = new Random(productList.size());
		int randomProductNumber = rand.nextInt(productList.size() - 1);
		
		WebElement luckyProduct = productList.get(randomProductNumber);
		System.out.println(productList.size());
		System.out.println(randomProductNumber);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", luckyProduct);
		Thread.sleep(1000);
		String price = luckyProduct.findElement(By.className("fiyat")).getText();
		System.out.println(price);
		
		Actions action = new Actions(driver);
		action.moveToElement(luckyProduct);
		action.clickAndHold().perform();
		Thread.sleep(1000);
		WebElement addToBasketButton = luckyProduct.findElement(By.className("buy-now-button"));
		addToBasketButton.click();

		
		driver.findElement(By.className("dIB")).click();
		//-----------------------------------
		WebElement basketProduct = driver.findElement(By.className("product-item-box-container"));
		String basketPrice = basketProduct.findElement(By.className("total-price")).getText();
		System.out.println(basketPrice);
		Thread.sleep(1000);
		WebElement selectBox = driver.findElement(By.xpath("//select[@class='amount']"));
		selectBox.click();
		Thread.sleep(1000);
		WebElement amount = selectBox.findElement(By.xpath("//option[@value='2']"));
		amount.click();
		System.out.println(selectBox.getAttribute("value"));
		Thread.sleep(1000);
		//btn-delete
		WebElement deleteButton = basketProduct.findElement(By.className("btn-delete"));
		deleteButton.click();
		Thread.sleep(2000);
		//check if deleted or not
		List<WebElement> basketProductsList = driver.findElements(By.className("product-item-box-container"));
		System.out.println(basketProductsList.size());
		if(basketProductsList.size()==0) {
			System.out.println("Tebrikler ürün silindi");
		}
	
		
		
		
		
		
		
		
		
		
		
		
	    
		}
	
	
}
