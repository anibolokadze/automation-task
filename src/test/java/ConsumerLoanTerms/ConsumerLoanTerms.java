package ConsumerLoanTerms;

import BaseTests.BaseTest;
import org.tbc.steps.ConsumerLoanTermsSteps;
import org.tbc.steps.OfferDetailsSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.tbc.data.Constants.CONSUMER_LOAN_URL;
import static org.tbc.data.Constants.OFFER_DETAILS_URL;

public class ConsumerLoanTerms extends BaseTest {
    private ConsumerLoanTermsSteps consumerLoanTermsSteps;
    @BeforeClass
    public void setUpSteps(){
        navigateTo(CONSUMER_LOAN_URL);
        consumerLoanTermsSteps = new ConsumerLoanTermsSteps(getPage());
    }
    @Test(priority = 1)
    public void navigateToTermsPage(){
        consumerLoanTermsSteps.navigateToTermsPage();
    }
    @Test(priority = 2)
    public void verifyLoad(){
        consumerLoanTermsSteps.verifyLoad();
    }
    @Test(priority = 3)
    public void clickApply(){
        consumerLoanTermsSteps.clickApply();
    }
    @Test(priority = 4)
    public void verifyURL(){
        consumerLoanTermsSteps.verifyURL();
    }
    @Test(priority = 5)
    public void verifyTitle(){
        consumerLoanTermsSteps.verifyTitle();
    }
}
