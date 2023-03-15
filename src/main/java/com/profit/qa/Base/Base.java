package com.profit.qa.Base;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v106.network.Network;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import com.google.common.base.Function;
import com.profit.qa.Settings.Pages.UserManagementSetting;

import com.profit.qa.pages.Page;
import com.profit.qa.pages.PageMenus;

public class Base extends Page {

	public Base(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	private static final Logger logger = Logger.getLogger(Base.class);
    Properties prop;
    String configPath ="src/main/java/com/profit/qa/Properties/config.properties";
    Page page = new Page(driver, wait); 




    public static WebElement findElement(By locator)
    {
    	try {
    		return waitForElementToBeRefreshed(driver, locator);
    	} catch (StaleElementReferenceException e) {
    	    driver.navigate().refresh();
    		waitForElementToBeRefreshed(driver, locator);
    	    return waitForElementToBeRefreshed(driver, locator);
    	} catch(NullPointerException e )
   	{
    		return null;

    	}
    }




    public static List<WebElement> findElements(By locator)
    {
    	try {
    		return driver.findElements(locator);
    	} catch (StaleElementReferenceException e) {
    	    driver.navigate().refresh();
    	    return driver.findElements(locator);
    	}
    }




    public static WebElement isElementAvailable(By locator)
    {
    	return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement isElementVisible(By locator)
    {
    	return wait.until(ExpectedConditions.visibilityOf(findElement(locator)));

    }



	/*
	 * public void elementSafe(By locator) {
	 * if(wait.until(ExpectedConditions.presenceOfElementLocated(locator))==true) {
	 *
	 * } }
	 */

	public void click(By locator) {


		waitForElementToBeRefreshed(driver, locator).click();

		}




	public  void clickFromListOfElement(By locator, int positionFromLast)
	{
		int attempts = 0;

		try {
		waitForElementPresence(locator, 30);
		List<WebElement> path =findElements(locator);
		path.get(path.size()-positionFromLast).click();
		}
		catch (StaleElementReferenceException e) {
			while (attempts < 2) {
			System.out.println("State Element Exception Trigger While try to click " + locator + "Times : " + attempts);
			findElement(locator).click();
			break;
			}
			}
			attempts++;

	}





	public void inputClick(By locator)
	{
		findElement(locator).click();
		findElement(locator).clear();
	}



public boolean hasAttribute(By locator, String attribute)
{
	WebElement element = findElement(locator);
	String hasAttribute = element.getAttribute("class");
	if(hasAttribute==null)
	{
		return null != null;
	}
	return true;
}


	public String getCurrentPageUrl(){

		return driver.getCurrentUrl();
	}



	public boolean isEnabled(By locator)
	{

		return findElement(locator).isEnabled();

	}






	public boolean isSelected(By locator)
	{
	return findElement(locator).isSelected();
	}





	public boolean isdisplayed(By locator)
	{
	return findElement(locator).isDisplayed();
	}



	public void clear(By locator) {
		findElement(locator).clear();
	}

	public void sendkeys(By locator, String enter) {
		findElement(locator).sendKeys(enter);
	}
	public void sendkeys(By locator, Keys enter) {
		findElement(locator).sendKeys(enter);
	}





	public String doGetText(By locator) {
		try {
		return waitForElementToBeRefreshed(driver, locator).getText();
		}catch(StaleElementReferenceException e)
		{
		    driver.navigate().refresh();
			return  waitForElementToBeRefreshed(driver, locator).getText();

		}
	}






	// Have to enhance these function with dynamic path type param
    // This function will allow you to choose the dropdown value
	public void selectdropdownoption(WebElement path, Integer index, String byvalue, String byvisibletext) {
		if (index != null)
		{
			System.out.println(index);
			((Select) path).selectByIndex(index);
		}
		else if (byvalue != null)
		{
			System.out.println(byvalue);
			((Select) path).selectByValue(byvalue);
		}
		else if (byvisibletext != null)
		{
			System.out.println(byvisibletext);
			((Select) path).selectByVisibleText(byvisibletext);
		}

	}

	// Function will wait for execution until the element present [ or ] get load
	public List<WebElement> waitForElementPresence(By locator, int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

	}



	public WebElement waitForElementToBeClickable(By locator, int value)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(value));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));

	}





	public WebElement waitForElementToBeVisible(By locator, int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}



	public static List<WebElement> handleStaleElement(By locator) throws InterruptedException {
		List<WebElement> elements = null;
		int maxRetries = 3;

		int retries = 0;

		boolean elementFound = false;

		while (!elementFound && retries < maxRetries) {
			try {
				elements = findElements(locator);
				elementFound = true;
			} catch (StaleElementReferenceException e) {
				retries++;
				Thread.sleep(500);
			} catch (NoSuchElementException e) {
				try {
					elements = findElements(locator);
					elementFound = true;
				} catch (StaleElementReferenceException e2) {
					retries++;
					Thread.sleep(500);
				}
			}
		}

		if (!elementFound) {
			throw new ElementNotInteractableException(" Check locator value has changed or not ");
		}

		return elements;
		}



	// this function will let you access any property files by passing path of the file
	public static Properties getPropertyAccess(String configPath) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream path = new FileInputStream(configPath);
		prop.load(path);
		return prop;
		}


	public static String getValueFromProperty(String configPath , String propertyName) throws IOException
	{
		Properties prop ;
		prop=getPropertyAccess(configPath);
		return prop.getProperty(propertyName);
	}



	// This function will let you update the value on property files by passing the path of the file
	public static void saveOnProperties(String configPath , String title, String value)throws IOException {
		FileInputStream in = new FileInputStream(configPath);
		Properties props = new Properties();
		props.load(in);
		in.close();

		FileOutputStream out = new FileOutputStream(configPath);
		props.setProperty(title, value);
		props.store(out, null);
		out.close();
	}








	/*
	 * ***************************** Read Email from Gmail ********************************
	 */

	public static String getEmail(String host, String storeType, String user, String password) throws Exception
	{
		String extactedPasswordFormUrl = "";
		Base base = new Base(driver, wait);
		Properties properties = new Properties();
		properties.put("mail.imap.host", host);
		properties.put("mail.imap.port", "993");
		properties.put("mail.imap.starttls.enable", "true");
		properties.put("mail.imap.ssl.trust", host);

		Session emailSession = Session.getDefaultInstance(properties);
		Store store = emailSession.getStore("imaps");
		store.connect(host, user, password);
		Folder inbox = store.getFolder("Inbox");
		inbox.open(Folder.READ_WRITE);

		Message[] messages = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
		System.out.println("messages.length---" + messages.length);

		for (Message m : messages) {
			m.setFlag(Flag.SEEN, true);
			if (m.getSubject() != null && m.getSubject().contains("Welcome to Profit.co")) {
				for (Message message : messages) {
					MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
					extactedPasswordFormUrl = extractURL(base.getTextFromMimeMultipart(mimeMultipart));
					// saveOnProperties("src/main/java/com/profit/qa/properties/config.properties" ,
					// "passwordPageUrl", extactedPasswordFormUrl.toString());
				}
			}
		}

		inbox.close(false);
		store.close();
		// System.out.println(extactedPasswordFormUrl);
		return extactedPasswordFormUrl;
	}

	/*
	 *
	 *
	 *
	 */

	public static String extractURL(String str)
    {
        List<String> list= new ArrayList<>();
//        String url;

        String regex= "\\b((?:https?|ftp|file):"
              + "//[-a-zA-Z0-9+&@#/%?="
              + "~_|!:, .;]*[-a-zA-Z0-9+"
              + "&@#/%=~_|])";

  	    Pattern p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);

        while (m.find()) { list.add(str.substring( m.start(0), m.end(0)));}
        if (list.size() == 0) { System.out.println("-1"); return "no URL present"; }
        for (String url : list) { return(url); }
		return "";
    }




	/*                                                                                                    /*
	 * 																									   *
	 * *****************************************************************************************************
	 * 																									   *
	 *                                                                                                     */




	private String getTextFromMessage(Message message) throws IOException, MessagingException {
	    String result = "";
	    if (message.isMimeType("text/plain")) { result = message.getContent().toString(); }
	    else if (message.isMimeType("multipart/*"))
	    { MimeMultipart mimeMultipart = (MimeMultipart) message.getContent(); result = getTextFromMimeMultipart(mimeMultipart); }
	    return result;
	}




	/*                                                                                                    /*
	 * 																									   *
	 * *****************************************************************************************************
	 * 																									   *
	 *                                                                                                     */





	public String getTextFromMimeMultipart(
	        MimeMultipart mimeMultipart) throws IOException, MessagingException {

	    int count = mimeMultipart.getCount();
	    if (count == 0) throw new MessagingException("Multipart with no body parts not supported.");
	    boolean multipartAlt = new ContentType(mimeMultipart.getContentType()).match("multipart/alternative");
	    if (multipartAlt)
	    return getTextFromBodyPart(mimeMultipart.getBodyPart(count - 1));
	    String result = "";
	    for (int i = 0; i < count; i++)
	    { BodyPart bodyPart = mimeMultipart.getBodyPart(i); result += getTextFromBodyPart(bodyPart);}
	    return result;
	}




	/*                                                                                                    /*
	 * 																									   *
	 * *****************************************************************************************************
 * 																									   *
	 *                                                                                                     */




	private String getTextFromBodyPart(BodyPart bodyPart) throws IOException, MessagingException
	{ String result = "";
	    if (bodyPart.isMimeType("text/plain")) { result = (String) bodyPart.getContent();}
	    else if (bodyPart.isMimeType("text/html"))
	    { String html = (String) bodyPart.getContent(); result = org.jsoup.Jsoup.parse(html).text();}
	    else if (bodyPart.getContent() instanceof MimeMultipart)
	    { result = getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());}
	    return result;
	}







