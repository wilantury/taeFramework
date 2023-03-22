package net.antury.seleniumdesign.srp;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SearchWidget extends AbstractComponent {

    @FindBy(name = "q")
    private WebElement searchTextInput;


    public SearchWidget(final WebDriver driver) {
        super(driver);
    }

    public void enterText(String keyword) {
        this.searchTextInput.clear();
        for (char ch : keyword.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
            this.searchTextInput.sendKeys(ch + "");
        }
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(d -> this.searchTextInput.isDisplayed());
    }
}
