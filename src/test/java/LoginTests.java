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
import page.PasswordRecoveryPage;
import page.RegistrationPage;

@RunWith(Parameterized.class)
public class LoginTests extends BaseTest {
    private final MainPage mainPage = new MainPage(driver);
    private final LoginPage loginPage = new LoginPage(driver);
    private final RegistrationPage registerPage = new RegistrationPage(driver);
    private final PasswordRecoveryPage recoveryPage = new PasswordRecoveryPage(driver);

    public LoginTests(String browserDriver) {
        super(browserDriver);
    }

    @Before
    public void setUp() {
        specification.createUser(new UserCreateDto(EMAIL, PASSWORD_VALID, NAME));
    }

    @Test
    @DisplayName("Авторизация пользователя - вход по кнопке «Войти в аккаунт» на главной")
    @Description("Проверка авторизации пользователя по кнопке «Войти в аккаунт» на главной")
    public void loginViaButtonSignInAccount() {
        mainPage.loginClick();
        loginPage.authorizationUser(EMAIL, PASSWORD_VALID);
        Assert.assertTrue(mainPage.checkoutButtonDisplayed());
    }

    @Test
    @DisplayName("Авторизация пользователя - вход через кнопку «Личный кабинет»")
    @Description("Проверка авторизации пользователя через кнопку «Личный кабинет»")
    public void loginViaButtonPersonalAccount() {
        mainPage.profileHeaderLinkClick();
        loginPage.authorizationUser(EMAIL, PASSWORD_VALID);
        Assert.assertTrue(mainPage.checkoutButtonDisplayed());
    }

    @Test
    @DisplayName("Авторизация пользователя - вход через кнопку в форме регистрации")
    @Description("Проверка авторизации пользователя через кнопку в форме регистрации")
    public void loginViaRegistrationForm() {
        mainPage.loginClick();
        loginPage.registerClick();
        registerPage.loginClick();
        loginPage.authorizationUser(EMAIL, PASSWORD_VALID);
        Assert.assertTrue(mainPage.checkoutButtonDisplayed());
    }

    @Test
    @DisplayName("Авторизация пользователя - вход через кнопку в форме восстановления пароля")
    @Description("Проверка авторизации пользователя через кнопку в форме восстановления пароля")
    public void loginViaRecoveryForm() {
        mainPage.loginClick();
        loginPage.passwordRestoreClick();
        recoveryPage.loginClick();
        loginPage.authorizationUser(EMAIL, PASSWORD_VALID);
        Assert.assertTrue(mainPage.checkoutButtonDisplayed());
    }
}