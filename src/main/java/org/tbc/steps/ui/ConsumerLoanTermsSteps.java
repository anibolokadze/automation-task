package org.tbc.steps.ui;

import com.microsoft.playwright.Page;
import org.tbc.pages.ConsumerLoanPage;
import org.tbc.pages.ConsumerLoanTermsPage;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.tbc.data.Constants.TBC_CREDIT_URL_TITLE;

public class ConsumerLoanTermsSteps extends ConsumerLoanTermsPage {
    protected final Page page;
    private Page redirectedPage;
    private final ConsumerLoanPage consumerLoanPage;

    public ConsumerLoanTermsSteps(Page page){
        super(page);
        this.page = page;
        this.consumerLoanPage = new ConsumerLoanPage(page);
    }

    public ConsumerLoanTermsSteps navigateToTermsPage(){
        consumerLoanPage.consumerLoanConditionsButton.click();
        return this;
    }
    public ConsumerLoanTermsSteps verifyLoad(){
        assertThat(applyBtn).isVisible();
        assertThat(applyBtn).isEnabled();
        return this;
    }
    public ConsumerLoanTermsSteps clickApply(){
        redirectedPage = page.waitForPopup(() -> {
            applyBtn.click();
        });
        return this;
    }
    public ConsumerLoanTermsSteps verifyURL(){
        assertThat(redirectedPage)
                .hasURL(Pattern.compile(".*tbccredit\\.ge.*"));
        return this;
    }
    public ConsumerLoanTermsSteps verifyTitle(){
        assertThat(redirectedPage).hasTitle(TBC_CREDIT_URL_TITLE);
        return this;
    }
}
