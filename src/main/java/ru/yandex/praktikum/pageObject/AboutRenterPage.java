package ru.yandex.praktikum.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// PageObject для страницы https://qa-scooter.praktikum-services.ru/order
// "Для кого самокат" — поля формы и кнопки

public class AboutRenterPage {
    private final WebDriver driver;

    private final By orderHeader = By.className("Order_Header__BZXOb");
    private final By name = By.xpath(".//input[@placeholder='* Имя']");
    private final By surname = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By stateMetro = By.className("select-search__input");
    private final By telephone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By buttonNext = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By scooterButton = By.xpath(".//*[@alt='Scooter']");

    public AboutRenterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод ожидания загрузки страницы заказа
    public AboutRenterPage waitForLoadOrderPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> (driver.findElement(orderHeader).getText() != null
                        && !driver.findElement(orderHeader).getText().isEmpty()));
        return this;
    }

    public AboutRenterPage inputName(String newName) {
        driver.findElement(name).sendKeys(newName);
        return this;
    }

    public AboutRenterPage inputSurname(String newSurname) {
        driver.findElement(surname).sendKeys(newSurname);
        return this;
    }

    public AboutRenterPage inputAddress(String newAddress) {
        driver.findElement(address).sendKeys(newAddress);
        return this;
    }

    public AboutRenterPage changeStateMetro(int stateNumber) {
        driver.findElement(stateMetro).click();
        String nameStateMetro = ".//button[@value='%s']";
        By newStateMetro = By.xpath(String.format(nameStateMetro, stateNumber));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(newStateMetro));
        driver.findElement(newStateMetro).click();
        return this;
    }

    public AboutRenterPage inputTelephone(String newTelephone) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(telephone));
        driver.findElement(telephone).sendKeys(newTelephone);
        return this;
    }

    public void clickNextButton() {
        driver.findElement(buttonNext).click();
    }

    public void clickScooter() {
        driver.findElement(scooterButton).click();
    }

    // Проверка, что форма заказа действительно открыта
    public boolean isOrderFormOpened() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderHeader))
                .isDisplayed();
    }
}

