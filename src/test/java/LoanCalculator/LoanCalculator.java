package LoanCalculator;

import BaseTests.BaseTest;
import org.tbc.steps.ConsumerLoanPageSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.tbc.data.Constants.*;

public class LoanCalculator extends BaseTest {
    private ConsumerLoanPageSteps consumerLoanPageSteps;

    @BeforeClass
    public  void setUpSteps(){
        navigateTo(CONSUMER_LOAN_URL);
        consumerLoanPageSteps = new ConsumerLoanPageSteps(getPage());
    }

    @Test(priority = 1)
    public void verifyPage(){
        consumerLoanPageSteps
                .navigateToConsumerLoanPage();
    }
    @Test(priority = 2)
    public void fillLoanAmount(){
        consumerLoanPageSteps
                .fillLoanAmount(String.valueOf(LOAN_AMOUNT_1));
    }
    @Test(priority = 3)
    public void fillLoanDuration(){
        consumerLoanPageSteps
                .fillLoanDuration(String.valueOf(LOAN_DURATION_1));
    }
    @Test(priority = 4)
    public void verifyCalculatedAmounts(){
        consumerLoanPageSteps
                .verifyCalculatedAmounts();
    }
    @Test (priority = 5)
    public void updateAmountAndVerify(){
        consumerLoanPageSteps
                .updateLoanAmount(String.valueOf(LOAN_AMOUNT_2))
                .verifyUpdatedCalculatedAmounts();
    }
}
