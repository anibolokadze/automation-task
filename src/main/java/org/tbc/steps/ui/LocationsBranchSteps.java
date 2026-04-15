package org.tbc.steps.ui;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.tbc.pages.HomePage;
import org.tbc.pages.LocationsBranchPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LocationsBranchSteps extends LocationsBranchPage {
    private final Page page;
    private final HomePage homePage;
    public LocationsBranchSteps(Page page){
        super(page);
        this.page = page;
        this.homePage = new HomePage(page);
    }
    public LocationsBranchSteps clickLocations(){
        homePage.hamburgerMenu.click();
        homePage.forMyBusinessBtn.click(new Locator.ClickOptions().setForce(true));
        homePage.locationsBtn.click();
        return this;
    }
    public LocationsBranchSteps verifyTitle(){
        title.isVisible();
        return this;
    }
    public LocationsBranchSteps clickATM(){
        ATMTitle.click();
        return this;
    }
    public LocationsBranchSteps verifyATMAddress(){
        page.waitForTimeout(15_000);
        ATMBranchContainer.scrollIntoViewIfNeeded();
        assertThat(ATMBranchContainer).containsText("გრ. აბაშიძის ქ. #2");
        assertThat(ATMBranchContainer).containsText("ATM");
        return this;
    }
    public LocationsBranchSteps switchToBranchTab(){
        branchesTitle.click();
        return this;
    }
    public LocationsBranchSteps verifyBranchAddress(){
        page.waitForTimeout(15_000);
        assertThat(branchScheduleText).containsText("ორშაბათი-პარასკევი");
        assertThat(branchScheduleText).containsText("10:00-18:00");
        assertThat(branchScheduleText).containsText("შაბათი");
        assertThat(branchScheduleText).containsText("10:00-14:00");
        return this;
    }
}
