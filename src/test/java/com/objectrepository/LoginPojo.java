package com.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.baseclass.BaseClass;

public class LoginPojo extends BaseClass {
	
	// 1.Constructor with page factory
	public LoginPojo() {
		PageFactory.initElements(driver, this);
	}

	// 2.Using annotations we will find the webElements
	@FindBy(xpath = "//input[@id='email']")
	private WebElement txtEmail;
	@FindBy(xpath = "//input[@id='pass']")
	private WebElement txtPass;
	@FindBy(xpath = "//button[@name='login']")
	private WebElement LgnBtn;
	@FindBy(xpath="(//div[@data-visualcompletion='ignore'])[9]")
	private WebElement picClick;
	@FindBy(xpath = "//span[text()='Log Out']")
	private WebElement LgotBtn;

	// 3.To Generate Getters and Setters
	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getLgnBtn() {
		return LgnBtn;
	}

	public WebElement getPicClick() {
		return picClick;
	}

	public WebElement getLgotBtn() {
		return LgotBtn;
	}

	

	
	
	
	
	
//	@FindBy(xpath = "//input[@id='username']")
//	private WebElement Username;
//	@FindBy(xpath = "//input[@name='password']")
//	private WebElement password;
//	@FindBy(xpath = "//input[@value='Login']")
//	private WebElement Btnlgn;
//	@FindBy(xpath = "//select[@name='location']")
//	private WebElement location;
//	@FindBy(xpath = "//select[@id='hotels']")
//	private WebElement hotels;
//	@FindBy(xpath = "//select[@name='room_type']")
//	private WebElement roomtype;
//	@FindBy(xpath = "(//select[@class='search_combobox'])[4]")
//	private WebElement searchcombobox;
//	@FindBy(xpath = "//input[@name='datepick_in']")
//	private WebElement datepickin;
//	@FindBy(xpath = "//input[@id='datepick_out']")
//	private WebElement datepickout;
//	@FindBy(xpath = "//select[@name='adult_room']")
//	private WebElement adultroom;
//	@FindBy(xpath = "//select[@name='child_room']")
//	private WebElement childroom;
//	@FindBy(xpath = "//input[@value='Search']")
//	private WebElement search;

	// 3.To create Getters
//	public WebElement getUsername() {
//		return Username;
//	}
//	public WebElement getPassword() {
//		return password;
//	}
//	public WebElement getBtnlgn() {
//		return Btnlgn;
//	}
//	public WebElement getLocation() {
//		return location;
//	}
//	public WebElement getHotels() {
//		return hotels;
//	}
//	public WebElement getRoomtype() {
//		return roomtype;
//	}
//	public WebElement getSearchcombobox() {
//		return searchcombobox;
//	}
//	public WebElement getDatepickin() {
//		return datepickin;
//	}
//	public WebElement getDatepickout() {
//		return datepickout;
//	}
//	public WebElement getAdultroom() {
//		return adultroom;
//	}
//	public WebElement getChildroom() {
//		return childroom;
//	}
//	public WebElement getSearch() {
//		return search;
//	}

	
}
