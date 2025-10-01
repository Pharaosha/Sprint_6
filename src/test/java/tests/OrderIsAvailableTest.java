package tests;


import POM.HomePagePOM;
import POM.OrderPagePOM;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.stream.Stream;

public class OrderIsAvailableTest {

    private WebDriver driver;
    private HomePagePOM homePagePOM;
    private OrderPagePOM orderPagePOM;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru");
        homePagePOM = new HomePagePOM(driver);
        orderPagePOM = new OrderPagePOM(driver);
    }

    @ParameterizedTest
    @MethodSource("credentialsProvider")
    public void test(String name, String lastName, String address, String metro, String phone, String date,
                     String period, String color, String comment, String answer) {

        homePagePOM.acceptCookies();
        homePagePOM.clickOrderButtonHeader();
        orderPagePOM.enterName(name);
        orderPagePOM.enterLastName(lastName);
        orderPagePOM.enterAddress(address);
        orderPagePOM.selectMetro(metro);
        orderPagePOM.enterPhone(phone);
        orderPagePOM.clickNextButton();
        orderPagePOM.enterDate(date);
        orderPagePOM.selectRentalPeriod(period);
        orderPagePOM.selectScooterColor(color);
        orderPagePOM.enterComment(comment);
        orderPagePOM.clickOrderButton();
        orderPagePOM.clickOrderConfirmation(answer);
    }

    private static Stream<Arguments> credentialsProvider() {
        return Stream.of(
                Arguments.of("Женя", "Иванов", "ул. Пушкина, д. Колотушкитна", "Сокол",
                        "+79779940101", "02.10.2025", "сутки", "чёрный жемчуг", "Оставить у двери", "Да"),
                Arguments.of("Олег", "Макаров", "ул. Ленина, д. 42", "Охотный Ряд",
                        "+79779940102", "02.10.2025", "двое суток", "серая безысходность", "Привезти после 12", "Нет")
        );
}

    @AfterEach
    void teardown() {
        driver.quit();
    }
}
