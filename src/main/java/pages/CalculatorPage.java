package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class CalculatorPage {
	WebDriver driver = null;

	By fromPostCode = By.xpath("//input[@formcontrolname='postcodeFrom']");
	By toPostCode = By.xpath("//input[@formcontrolname='postcodeTo']");
	By toCountry = By.xpath("//input[@placeholder='Select country']");
	By selectIndia = By.xpath("//div[@role='listbox']");
	By weight = By.xpath("//input[@formcontrolname='itemWeight']");
	By Calculate = By.xpath("//a[@type=' button']");
	By quoteHeading = By.xpath("//h1[contains(text(),'Your Quote')]");
	By allQuoteSections = By.cssSelector("div.border-b.border-gray-300.ng-star-inserted");
	By serviceTypeSection = By.xpath(".//dt[contains(text(),'Service Type')]/following-sibling::dd");
	By featureSection = By.xpath(".//dt[contains(text(),'Features')]/following-sibling::dd");
	By feeSection = By.xpath(".//h3[contains(@class, 'text-2xl')]");
	By buttonBookNow = By.xpath(".//a[contains(text(),'Book Now')]");
	By calculatorSection = By.xpath("//div[@class='d-md-flex d-sm-block calculator-container max-w-7xl mx-auto mt-12 sm:space-x-3 px-6 sm:px-0 ng-untouched ng-pristine ng-invalid']"); 
	By quoteSection = By.xpath("//div[@class='mx-auto max-w-7xl px-4 py-16 sm:px-6 lg:px-8 lg:pb-24']");
	
	

	public CalculatorPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void gotoCalculatorSection() {
		WebElement element = driver.findElement(calculatorSection);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void enterIndiaInToCountry() {
		driver.findElement(toCountry).clear();
		driver.findElement(toCountry).sendKeys("India");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Wait until the element is visible
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(selectIndia));
		element.click();
		
	}
	
	public void enterFromPostCode() {
		driver.findElement(fromPostCode).sendKeys("35600");
		
	}
	
	public void enterWeight() {
		driver.findElement(weight).sendKeys("1");
		
	}
	
	public void clickCalculate() throws InterruptedException {
		driver.findElement(Calculate).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Wait until the element is visible
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(quoteHeading));
		element.click();
		
	}
	
	public void gotoQuoteSection() {
		WebElement element = driver.findElement(quoteSection);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	public void verifyQuotes(ExtentTest test) throws InterruptedException {
        // Verify the presence of the main heading "Your Quote"
        WebElement heading = driver.findElement(quoteHeading);
        Assert.assertTrue(heading.isDisplayed(), "Heading 'Your Quote' is not displayed.");
        test.pass("Heading 'Your Quote' is displayed.");

        // Locate all quote sections
        List<WebElement> quoteSections = driver.findElements(allQuoteSections);
        Assert.assertTrue(quoteSections.size() > 0, "No quotes are displayed.");
        test.pass("Quotes are displayed: " + quoteSections.size());

        for (WebElement quote : quoteSections) {
            // Verify Service Type
            WebElement serviceType = quote.findElement(serviceTypeSection);
            Assert.assertNotNull(serviceType, "Service Type is missing.");
            Assert.assertFalse(serviceType.getText().isEmpty(), "Service Type is empty.");
            test.pass("Service Type: " + serviceType.getText());

            // Verify Features
            WebElement featuresSection = quote.findElement(featureSection);
            List<WebElement> features = featuresSection.findElements(By.cssSelector(".features"));
            Assert.assertTrue(features.size() > 0, "Features are missing.");
            test.pass("Features found: ");
            for (WebElement feature : features) {
                test.pass("- " + feature.getText());
            }

            // Verify Fee
            WebElement fee = quote.findElement(feeSection);
            Assert.assertNotNull(fee, "Fee is missing.");
            Assert.assertFalse(fee.getText().isEmpty(), "Fee is empty.");
            test.pass("Fee: " + fee.getText());

            // Verify Book Now button
            WebElement bookNowButton = quote.findElement(buttonBookNow);
            Assert.assertNotNull(bookNowButton, "Book Now button is missing.");
            Assert.assertTrue(bookNowButton.isDisplayed(), "Book Now button is not displayed.");
            test.pass("Book Now button is present.");

            test.info("----------------------------");
        }
    }

}
