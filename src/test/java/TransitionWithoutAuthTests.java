import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.LoginPage;
import page.MainPage;

@RunWith(Parameterized.class)
public class TransitionWithoutAuthTests extends BaseTest {
    private final MainPage mainPage = new MainPage(driver);
    private final LoginPage loginPage = new LoginPage(driver);

    public TransitionWithoutAuthTests(String browserDriver) {
        super(browserDriver);
    }

    @Test
    @DisplayName("Переход по страницам - переход без авторизации Главная страница -> Личный кабинет")
    @Description("Проверка перехода без авторизации Главная страница -> Личный кабинет")
    public void transitionFromMainToAccountWithAuth() {
        mainPage.profileHeaderLinkClick();
        Assert.assertTrue(loginPage.loginHeaderDisplayed());
    }

    @Test
    @DisplayName("Переход по страницам - переход без авторизации Личный кабинет -> Конструктор")
    @Description("Проверка перехода без авторизации Личный кабинет -> Конструктор")
    public void transitionFromAccountToConstructorWithAuth() {
        mainPage.profileHeaderLinkClick();
        mainPage.constructorHeaderLinkClick();
        Assert.assertTrue(mainPage.constructorBurgerHeaderDisplayed());
    }

    @Test
    @DisplayName("Переход по страницам - переход без авторизации Личный кабинет -> Логотип")
    @Description("Проверка перехода без авторизации Личный кабинет -> Логотип")
    public void transitionFromAccountToLogoWithAuth() {
        mainPage.profileHeaderLinkClick();
        mainPage.logoHeaderLinkClick();
        Assert.assertTrue(mainPage.constructorBurgerHeaderDisplayed());
    }

    @Test
    @DisplayName("Переход по страницам - переход без авторизации в раздел Соусы в конструкторе")
    @Description("Проверка перехода без авторизации в раздел Соусы в конструкторе")
    public void transitionToSaucesWithAuth() {
        mainPage.constructorHeaderLinkClick();
        mainPage.saucesSectionClick();
        Assert.assertTrue(mainPage.saucesHeaderDisplayed());
    }

    @Test
    @DisplayName("Переход по страницам - переход без авторизации в раздел Булки в конструкторе")
    @Description("Проверка перехода без авторизации в раздел Булки в конструкторе")
    public void transitionToBunsWithAuth() {
        mainPage.constructorHeaderLinkClick();
        mainPage.saucesSectionClick();
        mainPage.bunsSectionClick();
        Assert.assertTrue(mainPage.bunsHeaderDisplayed());
    }

    @Test
    @DisplayName("Переход по страницам - переход без авторизации в раздел Начинки в конструкторе")
    @Description("Проверка перехода без авторизации в раздел Начинки в конструкторе")
    public void transitionToFillingsWithAuth() {
        mainPage.constructorHeaderLinkClick();
        mainPage.fillingsSectionClick();
        Assert.assertTrue(mainPage.fillingsHeaderDisplayed());
    }
}