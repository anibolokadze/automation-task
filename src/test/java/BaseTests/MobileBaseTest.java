package BaseTests;

import com.microsoft.playwright.*;
import org.testng.annotations.BeforeClass;

import java.util.Arrays;
import java.util.List;


public class MobileBaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected boolean headless;

    @BeforeClass
    public void setUp() {
        headless = false;
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(headless)
        );
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(412, 915)
                .setHasTouch(true)
                .setIsMobile(true)
                .setUserAgent("Samsung Galaxy S20 Ultra")
        );

        page = context.newPage();
    }
    protected void navigateTo(String url) {
        page.navigate(url);
    }
    protected Page getPage(){return page;}
    protected boolean isHeadless() {
        return headless;
    }
}