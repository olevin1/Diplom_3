package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private final WebDriver driver;
    /**
     * Описание элементов Личного кабинета
     */
    // Кнопка "Выход"
    private final By exitButton = By.xpath(".//li/button[text()='Выход']");
    // Подсказка на странице Личного кабинета
    private final By infoHint = By.xpath(".//nav/p[text()='В этом разделе вы можете изменить свои персональные данные']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Описание действий в Личном кабинете
     */
    @Step("Найти текст для подтверждения перехода в Личный кабинет")
    public Boolean textInPersonalAccount() {
        return driver.findElement(infoHint).isDisplayed();
    }

    @Step("Нажать на кнопку Выход")
    public void exitClick() {
        driver.findElement(exitButton).click();
    }
}