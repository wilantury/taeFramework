package net.antury.seleniumdesign.srp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchWidget extends AbstractComponent {

    @FindBy(name = "q")
    private WebElement searchTextInput;


    public SearchWidget(final WebDriver driver) {
        super(driver);
    }

    public void enterText(String keyword){
        this.searchTextInput.clear();
        this.searchTextInput.sendKeys(keyword);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(d-> this.searchTextInput.isDisplayed());
    }
}
