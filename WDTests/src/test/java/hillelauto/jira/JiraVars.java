package hillelauto.jira;

import hillelauto.Tools;

public interface JiraVars {
    public static final String baseURL = "http://jira.hillel.it:8080/";
    //User Login
    public static final String username = "Denysmatolikov";
    public static final String password = "00112233";
    //Admin Login
    public static final String adminName = "autorob";
    public static final String adminPassword = "forautotests";
    //Issue Summary, attachment File
    public static final String newIssueSummary = "Denys AutoTest " + Tools.timestamp(false);
    public static final String attachmentFileLocation = "C:\\Users\\Денис\\Dropbox\\eclipse-workspace\\WDTests\\src\\test\\resources\\";
    public static final String downloadsLocation ="C:\\Users\\Денис\\Downloads\\";
    public static final String attachmentFileName = "FileForTest.jpg";
    //New User
    public static final String newEMail = "Denys" + Tools.timestamp(true) + "@user.com";
    public static final String newFullName = "Denys" + Tools.timestamp(true) + " Test";
    public static final String newName = "Denys" + Tools.timestamp(true);   
    //TestRail
    public static final String testRailURL = "https://hillelmanold.testrail.io/";
    public static final String testRailUser = "rvalek@intersog.com";
    public static final String testRailPassword = "hillel";
    public static final String testRun = "5";
}