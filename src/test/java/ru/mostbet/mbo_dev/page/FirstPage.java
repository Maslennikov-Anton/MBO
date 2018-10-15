package ru.mostbet.mbo_dev.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstPage extends Header {

    private String EXPECTED_URL = "http://dev-mbo.mostbet.ru/";

    WebDriver driver;
    WebDriverWait wait;




    public FirstPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(this.driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[contains(text(),'menu')]")));


        Assert.assertEquals("not first page", driver.getCurrentUrl(), EXPECTED_URL);

    }





}
