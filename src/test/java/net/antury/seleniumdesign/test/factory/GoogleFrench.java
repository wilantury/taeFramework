package net.antury.seleniumdesign.test.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleFrench extends GoogleEnglish{
    @FindBy(css = "div#SIvCob a")
    private WebElement language;

    public GoogleFrench(WebDriver driver) {
        super(driver);
    }


    @Override
    public void launchSite() {
        this.driver.get("https://www.google.fr");
        this.language.click();
    }

    @Override
    public int getResultsCount() {
        return 0;
    }
}
