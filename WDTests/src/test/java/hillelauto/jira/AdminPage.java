package hillelauto.jira;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import hillelauto.Tools;

public class AdminPage {
	private WebDriver browser;
	
	@FindBy(css = "a#admin_menu")
    private WebElement adminMenu;
    @FindBy(css = "a#admin_users_menu")
    private WebElement adminUserMenu;
    private final By inputPassword = By.cssSelector("input#login-form-authenticatePassword");
    @FindBy(css = "a#create_user")
    private WebElement buttonCreateUser;
    private final By newUserEMail = By.cssSelector("input#user-create-email");
    private final By newUserFullName = By.cssSelector("input#user-create-fullname");
    private final By newUserName = By.cssSelector("input#user-create-username");
    @FindBy(css = "table#user_browser_table > tbody > tr:nth-child(1) > td:nth-child(2) > div > a > span")
    private WebElement mailInUsersTable;
    private final By FilterUsers = By.cssSelector("input#user-filter-userSearchFilter");
   
    private By userActionsButton = By.cssSelector("a[href=\"#user-actions-"+JiraVars.newName+"\"]");
    private By deleteUserButton = By.cssSelector("a[id=\"deleteuser_link_"+JiraVars.newName+"\"]");
    @FindBy(css = "input#delete_user_confirm-submit")
    private WebElement deleteUserConfirm;
	
    
    public AdminPage(WebDriver browser) {
        this.browser = browser;
    }
    
    public void createUser() {
    	adminMenu.click();
    	adminUserMenu.click();
    	Tools.clearAndFill(inputPassword, JiraVars.adminPassword).submit();
    	buttonCreateUser.click();
    	Tools.clearAndFill(newUserEMail, JiraVars.newEMail);
    	Tools.clearAndFill(newUserFullName, JiraVars.newFullName);
    	Tools.clearAndFill(newUserName, JiraVars.newName).submit();
    	
    	Assert.assertEquals(JiraVars.newEMail, mailInUsersTable.getText());
    }
    
    public void deleteUser() {
    	adminMenu.click();
    	adminUserMenu.click();
    	Tools.clearAndFill(FilterUsers, JiraVars.newFullName).submit();
    	browser.findElement(userActionsButton).click();
    	browser.findElement(deleteUserButton).click();
    	deleteUserConfirm.click();
    }
    
    
}
