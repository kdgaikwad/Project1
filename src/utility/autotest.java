package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.Constant;
import utilities.ExcelUtils;

public class autotest {
	WebDriver driver;
	@BeforeTest
	public void sample() throws Exception {
		
	Reporter.log("Testcases Exceution Report For Website", true);
	
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		 
	     driver = new ChromeDriver();
	 
	         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 
	         driver.get("https://www.biba.in/"); 
	         driver.manage().window().maximize();
	         ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
	         
	 
	 }
  @Test(priority = 0)//this test verifies user is able to sign in the website or not
  public void signin() throws Exception {
	 WebElement sclick = driver.findElement(By.xpath("//*[@id=\"myaccount\"]/div/div/a[1]"));
		sclick.click();
	  //Code for entering username and password from excel
	String sUserName = ExcelUtils.getCellData(1, 1);
		WebElement uname = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_ctl00_ctl01_Login1_UserName\"]")); 
	if(uname.isDisplayed())
				uname.click();
			   uname.sendKeys(sUserName);
   String sPassword = ExcelUtils.getCellData(1, 2);
		WebElement passwordTxtBox = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_ctl00_ctl01_Login1_Password\"]"));  
		if(passwordTxtBox.isDisplayed())
			passwordTxtBox.sendKeys(sPassword);
 WebElement submit = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_ctl00_ctl01_Login1_LoginImageButton\"]"));
	   submit.click();
	   System.out.println("--------Testcases Description-------");
	   System.out.println("TC001--signin--This Testcase Verifies that User is able to Login with  Valid Credentials which are taken from excel sheet");
	  
}
  
  @Test(priority = 1)//this test verifies user able to search particular item from excel or not
  public void searchItem() throws Exception {
	  String serch = ExcelUtils.getCellData(1, 3);
		  WebElement srch = driver.findElement(By.xpath("//*[@id=\"txtSearch\"]"));
		  WebElement ic =driver.findElement(By.xpath("//*[@id=\"btnSearch\"]"));
		  if(srch.isDisplayed())
				srch.click();
			   srch.sendKeys(serch);
			   ic.click();
			

	  System.out.println("TC002--searchItem--This Testcase Verifies User is able to search the particular item which is taken from Excel sheet. ");
	  
	  }
  @Test(priority = 2)//this test verifies user able to add the item into the cart or not.
  public void addToCart() throws Exception{
	  WebElement ck =driver.findElement(By.xpath("//*[@id=\"3241494\"]/div[2]/div/div[2]/div/h2/a"));
	  ck.click();
	//  ck.click();
	  WebElement size = driver.findElement(By.xpath("//*[@id=\"236992\"]/span"));
	  size.click();
	  WebElement cart = driver.findElement(By.xpath("//*[@id=\"pdmainDiv\"]/div/div/div[1]/div/div[2]/div[5]/div[2]/div[2]/div/div[3]/div[1]/span[2]/input"));
	  cart.click();
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	 WebElement hm= driver.findElement(By.xpath("//*[@id=\"QuickCart\"]/div[1]/a"));
	  hm.click();
	  System.out.println("TC003--addToCart--This Testcase Verifies User is able to add the searched item to Cart");
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  }

 
  @Test(priority = 3)//this testcase veifies user able to logout.
  
  public void logout() throws Exception{
	  WebElement lg = driver.findElement(By.xpath("//*[@id=\"lblusrn\"]"));
	  lg.click();
	  WebElement out = driver.findElement(By.xpath("//*[@id=\"lnkLogout1\"]"));
	  	out.click();
	  	 driver.quit();
	  	 System.out.println("TC004--logout--This Testcase Verifies User is able to logout from website");
	  	 System.out.println("----------Result of Testcases-----------");
	  
	  
  }
}


