package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.BaseMailPage;
import pages.DraftPage;
import pages.MailCreationPage;
import pages.SentPage;
import utils.bo.MailBO;
import utils.driversingleton.WebDriverSingleton;
import utils.elementdecorator.CustomWebDriver;

import static utils.driversingleton.WebDriverSingleton.cleanUp;

/**
 * Created by Katsiaryna_Skarzhyns on 2/8/2018.
 */
public class CreatemailStep {

	private CustomWebDriver driver = WebDriverSingleton.getWebDriverInstance();
	private MailBO mailBO;
	private MailCreationPage mailCreationPage;

	@When("^user fill mail form$")
	public void userFillMailForm() {
		mailCreationPage = new BaseMailPage(driver).openCreateMailPage();
		mailBO = new MailBO();
		mailCreationPage.createMail(mailBO);
	}

	@Then("^created mail is displayed on draft page$")
	public void createdMailIsDisplayedOnDraftPage() {
		DraftPage draftPage = new BaseMailPage(driver).openDrafts();
		Assert.assertTrue(draftPage.isExpectedDraftSubjectPresent(mailBO.getSubject()), "The draft with subject isn't displayed");
		Assert.assertTrue(draftPage.isExpectedDraftBodyDisplayed(mailBO.getDescription()), "The draft with body isn't displayed");
		cleanUp();
	}

	@And("^user send draft$")
	public void userSendDraft()  {
		DraftPage draftPage = new BaseMailPage(driver).openDrafts();
		Assert.assertTrue(draftPage.sendDraft(0), "The mailBO doesn't disappear from drafts");
	}

	@Then("^mail is disappeared from the mail box$")
	public void mailIsDisappearedFromTheMailBox() {
		SentPage sentPage = new DraftPage(driver).openSentMails();
		Assert.assertTrue(sentPage.isExpectedMailPresent(mailBO.getDescription(), mailBO.getSubject(), mailBO.getAddress()),
				"Expected mailBO doesn't present in the folder");
		cleanUp();
	}
}