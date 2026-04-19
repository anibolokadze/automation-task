package APITests;

import BaseTests.BaseTest;
import org.tbc.API.MoneyTransferSystemsAPIClient;
import org.tbc.data.Constants;
import org.tbc.steps.api.MoneyTransferSystemsAPISteps;
import org.tbc.steps.web.MoneyTransferSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class verifyMoneyTransferSystemsData extends BaseTest {
    MoneyTransferSteps moneyTransferSteps;
    MoneyTransferSystemsAPISteps apiSteps;

    @BeforeClass
    public void setup() {
        moneyTransferSteps = new MoneyTransferSteps(page);
        apiSteps = new MoneyTransferSystemsAPISteps();
    }

    @Test
    public void CheckMoneyTransfersSystemsNames() {
        MoneyTransferSystemsAPIClient apiClient =
                new MoneyTransferSystemsAPIClient()
                        .getTransferSystems();

        MoneyTransferSystemsAPISteps steps = apiSteps
                .deserializeTransferSystems(apiClient.getResponse())
                .validateStructure()
                .validateNames()
                .validateCurrencies();

        List<String> apiNames = steps.getTransferSystemsNames();
        List<String> apiCurrencies = steps.getTransferSystemsCurrencies();

        moneyTransferSteps
                .navigate(Constants.PATH_MONEY_TRANSFERS)
                .getSystemsTabs()
                .assertMenuNamesMatch(apiNames)
                .assertCurrenciesMatch(apiCurrencies);
    }
}