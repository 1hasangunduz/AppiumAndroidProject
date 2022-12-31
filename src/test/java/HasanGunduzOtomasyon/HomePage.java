package HasanGunduzOtomasyon;

import Base.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    String eMail = "hasangunduz1010@gmail.com"; //enum yapilabilir.
    public WebDriverWait wait;
    public AppiumDriver<MobileElement> driver;

    public BaseTest() {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }
   
    @AndroidFindBy(id = "com.faladdin.app:id/getStartedButton")
    WebElement btnExploreHomePage;


    @AndroidFindBy(id = "com.faladdin.app:id/social_graph")
    WebElement btnLoginWithSocialGraph;


    @AndroidFindBy(id = "com.faladdin.app:id/socialWelcomeSubmit")
    WebElement btnJoinForSocialArea;


    @AndroidFindBy(id = "com.faladdin.app:id/btnMail")
    WebElement btnEmail;


    @AndroidFindBy(id = "com.faladdin.app:id/editTextEmail")
    WebElement txtEmail;


    @AndroidFindBy(id = "com.faladdin.app:id/btnSend")
    WebElement btnSendMail;


    @BeforeTest
    public void setUp() {
        try {

            DesiredCapabilities cap;
            cap = new DesiredCapabilities();

            cap.setCapability("deviceName", "Pixel 4 API 29");
            cap.setCapability("platformName", "Android");
            cap.setCapability("udid", "emulator-5554");
            cap.setCapability("platformVersion", "10.0");
            cap.setCapability("appPackage", "com.faladdin.app");
            cap.setCapability("appActivity", "com.faladdin.app.ui.launcher.LauncherActivity");
            cap.setCapability("skipUnlock", "true");
            cap.setCapability("noReset", "false");

            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
            AppDriver.setDriver(driver);
           // wait = new WebDriverWait(driver, 5);
        } catch (MalformedURLException e) {
            System.out.println("Error while creating URL object");

        }
    }


    
    @Test
    public void loginTest() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("karsilama ekranindaki acildi..");

        btnExploreHomePage.click();
        System.out.println("karsilama ekranindaki: Explore butonuna tiklandi");

        btnLoginWithSocialGraph.click();
        System.out.println("Anasayafa'daki social tabına tiklandi");

        btnJoinForSocialArea.click();
        System.out.println("Join Now butonuna tiklandi");

        btnEmail.click();
        System.out.println("Email ile giris yapa tiklandi.");

        txtEmail.sendKeys(eMail);
        System.out.println("Mail adresi girildi.");

        btnSendMail.click();
        System.out.println("Mail adresi girip send butonuna basildi.");
    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}























