package ru.mostbet.mbo_dev.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.mostbet.mbo_dev.page.RegisterPage;

public class RegisterUtility {

    private String EXPECTED_URL = "http://dev-mbo.mostbet.ru/login";
    private String EXPECTED_ERROR = "Username or password is incorrect\nTRY AGAIN";

    private WebDriver driver;
    private WebDriverWait wait;
    private RegisterPage registerPage = new RegisterPage();

    public RegisterUtility(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(this.driver,30);

        Assert.assertEquals("not register page", driver.getCurrentUrl(), EXPECTED_URL);

    }

    public void successRegister(User user) {
        register(user);
    }

    public void errorRegister(User user) {
        register(user);
        checkError();
    }


    private void register (User user) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.getLogin())).clear();
        driver.findElement(registerPage.getLogin()).sendKeys(user.email);

        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.getPass()));
        driver.findElement(registerPage.getPass()).sendKeys(user.pass);

        driver.findElement(registerPage.getComebtn()).click();

    }

    private void checkError(){

        wait.until(ExpectedConditions.presenceOfElementLocated(registerPage.getErrwindow()));

        Assert.assertEquals("not expected error text",
                            driver.findElement(registerPage.getErrwindow()).getText(),
                            EXPECTED_ERROR);
    }

}
