package org.tbc.steps.ui;

import com.microsoft.playwright.Page;
import org.tbc.data.Constants;
import org.tbc.pages.MoneyTransferPage;
import org.testng.Assert;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MoneyTransferSteps extends MoneyTransferPage {
    private final Page page;
    private List<String> UINames;
    private List<String> UICurrencies;

    public MoneyTransferSteps(Page page){
        super(page);
        this.page = page;
    }
    public MoneyTransferSteps navigate(String moneyTransfersURL){
        page.navigate(Constants.MONEY_TRANSFERS_URL);
        return this;
    }

    public MoneyTransferSteps verifyLoad(){
        page.waitForURL(Constants.MONEY_TRANSFERS_URL);
        return this;
    }
    public MoneyTransferSteps selectRemittanceFee(){
        remittanceFeeButton.click();
        return this;
    }
    public MoneyTransferSteps fillRemittanceFeeAmount(int amount){
        remittanceFeeAmount.fill(String.valueOf(amount));
        return this;
    }
    public MoneyTransferSteps selectRemittanceFeeAmountCurrency(){
        remittanceFeeAmountCurrency.click();
        remittanceFeeCurrencyEUR.click();
        return this;
    }
    public MoneyTransferSteps selectRemittanceFeeCountry(){
        remittanceFeeCountry.click();
        remittanceFeeGreece.click();
        return this;
    }
    public MoneyTransferSteps verifyCalculationResult(){
        calculationResult.scrollIntoViewIfNeeded();
        assertThat(calculationResult).isVisible();
        return this;
    }
    public MoneyTransferSteps verifyCalculationResultValue(){
        assertThat(calculationResultValue).isVisible();
        return this;
    }

    public MoneyTransferSteps getSystemsTabs(){
        transferSystemsNamesItems.first().waitFor();
        UINames = transferSystemsNamesItems.allInnerTexts();
        UICurrencies = transferSystemsCurrenciesItems.allInnerTexts();
        return this;
    }

    public MoneyTransferSteps assertMenuNamesMatch(List<String> APINames){
        Assert.assertEquals(UINames, APINames);
        return this;
    }
    public MoneyTransferSteps assertCurrenciesMatch(List<String> APINames){
        Assert.assertEquals(UICurrencies, APINames);
        return this;
    }
}
