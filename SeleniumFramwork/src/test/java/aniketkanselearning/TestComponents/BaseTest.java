package aniketkanselearning.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import aniketkanselearning.pageobject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
		
		public WebDriver driver;
		public LandingPage landingpage;
		public WebDriver InitializeBrowser() throws IOException
		{
			Properties prop =new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//aniketkanselearning//resources//GlobalData.properties");
			prop.load(fis);
			String BrowserName = prop.getProperty("browser");
			if(BrowserName.equalsIgnoreCase("chrome"))
			{
				//WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}else if(BrowserName.equalsIgnoreCase("edge"))
			{
				//
			}else if(BrowserName.equalsIgnoreCase("firefox"))
			{
				//
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			
			return driver;
			
			
		}
		@BeforeMethod(alwaysRun=true)
		public LandingPage LaunchApplication() throws IOException
		{
			driver = InitializeBrowser();
			landingpage = new LandingPage(driver);
			landingpage.URL();
			return landingpage;
			
		}
		@AfterMethod(alwaysRun=true)
		public void CloseBrowser()
		{
			driver.close();
		}
		
		public List<HashMap<String, String>> getJsonDataToMap(String filePath ) throws IOException
		{
			
			//String Jsoncontent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+ "//src//test//java//aniketkanselearning//Data//PurchaseOrder.json"),StandardCharsets.UTF_8);
			String Jsoncontent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
			
			//string to hashmap : Jackson databind dependency
			
			ObjectMapper mapper = new ObjectMapper();
			List<HashMap<String,String>> data = mapper.readValue(Jsoncontent, new TypeReference<List<HashMap<String,String>>>() {
			});
			return data;
		}
		//To take a screenshot
		public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
			FileUtils.copyFile(source, destination);
			return System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
					
		}

	}

