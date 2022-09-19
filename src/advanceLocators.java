import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class advanceLocators {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Applications\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com/");
		driver.findElement(By.xpath("//div[@class='nav-line-1-container']/span")).click();
		
		//xpath by parent to child navigation
		driver.findElement(By.xpath("//div[@class='a-section a-spacing-base']/span/span/a[@id='createAccountSubmit']")).click();
		
		//locate by css
		driver.findElement(By.cssSelector("div[class='a-row a-spacing-base'] input")).sendKeys("UserQA81");
		//locate by xpath
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("lanceqa81@gmail.com");
		//xpath by parent to child navigation
		driver.findElement(By.xpath("(//div[@class='a-row a-spacing-base']/input)[2]")).sendKeys("Newp@ssword12");
		driver.findElement(By.xpath("(//div[@class='a-row a-spacing-base']/input)[3]")).sendKeys("Newpassword12");
		//locate by css
		driver.findElement(By.cssSelector("input#continue")).click();
		//Validating the result with Assertions
		Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='a-box-inner a-alert-container'])[9]/div")).getText(),"Passwords must match");
		System.out.println(driver.findElement(By.xpath("(//div[@class='a-box-inner a-alert-container'])[9]/div")).getText());
		driver.quit();
	}

}
