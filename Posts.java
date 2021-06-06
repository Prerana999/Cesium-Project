package Automation;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Posts {
	public static void main(String[] args) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
	
		//Navigate to the url
		driver.get("http://localhost:3001/");
		
		//maximize the window
		driver.manage().window().maximize();
		
		
		//Retrieving the page title
		String title = driver.getTitle();
		System.out.println("The page title is:" +title);
		
		
		//Adding new post
		WebElement postTitle = driver.findElement(By.xpath("//*[@id='postTitle']"));
		postTitle.sendKeys("Today is a good day");
		System.out.println("Title added successfully");
		
		//Using Select class for selecting value from dropdown
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='postAuthor']")));
		dropdown.selectByIndex(0);
				
		WebElement postContent = driver.findElement(By.xpath("//*[@id='postContent']"));
		postContent.sendKeys("Today is a good day to start something fresh");
		System.out.println("Content added successfully");
		
		WebElement button1 = driver.findElement(By.xpath("//*[@type='button']"));
		button1.click();
		System.out.println("Post added successfully");
		
		Thread.sleep(3000);
		
		//Navigate to Users Tab
		
		WebElement userLink = driver.findElement(By.linkText("Users"));
		userLink.click();
		String actualUrl="http://localhost:3001/users"; 
		String expectedUrl= driver.getCurrentUrl(); 
		Assert.assertEquals(expectedUrl,actualUrl);
		if(actualUrl.equalsIgnoreCase(expectedUrl)) 
		{ 
			  System.out.println("Navigate to User tab successful"); 
	
		} else 
		
		{ 
			System.out.println("Navigate to User tab was not successful"); 
		} 
		
		
		Thread.sleep(3000);
		
		//Navigate to each author's link
		WebElement userLink1 = driver.findElement(By.linkText("Mr. Zola Gutkowski"));
		userLink1.click();
		Thread.sleep(3000);
		
		WebElement UsersLink = driver.findElement(By.linkText("They were lost without the dazzling fly that composed their owl?"));
		UsersLink.click();
		Thread.sleep(3000);
		
		//Navigate to Notification Tab
		WebElement notiLink = driver.findElement(By.linkText("Notifications"));
		notiLink.click();
		String actualUrl1="http://localhost:3001/notifications";
		String expectedUrl1= driver.getCurrentUrl(); 
		Assert.assertEquals(expectedUrl1,actualUrl1);
		if(actualUrl1.equalsIgnoreCase(expectedUrl1)) 
		{ 
			  System.out.println("Navigate Successful"); 
	
		} else 
		
		{ 
			System.out.println("Navigate not successful"); 
		} 
		
		//Refresh Notification functionality
		WebElement nButton = driver.findElement(By.className("button"));
		nButton.click();
		System.out.println("Refresh Notification Successful");
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
