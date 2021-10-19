package week2.day1.oct9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchApplication 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click(); 
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("MyCompany");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Test");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Check");

		WebElement dataSource= driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dropDown = new Select(dataSource);
		dropDown.selectByVisibleText("Direct Mail");

		WebElement industry=driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select dropDown1= new Select(industry);
		dropDown1.selectByIndex(7);
		driver.findElement(By.id("createLeadForm_marketingCampaignId")).sendKeys("Affiliate Sites");

		WebElement ownership=driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select dropDown2= new Select(ownership);
		dropDown2.selectByValue("OWN_PARTNERSHIP");

		
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("10/12/94");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9487587458");
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		WebElement Title=driver.findElement(By.id("sectionHeaderTitle_leads"));
		if(Title.isDisplayed()) 
		{
			System.out.println("The page is correct");
		}
		else
		{
			System.out.println("The page is Incorrect");
		}
		
		Thread.sleep(2000);
		driver.close();
	}
	
	}

