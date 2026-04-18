package APITests;

import BaseTests.BaseTest;
import org.tbc.data.Constants;
import org.tbc.steps.api.MoneyTransferSystemsApiSteps;
import org.tbc.steps.web.MoneyTransferSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class verifyMoneyTransferSystemsData extends BaseTest {
    MoneyTransferSteps moneyTransferSteps;
    MoneyTransferSystemsApiSteps moneyTransfersSystemsNamesSteps;

    @BeforeClass
    public void setup(){
        moneyTransferSteps = new MoneyTransferSteps(page);
        moneyTransfersSystemsNamesSteps = new MoneyTransferSystemsApiSteps();
    }
    @Test
    public void CheckMoneyTransfersSystemsNames(){
        MoneyTransferSystemsApiSteps api = moneyTransfersSystemsNamesSteps
                .getTransferSystems()
                .assertField()
                .deserializeTransferSystems();

        List<String> expectedAPINames = api.getTransferSystemsNames();
        List<String> expectedAPICurrencies = api.getTransferSystemsCurrencies();

        moneyTransferSteps
                .navigate(Constants.PATH_MONEY_TRANSFERS)
                .getSystemsTabs()
                .assertMenuNamesMatch(expectedAPINames);

        moneyTransferSteps
                .navigate(Constants.PATH_MONEY_TRANSFERS)
                .getSystemsTabs()
                .assertCurrenciesMatch(expectedAPICurrencies);

    }
}
