package ru.mostbet.mbo_dev.scenario.ui;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ru.mostbet.mbo_dev.page.FirstPage;
import ru.mostbet.mbo_dev.utilities.Servant;
import ru.mostbet.mbo_dev.page.RegisterPage;
import ru.mostbet.mbo_dev.utilities.User;

public class Users {

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

    public void test() {


        User user = new User("admin@example.com","12345");


        RegisterPage page = new RegisterPage(driver);
        FirstPage fppage = page.SuccessRegister(user);
                  fppage.Users();

        try {
            Thread.sleep(10000);
        }catch (InterruptedException e) {

        }



    }


}
