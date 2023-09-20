package net.antury.seleniumdesign.command;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebElement;

import static java.util.concurrent.TimeUnit.SECONDS;

public class NotificationValidator extends ElementValidator {

    private final WebElement button;
    private final WebElement notification;

    public NotificationValidator(WebElement button, WebElement notification) {
        this.button = button;
        this.notification = notification;
    }

    @Override
    public boolean validate() {
        this.button.click();
        boolean appearanceState  = this.notification.isDisplayed();
        Uninterruptibles.sleepUninterruptibly(4, SECONDS);
        boolean disappearanceState  = this.notification.isDisplayed();
        return appearanceState && (!disappearanceState);
    }
}
