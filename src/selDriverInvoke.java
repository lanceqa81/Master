import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class selDriverInvoke {

	public static void main(String[] args) {
		//Invoke the webDriver
		
		//chrome
//		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Applications\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
		
		//firefox
//		System.setProperty("webdriver.gecko.driver","E:\\Selenium\\Applications\\geckodriver.exe");
//		WebDriver driver=new FirefoxDriver();
		
		//edge
		System.setProperty("webdriver.edge.driver","E:\\Selenium\\Applications\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://chromedriver.chromium.org/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();//closes the current window
		driver.quit();//closes all the windows opened by automation 

	}

}
