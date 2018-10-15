package ru.mostbet.mbo_dev.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeoutException;

public class Header {

    WebDriver driver;
    WebDriverWait wait;


    private void Menu () {
        WebElement menu = driver.findElement(By.xpath("//button[@class=\"md-button md-icon-button md-theme-default\"]"));

        if (menu.isDisplayed()){
            System.out.println("MENU DISPLAYED");
            menu.click();
        } else {
            new TimeoutException("menu not found");
        }

    }

    private void Catalog () {
        Menu();

        WebElement catalog = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[1]"));

        if (catalog.isDisplayed()){
            System.out.println("CATALOG DISPLAYED");
            catalog.click();
        } else {
            new TimeoutException("catalog not found");
        }
    }

    public UsersPage Users() {
        Menu();

        WebElement users = driver.findElement(By.xpath("//li[@to=\"/users\"]"));

        if (users.isDisplayed()){
            System.out.println("USERS DISPLAYED");
            users.click();
        } else {
            new TimeoutException("users not found");
        }

        return new UsersPage(driver);
    }





}
