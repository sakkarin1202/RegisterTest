import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class TestTextFieldStatus {

	@Disabled
	void testRegisterForm() {
		WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.coding-midcareer.com/register");
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");
        
        Boolean depTelIsEnabled = driver.findElement(By.name("dep_tel")).isEnabled();
        assertTrue(depTelIsEnabled);
        
        Boolean receiptNameIsEnabled = driver.findElement(By.name("receipt_name")).isEnabled();
        assertFalse(receiptNameIsEnabled);
        
//        WebElement firstNameInput = driver.findElement(By.id("firstname"));
//        WebElement lastNameInput = driver.findElement(By.id("lastname"));
//        WebElement ageInput = driver.findElement(By.id("age"));
//        WebElement submitButton = driver.findElement(By.id("sub"));
//        firstNameInput.sendKeys("johnjohn");
//        lastNameInput.sendKeys("canonc");
//        ageInput.sendKeys("2");
//        
//        submitButton.click();
//        
//        String result = driver.findElement(By.id("firstname")).getText();
//        assertEquals("johnjohn", result);
//        driver.close();
	}
	
	@Test
	void testButton() throws InterruptedException {
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://mflowthai.com/mflow/consent");
        
        Boolean confirmButtonIsEnabled = driver.findElement(By.id("confirmModalButton")).isEnabled();
        assertFalse(confirmButtonIsEnabled);
        
        // Click Check_box
        WebElement chk0 = driver.findElement(By.id("0"));
        WebElement chk1 = driver.findElement(By.id("1"));
        WebElement chk2 = driver.findElement(By.id("2"));
        WebElement chk3 = driver.findElement(By.id("3"));
        chk0.click();
        chk1.click();
        chk2.click();
        chk3.click();
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        
        Boolean confirmButtonAfterScrollIsEnabled = driver.findElement(By.id("confirmModalButton")).isEnabled();
        assertTrue(confirmButtonAfterScrollIsEnabled);
        driver.findElement(By.id("confirmModalButton")).click();
        
        Thread.sleep(3000);
        Boolean confirmButtonAfterClickIsEnabled = driver.findElement(By.id("confirmModalButton")).isEnabled();
        assertFalse(confirmButtonAfterClickIsEnabled);
	}
}





