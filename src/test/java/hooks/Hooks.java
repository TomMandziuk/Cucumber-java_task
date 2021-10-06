
package hooks;

import driverManager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void initDriver(){
        DriverManager.getDriver();
    }
    @After
    public void quiteBrowser(){
        DriverManager.killDriver();
    }

}