package hooks;

import driverManager.DriverManager;
import io.cucumber.java.After;

public class Hooks {

    @After
    public void quiteBrowser(){
        DriverManager.killDriver();
    }

}