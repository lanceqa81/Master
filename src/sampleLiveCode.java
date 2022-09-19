import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class sampleLiveCode {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Applications\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//Clicking on the radio
		driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_1")).click();
		String radiostatus= driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_1")).getAttribute("checked");
		Assert.assertEquals(radiostatus, "true");
		//Clicking on checkbox
//		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("input[id*='StudentDiscount']")));
		driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).click();
		boolean checkboxstatus=driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected();
		Assert.assertEquals(checkboxstatus, true);
		Thread.sleep(2000);
		driver.quit();
	}

}
