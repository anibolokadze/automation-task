package APITests;

import BaseTests.BaseTest;
import org.tbc.data.Constants;
import org.tbc.steps.api.MoneyTransfersSystemsNamesSteps;
import org.tbc.steps.ui.MoneyTransferSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckMoneyTransfersSystemsNames extends BaseTest {
    MoneyTransferSteps moneyTransferSteps;
    MoneyTransfersSystemsNamesSteps moneyTransfersSystemsNamesSteps;
    @BeforeMethod
    public void setup(){
        moneyTransferSteps = new MoneyTransferSteps(page);
        moneyTransfersSystemsNamesSteps = new MoneyTransfersSystemsNamesSteps();
    }
    @Test
    public void CheckMoneyTransfersSystemsNames(){

        List<String> expectedApiNames = moneyTransfersSystemsNamesSteps.getTransferSystems()
                .assertField()
                .deserializeTransferSystems()
                .getTransferSystemsNames();

        moneyTransferSteps
                .navigate(Constants.PATH_MONEY_TRANSFERS)
                .getSystemsTabs()
                .assertMenuNamesMatch(expectedApiNames);

    }
}
