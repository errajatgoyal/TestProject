package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//img[@src='/navigation-assets/halo-logo-red.svg']")
    private WebElement haloLogoOnHomePage;

    @FindBy(xpath = "//h1[text()='Problem solving with a mix of creative talent and subject matter expertise']")
    private WebElement missionStatementLocator;

    @FindBy(xpath = "//div[text()='Contact']")
    private WebElement contactButton;

    @FindBy(name = "name")
    private WebElement nameField;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "message")
    private WebElement messageField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//h1[text()=\"We're excited to hear about your project\"]")
    private WebElement contactPageText;

    @FindBy(xpath = "//h3[@class='contact__header--success']")
    private WebElement submissionSuccessfulMessage;

    public WebElement getHaloLogoOnHomePage() {
        return haloLogoOnHomePage;
    }

    public WebElement getMissionStatementLocator() {
        return missionStatementLocator;
    }

    public WebElement getContactButton() {
        return contactButton;
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getMessageField() {
        return messageField;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getContactPageText() {
        return contactPageText;
    }

    public WebElement getSubmissionSuccessfulMessage() {
        return submissionSuccessfulMessage;
    }
}
