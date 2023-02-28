package net.antury.seleniumdesign.srp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {
    protected WebDriverWait wait;

    public AbstractComponent(WebDriver driver){
        this.wait = new WebDriverWait(driver,5);
        PageFactory.initElements(driver,this);
    }

    public abstract boolean isDisplayed();
}
