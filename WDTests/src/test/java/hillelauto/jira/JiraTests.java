package hillelauto.jira;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import hillelauto.WebDriverTestBase;

public class JiraTests extends WebDriverTestBase {
    private LoginPage loginPage;
    private IssuePage issuePage;
    private AdminPage adminPage;

    @BeforeClass(alwaysRun = true)
    public void initPages() {
        loginPage = PageFactory.initElements(browser, LoginPage.class);
        issuePage = PageFactory.initElements(browser, IssuePage.class);
        adminPage = PageFactory.initElements(browser, AdminPage.class);
        System.out.println("Jira Pages Initialized");
    }

    @Test(description = "1. Invalid Login", priority = -1)
    public void failureLogin() {
        loginPage.failureLogin();
    }

    @Test(description = "2. Valid Login", groups = { "Sanity" })
    public void successfulLogin() {
        loginPage.successfulLogin();
    }

    @Test(description = "3. Create issue", dependsOnMethods = { "successfulLogin" }, groups = { "Sanity", "Issues" })
    public void createIssue() {
        issuePage.createIssue();
    }

    @Test(description = "4. Open issue", dependsOnMethods = { "createIssue" }, groups = { "Sanity", "Issues" })
    public void openIssue() {
        issuePage.openIssue();
    }

    @Test(description = "5. Uplaod Attachment", dependsOnMethods = { "openIssue" }, groups = { "Issues.Attachments" })
    public void uploadAttachment() {
        issuePage.uploadAttachment();
    }

    @Test(description = "6. Download Attachment", dependsOnMethods = { "uploadAttachment" }, groups = {
            "Issues.Attachments", "disabled" })
    public void downloadAttachment() throws NoSuchAlgorithmException, IOException {
        issuePage.downloadAttachment();
    }
    
    @Test(description = "7. Admin Valid Login", priority = 0, groups = { "Sanity", "Admin" })
    public void successfulAdminLogin() {
    	loginPage.adminLogin();
    }
    
    @Test(description = "8. Create User", dependsOnMethods = { "successfulAdminLogin" }, groups = { "Sanity", "Admin", "User.Create" })
    public void createUser() {
    	adminPage.createUser();
    }
   
    
  
}