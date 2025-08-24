package ru.yandex.praktikum.pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrderStatusTest {
    WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        String site = "https://qa-scooter.praktikum-services.ru/";
        driver.get(site);
    }

    @After
    public void teardown() {

        driver.quit();
    }

    @Test
    public void orderStatusWithoutNumber() {
        String numberOrder = "45106";
        new HomePage(driver)
                .waitForLoadHomePage()
                .clickOrderState()
                .inputOrderNumber(numberOrder)
                .clickGo();
        new OrderStatus(driver)
                .waitLoadOrderStatusPage();
    }
}
