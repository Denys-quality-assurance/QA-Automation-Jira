package hillelauto.jira;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import hillelauto.Tools;

public class IssuePage {
    private final By inputProject = By.cssSelector("input#project-field");
    private final By inputSummary = By.cssSelector("input#summary");
    private final WebDriver browser;
    private String newIssuePath;
    private String attachmentLink;
    @FindBy(css = "a#create_link")
    private WebElement buttonCreateIssue;
    @FindBy(css = "a.issue-created-key")
    private List<WebElement> linkNewIssues;
    @FindBy(css = "input.issue-drop-zone__file")
    private WebElement inputUploadAttachment;
    @FindBy(css = "a.attachment-title")
    private WebElement linkAttachmentName;
    
    @FindBy(css = "body > img")
    private WebElement testFile;
    
   
    public IssuePage(WebDriver browser) {
        this.browser = browser;
    }

    public void createIssue() {
        buttonCreateIssue.click();

        Tools.clearAndFill(inputProject, "General QA Robert (GQR)\n");

        new FluentWait<>(browser).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(500))
                .ignoring(InvalidElementStateException.class)
                .until(browser -> Tools.clearAndFill(inputSummary, JiraVars.newIssueSummary)).submit();


        Assert.assertTrue(linkNewIssues.size() != 0);

        newIssuePath = linkNewIssues.get(0).getAttribute("href");
    }

    public void openIssue() {
        browser.get(newIssuePath);
        Assert.assertTrue(browser.getTitle().contains(JiraVars.newIssueSummary));
    }

    public void uploadAttachment() {
        inputUploadAttachment.sendKeys(JiraVars.attachmentFileLocation + JiraVars.attachmentFileName);

        new FluentWait<>(browser).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class).until(browser -> linkAttachmentName);

        Assert.assertEquals(JiraVars.attachmentFileName, linkAttachmentName.getText());

        attachmentLink = linkAttachmentName.getAttribute("href");


    }

    public void downloadAttachment() throws NoSuchAlgorithmException, IOException {
    	//browser.get(attachmentLink);
       // attachmentLink = testFile.getAttribute("src");
        Assert.assertEquals(Tools.getURLDigest(attachmentLink, JiraVars.attachmentFileLocation), Tools.getFileDigest(JiraVars.attachmentFileLocation + JiraVars.attachmentFileName));
        
        
        // https://stackoverflow.com/questions/304268/getting-a-files-md5-checksum-in-java
    }
    
    
}