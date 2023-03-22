package net.antury.seleniumdesign.srp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultStat extends AbstractComponent {

    @FindBy(id = "result-stats")
    private WebElement stats;

    public ResultStat(WebDriver driver) {
        super(driver);
    }

    public String getStat(){
        return this.stats.getText();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(d-> stats.isDisplayed());
    }
}
