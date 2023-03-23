import domain.UserLoginDto;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import client.UserClient;

import java.time.Duration;


public abstract class BaseTest {
    protected static String NAME = RandomStringUtils.randomAlphanumeric(5, 10);
    protected static String EMAIL = RandomStringUtils.randomAlphanumeric(5, 10) + "@yandex.ru";
    protected static String PASSWORD_VALID = RandomStringUtils.randomAlphanumeric(6, 10);
    protected final static String PASSWORD_INVALID = RandomStringUtils.randomAlphanumeric(1, 5);
    protected final WebDriver driver;
    protected final UserClient specification = new UserClient();

    public BaseTest(String browserDriver) {
        System.setProperty(
                "webdriver.chrome.driver",
                "src\\main\\resources\\" + browserDriver + ".exe"
        );
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Parameterized.Parameters(name = "driver: {0}")
    public static Object[][] getDriver() {
        return new Object[][]{
                {"chromedriver"},
                {"yandexdriver"}
        };
    }

    @After
    public void tearDown() {
        driver.quit();
        specification.deleteUser(new UserLoginDto(EMAIL, PASSWORD_VALID));
    }
}