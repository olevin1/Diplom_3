package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private final WebDriver driver;
    /**
     * Описание элементов страницы восстановления пароля
     */
    // Заголовок "Восстановление пароля"
    public By recoverPasswordHeader = By.xpath(".//main/div/h2[text()='Восстановление пароля']");
    // Поле "Email"
    private final By emailField = By.xpath(".//div[./label[text()='Email']]/input[@name='name']");
    // Кнопка "Восстановить"
    private final By recoverButton = By.xpath(".//form/button[text()='Восстановить']");
    // Ссылка "Войти"
    private final By loginHyperlink = By.xpath(".//a[text() = 'Войти']");

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Описание действий на странице входа в Личный кабинет пользователя
     */
    @Step("Найти элемент для подтверждения перехода на страницу восстановления пароля")
    public Boolean passwordRecoveryDisplayed() {
        return driver.findElement(recoverPasswordHeader).isDisplayed();
    }

    @Step("Ввести адрес почты в поле Email")
    public void emailInput(String newEmail) {
        driver.findElement(emailField).sendKeys(newEmail);
    }

    @Step("Нажать на кнопку Восстановить")
    public void recoverClick() {
        driver.findElement(recoverButton).click();
    }

    @Step("Нажать на гиперссылку Войти")
    public void loginClick() {
        driver.findElement(loginHyperlink).click();
    }
}