package org.demo;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class OnlineBookStoreApplication {
	public WebDriver driver;
	@BeforeTest
	public void start() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.packtpub.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
	}
	@Test(priority=1)
	public void LoginFunctionality() throws Exception {
		driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Create Account']")).click();
		driver.findElement(By.xpath("//input[@id='inline-form-input-firstName']")).sendKeys("Sainavya");
		driver.findElement(By.xpath("//input[@id='inline-form-input-lastName']")).sendKeys("thadikala");
		driver.findElement(By.xpath("//input[@id='inline-form-input-username']")).sendKeys("sainavya264@gmail.com");
		driver.findElement(By.xpath("//input[@id='inline-form-input-password']")).sendKeys("Navyasai264");
		driver.findElement(By.xpath("//input[@id='inline-form-input-passwordConfirmation']")).sendKeys("Navyasai264");
		driver.findElement(By.xpath("//input[@id='notifyUserCheck']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Create Account']")).click();
		String expectedUrl="https://www.packtpub.com/register";
		
		String currentUrl=driver.getCurrentUrl();
		if(currentUrl.equals(expectedUrl)) {
			System.out.println("Register Successfully");
		}else {
			System.out.println("failed");
		}
		driver.findElement(By.xpath("//a[normalize-space()='sign in']")).click();
		driver.findElement(By.xpath("//input[@id='inline-form-input-username']")).sendKeys("sainavya264@gmail.com");
		driver.findElement(By.xpath("//input[@id='inline-form-input-password']")).sendKeys("Navyasai264");
		driver.findElement(By.xpath("//span[normalize-space()='sign in']")).click();
		String loginexpectedUrl="https://www.packtpub.com/login";
		String logincurrentUrl=driver.getCurrentUrl();
		if(logincurrentUrl.equals(loginexpectedUrl)) {
			System.out.println("Login Successfully");
		}else {
			System.out.println("failed");
		}
		driver.findElement(By.xpath("//div[@class='category-content-section ']//a[@class='view-all'][normalize-space()='View All']")).click();
		
	}

	@Test(priority=2)
	public void BookDetails() throws Exception{
		String title=driver.findElement(By.xpath("//div[@class='products-wrapper']//div[1]//a[2]//div[2]//div[1]")).getText().toString();
		System.out.println(title);
		String description=driver.findElement(By.xpath("//div[normalize-space()='This latest edition of the bestselling Packt series will give you a solid foundation to start building projects usi...']")).getText().toString();
		System.out.println(description);
		String Author=driver.findElement(By.xpath("//div[normalize-space()='By Mark J. Price']")).getText().toString();
		System.out.println(Author);
		String year=driver.findElement(By.xpath("//div[normalize-space()='Nov 2023']")).getText().toString();
		System.out.println(year);
		String actualprice=driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[5]/div[2]/div[1]/div[1]/a[3]/div[1]/div[2]/span[1]")).getText().toString();
		System.out.println(actualprice);
		String offerprice=driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[5]/div[2]/div[1]/div[1]/a[3]/div[1]/div[2]/span[2]")).getText().toString();
		System.out.println(offerprice);	
		
	}
	@Test(priority=3)
	public void AddToCart() throws Exception{
		driver.findElement(By.xpath("(//button[@class='cart-btn'][normalize-space()='Add to Cart'])[1]")).click();	
		
	}
	@Test(priority=4)
	public void removeitem() throws Exception{
		driver.findElement(By.xpath("(//button[@class='remove-btn'][normalize-space()='Remove'])[1]")).click();
		
	}
	@Test(priority=5)
	public void signout() throws Exception{
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/nav[1]/div[4]/a[3]")).click();
			
		
	}
	
	
		
		
	
	
	
	
	
	
	
	
	
	
	
    
    
}
    
    
    
	
		
		

		
		
		
		
		
		
		
		
	

