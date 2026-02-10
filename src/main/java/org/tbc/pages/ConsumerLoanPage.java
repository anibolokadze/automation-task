package org.tbc.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ConsumerLoanPage {
    public Locator consumerLoanConditionsButton, loanLabel, amountInput, loanDuration,
            calculatedMonthlyContribution;
    public ConsumerLoanPage(Page page){
        this.consumerLoanConditionsButton =
                page.getByRole(
                        AriaRole.BUTTON, new Page.GetByRoleOptions()
                                        .setName("პირობები")
                                        .setExact(true)).nth(0);
        this.loanLabel = page.getByText("სესხის თანხა (ლარი)");
        this.amountInput= page.locator("tbcx-text-input input[type='number']").nth(0);
        this.loanDuration= page.locator("tbcx-text-input input[type='number']").nth(1);
        this.calculatedMonthlyContribution = page.locator("div.tbcx-pw-calculated-info__number--new");
    }
}
