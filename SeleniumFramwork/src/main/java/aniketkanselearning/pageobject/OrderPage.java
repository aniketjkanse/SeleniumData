package aniketkanselearning.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aniketkanselearning.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents{
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> OrderList;

	public Boolean VerifyOrder(String ProductName)
	{
		Boolean OrderMatch = OrderList.stream().anyMatch(order->order.getText().equalsIgnoreCase(ProductName));
		return OrderMatch;
	}

}
