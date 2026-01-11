package org.stepdefination;

import org.pages.TransferFundPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TransferFundsSteps {
	
	TransferFundPage t=new TransferFundPage();
	@When("user goes to Transfer Funds")
	public void user_goes_to_transfer_funds() {
	   t.transferFundPage();
	}
	@When("enters valid From Account, To Account and Amount")
	public void enters_valid_from_account_to_account_and_amount() {
	    t.validAccount();
	   
	}
	@Then("transfer should be successful")
	public void transfer_should_be_successful() {
	    t.validTransferMsg();
	 
	}
	@When("user enters amount greater than account balance")
	public void user_enters_amount_greater_than_account_balance() {
	    t.userGraterAmount();
	  
	}
	@Then("error “Insufficient funds” should appear")
	public void error_insufficient_funds_should_appear() {
	    t.InsufficientFundMsg();
	   
	}
	@When("user enters invalid account numbers")
	public void user_enters_invalid_account_numbers() {
	    t.invalidAccountNumber();
	    
	}
	@Then("proper invalid account error message should show")
	public void proper_invalid_account_error_message_should_show() {
	    t.ErrorMsg();
	   
	}


}
