package com.profit.qa.testpages;

import java.lang.reflect.InvocationTargetException;

import org.testng.annotations.Test;

import com.profit.qa.basetest.SignupTestBase;
import com.profit.qa.pages.GoogleSSO;

public class GoogleSSOTest extends SignupTestBase {



	@Test
	public void checkGoogleSSOLogin() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		page.getInstance(GoogleSSO.class).doGoogleLogin();
	}

}
