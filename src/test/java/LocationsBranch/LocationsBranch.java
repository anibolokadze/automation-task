package LocationsBranch;

import BaseTests.MobileBaseTest;
import org.tbc.steps.LocationsBranchSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.tbc.data.Constants.*;

public class LocationsBranch extends MobileBaseTest {
    private LocationsBranchSteps locationsBranchSteps;

    @BeforeClass
    public  void setUpSteps(){
        navigateTo(HOME_URL);
        locationsBranchSteps = new LocationsBranchSteps(getPage());
    }
    @Test (priority = 1)
    public void clickLocations(){
        locationsBranchSteps.clickLocations();
    }
    @Test (priority = 2)
    public void verifyTitle(){
        locationsBranchSteps.verifyTitle();
    }
    @Test(priority = 3)
    public void clickATM(){
        locationsBranchSteps.clickATM();
    }
    @Test (priority = 4)
    public void verifyATMAddress(){
        locationsBranchSteps.verifyATMAddress();
    }
    @Test(priority = 5)
    public void switchToBranchTab(){
        locationsBranchSteps.switchToBranchTab();
    }
    @Test (priority = 6)
    public void verifyBranchAddress(){
        locationsBranchSteps.verifyBranchAddress();
    }
}
