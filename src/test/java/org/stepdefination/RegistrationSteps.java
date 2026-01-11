package org.stepdefination;

import org.pages.RegistrationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps {
	
	RegistrationPage r=new RegistrationPage();
	@Given("user is on Parabank Registration page")
	public void user_is_on_parabank_registration_page() {
	    r.reistrationPage();
	}
	@When("user enters valid details")
	public void user_enters_valid_details() {
	   r.validDetails();
	}
	@When("clicks on Register button")
	public void clicks_on_register_button() {
	    r.submit();
	}
	@Then("user account should be created successfully")
	public void user_account_should_be_created_successfully() {
	    r.validateSuccessfulMsg();
	}
	@When("user leaves mandatory fields blank")
	public void user_leaves_mandatory_fields_blank() {
		r.leavesMandatory();
	   
	}
	@Then("error message should be displayed")
	public void error_message_should_be_displayed() {
		r.errorMsg();
	 
	}
	@When("user enters mismatching password and confirm password")
	public void user_enters_mismatching_password_and_confirm_password() {
	    r.mismatchPassword();
	}
	
	@Then("a password mismatch error should display")
	public void a_password_mismatch_error_should_display() {
		r.mismatchError();
	    
	}



}
