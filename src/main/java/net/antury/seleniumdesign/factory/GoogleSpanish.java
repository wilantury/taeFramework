package net.antury.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class GoogleSpanish extends GoogleEnglish {
    @FindBy(css = "div#gws-output-pages-elements-homepage_additional_languages_als a")
    private WebElement language;

    public GoogleSpanish(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.es");
        this.language.click();
    }
}
