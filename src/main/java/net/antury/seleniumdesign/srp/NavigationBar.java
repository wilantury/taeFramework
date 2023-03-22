package net.antury.seleniumdesign.srp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractComponent {

    @FindBy(id = "hdtb")
    private WebElement barWrapper;

    @FindBy(linkText = "Images")
    private WebElement images;

    @FindAll({@FindBy(linkText = "News"),
                @FindBy(linkText = "Noticias")})
    private WebElement news;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void goToImages() {
        this.images.click();
    }

    public void goToNews() {
        this.news.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(d -> this.barWrapper.isDisplayed());
    }
}
