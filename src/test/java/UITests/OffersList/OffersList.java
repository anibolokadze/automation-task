package UITests.OffersList;

import BaseTests.BaseTest;
import org.tbc.steps.ui.OfferListSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.tbc.data.Constants.OFFER_LIST_URL;

public class OffersList extends BaseTest {
    private OfferListSteps offerListSteps;
    @BeforeClass
    public void setUpSteps(){
        navigateTo(OFFER_LIST_URL);
        offerListSteps = new OfferListSteps(getPage(), isHeadless());
    }
    @Test (priority = 1)
    public void verifyFilterAndOffersList(){
        offerListSteps.verifyFilterAndOffersList();
    }
    @Test (priority = 2)
    public void selectFilter(){
        offerListSteps.selectFilter();
    }
    @Test (priority = 3)
    public void verifyEmptyState(){
        offerListSteps.verifyEmptyState();
    }
    @Test (priority = 4)
    public void verifyNoOfferCards(){
        offerListSteps.verifyNoOfferCards();
    }
    @Test (priority = 5)
    public void clearFiltersAndVerifyOffersList(){
        offerListSteps.clearFiltersAndVerifyOffersList();
    }
}
