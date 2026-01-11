package org.pages;

import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utils.Utils;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@class='input'])[1]")
	private WebElement username;
	@FindBy(xpath="(//input[@class='input'])[2]")
	private WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit;
	@FindBy(xpath="//h1[normalize-space(text())='Accounts Overview']")
	private WebElement accountOverviewMsg;
	@FindBy(xpath="//p[normalize-space(text())='The username and password could not be verified.']")
	private WebElement invalidUserNameMsg;
	@FindBy(xpath="//p[normalize-space(text())='Please enter a username and password.']")
	private WebElement enterCredentialMsg;
	@FindBy(xpath="//h2[normalize-space(text())='Customer Login']")
	private WebElement loginPageMsg;
	
	public WebElement getLoginPageMsg() {
		return loginPageMsg;
	}
	public void setLoginPageMsg(WebElement loginPageMsg) {
		this.loginPageMsg = loginPageMsg;
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
	public WebElement getSubmit() {
		return submit;
	}
	public void setSubmit(WebElement submit) {
		this.submit = submit;
	}
	public WebElement getAccountOverviewMsg() {
		return accountOverviewMsg;
	}
	public void setAccountOverviewMsg(WebElement accountOverviewMsg) {
		this.accountOverviewMsg = accountOverviewMsg;
	}
	public WebElement getInvalidUserNameMsg() {
		return invalidUserNameMsg;
	}
	public void setInvalidUserNameMsg(WebElement invalidUserNameMsg) {
		this.invalidUserNameMsg = invalidUserNameMsg;
	}
	public WebElement getEnterCredentialMsg() {
		return enterCredentialMsg;
	}
	public void setEnterCredentialMsg(WebElement enterCredentialMsg) {
		this.enterCredentialMsg = enterCredentialMsg;
	}
	
	public void userOnLogin() {
		LoginPage l=new LoginPage();
		Assert.assertEquals("Customer Login", l.getLoginPageMsg().getText());
	}
	public void enterValidCredential() {
		LoginPage l=new LoginPage();
		Utils.sendKeys(l.getUsername(), Utils.getProperty("loginUser"));
		Utils.sendKeys(l.getPassword(), Utils.getProperty("loginPassword"));
	}
	public void submit() {
		LoginPage l=new LoginPage();
		Utils.click(l.getSubmit());
	}
	public void valaditeLoginPage() {
		LoginPage l=new LoginPage();
		Assert.assertEquals("Accounts Overview", l.getAccountOverviewMsg().getText());
	}
	public void invalidCredentials() {
		LoginPage l=new LoginPage();
		Utils.sendKeys(l.getUsername(), Utils.getProperty("invaliduser"));
		Utils.sendKeys(l.getPassword(), Utils.getProperty("loginPassword"));
		Utils.click(l.getSubmit());
		
	}
	public void invalidError() {
		LoginPage l=new LoginPage();
		Assert.assertEquals("The username and password could not be verified.", l.getInvalidUserNameMsg().getText());
	}
	public void withoutCredential() {
		LoginPage l=new LoginPage();
		Utils.sendKeys(l.getUsername(), Utils.getProperty("null"));
		Utils.sendKeys(l.getPassword(), Utils.getProperty("null"));
		Utils.click(l.getSubmit());
	}
	public void errorMsgWithoutCredential() {
		LoginPage l=new LoginPage();
		Assert.assertEquals("Please enter a username and password.", l.getEnterCredentialMsg().getText());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
