package tests.calculatorpage;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import utils.BaseClass;
import utils.ExtentReportListener;
import pages.CalculatorPage;

public class ShipmentQuoteCalculator extends BaseClass {

    @Test(groups = {"Smoke"})
    public void verifyShipmentQuotes() throws InterruptedException {
        // Get the ExtentTest instance created by ExtentReportListener
        ExtentTest test = ExtentReportListener.test;

        CalculatorPage calculatorPage = new CalculatorPage(driver);

        calculatorPage.enterFromPostCode();
        calculatorPage.enterIndiaInToCountry();
        calculatorPage.enterWeight();
        calculatorPage.clickCalculate();
        calculatorPage.verifyQuotes(test);
    }
}
