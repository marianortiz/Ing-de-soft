package com.testautomatizado;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EliminarProductoTest {
	
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	
	@Before
	  public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }
	
	@After
	  public void tearDown() {
	    driver.quit();
	  }
	
	@Test
	  public void eliminarProducto() {
	    driver.get("https://www.demoblaze.com/index.html");
	    driver.manage().window().maximize();
	    driver.findElement(By.id("cartur")).click();
	    driver.findElement(By.linkText("Delete")).click();
	  }

}
