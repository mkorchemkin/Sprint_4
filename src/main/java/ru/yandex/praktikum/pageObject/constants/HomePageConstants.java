package ru.yandex.praktikum.pageObject.constants;

import org.openqa.selenium.By;

public class HomePageConstants {

    // Вопросы
    public static final By COST_QUESTION = By.id("accordion__heading-0");
    public static final By MULTIPLE_ORDERS_QUESTION = By.id("accordion__heading-1");
    public static final By RENT_PERIOD_QUESTION = By.id("accordion__heading-2");
    public static final By DELIVERY_DAY_QUESTION = By.id("accordion__heading-3");
    public static final By SUPPORT_CONTACT_QUESTION = By.id("accordion__heading-4");
    public static final By BATTERY_QUESTION = By.id("accordion__heading-5");
    public static final By CANCEL_ORDER_QUESTION = By.id("accordion__heading-6");
    public static final By DELIVERY_REGION_QUESTION = By.id("accordion__heading-7");

    // Ответы
    public static final By COST_ANSWER = By.id("accordion__panel-0");
    public static final By MULTIPLE_ORDERS_ANSWER = By.id("accordion__panel-1");
    public static final By RENT_PERIOD_ANSWER = By.id("accordion__panel-2");
    public static final By DELIVERY_DAY_ANSWER = By.id("accordion__panel-3");
    public static final By SUPPORT_CONTACT_ANSWER = By.id("accordion__panel-4");
    public static final By BATTERY_ANSWER = By.id("accordion__panel-5");
    public static final By CANCEL_ORDER_ANSWER = By.id("accordion__panel-6");
    public static final By DELIVERY_REGION_ANSWER = By.id("accordion__panel-7");

    // XPath для панелей (при необходимости)
    public static final By COST_ITEM_ANSWER = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-0']");
    public static final By MULTIPLE_ORDERS_ITEM_ANSWER = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-1']");
    public static final By RENT_PERIOD_ITEM_ANSWER = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-2']");
    public static final By DELIVERY_DAY_ITEM_ANSWER = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-3']");
    public static final By SUPPORT_CONTACT_ITEM_ANSWER = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-4']");
    public static final By BATTERY_ITEM_ANSWER = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-5']");
    public static final By CANCEL_ORDER_ITEM_ANSWER = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-6']");
    public static final By DELIVERY_REGION_ITEM_ANSWER = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-7']");

    // Тексты ответов
    public static final String COST_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String MULTIPLE_ORDERS_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String RENT_PERIOD_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String DELIVERY_DAY_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String SUPPORT_CONTACT_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String BATTERY_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String CANCEL_ORDER_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String DELIVERY_REGION_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
}

