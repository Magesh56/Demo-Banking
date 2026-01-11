package org.stepdefination;

import org.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	LoginPage l=new LoginPage();
	@Given("user is on Parabank Login page")
	public void user_is_on_parabank_login_page() {
	   l.userOnLogin();
	}
	@When("user enters correct username and password")
	public void user_enters_correct_username_and_password() {
	    l.enterValidCredential();
	}
	@When("clicks Login")
	public void clicks_login() {
	    l.submit();
	}
	@Then("user should land on Account Overview page")
	public void user_should_land_on_account_overview_page() {
	   l.valaditeLoginPage();
	}
	@When("user enters invalid credentials")
	public void user_enters_invalid_credentials() {
	    l.invalidCredentials();
	}
	@Then("appropriate error message should show")
	public void appropriate_error_message_should_show() {
	   l.invalidError();
	}
	@When("user clicks Login without entering credentials")
	public void user_clicks_login_without_entering_credentials() {
	   l.withoutCredential();
	}
	@Then("proper validation error should appear")
	public void proper_validation_error_should_appear() {
	   l.errorMsgWithoutCredential();
	}


}
