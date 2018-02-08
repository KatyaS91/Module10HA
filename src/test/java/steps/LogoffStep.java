package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.BaseMailPage;
import pages.LoginPage;
import utils.driversingleton.WebDriverSingleton;
import utils.elementdecorator.CustomWebDriver;

import static utils.driversingleton.WebDriverSingleton.cleanUp;

/**
 * Created by Katsiaryna_Skarzhyns on 2/5/2018.
 */
public class LogoffStep {

	private CustomWebDriver driver = WebDriverSingleton.getWebDriverInstance();
	private LoginPage loginPage;
	private BaseMailPage baseMailPage;

	@Given("^user navigates to home page$")
	public void navigate_to_login_page() {
		loginPage = new LoginPage(driver);
	}

	@When("^user submits login form$")
	public void userSubmitsLoginForm()  {
		baseMailPage = loginPage.login();
	}

	@And("^user singn off$")
	public void userSingnOff() {
		loginPage = baseMailPage.logOff();
	}

	@Then("^mail start page is displayed$")
	public void mailStartPageIsDisplayed() {
		Assert.assertTrue(loginPage.isNextBntDisplayed());
		Assert.assertTrue(loginPage.isPasswordInputDisplayed());
		cleanUp();
	}
}