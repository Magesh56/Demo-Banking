package org.pages;

import java.time.Duration;

import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utils.Utils;

public class AccountServicePage extends BaseClass {
	
	public AccountServicePage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[normalize-space(text())='Open New Account']")
	private WebElement newAccount;
	@FindBy(xpath="(//select[@class='input'])[1]")
	private WebElement accountType;
	@FindBy(xpath="//input[@value='Open New Account']")
	private WebElement createAccount;
	@FindBy(xpath="//p[normalize-space(text())='Congratulations, your account is now open.']")
	private WebElement createAccountMsg;
	@FindBy(xpath="//a[normalize-space(text())='Accounts Overview']")
	private WebElement accountOverviewBtn;
	@FindBy(xpath="//h1[normalize-space(text())='Accounts Overview']")
	private WebElement AccountOverviewMsg;
	@FindBy(xpath="//a[normalize-space(text())='Log Out']")
	private WebElement logoutBtn;
	@FindBy(xpath="//h2[normalize-space(text())='Customer Login']")
	private WebElement loginPageMsg;
	public WebElement getNewAccount() {
		return newAccount;
	}
	public void setNewAccount(WebElement newAccount) {
		this.newAccount = newAccount;
	}
	public WebElement getAccountType() {
		return accountType;
	}
	public void setAccountType(WebElement accountType) {
		this.accountType = accountType;
	}
	public WebElement getCreateAccount() {
		return createAccount;
	}
	public void setCreateAccount(WebElement createAccount) {
		this.createAccount = createAccount;
	}
	public WebElement getCreateAccountMsg() {
		return createAccountMsg;
	}
	public void setCreateAccountMsg(WebElement createAccountMsg) {
		this.createAccountMsg = createAccountMsg;
	}
	public WebElement getAccountOverviewBtn() {
		return accountOverviewBtn;
	}
	public void setAccountOverviewBtn(WebElement accountOverviewBtn) {
		this.accountOverviewBtn = accountOverviewBtn;
	}
	public WebElement getAccountOverviewMsg() {
		return AccountOverviewMsg;
	}
	public void setAccountOverviewMsg(WebElement accountOverviewMsg) {
		AccountOverviewMsg = accountOverviewMsg;
	}
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	public void setLogoutBtn(WebElement logoutBtn) {
		this.logoutBtn = logoutBtn;
	}
	public WebElement getLoginPageMsg() {
		return loginPageMsg;
	}
	public void setLoginPageMsg(WebElement loginPageMsg) {
		this.loginPageMsg = loginPageMsg;
	}
	
	public void loggedInPage() {
		LoginPage l=new LoginPage();
		l.enterValidCredential();
		l.submit();
	}
	public void openNewAccount() {
		AccountServicePage a=new AccountServicePage();
		Utils.click(a.getNewAccount());
	}
	public void accountType()  {
		AccountServicePage a=new AccountServicePage();
		Utils.click(a.getAccountType());
		Utils.downKey(2);
		Utils.click(a.getCreateAccount());
	}
	public void createValidate()  {
		AccountServicePage a=new AccountServicePage();
		Utils.waits(a.getCreateAccountMsg());
		Assert.assertEquals("Congratulations, your account is now open.", a.getCreateAccountMsg().getText());
	}
	public void accountOverview() {
		AccountServicePage a=new AccountServicePage();
		Utils.click(a.getAccountOverviewBtn());
	}
	public void accountOverviewValidate() {
		AccountServicePage a=new AccountServicePage();
		Assert.assertEquals("Accounts Overview", a.getAccountOverviewMsg().getText());
	}
	public void loggedOut() {
		AccountServicePage a=new AccountServicePage();
		Utils.click(a.getLogoutBtn());
	}
	public void loggedOutMsg() {
		AccountServicePage a=new AccountServicePage();
		Utils.click(a.getLoginPageMsg());
	}
	
		

}
