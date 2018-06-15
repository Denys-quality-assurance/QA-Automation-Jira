package hillelauto.jira;

import hillelauto.Tools;

public interface JiraVars {
    public static final String baseURL = "http://jira.hillel.it:8080/";
    public static final String username = "Denysmatolikov";
    public static final String password = "00112233";

    public static final String newIssueSummary = "Denys AutoTest " + Tools.timestamp();
    public static final String attachmentFileLocation = "C:\\Users\\Денис\\Dropbox\\eclipse-workspace\\WDTests\\src\\test\\resources\\";
    public static final String attachmentFileName = "FileForTest.txt";
}