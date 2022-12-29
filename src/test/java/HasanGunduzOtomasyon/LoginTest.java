package HasanGunduzOtomasyon;

import Base.AppDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Deneme extends BaseTests {



    //TODO : mail adresi icin confirmation tanımlaması yapilmasi lazim.(maile gelen login olma islemi icin.)
    @Test
    public void loginTest() {
        setUp();

        System.out.println("karsilama ekranindaki acildi..");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        HomePage homePage = new HomePage();
        homePage.clickExploreHomePage();

        homePage.btnLoginWithSocialGraph.click();
        System.out.println("Anasayafa'daki social tabına tiklandi");

        homePage.btnJoinForSocialArea.click();
        System.out.println("Join Now butonuna tiklandi");

        homePage.btnEmail.click();
        System.out.println("Email ile giris yapa tiklandi.");

        homePage.txtEmail.sendKeys(homePage.eMail);
        System.out.println("Mail adresi girildi.");

        homePage.btnSendMail.click();
        System.out.println("Mail adresi girip send butonuna basildi.");
    }


    @AfterMethod
    public void teardown() {
        AppDriver.getDriver().quit();
    }
}
