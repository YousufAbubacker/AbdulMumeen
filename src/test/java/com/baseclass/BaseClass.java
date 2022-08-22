package com.baseclass;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
	// 0.Browser Launch
	public static WebDriver driver;

	public static WebDriver launchChrome() {
		WebDriverManager.chromedriver().setup();
		// 1.avoid notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		return driver;
	}

	// 2.To Load URL
	public static void loadUrl(String url) {
		driver.get(url);
	}

	// 3.To Maximize The Browser
	public static void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	// 4.To print title in console
	public static void printTitle() {
		System.out.println(driver.getTitle());

	}

	// 5.To print current URL in console
	public static void printUrl() {
		System.out.println(driver.getCurrentUrl());

	}

	// 6.To give the values in sendKeys
	public static void fill(WebElement element, String value) {
		element.sendKeys(value);
	}

	// 7.To Click all the button
	public static void btnclik(WebElement clk) {
		clk.click();
	}

	// 8.To close the entire Browser
	public static void offBrowser() {
		driver.close();
	}

	// 9.To close all the Browser
	public static void quitBrowser() {
		driver.quit();
	}

	// 10.To get text command for the field
	public static void textGet(WebElement ref) {
		System.out.println(ref.getText());
	}

	// 11.To get attribute command for the field
	public static void attributeGet(WebElement refe) {
		System.out.println(refe.getAttribute("value"));
	}

	// 12.move to element in mouse Action
	public static void mvetoElmnt(WebElement move) {
		Actions a = new Actions(driver);
		a.moveToElement(move).perform();
	}

	// 13.Drag and Drop in Mouse Action
	public static void dragandDrop(WebElement source, WebElement destination) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, destination).perform();
	}

	// 14.Single click in mouse action
	public static void singleClick(WebElement target) {
		Actions a = new Actions(driver);
		a.click(target).build().perform();
	}

	// 15.sendKeys through mouse action
	public static void keysSendMouse(WebElement target, String Keys) {
		Actions a = new Actions(driver);
		a.sendKeys(target, Keys).perform();
	}

	// 16.Enter Key using Robot Class
	public static void keyEnter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	// 17.Up-Arrow key using Robot class
	public static void arrowUp() throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}

	// 18.Down-Arrow key using Robot class
	public static void arrowDown() throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	// 19.Copying key using Robot class
	public static void copyKey() throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}

	// 20.Paste key using Robot class
	public static void pasteKey() throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}

	// 21.Cut key using Robot class
	public static void cutKey() throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);
	}

	// 22.Tab key using Robot class
	public static void tabKey() throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}

	// 23.To Select all using Robot class
	public static void selectallKey() throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
	}

	// 24.Simple Alert Accept
	public static void simpleAlert() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	// 25.Confirm Alert with Dismiss
	public static void confirmAlert() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	// 26.Prompt Alert with command Print in console
	public static void promptAlert(String command) {
		Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
		a.sendKeys(command);
		a.accept();
	}

	// 27.Take Screenshot
	public static void screenShot(String filename) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\moham\\eclipse-workspace\\Cucumber10.00Am\\ScreenShot" + filename + ".png");
		FileUtils.copyFile(source, destFile);
	}

	// 28.java script to pass the value
	public static void jsFill(WebElement element, String sendkeys) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + sendkeys + "')", element);
	}

	// 29.java script to click
	public static void jsClick(WebElement reference) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", reference);
	}

	// 30.java script to scroll-up
	public static void jsScrollup(WebElement scrlup) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scollIntoView(true)", scrlup);
	}

	// 31.java script to scroll-down
	public static void jsScrolldown(WebElement scrldwn) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scollIntoView(false)", scrldwn);
	}

	// 32.getAttribute value using java Script
	public static void jsAttributeGet(WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].getAttribute('value')", element);
	}

	// 33.highlight the WebElement using java Script
	public static void jsHighlight(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background:red;border:3px solid orange')", element);
	}

	// 34.Single Drop-down using select by value
	public static void selectValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	// 35.Single Drop-down using select by visible text
	public static void selectVisibleTxt(String value, WebElement reference) {
		Select s = new Select(reference);
		s.selectByVisibleText(value);
	}

	// 36.single Drop-down using select by index
	public static void selectValue(WebElement reference, int index) {
		Select s = new Select(reference);
		s.selectByIndex(index);
	}

	// 37.is multiple in drop-down box
	public static void isMultiple(WebElement element, int index) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
	}

	// 38.get options select class in Drop-down
	public static void alloption(WebElement element) {
		Select s = new Select(element);
		List<WebElement> li = s.getOptions();
		for (int i = 0; i < li.size(); i++) {
			WebElement eachoption = li.get(i);
			String ss = eachoption.getText();
			System.out.println(ss);
		}
	}

	// 39.get all selected option in drop-down box also print in the console
	public static void optionAll(WebElement elements) {
		Select s = new Select(elements);
		List<WebElement> alloption = s.getAllSelectedOptions();
		for (WebElement eachoption : alloption) {
			String texts = eachoption.getText();
			System.out.println(texts);
		}
	}

	// 40.To get first selected option in drop-down
	public static void selectedFirstOption(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		System.out.println("First Selected Option = " + firstSelectedOption);
	}

	// 41.single Drop-down using De-select by index
	public static void deSelectIndx(WebElement reference, int index) {
		Select s = new Select(reference);
		s.deselectByIndex(index);
	}

	// 42.single Drop-down using De-select by value
	public static void deSelectValue(WebElement reference, String value) {
		Select s = new Select(reference);
		s.deselectByValue(value);
	}

	// 43.Single Drop-down using select by De-select visible text
	public static void desSelectVisible(String value, WebElement reference) {
		Select s = new Select(reference);
		s.selectByVisibleText(value);
	}

	// 44.De-select All in drop-down box
	public static void deSelectAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}

	// 45.Switch to frame by Frame id
	public static void frameId(String id) {
		driver.switchTo().frame(id);
	}

	// 46.Switch to frame by Frame name
	public static void frameName(String name) {
		driver.switchTo().frame(name);
	}

	// 47.Switch to frame by Frame WebElement
	public static void frameWebElement(String element) {
		driver.switchTo().frame(element);
	}

	// 48.switch to frame by using index
	public static void frameIndx(int index) {
		driver.switchTo().frame(index);
	}

	// 49.switch to frame2 to frame1
	public static void comeOutFrame() {
		driver.switchTo().parentFrame();
	}

	// 50.To switch any frame to main window
	public static void frametoMainWindow() {
		driver.switchTo().defaultContent();
	}

	// 51.To move to the one page to next page
	public static void forwardTab() {
		driver.navigate().forward();
	}

	// 52.To move to the current page to previous page
	public static void backwardTab() {
		driver.navigate().back();
	}

	// 53.To Refresh your page
	public static void refreshPage() {
		driver.navigate().refresh();
	}

	// 54.To Implicit wait applicable for the all Web-Element
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// 55 To Excel read
	public static String readExcel(int rowsCount, int rowsCells) throws IOException {
		File file = new File("C:\\Users\\moham\\eclipse-workspace\\Cucumber10.00Am\\ExcelSheet\\YousufAbubacker.xlsx");
		FileInputStream fin = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet("YousufAbubacker");
		Row r = s.getRow(rowsCount);
		Cell c = r.getCell(rowsCells);
		int type = c.getCellType();
		String value = "";
		if (type == 1) {
			value = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {
			Date d = c.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
			value = sim.format(d);
		} else {
			double dd = c.getNumericCellValue();
			long l = (long) dd;
			value = String.valueOf(l);
		}
		return value;
	}

	// 56.present the Date and Time
	public static void findSysDateTime() {
		Date d = new Date();
		System.out.println(d);
	}

	// 57.To write Excel
	public static void writeExcel(String name) throws IOException {
		File file = new File("C:\\Users\\moham\\eclipse-workspace\\MohamedYousuf\\ExcelSheet\\" + name + ".xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("KaderMohideen");
		Row r = s.createRow(0);
		Cell c = r.createCell(0);
		c.setCellValue("Afrin");
		FileOutputStream fout = new FileOutputStream(file);
		w.write(fout);
	}

}
