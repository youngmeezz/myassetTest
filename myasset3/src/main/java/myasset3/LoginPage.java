package myasset3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {
	private static final int AJAX_ELEMENT_TIMEOUT= 5;
	private final WebDriver driver;
	
	@FindBy(css="#id")
	private WebElement id;
	
	@FindBy(css="#pw")
	private WebElement pw;
	
	@FindBy(css=".btn_login")
	private WebElement login;
	
	@FindBy(css="button[class='btn_check']")
	private WebElement loginPG;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, AJAX_ELEMENT_TIMEOUT), this);
	}
	
	public void clickLogin(String id, String pw) {
		login.click();
		this.id.sendKeys(id);
		this.pw.sendKeys(pw);
		login.click();
	}
}

