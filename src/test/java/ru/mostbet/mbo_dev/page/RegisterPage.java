package ru.mostbet.mbo_dev.page;



import lombok.Getter;
import org.openqa.selenium.By;


@Getter
public class RegisterPage {


    // Email
    public final By login = By.xpath("//input[@id='_username']");

    // Password
    public final By pass = By.xpath("//input[@id='_password']");

    // войти
    public final By comebtn = By.xpath("//button[@type='submit']");


    public final By errwindow = By.xpath("//div[@class='md-snackbar-content']");








}
