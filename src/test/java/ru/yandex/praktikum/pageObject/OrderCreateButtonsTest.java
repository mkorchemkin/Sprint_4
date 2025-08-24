package ru.yandex.praktikum.pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.pageObject.constants.CreateOrderButton.DOWN_BUTTON;
import static ru.yandex.praktikum.pageObject.constants.CreateOrderButton.UP_BUTTON;

@RunWith(Parameterized.class)
public class OrderCreateButtonsTest {
    private WebDriver driver;
    private final Enum button;

    public OrderCreateButtonsTest(Enum button) {
        this.button = button;
    }

    @Parameterized.Parameters
    public static Object[] getButtons() {
        return new Object[]{UP_BUTTON, DOWN_BUTTON};
    }

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
    public void testOpenOrderFormFromButton() {
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHomePage()
                .clickCreateOrderButton(button);

        assertTrue(new AboutRenterPage(driver).isOrderFormOpened());
    }
}

