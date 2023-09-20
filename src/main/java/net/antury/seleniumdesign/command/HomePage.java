package net.antury.seleniumdesign.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public class HomePage {

    private final WebDriver driver;

    @FindBy(css = "div.button-box button.btn-info")
    private WebElement infoBtn;

    @FindBy(css = "div.button-box button.btn-warning")
    private WebElement warnBtn;

    @FindBy(css = "div.button-box button.btn-success")
    private WebElement successBtn;

    @FindBy(css = "div.button-box button.btn-danger")
    private WebElement dangerBtn;

    @FindBy(css = "div.jq-icon-info")
    private WebElement infoAlert;

    @FindBy(css = "div.jq-icon-warning")
    private WebElement warnAlert;

    @FindBy(css = "div.jq-icon-success")
    private WebElement successAlert;

    @FindBy(css = "div.jq-icon-error")
    private WebElement dangerAlert;

    @FindBy(css = "div.alert-info")
    private WebElement dismissInfoAlert;

    @FindBy(css = "div.alert-success")
    private WebElement dismissSuccessAlert;

    @FindBy(css = "div.alert-danger")
    private WebElement dismissDangerAlert;

    @FindBy(css = "div.alert-warning")
    private WebElement dismissWarningAlert;

    public HomePage(final WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("https://wrappixel.com");
    }

    public List<ElementValidator> getElementValidators(){
        return Arrays.asList(
                new NotificationValidator(infoBtn, infoAlert),
                new NotificationValidator(successBtn, successAlert),
                new NotificationValidator(warnBtn, warnAlert),
                new DismissalAlertValidator(dismissInfoAlert),
                new DismissalAlertValidator(dismissSuccessAlert),
                new DismissalAlertValidator(dismissWarningAlert),
                new DismissalAlertValidator(dismissDangerAlert)
        );
    }
}
