package com.testautomatizado;



import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

//import java.util.HashMap;
//import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AgregarProductoAlCarrito {

		private WebDriver driver;
		//private Map<String, Object> vars;
		JavascriptExecutor js;
		EliminarProductoTest eliminar = new EliminarProductoTest();
		
	@Before
	  public void setUp() {
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		    driver = new ChromeDriver();
		    js = (JavascriptExecutor) driver;
		   // vars = new HashMap<String, Object>();
	  }
	
	@After
	  public void tearDown() {
	    eliminar.eliminarProducto();
		//driver.quit();
	  }
	
		
	
	  @Test
	  public void agregarProducto() {
	    driver.get("https://www.demoblaze.com/index.html");
	    driver.manage().window().maximize();
	    driver.findElement(By.linkText("Phones")).click();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.findElement(By.linkText("Samsung galaxy s6")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.linkText("Add to cart")).click();
	    
	    if (isAlertPresent()) {
	    	
	    	assertThat(driver.switchTo().alert().getText(), equalTo("Product added"));
	    	
	        driver.switchTo().alert();
	        driver.switchTo().alert().accept();
	        driver.switchTo().defaultContent();
	    }
	    
	    driver.findElement(By.id("cartur")).click();
	    
	  }
	  
	  
	 public boolean isAlertPresent() {
		    try {
		        driver.switchTo().alert();
		        return true;
		    } // try
		    catch (Exception e) {
		        return false;
		    } // catch
		}
	
}


