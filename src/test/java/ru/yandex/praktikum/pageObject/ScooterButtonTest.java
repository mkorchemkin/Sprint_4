package ru.yandex.praktikum.pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ScooterButtonTest {
    private WebDriver driver;

    // Константа для URL
    private static final String SITE_URL = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void startUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(SITE_URL);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void clickScooterFromAboutRenterPage() {
        HomePage homePage = new HomePage(driver);
        AboutRenterPage aboutRenter = new AboutRenterPage(driver);

        homePage.waitForLoadHomePage()
                .clickUpOrderButton();

        aboutRenter.waitForLoadOrderPage()
                .clickScooter();

        // Проверка: URL остался прежним (можно заменить на проверку выбранного самоката)
        assertEquals(SITE_URL, driver.getCurrentUrl());
    }

    @Test
    public void clickScooterFromAboutScooterPage() {
        AboutScooterPage aboutScooter = new AboutScooterPage(driver);

        // Предусловие: сразу открываем страницу заказа
        aboutScooter.open()
                .waitAboutRentHeader()
                .clickScooter();

        // Проверка: самокат выбран
        assertTrue(aboutScooter.isScooterSelected());
    }

    @Test
    public void clickScooterFromOrderStatusPage() {
        HomePage homePage = new HomePage(driver);
        OrderStatus orderStatus = new OrderStatus(driver);

        homePage.waitForLoadHomePage()
                .clickOrderState()
                .inputOrderNumber("45106")
                .clickGo();

        orderStatus.waitLoadOrderStatusPage()
                .clickScooter();

        // Проверка: URL остался прежним
        assertEquals(SITE_URL, driver.getCurrentUrl());
    }
}
