package helpers;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

/**
 * Фабрика для создания драйвера
 */
public final class DriverFactory {

    private DriverFactory() {}

    /**
     * Метод создания драйвера
     *
     * @throws IOException когда файл конфигурации недоступен
     */
    public static final AndroidDriver createDriver() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", ParametersProvider.getPropertyByName("deviceName"));
        capabilities.setCapability("platformName", ParametersProvider.getPropertyByName("platformName"));
        capabilities.setCapability("platformVersion", ParametersProvider.getPropertyByName("platformVersion"));

        capabilities.setCapability("noSign", true);
        capabilities.setCapability("newCommandTimeout", ParametersProvider.getPropertyByName("newCommandTimeout"));
        capabilities.setCapability("automationName", ParametersProvider.getPropertyByName("automationName"));
        capabilities.setCapability("appium:appWaitForLaunch", false);
        capabilities.setCapability("appium:adbExecTimeout", ParametersProvider.getPropertyByName("adbExecTimeout"));
        capabilities.setCapability("noReset", "false");

        return new AndroidDriver<>(new URL(ParametersProvider.getPropertyByName("appiumUrl")), capabilities);
    }
}
