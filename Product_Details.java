import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Product_Details 
{
	public static void main(String args[]) throws InterruptedException
	{
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       
       //Open ing of the Mundo Trip
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
      
   // selecting the deal "Discover the Magic of Dubai & Abu Dhabi: A Luxury Tour Experience"
      
       List<WebElement> wb11 = driver.findElements(By.className("tour-detail"));
       for(WebElement li:wb11)
       {
    	   String hol = li.getText();
    	   if(hol.contains("Discover the Magic of Dubai & Abu Dhabi: A Luxury Tour Experience"))
    	   {
    		 // driver.findElement(By.xpath("//button[text() = 'View Deal']")).click();
    		   System.out.println(hol);  
    	   }
    	  // System.out.println(hol);
    	   
       }
	}

	
	
}
