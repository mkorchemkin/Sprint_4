package ru.yandex.praktikum.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ru.yandex.praktikum.pageObject.constants.CreateOrderButton.DOWN_BUTTON;
import static ru.yandex.praktikum.pageObject.constants.CreateOrderButton.UP_BUTTON;

// Главная страница и её методы
public class HomePage {
    private final WebDriver driver;

    // Заголовки и кнопки
    private final By homeHeader = By.className("Home_Header__iJKdX");
    private final By upOrderButton = By.className("Button_Button__ra12g");
    private final By downOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By questionsHeader = By.className("Home_FourPart__1uthg");
    private final By orderState = By.xpath(".//button[text()='Статус заказа']");
    private final By numberOrder = By.xpath(".//input[@placeholder='Введите номер заказа']");
    private final By buttonGo = By.xpath(".//button[text()='Go!']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Ожидание загрузки главной страницы
    public HomePage waitForLoadHomePage() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(driver -> {
            String text = driver.findElement(homeHeader).getText();
            return text != null && !text.isEmpty();
        });
        return this;
    }

    // Прокрутка к блоку вопросов
    public HomePage scrollToQuestions() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionsHeader));
        return this;
    }

    // Прокрутка ко второй кнопке "Заказать"
    public void scrollToDownOrderButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(downOrderButton));
    }

    // Клики по кнопкам "Заказать"
    public void clickUpOrderButton() {
        driver.findElement(upOrderButton).click();
    }

    public void clickDownOrderButton() {
        driver.findElement(downOrderButton).click();
    }

    public void clickCreateOrderButton(Enum button) {
        if (button.equals(UP_BUTTON)) {
            clickUpOrderButton();
        } else if (button.equals(DOWN_BUTTON)) {
            scrollToDownOrderButton();
            clickDownOrderButton();
        }
    }

    // Клик по вопросу
    public HomePage clickQuestion(By question) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(question))
                .click();
        return this;
    }

    // Ожидание загрузки ответа после клика
    public void waitLoadAfterClickQuestion(By answer) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(answer));
    }

    // Получение текста ответа
    public String getAnswerText(By answer) {
        return driver.findElement(answer).getText();
    }

    // Работа с формой "Статус заказа"
    public HomePage clickOrderState() {
        driver.findElement(orderState).click();
        return this;
    }

    public HomePage inputOrderNumber(String number) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(numberOrder))
                .sendKeys(number);
        return this;
    }

    public void clickGo() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(buttonGo))
                .click();
    }
}


