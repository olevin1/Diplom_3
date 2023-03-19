import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.LoginPage;
import page.MainPage;
import page.RegistrationPage;

@RunWith(Parameterized.class)
public class RegistrationTests extends BaseTest {
    MainPage mainPage = new MainPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    RegistrationPage registerPage = new RegistrationPage(driver);

    public RegistrationTests(String browserDriver) {
        super(browserDriver);
    }

    @Test
    @DisplayName("Регистрация пользователя - запрос с валидными данными")
    @Description("Проверка регистрации пользователя с валидными данными")
    public void successRegistration() {
        mainPage.loginClick();
        loginPage.registerClick();
        registerPage.registrationUser(NAME, EMAIL, PASSWORD_VALID);
        Assert.assertTrue(loginPage.loginHeaderDisplayed());
    }

    @Test
    @DisplayName("Регистрация пользователя - запрос с невалидными данными")
    @Description("Проверка невозможности регистрации пользователя с невалидным паролем (меньше 6 символов)")
    public void failRegistration() {
        mainPage.loginClick();
        loginPage.registerClick();
        registerPage.registrationUser(NAME, EMAIL, PASSWORD_INVALID);
        Assert.assertTrue(registerPage.incorrectPasswordHintDisplayed());
    }
}