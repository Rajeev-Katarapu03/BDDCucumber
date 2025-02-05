package Steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Reservation {
	WebDriver driver;
	JavascriptExecutor js;
	WebElement wb;
	@Given("user starts chrome browser")
	public void user_starts_browser() {
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
	}
	@And("user launch app using url {string}")
	public void user_launch_app(String url) {
	    driver.get(url);  // Launch the provided URL
	    driver.manage().window().maximize();  // Maximize the browser window
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));  // Set an implicit wait
	}

	@When("user enters text {string} in textbox using xpath {string}")
	public void user_enters_text(String text, String xpath) {
	    WebElement textbox = driver.findElement(By.xpath(xpath));
	    textbox.sendKeys(text);
	}
	@When("user clicks button using xpath {string}")
	public void user_clicks_button_using_xpath(String xpath) {
		
		driver.findElement(By.xpath(xpath)).click();
	   
	}
	@And("user selects location as {string}")
	public void user_selects_location(String location) {
	    new Select(driver.findElement(By.id("location"))).selectByVisibleText(location);
	}

	@And("user selects hotel as {string}")
	public void user_selects_hotel(String hotel) {
	    new Select(driver.findElement(By.id("hotels"))).selectByVisibleText(hotel);
	}

	@And("user selects roomType as {string}")
	public void user_selects_roomType(String roomType) {
	    new Select(driver.findElement(By.id("room_type"))).selectByVisibleText(roomType);
	}

	@And("user selects noOfRooms as {string}")
	public void user_selects_noOfRooms(String noOfRooms) {
	    new Select(driver.findElement(By.id("room_nos"))).selectByVisibleText(noOfRooms);
	}

	@And("user sets check-in-date as {string}")
	public void set_check_inDate(String checkindate) {
		js = (JavascriptExecutor) driver;
		WebElement checkInFeild = driver.findElement(By.id("datepick_in"));
		js.executeScript("arguments[0].value='"+checkindate+"';",checkInFeild);
		js.executeScript("arguments[0].dispatchEvent(new Event('change'));",checkInFeild);
	}
	 @And("user sets check-out date as {string}")
	    public void user_sets_check_out_date(String checkOutDate) {
	        WebElement checkOutField = driver.findElement(By.id("datepick_out"));
	        js.executeScript("arguments[0].value='" + checkOutDate + "';", checkOutField);
	        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", checkOutField);
	 }
	 @And("user selects adults per room as {string}")
	    public void user_selects_adults_per_room(String adults) {
	        new Select(driver.findElement(By.id("adult_room"))).selectByVisibleText(adults);
	    }
	 @And("user clicks submit button")
	    public void user_clicks_submit_button() {
	        driver.findElement(By.id("Submit")).click();
	    }
	 @Then("the error message {string} should be displayed")
	    public void the_error_message_should_be_displayed(String expectedErrorMessage) {
	        WebElement errorMessage = driver.findElement(By.xpath("//span[text()='" + expectedErrorMessage + "']"));
	        Assert.assertTrue("Error message is not displayed", errorMessage.isDisplayed());
	    }
	 @And("user closes browser")
	 public void user_closes_bowser() {
		 driver.quit();
	 }


	
	
}
