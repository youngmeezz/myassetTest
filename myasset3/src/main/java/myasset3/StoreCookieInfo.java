package myasset3;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class StoreCookieInfo {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver",
        		"C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://new-m.pay.naver.com/savings/list/deposit");
    }

    @Test
    public void storeCookies() {

//        driver.findElement(By.id("email")).sendKeys("");
//        driver.findElement(By.id("pass")).sendKeys("");
//        driver.findElement(By.id("send2")).submit();

        File dataFile = new File("./target/browser.data");
        try {
            dataFile.delete();
            dataFile.createNewFile();
            FileWriter fos = new FileWriter(dataFile);
            BufferedWriter bos = new BufferedWriter(fos);
            for (Cookie ck : driver.manage().getCookies()) {
                bos.write((ck.getName() + ";" + ck.getValue() + ";" + ck.
                        getDomain()
                        + ";" + ck.getPath() + ";" + ck.getExpiry() + ";" + ck.
                        isSecure()));
                bos.newLine();
            }
            bos.flush();
            bos.close();
            fos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
