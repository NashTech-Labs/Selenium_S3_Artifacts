package stepDefintions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class  Steps {
    private static WebDriver driver;

    @Given("^I navigate to website$")
    public void iNavigateToWebsite() {
        initializeWebDriver();
        driver.get("https://www.flipkart.com");
    }

    @When("Navigate to Other website {string}")
    public void navigateToOtherWebsite(String url) {
        driver.navigate().to(url);
    }

    @Then("Title should be {string} of website")
    public void titleShouldBeOfWebsite(String arg0) {
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains(arg0));
    }

    private static void initializeWebDriver() {
        WebDriverManager.chromedriver().setup(); // Automatically manage ChromeDriver binaries
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Enable headless mode
        options.addArguments("--disable-gpu"); // Optional: Disables GPU acceleration

        driver = new ChromeDriver(options);
    }


    // Optionally, add a @After method to clean up after the test
    @io.cucumber.java.After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        new S3StorageUtil();

    }



}


