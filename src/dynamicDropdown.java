import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class dynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Applications\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		String src="IXE";
		String dest="PNQ";
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.cssSelector("input#ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='IXE']")).click();
		Thread.sleep(2000);
		//Code to demonstrate error
//		driver.findElement(By.xpath("//a[@value='PNQ']")).click();
		//Code to execute without error
		//Using index
//		driver.findElement(By.xpath("(//a[@value='PNQ'])[2]")).click();
		
		//Using parent child navigation
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='PNQ']")).click();
		
		String src1=driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).getAttribute("selectedvalue");
		String dest1=driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).getAttribute("selectedvalue");
		
		Assert.assertEquals(src, src1);
		System.out.println("Required source selected"+src1);
		Assert.assertEquals(dest, dest1);
		System.out.println("Required destination selected:"+dest1);
		driver.quit();
	}

}
