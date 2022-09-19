import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locatorBasics {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Applications\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com/");
		//by link text
		driver.findElement(By.linkText("Your Account")).click();
		
		//locate by xpath
//		driver.findElement(By.xpath("//a[text()='Your Account']")).click();
		
		//locate by id
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		//locate by name
		driver.findElement(By.name("email")).sendKeys("lanceqa81@gmail.com");
		//locate by css
		driver.findElement(By.cssSelector("input.a-button-input")).click();
		System.out.println(driver.findElement(By.cssSelector("h4.a-alert-heading")).getText());
				
		driver.quit();
		
	}

}
