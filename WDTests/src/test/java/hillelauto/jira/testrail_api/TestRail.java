package hillelauto.jira.testrail_api;

import java.util.HashMap;
import java.util.Map;

import hillelauto.jira.JiraVars;

public class TestRail {
    private Map<String, Integer> testResultData = new HashMap<String, Integer>();
    private APIClient client = null;

    public TestRail() {
        authorize(JiraVars.testRailURL, JiraVars.testRailUser, JiraVars.testRailPassword);
    }

    public void setCaseResult(String testID, String testRun, boolean isResultSuccess) throws Exception{
        if (isResultSuccess){
            testResultData.put("status_id", new Integer(1));
        } else
            testResultData.put("status_id", new Integer(5));

        client.sendPost("add_result_for_case/"+testRun+"/"+testID, testResultData);
    }

    private void authorize(String testRailURL, String testRailUser, String testRailPassword) {
        client = new APIClient(testRailURL);
        client.setUser(testRailUser);
        client.setPassword(testRailPassword);
    }
}
