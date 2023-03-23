package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    /**
     * Хедер сайта
     */
    // Кнопка "Конструктор"
    private final By constructorHeaderLink = By.xpath(".//a[@href='/']/p[text()='Конструктор']");
    // Логотип "Stellar Burgers"
    private final By logoHeaderLink = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    //Кнопка "Личный кабинет"
    private final By profileHeaderLink = By.xpath(".//a[@href='/account']/p[text()='Личный Кабинет']");
    /**
     * Конструктор
     */
    //Заголовок "Соберите бургер"
    private final By constructorBurgerHeader = By.xpath(".//h1[text()='Соберите бургер']");
    //Раздел "Булки"
    private final By bunsSection = By.xpath(".//div[./span[text()='Булки']]");
    //Раздел "Соусы"
    private final By saucesSection = By.xpath(".//div[./span[text()='Соусы']]");
    //Раздел "Начинки"
    private final By fillingsSection = By.xpath(".//div[./span[text()='Начинки']]");
    //Кнопка "Войти в аккаунт"
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    //Кнопка "Оформить заказ"
    private final By checkoutButton = By.xpath(".//button[text()='Оформить заказ']");
    //Заголовок раздела "Булки"
    private final By bunsHeader = By.xpath(".//h2[text()='Булки']");
    //Заголовок раздела "Соусы"
    private final By saucesHeader = By.xpath(".//h2[text()='Соусы']");
    //Заголовок раздела "Начинки"
    private final By fillingsHeader = By.xpath(".//h2[text()='Начинки']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Найти элемент для подтверждения успешного входа")
    public Boolean checkoutButtonDisplayed() {
        return driver.findElement(checkoutButton).isDisplayed();
    }

    @Step("Найти заголовок страницы конструктора")
    public Boolean constructorBurgerHeaderDisplayed() {
        return driver.findElement(constructorBurgerHeader).isDisplayed();
    }

    @Step("Нажать на кнопку Войти в аккаунт")
    public void loginClick() {
        driver.findElement(loginButton).click();
    }

    @Step("Нажать на кнопку Конструктор")
    public void constructorHeaderLinkClick() {
        driver.findElement(constructorHeaderLink).click();
    }

    @Step("Нажать на логотип")
    public void logoHeaderLinkClick() {
        driver.findElement(logoHeaderLink).click();
    }

    @Step("Нажать на кнопку Личный кабинет")
    public void profileHeaderLinkClick() {
        driver.findElement(profileHeaderLink).click();
    }

    @Step("Выбрать раздел Булки в конструкторе")
    public void bunsSectionClick() {
        driver.findElement(bunsSection).click();
    }

    @Step("Выбрать раздел Соусы в конструкторе")
    public void saucesSectionClick() {
        driver.findElement(saucesSection).click();
    }

    @Step("Выбрать раздел Начинки в конструкторе")
    public void fillingsSectionClick() {
        driver.findElement(fillingsSection).click();
    }

    @Step("Найти заголовок раздела Булки")
    public Boolean bunsHeaderDisplayed() {
        return driver.findElement(bunsHeader).isDisplayed();
    }

    @Step("Найти заголовок раздела Соусы")
    public Boolean saucesHeaderDisplayed() {
        return driver.findElement(saucesHeader).isDisplayed();
    }

    @Step("Найти заголовок раздела Начинки")
    public Boolean fillingsHeaderDisplayed() {
        return driver.findElement(fillingsHeader).isDisplayed();
    }
}