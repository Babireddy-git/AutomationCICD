package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest{

@Test
public void LoginErrorValidation() throws IOException, InterruptedException
{	

		LandingPage landingPage=launchApplication();
		landingPage.loginApplication("Reddy3@gmail.com", "S11i@1234");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}

@Test(groups= {"ErrorHandling"})
public void ProductErrorValidation() throws IOException, InterruptedException
{	
		String ProductName = "ZARA COAT 3";
		LandingPage landingPage=launchApplication();
		ProductCatalogue productCatalogue = landingPage.loginApplication("Reddy3@gmail.com", "Sai@1234");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(ProductName);
		CartPage cartPage = productCatalogue.gotToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);

	}

}
