package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class StepDefinitions {

    public WebDriver driver;
    private WebDriverWait myWaitTime;

    @Before //Hooks
    public void beforeScenario(){

        // Set capability of IE driver to Ignore all zones browser protected mode settings.
        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        caps.setCapability("requireWindowFocus", true);

        InternetExplorerDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver(caps);

    }

    @After //Hooks
    public void afterScenario(){

        //Close the Browser
        driver.close();
        driver.quit();

    }

    @Given("I am on the Google homepage")
    public void iAmOnTheGoogleHomepage() {

        driver.manage().window().maximize();
        driver.navigate().to("http://www.google.nl");

        //Assert.assertTrue("Check if the Google logo is visible",
        //        driver.findElement(By.id("hplogo")).isDisplayed());

    }

    @When("I search for APG")
    public void iSearchForAPG() {

        //Add text and search
        driver.findElement(By.xpath("//input[@title='Zoeken']")).sendKeys("APG");
        driver.findElement(By.xpath("//input[@value='Google zoeken']")).click();

    }

    @Then("the APG website must be in the search results")
    public void theAPGWebsiteMustBeInTheSearchResults() {

        Assert.assertTrue("Check if the APG website is visible",
                driver.findElement(By.xpath("//SPAN[text()='APG - APG - Een goed inkomen voor nu, straks en later']")).isDisplayed());

    }

    @Then("the APG Wikipedia website must be in the search results")
    public void theAPGWikipediaWebsiteMustBeInTheSearchResults() {

        Assert.assertTrue("Check if the APG Wikipedia website is visible",
                driver.findElement(By.xpath("//SPAN[text()='APG - Wikipedia']")).isDisplayed());

    }

    @Then("the APG PPF website must be in the search results")
    public void theAPGPPFWebsiteMustBeInTheSearchResults() {

        Assert.assertTrue("Check if the APG PPF website is visible",
                driver.findElement(By.xpath("//SPAN[text()='PPF APG: Personeels Pensioen Fonds APG']")).isDisplayed());

       }

    @Then("the APG Google Maps details should be displayed in the search results")
    public void theAPGGoogleMapsDetailsShouldBeDisplayedInTheSearchResults() {

        Assert.assertTrue("Check if the APG Google Maps details are visible",
                driver.findElement(By.xpath("//SPAN[text()='Financiële instelling in Heerlen']")).isDisplayed());

    }

}
