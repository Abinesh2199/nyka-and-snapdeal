package Action;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//mouseover on brand
		WebElement Brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions men = new Actions(driver);
		men.moveToElement(Brands).perform();
		//click lorealparis
		driver.findElement(By.xpath("//img[@src='https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		//select sort
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("(//span[@class='title'])[4]")).click();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(3000);
		//click hair
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("(//div[@class='control-value'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(3000);
		//click concern
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		//print the mrp
		WebElement mrp = driver.findElement(By.xpath("//div[@class='css-1d0jf8e']"));
		String mrpshampoo = mrp.getText();
		System.out.println(mrpshampoo);
		//go to new window
		driver.findElement(By.xpath("//img[@class='css-11gn9r6']")).click();
		Set<String> newwindow = driver.getWindowHandles();
		List<String> openwindow = new ArrayList<String>(newwindow);
		String shampoo = openwindow.get(1);
		driver.switchTo().window(shampoo);
		//click on bag
		driver.findElement(By.xpath("(//button[@class=' css-12z4fj0'])[1]")).click();
		//click on cart
		driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
		//click the proceed
		WebElement proceedframe = driver.findElement(By.className("css-acpm4k"));
		driver.switchTo().frame(proceedframe);
		driver.findElement(By.xpath("//span[text()='Proceed']//ancestor::button")).click();
		//print the grand amount
		WebElement amount = driver.findElement(By.xpath("//span[text()='259']"));
		String grandamount = amount.getText();
		System.out.println(grandamount);
		//click on guest
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		driver.quit();
		    
	}

}

