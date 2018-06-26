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

    @Test(description = "19. Invalid Login", priority = -1, groups = { "User", "disabled" })
    public void failureLogin() {
        loginPage.failureLogin();
    }

    @Test(description = "20. Valid Login", groups = { "Sanity", "User" })
    public void successfulLogin() {
        loginPage.successfulLogin();
    }

    @Test(description = "21. Create issue", dependsOnMethods = { "successfulLogin" }, groups = { "Sanity", "Issues", "User" })
    public void createIssue() {
        issuePage.createIssue();
    }

    @Test(description = "22. Open issue", dependsOnMethods = { "createIssue" }, groups = { "Sanity", "Issues", "User" })
    public void openIssue() {
        issuePage.openIssue();
    }

    @Test(description = "23. Uplaod Attachment", dependsOnMethods = { "openIssue" }, groups = { "Issues.Attachments", "User" })
    public void uploadAttachment() {
        issuePage.uploadAttachment();
    }

    @Test(description = "24. Download Attachment", dependsOnMethods = { "uploadAttachment" }, groups = {
            "Issues.Attachments", "User" })
    public void downloadAttachment() throws NoSuchAlgorithmException, IOException {
        issuePage.downloadAttachment();
    }
    
    @Test(description = "25. Admin Valid Login", priority = 1, groups = { "Sanity", "Admin" })
    public void successfulAdminLogin() {
    	loginPage.adminLogin();
    }
    
    @Test(description = "26. Create User", dependsOnMethods = { "successfulAdminLogin" }, groups = { "Sanity", "Admin" })
    public void createUser() {
    	adminPage.createUser();
    }
   
    @Test(description = "396. Delete User", dependsOnMethods = { "createUser" }, groups = { "Sanity", "Admin" })
    public void deleteUser() {
    	adminPage.deleteUser();
    }
  
}