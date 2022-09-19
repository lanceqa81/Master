import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class autoSuggestiveDropdowns {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Applications\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("Uni");
		Thread.sleep(2000);
		List<WebElement> options=driver.findElements(By.cssSelector(".ui-menu-item"));
		
		for(WebElement option: options) {
			if(option.getText().contains("USA")) {
				option.click();
				break;
			}
		}
		String verifyselection= driver.findElement(By.id("autosuggest")).getAttribute("class");
		Assert.assertEquals(verifyselection, "inputs ui-autocomplete-input valid");
		System.out.println(verifyselection);
		driver.quit();
		
	}

}
