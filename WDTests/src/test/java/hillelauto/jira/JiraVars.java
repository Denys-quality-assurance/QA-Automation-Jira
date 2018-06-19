package hillelauto.jira;

import hillelauto.Tools;

public interface JiraVars {
    public static final String baseURL = "http://jira.hillel.it:8080/";
    
    public static final String username = "Denysmatolikov";
    public static final String password = "00112233";
    public static final String adminName = "autorob";
    public static final String adminPassword = "forautotests";

    public static final String newIssueSummary = "Denys AutoTest " + Tools.timestamp(false);
    public static final String attachmentFileLocation = "C:\\Users\\Денис\\Dropbox\\eclipse-workspace\\WDTests\\src\\test\\resources\\";
    public static final String attachmentFileName = "FileForTest.jpg";
    
    public static final String newEMail = "Denys" + Tools.timestamp(true) + "@user.com";
    public static final String newFullName = "Denys" + Tools.timestamp(true) + " Test";
    public static final String newName = "Denys" + Tools.timestamp(true);
}