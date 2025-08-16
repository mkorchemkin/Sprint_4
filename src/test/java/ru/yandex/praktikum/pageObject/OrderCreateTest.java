package ru.yandex.praktikum.pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.pageObject.constants.CreateOrderButton.DOWN_BUTTON;
import static ru.yandex.praktikum.pageObject.constants.CreateOrderButton.UP_BUTTON;
import static ru.yandex.praktikum.pageObject.constants.RentDurationConstants.*;
import static ru.yandex.praktikum.pageObject.constants.ScooterColours.*;

@RunWith(Parameterized.class)
public class OrderCreateTest {
    private WebDriver driver;
    private final String site = "https://qa-scooter.praktikum-services.ru/";
    private final String name;
    private final String surname;
    private final String address;
    private final int stateMetroNumber;
    private final String telephoneNumber;
    private final String date;
    private final String duration;
    private final Enum colour;
    private final String comment;
    private final String expectedHeader = "Заказ оформлен";

    public OrderCreateTest(String name, String surname, String address, int stateMetroNumber, String telephoneNumber,
                           String date, String duration, Enum colour, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.stateMetroNumber = stateMetroNumber;
        this.telephoneNumber = telephoneNumber;
        this.date = date;
        this.duration = duration;
        this.colour = colour;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {"Иван", "Иванов", "ул Тестовая 1", 123, "79999999999", "24.06.2024", SIX_DAYS, GREY, "Заранее позвоните"},
                {"Петр", "Петров", "ул Тестовая 2", 7, "79000000000", "25.06.2024", FIVE_DAYS, BLACK, "Заранее позвоните"},
                {"Анна", "Рябова", "ул Тестовая 3", 10, "79555555555", "26.06.2024", ONE_DAY, BLACK, "Заранее позвоните"},
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(site);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    // 🔹 Отдельный тест: проверка перехода по обеим кнопкам
    @Test
    public void testOpenOrderFormFromUpAndDownButtons() {
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHomePage();

        // Проверяем верхнюю кнопку
        homePage.clickCreateOrderButton(UP_BUTTON);
        assertTrue(new AboutRenter(driver).isOrderFormOpened());

        driver.get(site);

        // Проверяем нижнюю кнопку
        homePage.waitForLoadHomePage().clickCreateOrderButton(DOWN_BUTTON);
        assertTrue(new AboutRenter(driver).isOrderFormOpened());
    }

    // 🔹 Параметризованный тест: заполнение и оформление заказа
    @Test
    public void testCreateOrder() {
        new HomePage(driver)
                .waitForLoadHomePage()
                .clickCreateOrderButton(UP_BUTTON); // всегда одна кнопка, этого достаточно

        new AboutRenter(driver)
                .waitForLoadOrderPage()
                .inputName(name)
                .inputSurname(surname)
                .inputAddress(address)
                .changeStateMetro(stateMetroNumber)
                .inputTelephone(telephoneNumber)
                .clickNextButton();

        new AboutScooter(driver)
                .waitAboutRentHeader()
                .inputDate(date)
                .inputDuration(duration)
                .changeColour(colour)
                .inputComment(comment)
                .clickButtonCreateOrder();

        PopUpWindow popUpWindow = new PopUpWindow(driver);
        popUpWindow.clickButtonYes();

        assertTrue(popUpWindow.getHeaderAfterCreateOrder().contains(expectedHeader));
    }
}

