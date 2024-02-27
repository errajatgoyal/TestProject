package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pages.HomePage;

import java.util.concurrent.TimeUnit;


public class HomePageStepDefs {

    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("–start-fullscreen");
        options.addArguments("--kiosk");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am on the Halo powered home page")
    public void i_am_on_the_halo_home_page() {
        driver.get("https://halopowered.com/");
        Assert.assertTrue(homePage.getHaloLogoOnHomePage().isEnabled(), "User is not on Halo HomePage");
    }

    @Then("I should be able to see their mission statement successfully")
    public void i_should_be_able_to_see_their_mission_statement() {
        Assert.assertTrue(homePage.getMissionStatementLocator().isDisplayed(), "User is not able to see the mission statement on the HomePage");
    }

    @Given("I clicked on the contact button on the top")
    public void click_on_the_contact_button() {

        homePage.getContactButton().click();
        Assert.assertTrue(homePage.getContactPageText().isEnabled(), "User is not on the contact details page after clicking on contact button");
    }

    @And("I have entered valid {string}, {string} and a {string}")
    public void enter_valid_name_email_message(String name, String email, String message) {
        homePage.getNameField().sendKeys(name);
        homePage.getEmailField().sendKeys(email);
        homePage.getMessageField().sendKeys(message);
        Assert.assertTrue(homePage.getSubmitButton().isEnabled(), "Submit button is not enabled even after entering valid name, email and message");
    }

    @When("I click on the Submit button")
    public void click_on_submit_button() {
        homePage.getSubmitButton().click();
    }

    @Then("I should be able to submit the details successfully")
    public void details_submitted_successfully(){
        Assert.assertTrue(homePage.getSubmissionSuccessfulMessage().isEnabled(),"Submission is not successful since there is no acknowledgement");
        Assert.assertEquals(homePage.getSubmissionSuccessfulMessage().getText(),"Thank you for your message!","Success message is not as per expectations");
    }
}
