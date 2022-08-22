package org.stepdefinition;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.objectrepository.LoginPojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition extends LoginPojo {
	public static LoginPojo l;

	@Given("User is in Hazelton login page")
	public void user_is_in_Hazelton_login_page() throws InterruptedException, IOException {
		launchChrome();
		loadUrl("https://hazeltonswines.com/");
		maximizeBrowser();
		screenShot("Hazelton_HomePage");
		Thread.sleep(500);

	}

	@When("User enter valid username and valid password")
	public void user_enter_valid_username_and_valid_password() throws IOException, InterruptedException {
		l = new LoginPojo();
		l.getSignIn().click();
		screenShot("Hazelton_Signin");
		Thread.sleep(1000);
		fill(l.getEmailId(), readExcel(6, 0));
		fill(l.getPassWord(), readExcel(6, 1));
		screenShot("Hazelton_Enter_UserId_Password");

	}

	@When("User click Login Button")
	public void user_click_Login_Button() throws InterruptedException, IOException {
		btnclik(l.getClkBtn());
		screenShot("Hazelton_Click_Enter");
		Thread.sleep(1000);
	}

	@Then("User should be in valid credentials page")
	public void user_should_be_in_valid_credentials_page() throws InterruptedException {
		String Url = driver.getCurrentUrl();
		Assert.assertTrue("Check the Url.....", Url.contains("hazeltonswines"));
		Thread.sleep(500);
	}

	@When("close the Hazelton Application browser")
	public static void close_the_Hazelton_Application_browser() throws IOException {
		l.getHidebutton().click();
		mvetoElmnt(l.getSignOut());
		singleClick(l.getSignOut());

	}

	@Given("User is in Facebook login page")
	public void user_is_in_Facebook_login_page() throws IOException {
		launchChrome();
		loadUrl("https://www.facebook.com/");
		maximizeBrowser();
		screenShot("Facebook_login");
	}

	@When("User click forgot password link")
	public void user_click_forgot_password_link() throws IOException {
		WebElement frgtBtn = driver.findElement(By.xpath("//a[text()='Forgotten password?']"));
		frgtBtn.click();
		screenShot("Click_FrgtBtn");
	}

	@When("User searches the account using invalid mobile number {string}")
	public void user_searches_the_account_using_invalid_mobile_number(String mobile)
			throws InterruptedException, IOException {
		WebElement txtMobile = driver.findElement(By.xpath("//input[@id='identify_email']"));
		txtMobile.sendKeys(mobile);
		screenShot("Enter_Mobile");
		Thread.sleep(500);
		WebElement srchBtn = driver.findElement(By.xpath("//button[@id='did_submit']"));
		srchBtn.click();
		Thread.sleep(1000);
	}

	@Then("user is displayed with error message")
	public void user_is_displayed_with_error_message() throws IOException {
		WebElement errormessage = driver
				.findElement(By.xpath("//div[contains(text(),'Your search did not return any results.')]"));
		Assert.assertTrue("The Error Message Will Come.....", errormessage.isDisplayed());
		screenShot("Final_Click_Btn");
	}

}
