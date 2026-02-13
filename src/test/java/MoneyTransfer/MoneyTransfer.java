package MoneyTransfer;

import BaseTests.BaseTest;
import org.tbc.steps.MoneyTransferSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.tbc.data.Constants.*;

public class MoneyTransfer extends BaseTest {
    private MoneyTransferSteps moneyTransferSteps;

    @BeforeClass
    public void setUpSteps(){
        navigateTo(MONEY_TRANSFERS_URL);
        moneyTransferSteps = new MoneyTransferSteps(getPage());
    }

    @Test(priority = 1)
    public void verifyLoad(){
        moneyTransferSteps
                .verifyLoad();
    }
    @Test(priority = 2)
    public void selectRemittanceFee(){
        moneyTransferSteps
                .selectRemittanceFee();
    }
    @Test(priority = 3)
    public void fillRemittanceFeeAmount(){
        moneyTransferSteps
                .fillRemittanceFeeAmount(REMITTANCE_FEE_AMOUNT);
    }
    @Test(priority = 4)
    public void selectRemittanceFeeAmountCurrency(){
        moneyTransferSteps
                .selectRemittanceFeeAmountCurrency();
    }
    @Test(priority = 5)
    public void selectRemittanceFeeCountry(){
        moneyTransferSteps
                .selectRemittanceFeeCountry();
    }
    @Test(priority = 6)
    public void verifyCalculationResult(){
        moneyTransferSteps
                .verifyCalculationResult();
    }
    @Test(priority = 7)
    public void verifyCalculationResultValue(){
        moneyTransferSteps
                .verifyCalculationResultValue();
    }
}
