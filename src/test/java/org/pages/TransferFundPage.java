package org.pages;

import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utils.Utils;


public class TransferFundPage extends BaseClass {
	
	public TransferFundPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space(text())='Transfer Funds']")
	private WebElement transferFundBtn;
	@FindBy(xpath="(//b[normalize-space(text())='Amount:']/following::input)[1]")
	private WebElement amount;
	@FindBy(xpath="//select[@class='input']/following-sibling::select[1]")
	private WebElement accountDropDown;
	@FindBy(xpath="//input[@type='submit']")
	private WebElement transferBtn;
	@FindBy(xpath="//h1[normalize-space(text())='Transfer Complete!']")
	private WebElement transferSuccessMsg;
	@FindBy(xpath="//h1[normalize-space(text())='Error!']")
	private WebElement insufficientErrorMsg;
	public WebElement getTransferFundBtn() {
		return transferFundBtn;
	}
	public void setTransferFundBtn(WebElement transferFundBtn) {
		this.transferFundBtn = transferFundBtn;
	}
	public WebElement getAmount() {
		return amount;
	}
	public void setAmount(WebElement amount) {
		this.amount = amount;
	}
	public WebElement getAccountDropDown() {
		return accountDropDown;
	}
	public void setAccountDropDown(WebElement accountDropDown) {
		this.accountDropDown = accountDropDown;
	}
	public WebElement getTransferBtn() {
		return transferBtn;
	}
	public void setTransferBtn(WebElement transferBtn) {
		this.transferBtn = transferBtn;
	}
	public WebElement getTransferSuccessMsg() {
		return transferSuccessMsg;
	}
	public void setTransferSuccessMsg(WebElement transferSuccessMsg) {
		this.transferSuccessMsg = transferSuccessMsg;
	}
	public WebElement getInsufficientErrorMsg() {
		return insufficientErrorMsg;
	}
	public void setInsufficientErrorMsg(WebElement insufficientErrorMsg) {
		this.insufficientErrorMsg = insufficientErrorMsg;
	}
	
	public void transferFundPage() {
		TransferFundPage t=new TransferFundPage();
		 Utils.click(t.getTransferFundBtn());
	}
	
	public void validAccount() {
		TransferFundPage t=new TransferFundPage();
	   
		Utils.sendKeys(t.getAmount(), Utils.getProperty("amount"));
		Utils.click(t.getTransferBtn());
	}
	public void validTransferMsg() {
		TransferFundPage t=new TransferFundPage();
		Utils.waits(t.getTransferSuccessMsg());
		Assert.assertEquals("Transfer Complete!", t.getTransferSuccessMsg().getText());

	}
	public void userGraterAmount() {
		TransferFundPage t=new TransferFundPage();
		Utils.click(t.getTransferFundBtn());
		Utils.sendKeys(t.getAmount(), Utils.getProperty("largeamount"));
		Utils.click(t.getTransferBtn());
		Utils.waits(t.getInsufficientErrorMsg());
	}
	public void InsufficientFundMsg() {
		TransferFundPage t=new TransferFundPage();
	
		Utils.waits(t.getTransferSuccessMsg());
		Assert.assertEquals("Error!", t.getInsufficientErrorMsg().getText());
	}
	
	public void invalidAccountNumber() {
		TransferFundPage t=new TransferFundPage();
		t.userGraterAmount();
	}
	public void ErrorMsg() {
		TransferFundPage t=new TransferFundPage();
		Assert.assertEquals("Error!", t.getInsufficientErrorMsg().getText());
	}
	

}
