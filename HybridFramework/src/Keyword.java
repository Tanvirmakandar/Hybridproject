import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class Keyword 
{    
	   WebDriver driver;
	   
		public void LaunchURL(String Browser, String strURL) // LaunchURL method 
		{
		  if (Browser.equalsIgnoreCase("chrome")) // browser
		 {
			    System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\eclipse-workspace\\New\\target\\chromedriver.exe");
			   		
			   	driver = new ChromeDriver(); 
		 }
		
	   		
	   	      
	       if (Browser.equalsIgnoreCase("Firefox"))
	       {
	    	   System.setProperty("webdriver.gecko.driver","D:\\Automation\\Dependency\\geckodriver.exe");
	      		
	   		   driver = new FirefoxDriver();
	   		
	       }
	       
	       if (Browser.equalsIgnoreCase("IE"))
	       {
	    	   System.setProperty("webdriver.ie.driver","C:\\Users\\lenovo\\eclipse-workspace\\New\\target\\chromedriver.exe");
	      		
	   		   driver = new InternetExplorerDriver();
	   		
	        } 
	       
	       driver.get(strURL);   // open the URL
	       driver.manage().window().maximize(); // maximize the window
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // add implicitly wait
		}
		
		  
	        
	       public void EnterText(String Strobjname, String strXpath, String TestData) // EnterText method
	  		{
	  	 		driver.findElement(By.xpath(strXpath)).sendKeys(TestData); 
	  			
	  		}
	       public String EnterTextt(String Strobjname, String strXpath, String TestData) // EnterText method
	  		{
	  	 		String status = "False";
	  	 		try {
	  	 			driver.findElement(By.xpath(strXpath)).sendKeys(TestData);
	  	 			status = "True";
	  	 		}
	  	 		catch(Exception ex) {
	  	 			status = ex.getMessage();
	  	 		}
				return status;
	    	    
	  			
	  		}
	       
	  	/*	public void BtnClick(String objname, String strXpath) // BtnClick method
	  		{
	  			
	  		 driver.findElement(By.xpath(strXpath)).click();
	  			
	  		}
	    */
	  		public String BtnClickk(String objname, String strXpath) // BtnClick method
	  		{
	  			String status ="False";
	  			try {
	  		  		 driver.findElement(By.xpath(strXpath)).click();
                     status ="True";
	  			}
	  			catch(Exception ex)
	  			{
	  				status = ex.getMessage();
	  				System.out.println(status);
	  			}
	  			return status; 	
			}
	         
	  		
	  		public String linkClick( String objname,String strXpath )
	  		{
	  			String status ="False";
	  			try {
	  				driver.findElement(By.xpath(strXpath)).click();
	  				status="True";
	  			}
	  			catch(Exception ex)
	  			{
	  				status = ex.getMessage();
	  				System.out.println(status);
	  			}
	  			return status;
	  		}
	  	   
	  		public String Dropdown(String objname,String strXpath)
	  		{
	  			String status ="False";
	  			try {
	  				driver.findElement(By.xpath(strXpath)).click();
	  				
	  				status ="True";
	  			}
	  			catch(Exception ex)
	  			{
	  				status =ex.getMessage();
	  				System.out.println(status);
	  			}
	  			return status;
	  		}
	  		
	  		
	  		
	
	  		public String LaunchURLl(String Browser, String strURL) // LaunchURL method 
			{
	  			String status = "False";
	  			try {
	  				  if (Browser.equalsIgnoreCase("chrome")) // browser
	  				 {
	  					    System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\eclipse-workspace\\New\\target\\chromedriver.exe");
	  					   		
	  					   	driver = new ChromeDriver(); 
	  				 }
	  				
	  			   		
	  			   	      
	  			       if (Browser.equalsIgnoreCase("Firefox"))
	  			       {
	  			    	   System.setProperty("webdriver.gecko.driver","D:\\Automation\\Dependency\\geckodriver.exe");
	  			      		
	  			   		   driver = new FirefoxDriver();
	  			   		
	  			       }
	  			       
	  			       if (Browser.equalsIgnoreCase("IE"))
	  			       {
	  			    	   System.setProperty("webdriver.ie.driver","C:\\Users\\lenovo\\eclipse-workspace\\New\\target\\chromedriver.exe");
	  			      		
	  			   		   driver = new InternetExplorerDriver();
	  			   		
	  			        } 
	  			       
	  			       driver.get(strURL);   // open the URL
	  			       driver.manage().window().maximize(); // maximize the window
	  			       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // add implicitly wait
	  				
	  				
	                status ="True";
	  			} 
	  			catch (Exception ex)
	  			{
	  				status = ex.getMessage();
	  				System.out.println(status);
	  			}
				return status;
	  			
	  			
	  			
			 }
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

