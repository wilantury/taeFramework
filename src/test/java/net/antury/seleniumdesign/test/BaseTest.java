package net.antury.seleniumdesign.test;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Usuario\\Documents\\courseAutomation\\driver\\chromedriver.exe");
        this.driver = new ChromeDriver(options);
    }

    @AfterTest
    public  void quitDriver(){
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        this.driver.quit();
    }
}
