package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pgobj.Servant;
import pgobj.RegisterPage;
import pgobj.User;


public class Sign_up {

    static WebDriver driver;

    @BeforeAll
    public static void SWd(){
       driver = new Servant().CurrDriver();
       driver.get("http://dev-mbo.mostbet.ru/login");
    }

    @AfterAll
    public static void EWd(){
        driver.close();
    }

    @Test
    public void FailRegister() {

        User user = new User("admin@example.com", "123456");

        RegisterPage page = new RegisterPage(driver);
        page.ErrorRegister(user);

        System.out.println("FAIL REGISTER");

    }


    @Test
    public void GoodRegister() {

        User user = new User("admin@example.com","12345");

        RegisterPage page = new RegisterPage(driver);
                     page.SuccessRegister(user);

        System.out.println("SUCCESS REGISTER");



    }









}
