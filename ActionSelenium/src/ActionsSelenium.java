import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in");
		
		
		Actions a = new Actions(driver);
		WebElement movetomenu= driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
		WebElement movetosearchbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		
		a.moveToElement(movetomenu).contextClick().build().perform();  //Contextclick means right click 
		a.moveToElement(movetosearchbox).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
		
	}

}


