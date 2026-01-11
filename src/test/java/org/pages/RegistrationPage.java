package org.pages;

import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utils.Utils;

public class RegistrationPage extends BaseClass {
	
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space(text())='Register']")
	private WebElement regesterBtn;
	@FindBy(id="customer.firstName")
	private WebElement firstName;
	@FindBy(id="customer.lastName")
	private WebElement lastName;
	@FindBy(id="customer.address.street")
	private WebElement address;
	@FindBy(id="customer.address.city")
	private WebElement city;
	@FindBy(id="customer.address.state")
	private WebElement state;
	@FindBy(id="customer.address.zipCode")
	private WebElement zipCode;
	@FindBy(id="customer.phoneNumber")
	private WebElement phoneNumber;
	@FindBy(id="customer.username")
	private WebElement username;
	@FindBy(id="customer.password")
	private WebElement password;
	@FindBy(id="customer.ssn")
	private WebElement ssn;
	@FindBy(id="repeatedPassword")
	private WebElement conformPassword;
	@FindBy(xpath="(//input[@class='button'])[2]")
	private WebElement submitBtn;
	@FindBy(id="repeatedPassword.errors")
	private WebElement passwordMissmatchMsg;
	@FindBy(id="customer.username.errors")
	private WebElement usernameErrorMsg;
	@FindBy(xpath="//p[normalize-space(text())='Your account was created successfully. You are now logged in.']")
	private WebElement successMsg;
	public WebElement getRegesterBtn() {
		return regesterBtn;
	}
	public void setRegesterBtn(WebElement regesterBtn) {
		this.regesterBtn = regesterBtn;
	}
	public WebElement getFirstName() {
		return firstName;
	}
	public void setFirstName(WebElement firstName) {
		this.firstName = firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public void setLastName(WebElement lastName) {
		this.lastName = lastName;
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
	public WebElement getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(WebElement phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public WebElement getUsername() {
		return username;
	}
	public void setUsername(WebElement username) {
		this.username = username;
	}
	public WebElement getPassword() {
		return password;
	}
	public void setPassword(WebElement password) {
		this.password = password;
	}
	public WebElement getSsn() {
		return ssn;
	}
	public void setSsn(WebElement ssn) {
		this.ssn = ssn;
	}
	public WebElement getConformPassword() {
		return conformPassword;
	}
	public void setConformPassword(WebElement conformPassword) {
		this.conformPassword = conformPassword;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public void setSubmitBtn(WebElement submitBtn) {
		this.submitBtn = submitBtn;
	}
	public WebElement getPasswordMissmatchMsg() {
		return passwordMissmatchMsg;
	}
	public void setPasswordMissmatchMsg(WebElement passwordMissmatchMsg) {
		this.passwordMissmatchMsg = passwordMissmatchMsg;
	}
	public WebElement getZipCodeErrorMsg() {
		return usernameErrorMsg;
	}
	public void setZipCodeErrorMsg(WebElement zipCodeErrorMsg) {
		this.usernameErrorMsg = zipCodeErrorMsg;
	}
	public WebElement getSuccessMsg() {
		return successMsg;
	}
	public void setSuccessMsg(WebElement successMsg) {
		this.successMsg = successMsg;
	}
	
	public void reistrationPage() {
		RegistrationPage r=new RegistrationPage();
		Utils.click(r.getRegesterBtn());
		
	}
	public void validDetails() {
		RegistrationPage r=new RegistrationPage();
		Utils.sendKeys(r.getFirstName(), Utils.getProperty("firstname"));
		Utils.sendKeys(r.getLastName(), Utils.getProperty("lastname"));
		Utils.sendKeys(r.getAddress(), Utils.getProperty("address"));
		Utils.sendKeys(r.getState(), Utils.getProperty("state"));
		Utils.sendKeys(r.getCity(), Utils.getProperty("city"));
		Utils.sendKeys(r.getZipCode(), Utils.getProperty("zipcode"));
		Utils.sendKeys(r.getPhoneNumber(), Utils.getProperty("phnum"));
		Utils.sendKeys(r.getSsn(), Utils.getProperty("ssn"));
		Utils.sendKeys(r.getUsername(), Utils.getProperty("username"));
		Utils.sendKeys(r.getPassword(), Utils.getProperty("password"));
		Utils.sendKeys(r.getConformPassword(), Utils.getProperty("conformpass"));
	}
	public void submit() {
		RegistrationPage r=new RegistrationPage();
		Utils.click(r.getSubmitBtn());
	}
	
	public void validateSuccessfulMsg() {
		RegistrationPage r=new RegistrationPage();
		Assert.assertEquals("Your account was created successfully. You are now logged in.", r.getSuccessMsg().getText());
	}
	
	public void leavesMandatory() {
		RegistrationPage r=new RegistrationPage();
		r.validDetails();
		Utils.sendKeys(r.getUsername(), Utils.getProperty("username"));
		Utils.sendKeys(r.getZipCode(), " ");
		Utils.sendKeys(r.getState(), " ");
		
	}
	public void errorMsg() {
		RegistrationPage r=new RegistrationPage();
		Assert.assertEquals("This username already exists.", r.getZipCodeErrorMsg().getText());
	}
	
	public void mismatchPassword() {
		RegistrationPage r=new RegistrationPage();
		r.validDetails();
		Utils.sendKeys(r.getConformPassword(), Utils.getProperty("mismatchpassword"));
		
	}
	public void mismatchError() {
		RegistrationPage r=new RegistrationPage();
		Assert.assertEquals("Passwords did not match.", r.getPasswordMissmatchMsg().getText());
	}
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
