import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Product_Details 
{
	public static void main(String args[]) throws InterruptedException
	{
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       
       
       homePage(driver);
       vacationListing(driver);
       detailsPage(driver);
       priceGrid(driver);
       enquireForm(driver);
       
	}
	
	public static void homePage(WebDriver driver) throws InterruptedException
	{
		//Opening of the Mundo Trip
	       driver.get("https://www.mundotrip.com/en-us");
	       
	     //click on the vacations
	       driver.findElement(By.xpath("//a[@rel = '#holidays']")).click();
	       
	       //select Dubai from the dropdown
	       Thread.sleep(3000);
	       WebElement wb1 = driver.findElement(By.xpath("//select[@id = 'destinationHoliday']"));
	       
	       Select sc = new Select(wb1);
	       sc.selectByVisibleText("Dubai");
	       
	       //click on the Chat Icon
	       Thread.sleep(3000);
	      driver.findElement(By.className("cc-chat-bubble")).click();
	      
	      //Month Selection
	      WebElement wb2 = driver.findElement(By.xpath("//select[@id = 'monthDropdown']"));
	      Select scc = new Select(wb2);
	      scc.selectByVisibleText("June'25");
	      
	      //select on Search Button
	      driver.findElement(By.id("searchHoliday")).click();
	      
	       
	}
	
	public static void vacationListing(WebDriver driver)
	{
		// selecting the deal "Discover the Magic of Dubai & Abu Dhabi: A Luxury Tour Experience"
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	       List<WebElement> wb11 = driver.findElements(By.className("holilist-content"));
	       //System.out.println(wb1.getSize());
	       for(int i=0; i<wb11.size();i++)
	       {
	    	   //System.out.println("value of i: "+i);
	    	   String hol = wb11.get(i).getText();
	    	   if(hol.contains("Discover the Magic of Dubai & Abu Dhabi: A Luxury Tour Experience"))
	    	   {
	    		 // Thread.sleep(5000);
	    		   
	    		   WebElement el = driver.findElements(By.xpath("//button[@type='submit']")).get(i);
	    		   Actions act = new Actions(driver);
	    		   act.moveToElement(el).click().perform();
	    		   break;
	    	   }
	    	   //System.out.println(hol);
	    	   
	       }
	}
	
	public static void detailsPage(WebDriver driver)
	{
		//click on Transfer
		driver.findElement(By.xpath("//span[@id = 'transferCount']")).click();
		
		//click on the Highlight and the Day 3 Itinerary
		//driver.findElement(By.xpath("//a[text() = 'Highlights']")).click();
		driver.findElement(By.xpath("//div[@id = 'day3'] ")).click();
		
		
	}
	
	public static void priceGrid(WebDriver driver) throws InterruptedException
	{
		// select the Airport of JFK and calander month should be August
		Thread.sleep(3000);
		WebElement wb1 = driver.findElement(By.xpath("//select[@id = 'flyingFrom']"));
		Select sc = new Select(wb1);
		sc.selectByValue("LAX: Los Angeles International Airport,Los Angeles,United States");
		
		Thread.sleep(3000);
		WebElement wb2 = driver.findElement(By.xpath("//select[@id = 'hdnDepartDateHolidayDetailed']"));
		Select sd = new Select(wb2);
		sd.selectByValue("aug-2025");
		
		//click on the Enquire Now Button
		driver.findElement(By.xpath("//a[text() = 'Enquire Now']")).click();
	}
	
	public static void enquireForm(WebDriver driver) throws InterruptedException
	{
		//filling the Enquire form
		String pax_name = "Prakash Singh Rajput";
		String pax_email = "prakash@moresandtechnologies.com";
		String pax_phone = "7978670045";
		
		driver.findElement(By.xpath("//input[@id = 'enquiryNameText']")).sendKeys(pax_name);
		driver.findElement(By.id("enquiryEmailText")).sendKeys(pax_email);
		
		Thread.sleep(3);
		//click on the country code and select India then Enter the Phone no
		driver.findElement(By.xpath("//div[@class = 'iti__flag-container']")).click();
		driver.findElement(By.xpath("//li[@data-dial-code = '91']")).click();
		driver.findElement(By.id("txtPhones")).sendKeys(pax_phone);
		
		Thread.sleep(2);
		//select the 5  Travelers from the dropdown
		WebElement wb3 = driver.findElement(By.xpath("//select[@id = 'travellers']"));
		Select se = new Select(wb3);
		se.selectByValue("5");
		
		//enter the message and click on check box for accept
		driver.findElement(By.xpath("//textarea[@type = 'textarea']")).sendKeys("Hi this is Prakash Singh Rajput from Phorfic");
		driver.findElement(By.id("marketing1")).click();
		
		//click on the Enquire Now button
		WebElement wb5 =  driver.findElement(By.xpath("//div[@id = 'btnEnquireSubmit']"));
		  wb5.click();
		  
		  System.out.println(wb5.isSelected());
		
			
		
	}	
}