/*                                                                                                    /*
 * 							It will return response code by getting the URL			      			   *
 * *****************************************************************************************************
 * 																									   *
 *                                                                                                     */


public static int getStatus(WebDriver driver, String url) throws Exception {
	HttpURLConnection connection = (HttpURLConnection)(new URL(url).openConnection());
    connection.setRequestMethod("HEAD");
    connection.setRequestProperty("User-Agent", url);
    connection.connect();
    int code = connection.getResponseCode();
    connection.disconnect();
    return code;
}

/*                                                                                                    /*
 * 							Method will navigate the user to login page     		      			   *
 * *****************************************************************************************************
 * 																									   *
 *                                                                                                     */


public void doLogin() throws InterruptedException, IOException
{

	By emailId = By.id("login_email");
	By password = By.name("password");
	By loginBtn = By.id("login_btn");

	inputClick(emailId);
	sendkeys(emailId, getValueFromProperty(configPath, "loginEmail"));
	inputClick(password);
	sendkeys(password, getValueFromProperty(configPath, "loginPassword"));
	click(loginBtn);
	Thread.sleep(10000);

}





public static void elementToBeClickable(By locator)
{
	wait.until(ExpectedConditions.elementToBeClickable(locator));
}


public void invisibilityOfElementLocated(By locator)
{
	wait.until((ExpectedConditions.invisibilityOfElementLocated(locator)));

}


