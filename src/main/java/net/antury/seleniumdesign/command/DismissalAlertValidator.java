package net.antury.seleniumdesign.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DismissalAlertValidator extends ElementValidator {
    private final WebElement dismissalAlert;

    public DismissalAlertValidator(WebElement element){
        this.dismissalAlert = element;
    }

    @Override
    public boolean validate() {
        boolean resultInitial = this.dismissalAlert.isDisplayed();
        this.dismissalAlert.findElement(By.cssSelector("button.close")).click();
        boolean resultFinal = this.dismissalAlert.isDisplayed();
        return resultInitial && !resultFinal;
    }
}
