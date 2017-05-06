package cucumberID.HookCucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class hookTest {
	WebDriver driver = null;

	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "E:/Geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Given("^user navigates to Facebook$")
	public void goToFacebook() {
		driver.navigate().to("https://www.facebook.com/");
	}

	@When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void I_enter_Username_as_and_Password_as(String arg1, String arg2) {
		driver.findElement(By.id("email")).sendKeys(arg1);
		driver.findElement(By.id("pass")).sendKeys(arg2);
		driver.findElement(By.xpath(".//input[@type='submit']")).click();
	}

	@Then("^login should be unsuccessful$")
	public void validateRelogin() {
		if (driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/login.php?login_attempt=1&lwv=110")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Failed");
		}
		driver.close();
	}

	@After
	public void cleanUp() {
		driver.close();
	}
}