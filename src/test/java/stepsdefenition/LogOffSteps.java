package stepsdefenition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.testng.Reporter;
import pages.BaseMailPage;
import pages.LoginPage;
import tests.BaseTestPage;
import utils.driversingleton.WebDriverSingleton;
import utils.elementdecorator.CustomWebDriver;

import static utils.driversingleton.WebDriverSingleton.cleanUp;

/**
 * Created by Katsiaryna_Skarzhyns on 2/5/2018.
 */
public class LogOffSteps extends BaseTestPage {

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

	@Given("^user navigates to home page$")
	public void navigate_to_login_page() {
		new LoginPage(driver);
	}

	@When("^user submits login form$")
	public void userSubmitsLoginForm()  {
		new LoginPage(driver).login();
	}

	@And("^user singn off$")
	public void userSingnOff() {
		new BaseMailPage(driver).logOff();
	}

	@Then("^mail start page is displayed$")
	public void mailStartPageIsDisplayed() {
		Assert.assertTrue(new LoginPage(driver).isNextBntDisplayed());
		Assert.assertTrue(new LoginPage(driver).isPasswordInputDisplayed());
	}
}