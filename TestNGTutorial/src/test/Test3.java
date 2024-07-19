package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test3 {

	@Test(dataProvider="getData")
	public void WebCarLoan(String Username, String Password)
	{
	System.out.println("WebCarLoan");
	System.out.println(Username);
	System.out.println(Password);
	}
	@Test
	public void MobileCarLoan()
	{
	System.out.println("MobileCarLoan");
	}
	@Test
	public void APICarLoan()
	{
	System.out.println("APICarLoan");
	}
	@DataProvider
	public Object[][] getData()
	{
		//1st Combination - Enter username and password - good credit history
		//2nd combination - Enter username and password - bad credit history
		//3rd combination - Enter username and password - Fradulent credit history
		
		Object [][] data = new Object[3][2];
		data[0][0] = "FirstSetUsername";
		data[0][1] = "FirstSetPassword";
		
		data[1][0] = "SecondSetUsername";
		data[1][1] = "SecondSetPassword";
		
		data[2][0] = "ThirdSetUsername";
		data[2][1] = "ThirdSetPassword";
		
		return data;
	}
	
}
