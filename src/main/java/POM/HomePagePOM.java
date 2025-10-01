package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePagePOM {
    private WebDriver driver;

    public HomePagePOM(WebDriver driver) {
        this.driver = driver;
    }

    // ===== HEADER =====
    // Логотип Яндекс
    private By logoYandex = By.cssSelector("a.Header_LogoYandex__3TSOI img");

    // Логотип Scooter
    private By logoScooter = By.cssSelector("a.Header_LogoScooter__3lsAR img");

    // Дисклеймер "Учебный тренажер"
    private By headerDisclaimer = By.cssSelector(".Header_Disclaimer__3VEni");

    // Кнопка "Заказать" в шапке
    private By orderButtonHeader = By.xpath("//button[text()='Заказать']");

    // Кнопка "Статус заказа"
    private By orderStatusButton = By.xpath("//button[text()='Статус заказа']");

    // Поле ввода "Введите номер заказа"
    private By orderNumberInput = By.cssSelector("input[placeholder='Введите номер заказа']");

    // Сообщение об ошибке под полем ввода
    private By inputErrorMessage = By.cssSelector(".Input_ErrorMessage__3HvIb");

    // Кнопка "Go!"
    private By goButton = By.xpath("//button[text()='Go!']");


    // ===== HERO-БЛОК =====
    // Заголовок "Самокат на пару дней"
    private By mainHeader = By.xpath("//div[contains(@class,'Home_Header__iJKdX')]");

    // Подзаголовок первый
    private By subHeaderFirst = By.xpath("//div[contains(text(),'Привезём его прямо к вашей двери')]");

    // Подзаголовок второй
    private By subHeaderSecond = By.xpath("//div[contains(text(),'Он лёгкий и с мощными колёсами')]");

    // Картинка чертежа самоката
    private By blueprintImage = By.cssSelector("img[alt='Scooter blueprint']");

    // Картинка самоката
    private By scooterImage = By.cssSelector("div.Home_Scooter__3YdJy img");

    // Стрелка вниз "Scroll down"
    private By arrowDown = By.cssSelector("img[alt='Scroll down']");


    // ===== ТАБЛИЦА ХАРАКТЕРИСТИК =====
    // Модель
    private By scooterModel = By.xpath("//div[contains(text(),'Модель Toxic PRO')]");

    // Максимальная скорость
    private By maxSpeedRow = By.xpath("//div[contains(text(),'Максимальная скорость')]/following-sibling::div");

    // Пробег без подзарядки
    private By batteryRow = By.xpath("//div[contains(text(),'Проедет без поздарядки')]/following-sibling::div");

    // Максимальный вес
    private By weightRow = By.xpath("//div[contains(text(),'Выдерживает вес')]/following-sibling::div");


    // ===== КАК ЭТО РАБОТАЕТ =====
    // Заголовок "Как это работает"
    private By howItWorksHeader = By.xpath("//div[contains(text(),'Как это работает')]");

    // Этап 1
    private By stepOne = By.xpath("//div[contains(text(),'Заказываете самокат')]");

    // Этап 2
    private By stepTwo = By.xpath("//div[contains(text(),'Курьер привозит самокат')]");

    // Этап 3
    private By stepThree = By.xpath("//div[contains(text(),'Катаетесь')]");

    // Этап 4
    private By stepFour = By.xpath("//div[contains(text(),'Курьер забирает самокат')]");

    // Кнопка "Заказать" в конце блока
    private By orderButtonHowItWorks = By.xpath("//button[text()='Заказать' and contains(@class,'Button_UltraBig__UU3Lp')]");


    // ===== FAQ =====
    // Блок с вопросами
    private By faqBlock = By.className("Home_FAQ__3uVm4");

    // Вопросы
    private By faqQuestionOne = By.id("accordion__heading-0");
    private By faqQuestionTwo = By.id("accordion__heading-1");
    private By faqQuestionThree = By.id("accordion__heading-2");
    private By faqQuestionFour = By.id("accordion__heading-3");
    private By faqQuestionFive = By.id("accordion__heading-4");
    private By faqQuestionSix = By.id("accordion__heading-5");
    private By faqQuestionSeven = By.id("accordion__heading-6");
    private By faqQuestionEight = By.id("accordion__heading-7");

    // Ответы
    private By faqAnswerOne = By.id("accordion__panel-0");
    private By faqAnswerTwo = By.id("accordion__panel-1");
    private By faqAnswerThree = By.id("accordion__panel-2");
    private By faqAnswerFour = By.id("accordion__panel-3");
    private By faqAnswerFive = By.id("accordion__panel-4");
    private By faqAnswerSix = By.id("accordion__panel-5");
    private By faqAnswerSeven = By.id("accordion__panel-6");
    private By faqAnswerEight = By.id("accordion__panel-7");


    // ===== МЕТОДЫ =====
    // Прокрутка до блока FAQ
    public void scrollToFaq() {
        WebElement element = driver.findElement(faqBlock);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Клик по вопросу FAQ (универсально)
    public void clickFaqQuestion(int questionNumber) {
        driver.findElement(By.id("accordion__heading-" + questionNumber)).click();
    }

    // Получить текст ответа FAQ (универсально)
    public String getFaqAnswer(int answerNumber) {
        return driver.findElement(By.id("accordion__panel-" + answerNumber)).getText();
    }

    // Клик по кнопке "Заказать" в шапке
    public void clickOrderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
    }

    // Клик по кнопке "Статус заказа"
    public void clickOrderStatusButton() {
        driver.findElement(orderStatusButton).click();
    }

    // Ввод номера заказа
    public void setOrderNumber(String orderNumber) {
        driver.findElement(orderNumberInput).sendKeys(orderNumber);
    }

    // Клик по кнопке "Go!"
    public void clickGoButton() {
        driver.findElement(goButton).click();
    }

    // Кнопка закрытия cookie-баннера
    private By cookieAcceptButton = By.id("rcc-confirm-button");

    // Метод закрытия cookie-баннера
    public void acceptCookies() {
        driver.findElement(cookieAcceptButton).click();
    }
}
