package org.stepdefination;

import org.pages.AccountServicePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountServiceSteps {
	
	AccountServicePage a=new AccountServicePage();
	@Given("user is logged in")
	public void user_is_logged_in() {
		
		a.loggedInPage();
	}
	@When("user navigates to Open New Account")
	public void user_navigates_to_Open_New_Account() {
		a.openNewAccount();
	}
	@When("selects account type and submits")
	public void selects_account_type_and_submits() {
	    a.accountType();
	}
	@Then("new account is created and shown to user")
	public void new_account_is_created_and_shown_to_user() {
	   a.createValidate();
	}
	@When("user goes to Accounts Overview")
	public void user_goes_to_accounts_overview() {
       a.accountOverview();
	}
	@Then("the list of user accounts should be displayed")
	public void the_list_of_user_accounts_should_be_displayed() {
       a.accountOverviewValidate();
	}
	@When("user clicks logout")
	public void user_clicks_logout() {
	   a.loggedOut();
	}
	@Then("user should be redirected to login page")
	public void user_should_be_redirected_to_login_page() {
       a.loggedOutMsg();
	}


}
