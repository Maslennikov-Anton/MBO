package pgobj;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegisterPage {

    private String EXPECTED_URL = "http://dev-mbo.mostbet.ru/login";
    private String EXPECTED_ERROR = "Username or password is incorrect\nTRY AGAIN";

    public WebDriver driver;
    WebDriverWait wait;

    // Email
    private WebElement login;

    // Password
    private WebElement pass;

    // войти
    private WebElement comebtn;


    public RegisterPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(this.driver,30);

        login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='_username']")));
        pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='_password']")));
        comebtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));

        Assert.assertEquals("not register page", driver.getCurrentUrl(), EXPECTED_URL);


    }





    public FirstPage SuccessRegister(User user) {
        Register(user);
        return new FirstPage(driver);
    }

    public RegisterPage ErrorRegister(User user) {
        Register(user);
        CheckError();
        return new RegisterPage(driver);
    }


    private void Register (User user) {

        login.clear();
        login.sendKeys(user.email);

        pass.clear();
        pass.sendKeys(user.pass);

        comebtn.click();

    }

    private void CheckError(){

        WebElement errwindow = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='md-snackbar-content']")));

        Assert.assertEquals("not expected error text", errwindow.getText(), EXPECTED_ERROR);
    }




}
