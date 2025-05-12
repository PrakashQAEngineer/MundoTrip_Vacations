import java.time.Duration;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MundoAllLink 
{
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.mundotrip.com/en-us");
		
		allLinks(driver);
		footerLinks(driver);
		travelWithUs(driver);
		
	}
	
	public static void allLinks(WebDriver driver)
	{
					List<WebElement> li = driver.findElements(By.tagName("a"));
					int link_size = li.size();
					System.out.println(link_size);
	}
	
	public static void footerLinks(WebDriver driver)
	{
		WebElement wb2 = driver.findElement(By.xpath("//div[@id = 'footerMenu']"));
		    List<WebElement> li = wb2.findElements(By.tagName("a"));
		    int foot_link = li.size();
		    System.out.println(foot_link);
	}
	
	public static void travelWithUs(WebDriver driver) throws InterruptedException
	{
		WebElement wb1 = driver.findElement(By.xpath("//div[@class = 'container']/div/div[2]"));
		      List <WebElement> li1 = wb1.findElements(By.tagName("a"));
		        int tr_wi_us = li1.size();
		        System.out.println("Links under Travel With Us section: "+tr_wi_us);
		        
		        for(int i=0;i<tr_wi_us;i++)
		        {
		        	String str = Keys.chord(Keys.CONTROL,Keys.ENTER);
		        	//Thread.sleep(2000);
		        	li1.get(i).sendKeys(str);
		        }
		        
		        Set<String> str = driver.getWindowHandles();
		        java.util.Iterator<String> it = str.iterator();
		        
		        while(it.hasNext())
		        {
		        	driver.switchTo().window(it.next());
		        	
		        	System.out.println(driver.getTitle());
		        }
		        
     }

}
