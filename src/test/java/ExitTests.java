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
public class ExitTests extends BaseTest {
    private final MainPage mainPage = new MainPage(driver);
    private final ProfilePage profilePage = new ProfilePage(driver);
    private final LoginPage loginPage = new LoginPage(driver);

    public ExitTests(String browserDriver) {
        super(browserDriver);
    }

    @Before
    public void setUp() {
        specification.createUser(new UserCreateDto(EMAIL, PASSWORD_VALID, NAME));
    }

    @Test
    @DisplayName("Выход из аккаунта - выход по кнопке «Выйти» в личном кабинете")
    @Description("Проверка выхода из аккаунта по кнопке «Выйти» в личном кабинете")
    public void logOutOfAccount() {
        mainPage.loginClick();
        loginPage.authorizationUser(EMAIL, PASSWORD_VALID);
        mainPage.profileHeaderLinkClick();
        profilePage.exitClick();
        Assert.assertTrue(loginPage.loginHeaderDisplayed());
    }
}