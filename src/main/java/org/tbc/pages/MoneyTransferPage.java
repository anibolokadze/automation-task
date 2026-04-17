package org.tbc.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class MoneyTransferPage {
    public Locator remittanceFeeButton, remittanceFeeAmount,
            remittanceFeeAmountCurrency, remittanceFeeCurrencyEUR, remittanceFeeCountry, remittanceFeeGreece, calculationResult,
            calculationResultValue, transferSystemsNamesItems, transferSystemsCurrenciesItems;
    public MoneyTransferPage(Page page){
        this.remittanceFeeButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Remittance Fee Calculation"));
        this.remittanceFeeAmount = page.locator("tbcx-text-input input[type='text']");
        remittanceFeeAmountCurrency = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
                        .setName("GEL"));
        remittanceFeeCurrencyEUR = page.locator(".tbcx-dropdown-popover-item")
                .filter(new Locator.FilterOptions().setHasText("EUR"));
        remittanceFeeCountry = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Choose a country"));
        remittanceFeeGreece = page.locator("tbcx-dropdown-popover-item").filter(new Locator.FilterOptions().setHasText("Greece"));
        calculationResult = page.locator(".tbcx-pw-money-transfer-fee-calculator__cards");
        calculationResultValue = page.locator(".tbcx-pw-money-transfer-fee-calculator__cards");
        this.transferSystemsNamesItems = page.locator("div.tbcx-pw-card__logo-and-text-info");
        this.transferSystemsCurrenciesItems = page.locator("span.tbcx-pw-card__caption");
    }
}
