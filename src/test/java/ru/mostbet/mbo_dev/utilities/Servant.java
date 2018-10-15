package ru.mostbet.mbo_dev.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.mostbet.mbo_dev.page.FirstPage;

public class Servant {

    WebDriver driver;

    public WebDriver CurrDriver(){

        driver = new FirefoxDriver();

        return driver;
    }

    public FirstPage GoHome(WebDriver driver) {

        this.driver = driver;
        this.driver.navigate().to("http://dev-mbo.mostbet.ru/");
        return new FirstPage(this.driver);
    }


}
