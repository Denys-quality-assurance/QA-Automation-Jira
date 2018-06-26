package hillelauto.jira;

import hillelauto.Tools;

public interface JiraVars {

    //User Login
    public static final String username = "Denysmatolikov";
    public static final String password = "00112233";
    //Admin Login
    public static final String adminName = "autorob";
    public static final String adminPassword = "forautotests";
    //URLs
    public static final String baseURL = "http://jira.hillel.it:8080/";
    public static final String IssueSearchURL = "http://jira.hillel.it:8080/issues/?jql=reporter%20%3D%20"+username;
    //Issue Summary, attachment File
    public static final String newIssueSummary = "Denys AutoTest " + Tools.timestamp("forIssue");
    public static final String attachmentFileLocation = "C:\\Users\\Денис\\Dropbox\\eclipse-workspace\\WDTests\\src\\test\\resources\\";
    public static final String downloadsLocation ="C:\\Users\\Денис\\Downloads\\";
    public static final String attachmentFileName = "FileForTest.jpg";
    //New User
    public static final String newEMail = "Denys" + Tools.timestamp("forMail") + "@user.com";
    public static final String newFullName = "Denys" + Tools.timestamp("forMail") + " Test";
    public static final String newName = "Denys" + Tools.timestamp("forMail");   
}