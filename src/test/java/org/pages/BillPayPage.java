package org.pages;

import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utils.Utils;

public class BillPayPage extends BaseClass {
	
	public BillPayPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText ="Bill Pay")
	private WebElement billPayBtn;
	@FindBy(xpath="(//table[@class='form2']//input)[1]")
	private WebElement payName;
	@FindBy(xpath="(//input[@class='input'])[2]")
	private WebElement address;
	@FindBy(xpath="(//input[@class='input'])[3]")
	private WebElement city;
	@FindBy(xpath="//input[@name='payee.address.state']")
	private WebElement state;
	@FindBy(xpath="//input[@name='payee.address.zipCode']")
	private WebElement zipCode;
	@FindBy(name = "payee.phoneNumber")
	private WebElement phnum;
	@FindBy(xpath="//input[@name='payee.accountNumber']")
	private WebElement account;
	@FindBy(xpath="//input[@name='verifyAccount']")
	private WebElement verifyAccount;
	@FindBy(xpath="//input[@name='amount']")
	private WebElement amount;
	@FindBy(xpath="//select[@class='input']")
	private WebElement fromAccount;
	@FindBy(xpath="//input[@class='button']")
	private WebElement sendPayment;
	@FindBy(xpath="//span[@id='validationModel-verifyAccount-empty']")
	private WebElement SkipAcountNumberMsg;
	@FindBy(xpath="//span[normalize-space(text())='Please enter a valid amount.']")
	private WebElement validAmountMsg;
	
	public WebElement getValidAmountMsg() {
		return validAmountMsg;
	}
	public void setValidAmountMsg(WebElement validAmountMsg) {
		this.validAmountMsg = validAmountMsg;
	}
	public WebElement getBillPayBtn() {
		return billPayBtn;
	}
	public void setBillPayBtn(WebElement billPayBtn) {
		this.billPayBtn = billPayBtn;
	}
	public WebElement getPayName() {
		return payName;
	}
	public void setPayName(WebElement payName) {
		this.payName = payName;
	}
	public WebElement getAddress() {
		return address;
	}
	public void setAddress(WebElement address) {
		this.address = address;
	}
	public WebElement getCity() {
		return city;
	}
	public void setCity(WebElement city) {
		this.city = city;
	}
	public WebElement getState() {
		return state;
	}
	public void setState(WebElement state) {
		this.state = state;
	}
	public WebElement getZipCode() {
		return zipCode;
	}
	public void setZipCode(WebElement zipCode) {
		this.zipCode = zipCode;
	}
	public WebElement getPhnum() {
		return phnum;
	}
	public void setPhnum(WebElement phnum) {
		this.phnum = phnum;
	}
	public WebElement getAccount() {
		return account;
	}
	public void setAccount(WebElement account) {
		this.account = account;
	}
	public WebElement getVerifyAccount() {
		return verifyAccount;
	}
	public void setVerifyAccount(WebElement verifyAccount) {
		this.verifyAccount = verifyAccount;
	}
	public WebElement getAmount() {
		return amount;
	}
	public void setAmount(WebElement amount) {
		this.amount = amount;
	}
	public WebElement getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(WebElement fromAccount) {
		this.fromAccount = fromAccount;
	}
	public WebElement getSendPayment() {
		return sendPayment;
	}
	public void setSendPayment(WebElement sendPayment) {
		this.sendPayment = sendPayment;
	}
	public WebElement getSkipAcountNumberMsg() {
		return SkipAcountNumberMsg;
	}
	public void setSkipAcountNumberMsg(WebElement skipAcountNumberMsg) {
		SkipAcountNumberMsg = skipAcountNumberMsg;
	}
	
	public void userOnBillPage() {
		BillPayPage b=new BillPayPage();
		Utils.click(b.getBillPayBtn());
	}
	public void enterValidCredential() {
		BillPayPage b=new BillPayPage();
		Utils.sendKeys(b.getPayName(), Utils.getProperty("firstname"));
		Utils.sendKeys(b.getAddress(), Utils.getProperty("address"));
		Utils.sendKeys(b.getCity(), Utils.getProperty("city"));
		Utils.sendKeys(b.getState(), Utils.getProperty("state"));
		Utils.sendKeys(b.getZipCode(), Utils.getProperty("zipcode"));
		Utils.sendKeys(b.getPhnum(), Utils.getProperty("phnum"));
		Utils.sendKeys(b.getAccount(), Utils.getProperty("account"));
		Utils.sendKeys(b.getVerifyAccount(), Utils.getProperty("account"));
		Utils.sendKeys(b.getAmount(), Utils.getProperty("amount"));
		Utils.sendKeys(b.getPayName(), Utils.getProperty("lastname"));
	}
	public void completePayment() {
		BillPayPage b=new BillPayPage();
		Utils.click(b.getSendPayment());
	}
	
	public void balnkSpace() {
		BillPayPage b=new BillPayPage();
		Utils.click(b.getBillPayBtn());
		b.enterValidCredential();
		Utils.sendKeys(b.getVerifyAccount(), Utils.getProperty("null"));
		b.completePayment();
	  
	}
	public void errorBlankMsg() {
		BillPayPage b=new BillPayPage();
		 // Utils.waits(b.getSkipAcountNumberMsg());
		Assert.assertEquals("Account number is required.", b.getSkipAcountNumberMsg().getText());
	}
	public void invalidAmmount() {
		BillPayPage b=new BillPayPage();
		Utils.click(b.getBillPayBtn());
		b.enterValidCredential();
		Utils.sendKeys(b.getAmount(), Utils.getProperty("invalidamount"));
		b.completePayment();
		
	}
	public void invalidErrorMsg() {
		BillPayPage b=new BillPayPage();
		//Utils.waits(b.getValidAmountMsg());
		Assert.assertEquals("Please enter a valid amount.",b.getValidAmountMsg().getText());
	}
	
	
	
	
	
	
	
	
	

}
