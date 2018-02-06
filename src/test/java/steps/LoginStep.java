package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.testng.Reporter;
import pages.BaseMailPage;
import pages.LoginPage;
import utils.driversingleton.WebDriverSingleton;
import utils.elementdecorator.CustomWebDriver;

import static utils.driversingleton.WebDriverSingleton.cleanUp;

/**
 * Created by Katsiaryna_Skarzhyns on 2/5/2018.
 */
public class LoginStep {

	public CustomWebDriver driver;

	@Before
	public void setUp() {
		driver = WebDriverSingleton.getWebDriverInstance();
		Reporter.log("Browser started");
	}

	@After
	public void quitBrowser() {
		cleanUp();
		Reporter.log("Browser closed");
	}

	@When("^enters login \"([^\"]*)\" and password \"([^\"]*)\" submits login form$")
	public void login(String login, String password) {
		new LoginPage(driver).login(login, password);
	}

	@Then("mail home page is displayed")
	public void verify_login_is_completed() {
		Assert.assertTrue(new BaseMailPage(driver).isPageOpened(), "Account page wasn't opened");
	}
}