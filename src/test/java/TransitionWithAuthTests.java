import domain.UserCreateDto;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.LoginPage;
import page.MainPage;
import page.ProfilePage;

@RunWith(Parameterized.class)
public class TransitionWithAuthTests extends BaseTest {
    private final MainPage mainPage = new MainPage(driver);
    private final LoginPage loginPage = new LoginPage(driver);
    private final ProfilePage profilePage = new ProfilePage(driver);

    public TransitionWithAuthTests(String browserDriver) {
        super(browserDriver);
    }

    @Before
    public void setUp() {
        specification.createUser(new UserCreateDto(EMAIL, PASSWORD_VALID, NAME));
    }

    @Test
    @DisplayName("Переход по страницам - переход c авторизацией Главная страница -> Личный кабинет")
    @Description("Проверка перехода c авторизацией Главная страница -> Личный кабинет")
    public void transitionFromMainToAccountWithAuth() {
        mainPage.loginClick();
        loginPage.authorizationUser(EMAIL, PASSWORD_VALID);
        mainPage.profileHeaderLinkClick();
        Assert.assertTrue(profilePage.textInPersonalAccount());
    }

    @Test
    @DisplayName("Переход по страницам - переход с авторизацией Личный кабинет -> Конструктор")
    @Description("Проверка перехода с авторизацией Личный кабинет -> Конструктор")
    public void transitionFromAccountToConstructorWithAuth() {
        mainPage.loginClick();
        loginPage.authorizationUser(EMAIL, PASSWORD_VALID);
        mainPage.profileHeaderLinkClick();
        mainPage.constructorHeaderLinkClick();
        Assert.assertTrue(mainPage.constructorBurgerHeaderDisplayed());
    }

    @Test
    @DisplayName("Переход по страницам - переход с авторизацией Личный кабинет -> Логотип")
    @Description("Проверка перехода с авторизацией Личный кабинет -> Логотип")
    public void transitionFromAccountToLogoWithAuth() {
        mainPage.loginClick();
        loginPage.authorizationUser(EMAIL, PASSWORD_VALID);
        mainPage.profileHeaderLinkClick();
        mainPage.logoHeaderLinkClick();
        Assert.assertTrue(mainPage.constructorBurgerHeaderDisplayed());
    }

    @Test
    @DisplayName("Переход по страницам - переход с авторизацией в раздел Соусы в конструкторе")
    @Description("Проверка перехода с авторизацией в раздел Соусы в конструкторе")
    public void transitionToSaucesWithAuth() {
        mainPage.loginClick();
        loginPage.authorizationUser(EMAIL, PASSWORD_VALID);
        mainPage.constructorHeaderLinkClick();
        mainPage.saucesSectionClick();
        Assert.assertTrue(mainPage.saucesHeaderDisplayed());
    }

    @Test
    @DisplayName("Переход по страницам - переход с авторизацией в раздел Булки в конструкторе")
    @Description("Проверка перехода с авторизацией в раздел Булки в конструкторе")
    public void transitionToBunsWithAuth() {
        mainPage.loginClick();
        loginPage.authorizationUser(EMAIL, PASSWORD_VALID);
        mainPage.constructorHeaderLinkClick();
        mainPage.saucesSectionClick();
        mainPage.bunsSectionClick();
        Assert.assertTrue(mainPage.bunsHeaderDisplayed());
    }

    @Test
    @DisplayName("Переход по страницам - переход с авторизацией в раздел Начинки в конструкторе")
    @Description("Проверка перехода с авторизацией в раздел Начинки в конструкторе")
    public void transitionToFillingsWithAuth() {
        mainPage.loginClick();
        loginPage.authorizationUser(EMAIL, PASSWORD_VALID);
        mainPage.constructorHeaderLinkClick();
        mainPage.fillingsSectionClick();
        Assert.assertTrue(mainPage.fillingsHeaderDisplayed());
    }
}