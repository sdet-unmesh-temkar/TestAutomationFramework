package org.naukriAutomation.tests.cucumber;

import io.cucumber.java.en.*;

public class StepDefinitions {
    @Given("We launch the naukri application")
    public void we_launch_the_naukri_application() {
        System.out.println("step running");
    }
    @Given("We enter login credentials")
    public void we_enter_login_credentials() {
        System.out.println("step running");
    }
    @When("We update the profile details")
    public void we_update_the_profile_details() {
        System.out.println("step running");
    }
    @Then("We verify the profile is updated successfully")
    public void we_verify_the_profile_is_updated_successfully() {
        System.out.println("step running");
    }
}
