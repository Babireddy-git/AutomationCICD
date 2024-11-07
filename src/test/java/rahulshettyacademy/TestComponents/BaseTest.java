package rahulshettyacademy.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver initializeDriver() throws IOException {
	    Properties prop = new Properties();
	    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
	            + "\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
	    prop.load(fis);
	    String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");

	    if (browserName.contains("chrome")) {
	    	ChromeOptions options = new ChromeOptions();
	        WebDriverManager.chromedriver().setup();
	        if(browserName.contains("headless")) {
		        options.addArguments("headless");
	        }
	        driver = new ChromeDriver(options);
	        driver.manage().window().setSize(new Dimension(1440,990)); // helps to run in full screen
	    } else if (browserName.equalsIgnoreCase("firefox")) {
	        WebDriverManager.firefoxdriver().setup();
	    	//System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Documents\\geckodriver.exe");
	        driver = new FirefoxDriver();
	    } else if (browserName.equalsIgnoreCase("edge")) {
	        WebDriverManager.edgedriver().setup();
	    	//System.setProperty("webdriver.edge.driver", "edge.exe");
	        driver = new EdgeDriver();
	    } 

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	    return driver;
	}


	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}