public void expectedConditions( By locator , String type )
{

	switch(type)
	{
		 case "elementToBeClickable":
		 wait.until(ExpectedConditions.elementToBeClickable(locator));
		 break;

		 case "invisibilityOfElementLocated":
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

		 case "elementToBeSelected":
	     wait.until(ExpectedConditions.elementToBeSelected(locator));


	     default :
		 System.out.println("Check the type of the ExpectedCOnditions");
	}





	}

public static void getBrowserEntries()
{
	LogEntries logEntries = driver.manage().logs().get(LogType.PERFORMANCE);
	for (LogEntry entry : logEntries) {
	    System.out.println(entry.getMessage());
	}

}


public String getAttribute(By locator , String AttributeName)
{
    WebElement element = driver.findElement(locator);
	return element.getAttribute(AttributeName);
}



public void fileSizeFinder(String filePath) {
	File file = new File(filePath);
	long sizeInBytes = file.length();
	System.out.println("File size in bytes: " + sizeInBytes);
}
	

public void getAllAttributes(By locator)
{
	WebElement element = findElement(locator);

	Map<String, String> attributes = new HashMap<>();

	NamedNodeMap attributeNodes = ((Node) ((Select) element).getWrappedElement()).getAttributes();
	for (int i = 0; i < attributeNodes.getLength(); i++) {
	  Node attributeNode = attributeNodes.item(i);
	  String attributeName = attributeNode.getNodeName();
	  String attributeValue = attributeNode.getNodeValue();
	  attributes.put(attributeName, attributeValue);
	}
	for (Map.Entry<String, String> attribute : attributes.entrySet()) {
	  System.out.println(attribute.getKey() + ": " + attribute.getValue());
	}

}



