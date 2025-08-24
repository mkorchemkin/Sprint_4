package ru.yandex.praktikum.pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.pageObject.constants.HomePageConstants.*;

@RunWith(Parameterized.class)
public class HomePageTest {
    private static WebDriver driver;
    private static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";

    private final By question;
    private final By answer;
    private final By labelResult;
    private final String expected;

    public HomePageTest(By question, By answer, By labelResult, String expected) {
        this.question = question;
        this.answer = answer;
        this.labelResult = labelResult;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {COST_QUESTION, COST_ANSWER, COST_ITEM_ANSWER, COST_TEXT},
                {MULTIPLE_ORDERS_QUESTION, MULTIPLE_ORDERS_ANSWER, MULTIPLE_ORDERS_ITEM_ANSWER, MULTIPLE_ORDERS_TEXT},
                {RENT_PERIOD_QUESTION, RENT_PERIOD_ANSWER, RENT_PERIOD_ITEM_ANSWER, RENT_PERIOD_TEXT},
                {DELIVERY_DAY_QUESTION, DELIVERY_DAY_ANSWER, DELIVERY_DAY_ITEM_ANSWER, DELIVERY_DAY_TEXT},
                {SUPPORT_CONTACT_QUESTION, SUPPORT_CONTACT_ANSWER, SUPPORT_CONTACT_ITEM_ANSWER, SUPPORT_CONTACT_TEXT},
                {BATTERY_QUESTION, BATTERY_ANSWER, BATTERY_ITEM_ANSWER, BATTERY_TEXT},
                {CANCEL_ORDER_QUESTION, CANCEL_ORDER_ANSWER, CANCEL_ORDER_ITEM_ANSWER, CANCEL_ORDER_TEXT},
                {DELIVERY_REGION_QUESTION, DELIVERY_REGION_ANSWER, DELIVERY_REGION_ITEM_ANSWER, DELIVERY_REGION_TEXT},
        };
    }

    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDownClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Before
    public void openHomePage() {
        driver.get(BASE_URL);
    }

    @Test
    public void checkQuestions() {
        HomePage homePage = new HomePage(driver);

        // Ожидание загрузки главной страницы
        homePage.waitForLoadHomePage()
                .scrollToQuestions()
                .clickQuestion(question)
                .waitLoadAfterClickQuestion(labelResult);

        // Получение текста ответа
        String result = homePage.getAnswerText(answer);

        // Сравнение с ожидаемым текстом
        assertEquals(expected, result);
    }
}
