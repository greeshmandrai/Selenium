package b;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.awt.Robot;  
import java.awt.event.KeyEvent; 
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.awt.AWTException;  
public class FireF extends ExcelRead
{
    public static void dMethod() throws AWTException {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
          WebDriver driver = new FirefoxDriver();
          WebDriverWait wait=new WebDriverWait(driver, 60);
          JavascriptExecutor js = (JavascriptExecutor) driver;     
          driver.get("http://localhost:9000/?baseApiUrl=https://localhost:8443&tenantIdentifier=default#/home");
          Robot robot = new Robot();
           try {
               Thread.sleep(10000);
           } catch (InterruptedException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
           WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uid")));
     username.sendKeys("conflux");
           
           //Type LastName in the LastName text box
           WebElement password= driver.findElement(By.id("pwd"));
           password.sendKeys("password");
          
           // Click on the Submit button
           WebElement submit= driver.findElement(By.id("login-button"));
           submit.click();
           System.out.println("Sign In Test Pass");  
           WebElement Clients1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/nav/div/div/ul[1]/li[1]/a")));
          Clients1.click(); 
          WebElement Clients2= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Clients')]")));
          Clients2.click();   
          WebElement createClient= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div/div/div/a")));
          createClient.click(); 
          WebElement office= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div/div/div/form/fieldset/div[1]/div[1]/div[1]/div/a/span")));
          robot.keyPress(KeyEvent.VK_ESCAPE);
          System.out.println("Values are being entered to create client");
          robot.keyPress(KeyEvent.VK_ESCAPE);
          office.click(); 
           try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       driver.findElement(By.xpath("//li[contains(.,'Head Office')]")).click();
       
       robot.keyPress(KeyEvent.VK_TAB);

       WebElement legalForm= driver.findElement(By.xpath("//*[@id=\"legalFormId\"]"));
       legalForm.click();
       WebElement person=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'PERSON')]")));
       person.click();
       robot.keyPress(KeyEvent.VK_TAB);
       
       WebElement name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"firstname\"]")));
    name.sendKeys("Data[0]"); 
       WebElement middle= driver.findElement(By.xpath("//*[@id=\"middlename\"]"));
       middle.sendKeys("Data[1]");
       WebElement last= driver.findElement(By.xpath("//*[@id=\"lastname\"]"));
       last.sendKeys("Data[2]");
       WebElement DOB=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dateofbirth\"]")));
       DOB.sendKeys("Data[3]");
       robot.keyPress(KeyEvent.VK_ENTER);
           WebElement ExternalId= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"externalId\"]")));
           ExternalId.sendKeys("Data[4]"); 
           
           Select gender = new Select(driver.findElement(By.id("genderId")));
           gender.selectByIndex(2); 
           Select MaritalStatus = new Select(driver.findElement(By.name("maritalStatus")));
           MaritalStatus.selectByVisibleText("Married"); 
           robot.keyPress(KeyEvent.VK_TAB);  
           
           WebElement MobileNumber= driver.findElement(By.xpath("//*[@id=\"mobileNo\"]"));
           MobileNumber.sendKeys("Data[5]");  
           WebElement EmailID= driver.findElement(By.name("email"));
           EmailID.sendKeys("bbcc@gmail.com");
           WebElement Active= driver.findElement(By.id("activeCheckbox"));
           Active.click();
           WebElement Activationdate=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"activationDate\"]")));
           Activationdate.sendKeys("");
           robot.keyPress(KeyEvent.VK_TAB); 
           robot.keyPress(KeyEvent.VK_TAB); 
           robot.keyPress(KeyEvent.VK_TAB); 
           robot.keyPress(KeyEvent.VK_ESCAPE);
           robot.keyPress(KeyEvent.VK_ESCAPE);
           robot.keyPress(KeyEvent.VK_DOWN);
           
           WebElement OpenSavingsaccount= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opensavingsproduct")));
           robot.keyPress(KeyEvent.VK_ESCAPE);             
           robot.keyPress(KeyEvent.VK_ESCAPE);     
           OpenSavingsaccount.click();
           js.executeScript("window.scrollBy(0,1000)");      
           Select SelectSavingsAccount = new Select(driver.findElement(By.id("savingsProductId")));
           SelectSavingsAccount.selectByVisibleText("Atyathi"); 
           robot.keyPress(KeyEvent.VK_TAB);  
           robot.keyPress(KeyEvent.VK_ESCAPE);
           robot.keyPress(KeyEvent.VK_ESCAPE);
           
     
           WebElement SubmitNconti=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"saveandcontinue\"]")));
           
           
           SubmitNconti.click();
         
           System.out.println("Client created");
          // driver.close();
       }
}
