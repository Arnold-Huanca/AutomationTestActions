package newprojectautomationTest;

import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TestE {

    @Test
    public void Testing() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.collegeview.com/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("a[alt=\"SuperMatch\"] > img")).click();


        WebDriverWait w = new WebDriverWait(driver,15);
        driver.switchTo().frame("supermatch");

        WebElement e = w.until(ExpectedConditions.visibilityOfElementLocated(By.id("critHeader0")));
        new Actions(driver).click(e).build().perform();
        e = w.until(ExpectedConditions.elementToBeClickable(By.id("locationCriteriaClearButton")));
        new Actions(driver).click(e).build().perform();
        e = w.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Ohio')]/../..")));
        new Actions(driver).click(e).build().perform();

        e = w.until(ExpectedConditions.elementToBeClickable(By.id("critHeader1")));
        new Actions(driver).click(e).build().perform();
        e = w.until(ExpectedConditions.elementToBeClickable(By.id("degreeTypeRadio0")));
        new Actions(driver).click(e).build().perform();
        new Actions(driver).click(e).build().perform();
        new Actions(driver).sendKeys(e, Keys.ENTER).build().perform();
        e = w.until(ExpectedConditions.elementToBeClickable(By.id("majorSearchText")));
        new Actions(driver).sendKeys(e,"Computer Software Engineering").build().perform();
        e = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),' Computer Software Engineering')]/../..")));
        new Actions(driver).click(e).build().perform();

        String Univ = driver.findElement(By.cssSelector("#result1100738 > div.column.column3 > div.nameLogoBlock > a")).getText();
        String Porc = driver.findElement(By.xpath("//*[@id=\"result1100738\"]/div[1]/div/div")).getText();

        Assert.assertTrue(Univ.equals("Miami University-Oxford"));
        Assert.assertTrue(Porc.equals("100%"));


        //driver.close();
        // driver.quit();
    }

}

