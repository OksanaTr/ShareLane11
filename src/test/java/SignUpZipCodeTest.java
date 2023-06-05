import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignUpZipCodeTest {

    @Test
    public void zipCodeShouldAccept5Digits() {

        //Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //ОТКРЫТЬ СТРАНИЦУ https://www.sharelane.com/cgi-bin/register.py
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        //ВВЕСТИ ЛЮБЫЕ 5 ЦИФР (12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");

        //НАЖАТЬ КНОПКУ CONTINUE
        //driver.findElement(By.name("zip_code")).submit();
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        //УБЕДИТЬСЯ ЧТО МЫ НА СТРАНИЦЕ SIGN UP
        boolean isOpened = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        assertTrue(isOpened, "Страница регистрации не открылась");

        //ЗАКРЫТЬ БРАУЗЕР.
        driver.quit();
    }

    @Test
    public void zipCodeShouldNotAccept6Digits() {

        //Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //ОТКРЫТЬ СТРАНИЦУ https://www.sharelane.com/cgi-bin/register.py
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        //ВВЕСТИ ЛЮБЫЕ 6 ЦИФР (123456)
        driver.findElement(By.name("zip_code")).sendKeys("123456");

        //НАЖАТЬ КНОПКУ CONTINUE
        //driver.findElement(By.name("zip_code")).submit();
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();

        assertEquals(error,
                "Oops, error on page. ZIP code should have 5 digits",
                "Сообщение об ошибке Zip code неверное");

        //ЗАКРЫТЬ БРАУЗЕР.
        driver.quit();
    }

    @Test
    public void zipCodeShouldNotAccept4Digits() {

        //Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //ОТКРЫТЬ СТРАНИЦУ https://www.sharelane.com/cgi-bin/register.py
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        //ВВЕСТИ ЛЮБЫЕ 4 ЦИФР (1234)
        driver.findElement(By.name("zip_code")).sendKeys("1234");

        //НАЖАТЬ КНОПКУ CONTINUE
        //driver.findElement(By.name("zip_code")).submit();
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();

        assertEquals(error,
                "Oops, error on page. ZIP code should have 5 digits",
                "Сообщение об ошибке Zip code неверное");

        //ЗАКРЫТЬ БРАУЗЕР.
        driver.quit();
    }
    @Test
    public void zipCodeShouldNotAcceptEmpty() {

        //Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //ОТКРЫТЬ СТРАНИЦУ https://www.sharelane.com/cgi-bin/register.py
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        //Оставить поле пустым
        driver.findElement(By.name("zip_code")).sendKeys("");

        //НАЖАТЬ КНОПКУ CONTINUE
        //driver.findElement(By.name("zip_code")).submit();
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();

        assertEquals(error,
                "Oops, error on page. ZIP code should have 5 digits",
                "Сообщение об ошибке Zip code неверное");

        //ЗАКРЫТЬ БРАУЗЕР.
        driver.quit();
    }

    @Test
    public void successfulSignUp() {

        //Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //ОТКРЫТЬ СТРАНИЦУ https://www.sharelane.com/cgi-bin/register.py
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        //ВВЕСТИ ЛЮБЫЕ 5 ЦИФР (12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");

        //НАЖАТЬ КНОПКУ CONTINUE
        //driver.findElement(By.name("zip_code")).submit();
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //ЗАПОЛНЯЕМ ФОРМУ
        //name="first_name"
        driver.findElement(By.name("first_name")).sendKeys("SERGEI");
        // name="last_name"
        driver.findElement(By.name("last_name")).sendKeys("TEST");
        //name = "email"
        driver.findElement(By.name("email")).sendKeys("test@test.com");
        //name = "password1"
        driver.findElement(By.name("password1")).sendKeys("1234");
        //name = "password2"
        driver.findElement(By.name("password2")).sendKeys("1234");

        //НАЖАТЬ КНОПКУ REGISTER
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // ПРОВЕРКА УСПЕШНОЙ РЕГИСТРАЦИИ
        String success = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        assertEquals(success,
                "Account is created!",
                "Аккаунт не создан");


        //ЗАКРЫТЬ БРАУЗЕР.
        driver.quit();
    }
}
