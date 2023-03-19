package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    /**
     * Описание элементов страницы входа
     */
    //Заголовок "Вход"
    private final By loginHeader = By.xpath(".//main/div/h2[text()='Вход']");
    //Поле "Email"
    private final By emailField = By.xpath(".//div[@class='input pr-6 pl-6 input_type_text input_size_default']/input[@name='name']");
    //Поле "Пароль"
    private final By passwordField = By.xpath(".//div[@class='input pr-6 pl-6 input_type_password input_size_default']/input[@name='Пароль']");
    //Кнопка "Войти"
    private final By enterButton = By.xpath(".//button[text()='Войти']");
    //Гиперссылка "Зарегистрироваться"
    private final By registerButton = By.xpath(".//a[@href='/register' and text()='Зарегистрироваться']");
    //Гиперссылка "Восстановить пароль"
    private final By passwordRestoreHyperlink = By.xpath(".//a[@href='/forgot-password' and text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Описание действий на странице входа в Личный кабинет пользователя
     */
    @Step("Найти элемент для подтверждения перехода на страницу входа")
    public Boolean loginHeaderDisplayed() {
        return driver.findElement(loginHeader).isDisplayed();
    }

    @Step("Ввести адрес почты в поле Email")
    public void emailInput(String newEmail) {
        driver.findElement(emailField).sendKeys(newEmail);
    }

    @Step("Ввести пароль в поле Пароль")
    public void passwordInput(String newPassword) {
        driver.findElement(passwordField).sendKeys(newPassword);
    }

    @Step("Нажать на кнопку Войти")
    public void enterClick() {
        driver.findElement(enterButton).click();
    }

    @Step("Нажать на гиперссылку Зарегистрироваться")
    public void registerClick() {
        driver.findElement(registerButton).click();
    }

    @Step("Нажать на гиперссылку Восстановить пароль")
    public void passwordRestoreClick() {
        driver.findElement(passwordRestoreHyperlink).click();
    }

    @Step("Авторизация пользователя")
    public void authorizationUser(String email, String password) {
        emailInput(email);
        passwordInput(password);
        enterClick();
    }
}