package tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.TestBase;
import utilities.ExcelUtility;
import utilities.ExcelWrite;
import utilities.MyListener;

@Listeners(MyListener.class)
public class LoginTest extends TestBase  {
	
		HomePage hp;
		LoginPage lp;
		ExcelWrite w = new ExcelWrite();
		static int RowNum=1;
		@BeforeTest
		public void start_browser()
		{
			OpenBrowser();
			hp = new HomePage(driver);
			lp = new LoginPage(driver);
		}

		
		//@Test(dataProvider="LoginDetails")
		@Test()
		public void test_login() throws IOException
		{
			hp.clickLoginLink();
			lp.user_login();
			
			try {
			lp.user_logout();
			//w.writeExcel("C:\\Users\\USER\\Desktop\\TestData2.xlsx", "Sheet1", RowNum, 2, "Pass");
			
			} 
			catch(Exception e) {
				Assert.fail("no logout");
				//w.writeExcel("C:\\Users\\USER\\Desktop\\TestData2.xlsx", "Sheet1", RowNum, 2, "Fail");
				
				
			}
			//RowNum=RowNum+1;
		}
		
		/*
		 * @DataProvider(name="LoginDetails") public Object[][] datasupplier() throws
		 * EncryptedDocumentException, IOException {
		 * 
		 * Object[] [] input = ExcelUtility.getTestData("Sheet1"); return input;
		 * 
		 * }
		 */
	
		@AfterTest
		public void close_browser()
		{
			driver.close();
		}
	}
	

