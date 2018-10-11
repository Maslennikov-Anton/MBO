package pgobj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoadDriver {


    public static WebDriver CurrDriver(){

        WebDriver driver = new FirefoxDriver();

        return driver;
    }


}
