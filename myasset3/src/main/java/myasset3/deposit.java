package myasset3;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class deposit{

	public WebDriver driver;
	String depositPage = "https://new-m.pay.naver.com/savings/list/deposit";

	
	@BeforeClass
	public void setUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		

        // 웹 사이트 접속
        driver.get(depositPage);

        // 쿠키 삭제
        driver.manage().deleteAllCookies();

        // 캐시 삭제
        driver.manage().deleteAllCookies();
        driver.navigate().refresh(); // 캐시를 삭제하기 위해 페이지를 새로고침

 
        Thread.sleep(5000);
		
	}

	
	
	//초기화 하는 함수 작성 필요 아니면 물어보기
//	public void clear() {
//		 
//			private int count;
//
//		    public MyTest() {
//		        super();
//		        count = 0;
//		    }
//	}
	
	
	/*
	 * 예적금 테스트 1
	 * 
	 */
	@Test(priority = 1, description = "예금 > 은행 선택 레이어 > 은행 전체 선택 동작 확인 (전체 은행사 미선택 상태) ")
	public void PC_SAVINGS_019() throws InterruptedException{	
			
			/**
			 * 
			 * 
			 *  1. 금융상품 > 예적금 > 예금 탭 진입 
				2. 금융사 필터 > [금융사 추가] 버튼 클릭
				3. 은행 선택 > 은행 목록 상단 "모든 은행 선택" 체크박스 클릭
				4. 은행 선택 > 은행 목록
			 * 
			 * 
			 * 
			 */
		
		
	
			WebElement bankFilter = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/button"));
			bankFilter.click();
			Thread.sleep(5000);
			
			
			WebElement allBankChecked = driver.findElement(By.xpath("//*[@id=\"companySelectLayerHeader_BA\"]/div/label")); 
			allBankChecked.click();
			Thread.sleep(5000);
			
			
			
			WebElement bankFilterPopupCheck = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[3]/button")); 
			bankFilterPopupCheck.click();
			Thread.sleep(5000);
			
		}
	
	
	/*
	 * 예적금 테스트 2
	 * 
	 */
	@Test(priority = 2, description = "예금 > 은행 선택 레이어 > 저축은행 전체 선택 동작 확인 (전체 저축 은행사 미선택 상태) ")
	public void PC_SAVINGS_020() throws InterruptedException{	
			
			/**
			 * 
			 * 
			 *  1. 금융상품 > 예적금 > 예금 탭 진입 
				2. 금융사 필터 > [금융사 추가] 버튼 클릭
				3. 은행 선택 > 저축은행 목록 상단 "모든 저축은행 선택" 체크박스 클릭
				4. 은행 선택 > 저축은행 목록 상단 "모든 저축은행 선택" 체크박스 클릭
			 * 
			 * 
			 * 
			 */
		
			//위에 선택한 내용 초기화 필요
	
			WebElement bankFilter = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/button"));
			bankFilter.click();
			Thread.sleep(5000);
			
			
			
			WebElement SaveBankChecked = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[1]/ul/li[2]/label")); 
			SaveBankChecked.click();
			Thread.sleep(5000);
			
			
			
			
			WebElement allSaveBankChecked = driver.findElement(By.xpath("//*[@id=\"companySelectLayerHeader_MB\"]/div/label")); 
			allSaveBankChecked.click();
			Thread.sleep(5000);
			
			
			
			WebElement bankFilterPopupCheck = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[3]/button")); 
			bankFilterPopupCheck.click();
			Thread.sleep(5000);
			
		}
	
	
	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
}

