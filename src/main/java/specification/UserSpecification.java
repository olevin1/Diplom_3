package specification;

import domain.UserCreateDto;
import domain.UserLoginDto;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class UserSpecification extends BasicSpecification {
    private static final String CREATE_USER_PATH = "/api/auth/register";
    private static final String AUTH_USER_PATH = "/api/auth/login";
    private static final String DELETE_USER_PATH = "/api/auth/user";

    @Step("Создать пользователя")
    public void createUser(UserCreateDto user) {
        given()
                .spec(baseSpec())
                .and()
                .body(user)
                .when()
                .post(CREATE_USER_PATH)
                .then()
                .assertThat().body("success", is(true));
    }

    @Step("Авторизоваться в системе")
    public ValidatableResponse loginUser(UserLoginDto user) {
        return given()
                .spec(baseSpec())
                .and()
                .body(user)
                .when()
                .post(AUTH_USER_PATH)
                .then()
                .assertThat().body("success", is(true));
    }

    @Step("Получить токен пользователя")
    public String getAccessToken(UserLoginDto user) {
        return given()
                .spec(baseSpec())
                .and()
                .body(user)
                .when()
                .post(AUTH_USER_PATH)
                .then().extract().body().path("accessToken");
    }

    @Step("Удалить пользователя")
    public void deleteUser(UserLoginDto user) {
        String accessToken = getAccessToken(user);
        if (accessToken != null) {
            given()
                    .header("Authorization", accessToken)
                    .spec(baseSpec())
                    .and()
                    .delete(DELETE_USER_PATH)
                    .then()
                    .assertThat().body("success", is(true));
        }
    }
}