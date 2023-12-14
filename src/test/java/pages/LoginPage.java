package pages;

import helpers.ParametersProvider;
import io.appium.java_client.android.AndroidDriver;
import lombok.Getter;
import org.openqa.selenium.By;

/**
 * Экран авторизации
 */
@Getter
public class LoginPage extends BasePage{

    /**
     * Поле ввода логина
     */
    private final By loginInput = By.xpath("//android.widget.EditText[@content-desc='test-Username']");

    /**
     * Поле ввода пароля
     */
    private final By passwordInput = By.xpath("//android.widget.EditText[@content-desc='test-Password']");

    /**
     * Текст кнопки LOGIN
     */
    private final By loginButtonText = By.xpath("//android.view.ViewGroup[@content-desc='test-LOGIN']/android.widget.TextView");

    /**
     * Конструктор
     *
     * @param driver
     */
    public LoginPage(AndroidDriver driver){
        super(driver);
    }

    /**
     * Проверка открытия экрана авторизации
     * @return
     */
    public LoginPage checkLoginPageOpened() {
        checkElementText("Поле ввода логина", loginInput, ParametersProvider.getPropertyByName("loginPlaceholder"));
        checkElementText("Поле ввода пароля", passwordInput,
                ParametersProvider.getPropertyByName("passwordPlaceholder"));
        checkElementText("Кнопка LOGIN", loginButtonText, ParametersProvider.getPropertyByName("loginButtonPlaceholder"));

        return this;
    }
}
