package pages;

import helpers.ParametersProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.Assert;

import static java.lang.String.format;

/**
 * Базовый класс эрана приложения
 */
@Getter
public abstract class BasePage {
    /**
     * Android драйвер
     */
    protected AndroidDriver driver;

    /**
     * Разрешение экрана
     */
    private Dimension window;

    /**
     * Время ожидания открытия экрана
     */
    protected final static int pageTimeout =
            Integer.valueOf(ParametersProvider.getPropertyByName("explicitTimeout")) * 1000;

    protected final String byTextLocator = "//*[@text='%s']";

    /**
     * Конструктор класса.
     *
     * @param driver драйвер
     */
    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        window = driver.manage().window().getSize();
    }

    /**
     * Получение размера окна устройства
     *
     * @return размер окна устройства
     */
    public Dimension getWindowSize() {
        return window;
    }

    /**
     * Проверка отображения элемента
     *
     * @param elementName название элемента
     * @param element     нужный элемент
     */
    protected final void checkElementPresent(final String elementName,
                                             final AndroidElement element) {
        Assert.assertTrue(element.isDisplayed(), format(ParametersProvider.getPropertyByName("elementNotPresentError"), elementName) +
                format(ParametersProvider.getPropertyByName("afterWaitingTimeSuffix"),
                        ParametersProvider.getPropertyByName("progressBarTimeout")));
    }

    /**
     * Проверка отображения элемента
     *
     * @param elementName название элемента
     * @param locator     локатор нужного элемента
     */
    protected final void checkElementPresent(final String elementName,
                                             final By locator) {
        checkElementPresent(elementName, (AndroidElement) driver.findElement(locator));
    }

    /**
     * Проверка соответствия текста элемента ожидаемому
     *
     * @param elementName  название элемента
     * @param element      элемент
     * @param expectedText ожидаемый текст
     */
    protected final void checkElementText(final String elementName,
                                          final AndroidElement element,
                                          final String expectedText) {
        checkElementPresent(elementName, element);
        Assert.assertTrue(element.getText().equals(expectedText),
                format(ParametersProvider.getPropertyByName("textsNotEqualError"), elementName, element.getText(), expectedText));
    }

    /**
     * Проверка соответствия текста элемента ожидаемому
     *
     * @param elementName  название элемента
     * @param locator      элемент
     * @param expectedText ожидаемый текст
     */
    protected final void checkElementText(final String elementName,
                                          final By locator,
                                          final String expectedText) {
        checkElementPresent(elementName, locator);
        checkElementText(elementName, (AndroidElement) driver.findElement(locator), expectedText);
    }
}
