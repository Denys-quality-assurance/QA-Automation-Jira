package hillelauto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import hillelauto.jira.JiraVars;
import hillelauto.jira.LoginPage;

public class WebDriverTestBase {
    protected WebDriver browser;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
    }

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        browser = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized", "--incognito"));
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Tools.setDriver(browser);
    }
 
    @AfterGroups(groups={ "User", "Admin" })
    public void logout() {
    	browser.get(JiraVars.baseURL);
    	LoginPage.logout();
    }

    @AfterTest(alwaysRun = true)
    public void finish() {
        browser.quit();
    }
}