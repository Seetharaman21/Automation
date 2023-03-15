package com.profit.qa.pages;

import java.io.IOException;
import java.time.Duration;
import java.time.Year;
import java.util.Properties;
import java.util.concurrent.CyclicBarrier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.profit.qa.Base.Base;
import com.profit.qa.StaticDatas.StaticData;

public class SignupPage extends Base {

	public SignupPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
		
	
    Year thisYear = Year.now();
    StaticData staticdata = new StaticData();
    Base base;
    CyclicBarrier barrier = new CyclicBarrier(3);



	/*
	 * ************************* Signup Basic form locators ****************************
	 */
	By signupPage = By.xpath("//h1[contains(text(),'Sign Up')]");
	By firstName = By.xpath("//input[@id='sign_up_firstname']");
	By firstNameWarning = By.xpath("//span[@id='fname_error']");
	By lastName = By.xpath("//input[@id='sign_up_lastname']");
	By lastNameWarning = By.xpath("//span[@id='lname_error']");

	By email= By.xpath("//input[@id='login_email']");
	By emailWarning = By.xpath("//span[@id='email_error']");
	By signupBtn = By.xpath("//input[@id=\"sign_up_button\" or@value=\"Sign Up\" or @type=\"submit\"]");
	By checkBox = By.xpath("//input[@id='notification_control_input']");



	/*
	 * ************************* Password page form locators ****************************
	 */
	By passwordPage = By.xpath("//h1[contains(text(),'Create your Password')]");
	By password = By.xpath("//input[@id='reset_password'or@name='password'or@id='reset_password']");
	By confirmPassword = By.xpath("//input[@id='reset_confirm_password']");
	By hidePassword = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[6]/a[1]/i[1]/img[1]");
	By passwordBtn = By.xpath("//button[@id='button-id']");
	By passwordEmptywarning = By.xpath("//span[@id='pass_error']");
	By confirmPasswordEmptywarning = By.xpath("//span[@id='confirmpassword_error']");
	By accountAlreadyCreated = By.xpath("//p[contains(text(),' ')]"); // Not used ]
	By accountAlreadyCreatedPageSignInBtn = By.xpath("//a[contains(text(),'Sign In')]");



	/*
	 * ********************** Business Detail Page form locators **************************
	 */
	By bussinessPage = By.xpath("//h4[contains(text(),'Just one click away from creating your first OKR..')]");
	By bussinessName = By.xpath("//input[@id='businessname']");
	By bussinessNameWarning = By.xpath("//span[@id='bname_error']");
	By phoneNumber = By.xpath("//input[@id='phone']");
	By signupbtn = By.xpath("//input[@id='apptivo_casesform']");
	By firmCreationCheck = By.xpath("//h2[contains(text(),'Your application is being installed, please wait..')]"); // Not Used






	/*
	 *  ************************* Signup page methods ****************************************
	 */



	/*
	 * *************************  Basic Form  *************************************************
	 */

	public String signupPageLoad() {

		return doGetText(signupPage);
	}






	public String checkfirstNameEmptyvalidation() {

		click(signupBtn);
		return doGetText(firstNameWarning);
	}





	public String checkSecondNameEmptyvalidation() {

		click(signupBtn);
		return doGetText(lastNameWarning);
	}






	public String checkEmailEmptyvalidation() {

		click(signupBtn);
		return doGetText(emailWarning);
	}






	public String checkInvalidEmailvalidation(String fname , String lname , String emailP) {

		sendkeys(firstName, fname);
		sendkeys(lastName, lname);
		sendkeys(email, emailP);
		click(signupBtn);
		return doGetText(emailWarning);
	}






	public void doSignupBasic(String fname , String lname , String emailP) throws InterruptedException, IOException {

		inputClick(firstName);
		sendkeys(firstName, fname);
		inputClick(lastName);
		sendkeys(lastName, lname);
		inputClick(email);
		sendkeys(email, emailP);
		//Select dataCenter = new Select(driver.findElement(By.xpath("//select[@id='regions']"))); // visible text = United States
		//dataCenter.selectByVisibleText("Europe");
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		click(signupBtn);

		Thread.sleep(10000);

	}




	/*
	 * *************************  Password Form  *************************************************
	 */

	public String checkPasswordPageLoad() throws Exception {

	 String url;
     Properties prop;
     prop=getPropertyAccess("src/main/java/com/profit/qa/properties/email.properties");
     Thread.sleep(3000);
     url= Base.getEmail(prop.getProperty("host"),prop.getProperty("mailStoreType"),prop.getProperty("username"),prop.getProperty("password"));
     Thread.sleep(3000);
     System.out.println(url);
     driver.get(url);
     Thread.sleep(3000);
     return doGetText(passwordPage);
	}





	public String checkForgotPasswordPageLoading() {

		return null;
	}






	public String checkForgotEmail() {

		return null;
	}






	public String checkAlreadyCreatedAccountEmail() {
		return null;
	}






	public String checkEmptyPasswordValidation() throws InterruptedException {

		click(passwordBtn);
		Thread.sleep(3000);
	    return doGetText(passwordEmptywarning);
	}






	public String CheckConfirmPasswordEmptyValidation() throws InterruptedException {

		click(passwordBtn);
		Thread.sleep(3000);
	    return doGetText(confirmPasswordEmptywarning);
	}






	/*
	 * public String checkInvalidPasswordValidation(String invalidPassword) {
	 * click(password); sendkeys(password, invalidPassword); click(passwordBtn);
	 * return dogettext(passwordEmptywarning);
	 *
	 * }
	 */






	public String checkPasswordMismatchValidation(String passwordP  , String confirmPasswordP) throws InterruptedException {

		Thread.sleep(3000);
		driver.navigate().refresh();
		sendkeys(password, passwordP);
     	sendkeys(confirmPassword, confirmPasswordP);
		click(passwordBtn);
	    return doGetText(passwordEmptywarning);
	}






	public void doSignupPassword(String validPassword) throws InterruptedException {

		sendkeys(password, validPassword);
		sendkeys(confirmPassword, validPassword);
		click(passwordBtn);
		Thread.sleep(5000);
	}



	/*
	 * ****************************** Business form ************************************************
	 */
	public String checkBusinessPageLoading() {
		driver.get("https://stag-app.profitokr.net/app/p-welcome.jsp");
		return doGetText(bussinessPage);
	}






	public String checkBusinessNameEmptyValidation(){
		click(signupbtn);
		return doGetText(bussinessNameWarning);
	}






	public void doSignupBusiness(String businessNameP , String phonenumberP) throws InterruptedException{
		By clickCountry = By.xpath("//select//option[@value=\"US_176\" and contains(text(),'United States')]");
		Select selectTimeZone = new Select(driver.findElement(By.xpath("//div//select[@id='timezone']")));
		Select selectNoOfUser = new Select(driver.findElement(By.xpath("//div//select[@id='num_users']")));
		Select selectMonth = new Select(driver.findElement(By.xpath("//div//select[@id='fymonth']")));
		Select selectYear = new Select(driver.findElement(By.xpath("//div//select[@id='fyyear']")));

		inputClick(bussinessName);
        sendkeys(bussinessName,businessNameP );
        click(clickCountry);
		Thread.sleep(2000);

		sendkeys(phoneNumber , phonenumberP);
		selectTimeZone.selectByVisibleText("(GMT -5.0) Eastern Time - America/New_York");
		selectNoOfUser.selectByVisibleText("51-100");
		selectMonth.selectByVisibleText("August");
		selectYear.selectByVisibleText(thisYear.toString());
		click(signupbtn);
	}
}


