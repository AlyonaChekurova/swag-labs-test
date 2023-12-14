package tests;

import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Класс с тестами экрана авторизации
 */
public class LoginTests extends BaseTest{

    @Test(description = "Установка и открытие приложения")
    public void openAppTest() throws IOException {
        setUp();
        openLoginPage()
                .checkLoginPageOpened();
    }
}
