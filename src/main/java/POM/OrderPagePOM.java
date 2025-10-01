package POM;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPagePOM {

    private WebDriver driver;

    public OrderPagePOM(WebDriver driver) {
        this.driver = driver;
    }

    // ===== HEADER =====
    // Заголовок блока "Для кого самокат"
    private By orderHeader = By.cssSelector(".Order_Header__BZXOb");

    // ===== ФОРМА =====
    // Поле "* Имя"
    private By firstNameInput = By.cssSelector("input[placeholder='* Имя']");

    // Поле "* Фамилия"
    private By lastNameInput = By.cssSelector("input[placeholder='* Фамилия']");

    // Поле "* Адрес: куда привезти заказ"
    private By addressInput = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");

    // Поле выбора станции метро
    private By metroInput = By.cssSelector(".select-search__input");

    // Сообщение об ошибке метро
    private By metroError = By.cssSelector(".Order_MetroError__1BtZb");

    // Поле "* Телефон: на него позвонит курьер"
    private By phoneInput = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");

    // Сообщения об ошибках полей
    private By inputErrors = By.cssSelector(".Input_ErrorMessage__3HvIb");

    // Кнопка "Далее"
    private By nextButton = By.xpath("//button[contains(@class,'Button_Button__ra12g') " +
            "and contains(@class,'Button_Middle__1CSJM')]");

    // ===== ЛОКАТОРЫ продолжение заказа =====

    // Заголовок блока "Про аренду"

    // Поле "* Когда привезти самокат"
    private By dateInput = By.cssSelector("input[placeholder='* Когда привезти самокат']");

    // Срок аренды (выпадающий список)
    private By rentalPeriodDropdown = By.cssSelector(".Dropdown-root .Dropdown-control");

    // Цвет самоката
    private By blackScooterCheckbox = By.id("black");
    private By greyScooterCheckbox = By.id("grey");

    // Комментарий для курьера
    private By commentInput = By.cssSelector("input[placeholder='Комментарий для курьера']");

    // Кнопки
    private By backButton = By.xpath("//button[contains(@class,'Button_Inverted__3IF-i')" +
            " and contains(text(),'Назад')]");
    private By orderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']//button[contains(text(),'Заказать')]");


    // ===== МЕТОДЫ =====

    public void enterName(String Name) {
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(Name);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void enterAddress(String address) {
        driver.findElement(addressInput).clear();
        driver.findElement(addressInput).sendKeys(address);
    }

    public void enterMetro(String metro) {
        WebElement metroElement = driver.findElement(metroInput);
        metroElement.clear();
        metroElement.sendKeys(metro);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneInput).clear();
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    // Получить текст ошибки по конкретному полю
    public String getInputErrorMessage(WebElement field) {
        return field.findElement(By.xpath("./following-sibling::div[contains(@class,'Input_ErrorMessage')]")).getText();
    }

    // Универсальный метод для получения ошибки метро
    public String getMetroError() {
        return driver.findElement(metroError).getText();
    }

    //Метод выбора станции метро

    public void selectMetro(String stationName) {
        // Вводим название станции
        driver.findElement(metroInput).sendKeys(stationName);

        // Ждём появления списка вариантов
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(String.format(
                                "//div[contains(@class,'select-search__select')]//*[contains(text(),'%s')]",
                                stationName
                        ))
                ));

        // Теперь ждём, когда станция будет кликабельна, и кликаем
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(String.format(
                                "//div[contains(@class,'select-search__select')]//*[contains(text(),'%s')]",
                                stationName
                        ))
                ))
                .click();
    }

    // Ввод даты
    public void enterDate(String date) {
        WebElement element = driver.findElement(dateInput);
        element.clear();
        element.sendKeys(date);
        element.sendKeys(Keys.ENTER); // подтверждаем ввод
    }

    // Выбор срока аренды
    public void selectRentalPeriod(String period) {
        driver.findElement(rentalPeriodDropdown).click();
        By optionLocator = By.xpath(String.format("//div[contains(@class,'Dropdown-menu')]//div[text()='%s']", period));
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(optionLocator))
                .click();
    }

    // Выбор цвета самоката
    public void selectScooterColor(String color) {
        By colorLocator = By.xpath(String.format(
                "//label[contains(@class,'Checkbox_Label__3wxSf')][contains(text(),'%s')]/input",
                color
        ));

        WebElement checkbox = driver.findElement(colorLocator);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }


    // Ввод комментария
    public void enterComment(String comment) {
        driver.findElement(commentInput).clear();
        driver.findElement(commentInput).sendKeys(comment);
    }

    // Клик по кнопке "Назад"
    public void clickBackButton() {
        driver.findElement(backButton).click();
    }

    // Клик по кнопке "Заказать"
    public void clickOrderButton() {
        WebElement element = driver.findElement(orderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    // ===== Окно подтверждения заказа =====
    // Кнопка "Нет"
    private By cancelOrderButton =
            By.xpath("//div[contains(@class,'Order_Buttons__1xGrp')]/button[text()='Нет']");

    // Кнопка "Да"
    private By confirmOrderButton =
            By.xpath("//div[contains(@class,'Order_Buttons__1xGrp')]/button[text()='Да']");

    //Метод выбора кнопки "Да"/"Нет"
    public void clickOrderConfirmation(String answer) {
        String xpath = String.format(
                "//div[contains(@class,'Order_Buttons__1xGrp')]/button[text()='%s']",
                answer
        );

        driver.findElement(By.xpath(xpath)).click();
    }


}