public int randomNoGeneration(int limit) {
	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(limit);
	return randomInt;
}





/*
 * ************************** Handle Dropdown ****************************
 */


public void handledropdown(By locator , Select sel)
{
	WebElement dropdown = findElement(locator);
	Select select = new Select(dropdown);

}



public void Get_All_Dropdown_Value(By locator)
{
	WebElement dropdown = findElement(locator);
	Select select = new Select(dropdown);
	List<WebElement> options = select.getOptions();
	for (WebElement option : options) {
		if (option.getText().equals("Option 3")) {
			option.click();
			break;
		}
	}

}


/*
 * ************************* Scroll methods ************************************/


public void ScrollPage(By locator)
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", locator);
}





public static void ChromeGetNetworkTabData()
{
	DevTools devTool = ((HasDevTools) driver).getDevTools();
	devTool.createSession();
	devTool.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
	devTool.addListener(Network.responseReceived(), responseReceieved -> {
		System.out.println("Response Url => " + responseReceieved.getResponse().getUrl());
		System.out.println("Response Status => " + responseReceieved.getResponse().getStatus());

		System.out.println("Response Headers => " + responseReceieved.getResponse().getHeaders().toString());

		System.out.println("Response MIME Type => " + responseReceieved.getResponse().getMimeType().toString());

		System.out.println("----------------------------------------------------------------------------------");

	});

}


/*
 * public static String getNetworkresponse() { String result = ""; DevTools
 * devTools = ((HasDevTools) driver).getDevTools(); devTools.createSession();
 * devTools.send(Network.clearBrowserCache());
 * devTools.send(Network.setCacheDisabled(true));
 *
 * final RequestId[] requestIds = new RequestId[1];
 *
 * devTools.send(Network.enable(Optional.empty(), Optional.empty(),
 *  * Optional.of(100000000)));
 *
 * devTools.addListener(Network.responseReceived(), responseReceieved -> {
 * requestIds[0] = responseReceieved.getRequestId(); String url =
 * responseReceieved.getResponse().getUrl(); int status =
 * responseReceieved.getResponse().getStatus(); String type =
 * responseReceieved.getType().toJson(); String headers =
 * responseReceieved.getResponse().getHeaders().toString(); String responseBody
 * = devTools.send(Network.getResponseBody(requestIds[0])).getBody().toString();
 * result = responseBody;
 *
 * });
 *
 * return result; }
 */



/*
 * *********************************** Get URls from the page ***********************************************
 */

public static List<String> getSideMenuUrl(By homeMenuPath) throws Exception
{

	List<WebElement> links = handleStaleElement(homeMenuPath);
	List<String> urls = new ArrayList<>();

	for (WebElement link : links)
	{

		try
		{
			String url = link.getAttribute("href");
			if (url != null && !url.isEmpty() && url.contains("/app/ng/profit.jsp"))
			{
				urls.add(url);
			}
			} catch (StaleElementReferenceException e)
		{
			driver.navigate().refresh();
		}
	}
	System.out.println(urls);
	return urls;
}

/*
 * Below method will click all the menu on the website and fetch the url
 * according to the page
 */

public static List<String> checkAllPage(List<String> menuLink , By locator) throws Exception
{
	List<String> urls = new ArrayList<>();

	for (String eachelement : menuLink)
	{
		driver.get(eachelement);

		List<WebElement> links = handleStaleElement(locator);
		for (WebElement link : links)
		{
			try
			{
				String url = link.getAttribute("href");
				if (url != null && !url.isEmpty() && url.contains("/app/ng/profit.jsp") && !urls.contains(url))
				{
					System.out.println(url);
					urls.add(url);
				}
			} catch (StaleElementReferenceException e)
			{
				driver.navigate().refresh();
				System.out.println("Fetching Url......................");
			}
		}
	}
	System.out.println(urls.size());
	System.out.println(urls);
	return urls;
}

public static void fetchallurl(List<String> urls) throws Exception
{
	for (String extacted : urls)
	{
		driver.get(extacted);
		if(!(Base.getStatus(driver, extacted)==200))
		{
			System.out.println();
			System.out.println(" Page Failed :" + extacted);
			System.out.println();
		}
		else
		{
			System.out.println();
			System.out.println(extacted + " ..........Launched");
		}
			System.out.println();
	    }


}

