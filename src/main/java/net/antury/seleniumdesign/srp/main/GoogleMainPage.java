package net.antury.seleniumdesign.srp.main;

import net.antury.seleniumdesign.srp.common.SearchSuggestion;
import net.antury.seleniumdesign.srp.common.SearchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {
    private WebDriver driver;
    private SearchWidget searchWidget;
    private SearchSuggestion searchSuggestion;

    public GoogleMainPage(final WebDriver driver) {
        this.driver = driver;
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
    }

    public void goTo() {
        this.driver.get("https://google.com");
    }

    public SearchWidget getSearchWidget() {
        return this.searchWidget;
    }

    public SearchSuggestion getSearchSuggestion(){
        return this.searchSuggestion;
    }
}
