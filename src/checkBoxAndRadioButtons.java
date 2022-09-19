import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class checkBoxAndRadioButtons {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Applications\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//Clicking on the radio
		driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_1")).click();
		String radiostatus= driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_1")).getAttribute("checked");
		Assert.assertEquals(radiostatus, "true");
		//Clicking on checkbox
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).click();
		boolean checkboxstatus=driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected();
		Assert.assertEquals(checkboxstatus, true);
		Thread.sleep(2000);
		driver.quit();
	}

}