public static void checkPageLoadingSpeed(String PageURL)
{
	long start = System.currentTimeMillis();
	driver.get(PageURL);
	long end = System.currentTimeMillis();
	long timeTaken = end - start;
	if (timeTaken > 5000)
	{
	    System.out.println("The page took too long to load.");
	}
}



public static void URLSplitter(List<String> urlString, String part) throws MalformedURLException {
	for (String foreach : urlString)
	{
		URL url = new URL(foreach);
		if (part == "protocol")   {  String protocol = url.getProtocol();System.out.println("Protocol: " + protocol);}
		else if (part == "host")  { String host = url.getHost(); System.out.println("Host: " + host);}
		else if (part == "path")  { String path = url.getPath(); System.out.println("Path: " + path);}
		else if (part == "query") { String query = url.getQuery();System.out.println("Query: " + query);}
	}
}



public boolean isUserLoggedIn()
{
List<WebElement> UserSetting = findElements(UserManagementSetting.openUserMenu);
	if (UserSetting.isEmpty())
	{
		return true;
	} else
	{
		findElement(UserManagementSetting.openUserMenu).click();
		if (!findElement(By.xpath("//apptivo-app-header//ul//li//a[@href=\"/app/logout\"]")).isDisplayed())
		{
			return true;
		} else return false;
	}
}





public void getData()
{
	ChromeDriver driver = new ChromeDriver();
	driver.executeScript("console.log('Opening DevTools...');");
	Object response = driver.executeScript("return window.fetch('https://stag-app.profitokr.net/app/dao/employee?a=canCreateUser')"
	                      + ".then(response => response.json())"
	                      + ".then(json => json);");

	System.out.println(response);

}


public void hover(By locator)
{
	  WebElement element = driver.findElement(locator);
      Actions actions = new Actions(driver);
      actions.moveToElement(element).build().perform();

}

public void hoverAndClick(By hoverLocator , By clickLocator)
{
	Actions actions = new Actions(driver);
	WebElement elementToHover = findElement(hoverLocator);
	actions.moveToElement(elementToHover).perform();
	WebElement linkToClick = findElement(clickLocator);
	linkToClick.click();
}

public boolean getWebElementAttribute(By locator , String Attribute , String attributeValue)
{
	return findElement(locator).getAttribute(Attribute).contains(attributeValue);

}



public static String getGetConsoleError(ITestResult result)
{
	String finalout = null;
	LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
	for (org.openqa.selenium.logging.LogEntry entry : logEntries) {
		if (entry.getLevel().equals(Level.SEVERE)) {

			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("console Error---->" +entry.getMessage().toString());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

			finalout =entry.getMessage().toString();
		}
	}
	return finalout;

}






public static WebElement waitForElementToBeRefreshed(WebDriver driver, final By locator) {
    WebElement element = null;
    try {
        element = wait.ignoring(StaleElementReferenceException.class).until(new Function<WebDriver, WebElement>()
        {
                @Override
				public WebElement apply(WebDriver driver)
                {
                	elementToBeClickable(locator);
                    return driver.findElement(locator);
                }
         });
    } catch (Exception e) {
        System.out.println("Element could not be found: " + e.getMessage());
    }
    return element;
}



public static void checkPageLoading() throws InterruptedException
{
	long start = System.currentTimeMillis();
	driver.navigate().to(driver.getCurrentUrl());
	long end = System.currentTimeMillis();
	long loadTime = end - start;
	System.out.println("Load time: " + loadTime + "ms");
if (loadTime < 3000) {
		  Thread.sleep(3000 - loadTime);
		}
}

