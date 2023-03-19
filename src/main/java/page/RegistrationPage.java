package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;
    /**
     * Описание элементов страницы регистрации
     */
    // Заголовок "Регистрация"
    public By registrationHeader = By.xpath(".//div/h2[text()='Регистрация']");
    // Поле "Имя"
    private final By nameField = By.xpath(".//div[./label[text()='Имя']]/input[@name='name']");
    // Поле Email"
    private final By emailField = By.xpath(".//div[./label[text()='Email']]/input[@name='name']");
    // Поле "Пароль"
    private final By passwordField = By.xpath(".//div[./label[text()='Пароль']]/input[@name='Пароль']");
    // Кнопка "Зарегистрироваться"
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    // Подсказка "Некорректный пароль"
    public By IncorrectPasswordHint = By.xpath(".//p[text()='Некорректный пароль']");
    //Гиперссылка "Войти"
    private final By loginHyperlink = By.xpath(".//a[text() = 'Войти']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Описание действий на странице регистрации
     */
    @Step("Найти элемент для подтверждения перехода на страницу регистрации")
    public Boolean registrationHeaderDisplayed() {
        return driver.findElement(registrationHeader).isDisplayed();
    }

    @Step("Ввести имя в поле Имя")
    public void nameInput(String newName) {
        driver.findElement(nameField).sendKeys(newName);
    }

    @Step("Ввести адрес почты в поле Email")
    public void emailInput(String newEmail) {
        driver.findElement(emailField).sendKeys(newEmail);
    }

    @Step("Ввести пароль в поле Пароль")
    public void passwordInput(String newPassword) {
        driver.findElement(passwordField).sendKeys(newPassword);
    }

    @Step("Нажать на кнопку Зарегистрироваться")
    public void registrationClick() {
        driver.findElement(registerButton).click();
    }

    @Step("Нажать на гиперссылку Войти")
    public void loginClick() {
        driver.findElement(loginHyperlink).click();
    }

    @Step("Найти подсказку, отображающуюся при вводе некорректного пароля")
    public Boolean incorrectPasswordHintDisplayed() {
        return driver.findElement(IncorrectPasswordHint).isDisplayed();
    }

    @Step("Регистрация пользователя")
    public void registrationUser(String name, String email, String password) {
        nameInput(name);
        emailInput(email);
        passwordInput(password);
        registrationClick();
    }
}