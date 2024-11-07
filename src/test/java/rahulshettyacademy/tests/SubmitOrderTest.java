package rahulshettyacademy.tests;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {

	String ProductName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void sumbitOrder(String email, String password, String productName)
			throws IOException, InterruptedException {

		LandingPage landingPage = launchApplication();
		ProductCatalogue productCatalogue = landingPage.loginApplication(email, password);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart("product");
		CartPage cartPage = productCatalogue.gotToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANK YOU FOR THE ORDER."));
	}

	@Test(dependsOnMethods = { "sumbitOrder" })
	public void OrderHistoryTest() {
		ProductCatalogue productCatalogue = landingPage.loginApplication("Reddy3@gmail.com", "Sai@1234");
		productCatalogue.gotToOrdersPage();
		OrderPage orderpage = new OrderPage(driver);
		Assert.assertTrue(orderpage.VerifyOrderDisplay(ProductName));

	}
	
	public String getScreenShot(String testCaseName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//" + testCaseName + ".png";
	}

	@DataProvider
	public Object[][] getData() {
		//HashMap<String, String> map = new HashMap<String, String>();

		//return new Object[][] { { "Reddy3@gmail.com", "Sai@1234", "ZARA COAT 3" },
		//		{ "Reddy4@gmail.com", "Sai@1234", "ADIDAS ORIGINAL" } };
		
		return new Object[][] {{map},{map1}};
	}

}
