package org.naukriAutomation.tests.testNG;

import org.naukriAutomation.Listener.TestListener;
import org.naukriAutomation.actions.ProfileActions;
import org.naukriAutomation.tests.base.BaseTest;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class NaukriAppUpdateAutomationTest extends BaseTest {

    private ProfileActions profileActions;

    @BeforeMethod
    @Override
    @Parameters("browser")
    public void setUp(String browser) {
        profileActions = new ProfileActions(driver);
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        return new Object[][]{
                {"unmeshtemkar@zohomail.in", "1995@umaaa"}
        };
    }

    @Test(dataProvider = "loginData")
    public void updateResumeHeadline(String username, String password) {
        profileActions.openApp();
        profileActions.login(username, password);
        profileActions.viewProfile();
        profileActions.editResumeHeadline();
        profileActions.saveProfile();
    }
}