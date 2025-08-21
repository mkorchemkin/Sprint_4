package ru.yandex.praktikum.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ru.yandex.praktikum.pageObject.constants.ScooterColours.*;

public class AboutScooter {
    WebDriver driver;

    // локаторы формы заказа
    private final By rentHeader = By.className("Order_Header__BZXOb");
    private final By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By durationRent = By.xpath(".//span[@class='Dropdown-arrow']");
    private final By colourBlack = By.id("black");
    private final By colourGrey = By.id("grey");
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By createOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public AboutScooter(WebDriver driver) {
        this.driver = driver;
    }

    // метод ожидания загрузки страницы
    public AboutScooter waitAboutRentHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> d.findElement(rentHeader).isDisplayed());
        return this;
    }

    public AboutScooter inputDate(String newDate) {
        driver.findElement(date).sendKeys(newDate);
        return this;
    }

    public AboutScooter inputDuration(String newDuration) {
        driver.findElement(durationRent).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath(String.format("//div[text()='%s']", newDuration))))
                .click();
        return this;
    }

    public AboutScooter changeColour(Enum colour) {
        return null;
    }

    public AboutScooter inputComment(String newComment) {
        driver.findElement(comment).sendKeys(newComment);
        return this;
    }

    public void clickButtonCreateOrder() {
        driver.findElement(createOrderButton).click();
    }

    public void clickScooter() {
    }
}


