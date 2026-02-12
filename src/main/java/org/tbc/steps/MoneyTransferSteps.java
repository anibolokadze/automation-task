package org.tbc.steps;

import com.microsoft.playwright.Page;
import org.tbc.data.Constants;
import org.tbc.pages.MoneyTransferPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MoneyTransferSteps extends MoneyTransferPage {
    private final Page page;

    public MoneyTransferSteps(Page page){
        super(page);
        this.page = page;
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
}
