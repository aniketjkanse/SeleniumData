//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.apache.commons.io.FileUtils;
public class CookiesandScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//MAXIMIZE screen and delete all cooking and open browser and take screenshot and paste it in specified path
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",
		Arrays.asList("disable-popup-blocking"));
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();  //to delete all cookies
		// driver.manage().deleteCookieNamed("cookie name");  //to delete specified cookie
		driver.get("http://google.com");
		
		//File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src, new File("C:\\Users\\Aniket"));
		
		
		

	}

}
