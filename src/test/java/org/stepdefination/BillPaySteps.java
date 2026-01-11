package org.stepdefination;

import org.pages.BillPayPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BillPaySteps {

	BillPayPage b=new BillPayPage();
	@When("user navigates to Bill Pay")
	public void user_navigates_to_bill_pay() {
		b.userOnBillPage();
	}
	@When("enters valid payee and account information")
	public void enters_valid_payee_and_account_information() {
	    b.enterValidCredential();
	}
	@Then("bill payment should complete")
	public void bill_payment_should_complete() {
	    b.completePayment();
	}
	@When("user leaves required fields blank on Bill Pay page")
	public void user_leaves_required_fields_blank_on_bill_pay_page() {
	    b.balnkSpace();
	}
	@Then("application should show field validation messages")
	public void application_should_show_field_validation_messages() {
	    b.errorBlankMsg();
	}
	@When("user enters invalid amount")
	public void user_enters_invalid_amount() {
	    b.invalidAmmount();
	}
	@Then("appropriate error message displayed")
	public void appropriate_error_message_displayed() {
	    b.invalidErrorMsg();
	}
}
