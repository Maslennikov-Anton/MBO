package ru.mostbet.mbo_dev.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersPage {



    private String EXPECTED_URL = "http://dev-mbo.mostbet.ru/users";

    WebDriver driver;
    WebDriverWait wait;

    public UsersPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(this.driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"md-card md-table md-theme-default\"]")));


        Assert.assertEquals("not users page", driver.getCurrentUrl(), EXPECTED_URL);

    }






}
