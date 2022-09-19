import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class staticDropdown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Applications\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		String reqCurrency="USD";
		WebElement currencyDropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select setCurrencyDropdown=new Select(currencyDropdown);
		
		//selecting by index
		setCurrencyDropdown.selectByIndex(3);
		String selectedCurrency = setCurrencyDropdown.getFirstSelectedOption().getText();
		System.out.println("selcted currency:"+selectedCurrency);
		Assert.assertEquals(selectedCurrency,reqCurrency);
		
		//selecting by visible text
		setCurrencyDropdown.selectByVisibleText("INR");
		String selectedCurrency1 = setCurrencyDropdown.getFirstSelectedOption().getText();
		System.out.println("selcted currency:"+selectedCurrency1);
		Assert.assertNotEquals(selectedCurrency1,reqCurrency);
		
		//Selecting by option Value
		setCurrencyDropdown.selectByValue("AED");
		String selectedCurrency2 = setCurrencyDropdown.getFirstSelectedOption().getText();
		System.out.println("selcted currency:"+selectedCurrency2);
		Assert.assertNotEquals(selectedCurrency2,reqCurrency);
		driver.quit();
		}

	}

