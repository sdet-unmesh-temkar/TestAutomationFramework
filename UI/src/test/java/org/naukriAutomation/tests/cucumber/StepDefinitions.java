package org.naukriAutomation.tests.cucumber;

import io.cucumber.java.en.*;
import org.naukriAutomation.actions.ProfileActions;
import org.naukriAutomation.webdrivermanager.DriverFactory;

public class StepDefinitions {
    private ProfileActions profileActions;

    public StepDefinitions() {
        	profileActions = new ProfileActions(DriverFactory.getDriver());
    }

    @Given("We launch the naukri application")
    public void openApp() {
        profileActions.openApp();
    }

    @Given("We enter login credentials")
    public void login() {
        profileActions.login("unmeshtemkar@zohomail.in", "1995@umaaa");
    }

    @When("We update the profile details")
    public void updateProfile() {
        profileActions.viewProfile();
        profileActions.editResumeHeadline();
    }

    @Then("We verify the profile is updated successfully")
    public void validateProfileUp() {
        profileActions.saveProfile();
    }
}