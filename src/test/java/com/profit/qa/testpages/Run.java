package com.profit.qa.testpages;

import org.testng.TestNG;

public class Run {

//  This Class will be only used for to run this testNG Script file as runnable jar file

	/*
	 * Right click on project on [ Eclipse ]
	 * Click Export
	 * Choose java and select Runnable jar file
	 * Click next
	 * Choose Run-profit class as " Launch Configuration"
	 * Now choose the folder to be download on and hit finish button
	 * Open terminal and go the folder
	 * Run the jar file like [ java -jar profit.jar ]
	 */


	public static void main(String[] args) {
        TestNG testng = new TestNG();
         Class[] classes = new Class[]{LoginPageTest.class};
         testng.setTestClasses(classes);
         testng.run();
}
}

