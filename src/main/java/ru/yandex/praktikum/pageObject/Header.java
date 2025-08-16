package ru.yandex.praktikum.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    WebDriver driver;

    private final By yandexButton = By.xpath(".//*[@alt='Yandex']");
    private final By scooterButton = By.xpath(".//*[@alt='Scooter']");

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public void clickYandex() {
        driver.findElement(yandexButton).click();
    }

    public void clickScooter() {
        driver.findElement(scooterButton).click();
    }
}