private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isAlertPresent() {
    try {
      driver.switchTo().alert().accept();
      
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public String closeAlertAndGetItsText(Boolean acceptNextAlert) {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  
  
  
  // Will check the Internet speed when load the url 
//  public long checkInternetSpeedOnMachine(String URL) throws IOException
//	{
//		URL url = new URL(URL);
//		URLConnection connection = url.openConnection();
//		connection.connect();
//
//		InputStream inputStream = connection.getInputStream();
//		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//
//		long startTime = System.currentTimeMillis();
//
//		int nRead;
//		byte[] data = new byte[16384];
//		while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
//			buffer.write(data, 0, nRead);
//		}
//
//		buffer.flush();
//		byte[] bytes = buffer.toByteArray();
//		int fileSizeInBytes = bytes.length;
//		long endTime = System.currentTimeMillis();
//
//		long elapsedTime = endTime - startTime;
//		double elapsedTimeInSeconds = (double) elapsedTime / 1000;
//		double downloadSpeed = fileSizeInBytes / elapsedTimeInSeconds;
//
//		return StorageConverter.bytesToKilobytes(fileSizeInBytes);
//	}
//  
  
  
  public String getFileName(String filePath)
	{
		File file = new File(filePath);
		String fileName = file.getName();
		System.out.println("File name: " + fileName);
		return fileName;

	}
  
  
  public boolean waitUntilExpectedAttributepresent(By locator , String Attribute , String compareAttribute)
{
		Wait<WebDriver> Await = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		WebElement element = driver.findElement(locator);
		return Await.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return element.getAttribute(Attribute).contains(compareAttribute);
			}
		});
	}
  
  
 public File randomFileGenerator(String format)
	{
		String fileName = "random-image-" + System.currentTimeMillis() + "."+format;
		File file = new File(fileName);
		return file;
	}

  /*
   *                | Have  Bug Need to Be Fixed |                     
   */
  public void enableAllModule() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
  {
	  page.getInstance(PageMenus.class).enableSettingMenu();
	  page.getInstance(PageMenus.class).checkModulesPageSetting();
	  By allToggle =By.xpath("//div//input");
	  By clickXpath= By.xpath("//div//span[@class=\"slider round\"]");
	  List<WebElement> path = driver.findElements(allToggle);
	  List<WebElement> clickPath = driver.findElements(clickXpath);
	  System.out.println(clickPath.size());
	  {
	  for(int j=0 ; j<path.size() ; j++)
		{
			if (!path.get(j).isSelected()) 
			{
				clickPath.get(j-1).click();
			}
		}
  }
  }  
  
  /*
   *  @Parent Method -> 
   *  @Purpose : Will allow the user to navigate from super user to some other user 
   *  
   *  @Params 
   *  ( 
   *  type :{ username , email } 
   *  configPath:{ one of the value from properties file }
   *  )
   *
   */
  public void switchUser(String type ,String configValue) throws IOException
	{
		By openUserMenu = By.xpath("//apptivo-app-header//li/a[@id=\"userSettings\"]");
		By openSwitchUser = By
				.xpath("//apptivo-app-header//ul//div/a[@role=\"button\" and contains(text(),'Switch User')]");
		click(openUserMenu);
		click(openSwitchUser);
		switchUserXpathGenerator(type, configPath).click();
		wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
		
	}
  
  
  /* 
   * @ Support method : ->
   * @ Parent Method : switchUser()
   * @ Purpose : it will generate the xpath based on the given type
   */
	public static WebElement switchUserXpathGenerator(String type , String Value) throws IOException 
	{
		WebElement locator = null;
		if (type.toLowerCase() == "username") {
			By elementPath = By.xpath("//div[@role=\"document\"]//ul/a/div//h5[contains(text(),'" + Value + "')]");
			locator = driver.findElement(elementPath);
		} else if (type.toLowerCase() == "email") {
			By elementPath = By.xpath("//div[@role=\"document\"]//p[normalize-space()='"+ Value +"']");
			locator = driver.findElement(elementPath);  
		}else
		{
			System.out.println("Check \"type\" name that you have been passed :switchUserXpathGenerator ");
		}
		return locator;

	}

	
  
	public void enableToggle(By Span_Path , By InputPath)
	{
		if (!driver.findElement(InputPath).isSelected()) {
			System.out.println(" Toggle is Already Selected ");
		} else if (driver.findElement(InputPath).isSelected()) {
			click(Span_Path);
		}
	}
	
	
	public void disableToggle(By Span_Path , By InputPath)
	{
		if (!driver.findElement(InputPath).isSelected()) {
			System.out.println(" Toggle is Already Disabled ");

		} else if (driver.findElement(InputPath).isSelected()) {
			click(Span_Path);

		}
	}
	
	
	public void WaitPageUntilLoadingDone()
	{
		WebElement loading = driver.findElement(By.xpath("//div[@class=\"spinnotr\"]"));
		wait.until(ExpectedConditions.invisibilityOf(loading));
	}




	
}
