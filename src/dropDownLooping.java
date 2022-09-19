import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class dropDownLooping {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver","E:\\Selenium\\Applications\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		//Variable to save the required number of passengers
		int adultPass=3;
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		//get the default count
		String setCountAdult=driver.findElement(By.id("spanAudlt")).getText();
		System.out.println("Selected count of adults:"+setCountAdult);
		int countAdult = Integer.parseInt(setCountAdult);
		System.out.println("Adult count in integer:"+countAdult);
		
		//Compare the default count with required count, if matches exit else increase count
		if(countAdult==adultPass) {
			System.out.println("Passenger count matches with expected");
		}else {
			
			//looping the add seat option to add the required number of seats
			
			//For loop
//			for(int i=countAdult;i<adultPass;i++) {
//				driver.findElement(By.id("hrefIncAdt")).click();
//				String updatedCount=driver.findElement(By.id("spanAudlt")).getText();
//				System.out.println("Updated count of Passenger:"+updatedCount);
//			}
			
			//while loop
			int j=countAdult;
			while(j<adultPass) {
				driver.findElement(By.id("hrefIncAdt")).click();
				String updatedCount=driver.findElement(By.id("spanAudlt")).getText();
				System.out.println("Updated count of Passenger:"+updatedCount);
				j++;
			}
		}
		
		driver.quit();
		

	}

}
