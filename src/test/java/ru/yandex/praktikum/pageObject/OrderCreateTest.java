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
import ru.yandex.praktikum.pageObject.constants.ScooterColours;

import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.pageObject.constants.CreateOrderButton.UP_BUTTON;
import static ru.yandex.praktikum.pageObject.constants.RentDurationConstants.*;
import static ru.yandex.praktikum.pageObject.constants.ScooterColours.*;

@RunWith(Parameterized.class)
public class OrderCreateTest {
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final int stateMetroNumber;
    private final String telephoneNumber;
    private final String date;
    private final String duration;
    private final ScooterColours colour;
    private final String comment;

    public OrderCreateTest(String name, String surname, String address, int stateMetroNumber,
                           String telephoneNumber, String date, String duration,
                           ScooterColours colour, String comment) {
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
                {"Иван", "Иванов", "ул Тестовая 1", 123, "79999999999", "24.06.2025", SIX_DAYS, GREY, "Заранее позвоните"},
                {"Петр", "Петров", "ул Тестовая 2", 7, "79000000000", "25.06.2025", FIVE_DAYS, BLACK, "Заранее позвоните"},
                {"Анна", "Рябова", "ул Тестовая 3", 10, "79555555555", "26.06.2025", ONE_DAY, BLACK, "Заранее позвоните"},
        };
    }

    @Before
    public void startUp() {
        String browser = System.getProperty("BROWSER", "chrome").toLowerCase(); // дефолт Chrome

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testCreateOrder() {
        new HomePage(driver)
                .waitForLoadHomePage()
                .clickCreateOrderButton(UP_BUTTON);

        new AboutRenterPage(driver)
                .waitForLoadOrderPage()
                .inputName(name)
                .inputSurname(surname)
                .inputAddress(address)
                .changeStateMetro(stateMetroNumber)
                .inputTelephone(telephoneNumber)
                .clickNextButton();

        new AboutScooterPage(driver)
                .waitAboutRentHeader()
                .inputDate(date)
                .inputDuration(duration)
                .changeColour(colour)
                .inputComment(comment)
                .clickButtonCreateOrder();

        PopUpWindow popUpWindow = new PopUpWindow(driver);
        popUpWindow.clickButtonYes();

        String expectedHeader = "Заказ оформлен";
        assertTrue(popUpWindow.getHeaderAfterCreateOrder().contains(expectedHeader));
    }
}


