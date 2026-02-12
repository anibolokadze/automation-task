package org.tbc.steps;

import com.microsoft.playwright.Page;
import org.tbc.data.Constants;
import org.tbc.pages.ConsumerLoanPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class ConsumerLoanPageSteps extends ConsumerLoanPage {
    private final Page page;

    public ConsumerLoanPageSteps(Page page){
        super(page);
        this.page = page;
    }

    public ConsumerLoanPageSteps navigateToConsumerLoanPage(){
        page.waitForURL(Constants.CONSUMER_LOAN_URL);
        assertThat(loanLabel).isVisible();
        return this;
    }
    public ConsumerLoanPageSteps fillLoanAmount(String amount){
        amountInput.click();
        amountInput.fill(amount);
        return this;
    }
    public ConsumerLoanPageSteps fillLoanDuration(String duration){
        loanDuration.click();
        loanDuration.fill(duration);
        return this;
    }
    public ConsumerLoanPageSteps verifyCalculatedAmounts(){
        assertThat(calculatedMonthlyContribution).hasText("75.94₾");
        return this;
    }
    public ConsumerLoanPageSteps updateLoanAmount(String amount){
        amountInput.click();
        amountInput.press("Control+A");
        amountInput.press("Backspace");
        amountInput.fill(amount);
        return this;
    }

    public ConsumerLoanPageSteps verifyUpdatedCalculatedAmounts(){
        assertThat(calculatedMonthlyContribution).hasText("126.57₾");
        return this;
    }

}
