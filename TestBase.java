package com.java.selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	
	//static JavascriptExecutor js = (JavascriptExecutor) driver;

	@BeforeMethod
	public static void setup() {
		System.out.println("I'm in setup method");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//driver.get("https://www.google.com");
		
		//driver.findElement(By.id("APjFqb")).sendKeys("Hello World");
		//driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
		//driver.close();
		driver.get("https://fitpeo.com/");
		
		driver.findElement(By.linkText("Revenue Calculator")).click();
		
		driver.get("https://fitpeo.com/revenue-calculator");
		JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)");
			
			Actions actions = new Actions(driver);
		   
		   WebElement min_slider = driver.findElement(By.xpath("//input[@type='range']"));
		   int xwidth = min_slider.getSize().width;
		   
		   actions.dragAndDropBy(min_slider, xwidth*5, 0);
		   actions.build().perform();
		   
		  // WebElement checkbox =driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/div/div/div"));
				//checkbox.sendKeys("520",Keys.ENTER);
		   
		   
			/*
			 * // Actions action = new Actions(driver); // WebElement checkbox =
			 * driver.findElement(By.xpath(
			 * "/html/body/div[2]/div[1]/div[1]/div[2]/div/div/div/div")); // Actions
			 * action1 = action.moveToElement(checkbox).sendKeys("500"); //
			 * action1.build().perform();
			 */		   
		   
		    //System.out.println("default location of the slider :"+min_slider.getLocation());
			//actions.dragAndDropBy(min_slider, 900, 662).perform();//(735,662)
			//System.out.println("location of the slider after moving:"+min_slider.getLocation());
			
			//WebElement max_slider = driver.findElement(By.xpath("//span[@class='MuiSlider-rail css-3ndvyc']"));
		    //System.out.println("default :"+max_slider.getLocation());
		   // actions.dragAndDropBy(max_slider, -500, 662).perform();
		
		js.executeScript("window.scrollBy(0, 900)");
		
		
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/label/span[1]/input")).click();
		
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/label/span[1]/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[8]/label/span[1]/input")).click();
		

	}

}
