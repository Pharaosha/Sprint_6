package tests;

import POM.HomePagePOM;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class faqIsClickable {

    private WebDriver driver;

@Test
public void test() {

    ChromeOptions options = new ChromeOptions();
    driver = new ChromeDriver(options);
    driver.get("https://qa-scooter.praktikum-services.ru");
    HomePagePOM homePagePOM = new HomePagePOM(driver);

    homePagePOM.acceptCookies();
    homePagePOM.scrollToFaq();
    homePagePOM.clickFaqQuestion(0);
    homePagePOM.clickFaqQuestion(1);
    homePagePOM.clickFaqQuestion(2);
    homePagePOM.clickFaqQuestion(3);
    homePagePOM.clickFaqQuestion(4);
    homePagePOM.clickFaqQuestion(5);
    homePagePOM.clickFaqQuestion(6);
    homePagePOM.clickFaqQuestion(7);
}

    @AfterEach
    void teardown() {
    driver.quit();
    }
}
