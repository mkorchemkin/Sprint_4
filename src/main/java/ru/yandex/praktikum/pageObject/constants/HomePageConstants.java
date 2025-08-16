package ru.yandex.praktikum.pageObject.constants;

import org.openqa.selenium.By;

public class HomePageConstants {

    // Определяем заголовки вопросов
    public static final By QUESTION_DELIVERY = By.id("accordion__heading-delivery");
    public static final By QUESTION_RENTAL = By.id("accordion__heading-rental");
    public static final By QUESTION_PAYMENT = By.id("accordion__heading-payment");
    public static final By QUESTION_CANCELLATION = By.id("accordion__heading-cancellation");
    public static final By QUESTION_CHARGING = By.id("accordion__heading-charging");
    public static final By QUESTION_RETURN = By.id("accordion__heading-return");
    public static final By QUESTION_SUPPORT = By.id("accordion__heading-support");
    public static final By QUESTION_AVAILABILITY = By.id("accordion__heading-availability");

    // Определяем элементы ответов
    public static final By ANSWER_DELIVERY = By.id("accordion__panel-delivery");
    public static final By ANSWER_RENTAL = By.id("accordion__panel-rental");
    public static final By ANSWER_PAYMENT = By.id("accordion__panel-payment");
    public static final By ANSWER_CANCELLATION = By.id("accordion__panel-cancellation");
    public static final By ANSWER_CHARGING = By.id("accordion__panel-charging");
    public static final By ANSWER_RETURN = By.id("accordion__panel-return");
    public static final By ANSWER_SUPPORT = By.id("accordion__panel-support");
    public static final By ANSWER_AVAILABILITY = By.id("accordion__panel-availability");

    // Определяем текст ответов
    public static final String TEXT_ANSWER_DELIVERY = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String TEXT_ANSWER_RENTAL = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String TEXT_ANSWER_PAYMENT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String TEXT_ANSWER_CANCELLATION = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String TEXT_ANSWER_CHARGING = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String TEXT_ANSWER_RETURN = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String TEXT_ANSWER_SUPPORT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String TEXT_ANSWER_AVAILABILITY = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
}
