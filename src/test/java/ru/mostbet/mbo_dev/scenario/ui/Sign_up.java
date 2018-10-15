package ru.mostbet.mbo_dev.scenario.ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import ru.mostbet.mbo_dev.utilities.RegisterUtility;
import ru.mostbet.mbo_dev.utilities.Servant;
import ru.mostbet.mbo_dev.page.RegisterPage;
import ru.mostbet.mbo_dev.utilities.User;


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

        RegisterUtility page = new RegisterUtility(driver);
                        page.errorRegister(user);

        System.out.println("FAIL REGISTER");

    }


    @Test
    public void GoodRegister() {

        User user = new User("admin@example.com","12345");

        RegisterUtility page = new RegisterUtility(driver);
                        page.successRegister(user);

        System.out.println("SUCCESS REGISTER");



    }









}
