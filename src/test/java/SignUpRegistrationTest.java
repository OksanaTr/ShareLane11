import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SignUpRegistrationTest {
    //#1 Positive case
    @Test
    public void enterValidDataForSignUp() {

        //Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //ОТКРЫТЬ СТРАНИЦУ https://www.sharelane.com/cgi-bin/register.py
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //ВВЕСТИ 5 ЦИФР (12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //НАЖАТЬ КНОПКУ CONTINUE
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //ЗАПОЛНЯЕМ ФОРМУ
        driver.findElement(By.name("first_name")).sendKeys("Vera");
        driver.findElement(By.name("last_name")).sendKeys("Ivanova");
        driver.findElement(By.name("email")).sendKeys("test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        //НАЖАТЬ КНОПКУ REGISTER
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // ПРОВЕРКА УСПЕШНОЙ РЕГИСТРАЦИИ
        String text = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        assertEquals(text,
                "Account is created!",
                "Аккаунт не создан");

        //ЗАКРЫТЬ БРАУЗЕР.
        driver.quit();
    }

    //Tests for First Name Field
    //#2
    @Test
    public void enterEmptyFirstName() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        //ЗАПОЛНЯЕМ ФОРМУ
        driver.findElement(By.name("last_name")).sendKeys("Ivanova");
        driver.findElement(By.name("email")).sendKeys("test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        //НАЖАТЬ КНОПКУ REGISTER
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // ПРОВЕРКА УСПЕШНОЙ РЕГИСТРАЦИИ
        String text = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(text,
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Форма с пустым полем First Name прошла регистрацию");
        //ЗАКРЫТЬ БРАУЗЕР.
        driver.quit();
    }

    //#3
    @Test
    public void enterRussianFirstName() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        //ЗАПОЛНЯЕМ ФОРМУ
        driver.findElement(By.name("first_name")).sendKeys("Вера");
        driver.findElement(By.name("last_name")).sendKeys("Ivanova");
        driver.findElement(By.name("email")).sendKeys("test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        //НАЖАТЬ КНОПКУ REGISTER
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // ПРОВЕРКА УСПЕШНОЙ РЕГИСТРАЦИИ
        String text = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(text,
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Форма с пустым полем First Name прошла регистрацию");
        //ЗАКРЫТЬ БРАУЗЕР.
        driver.quit();
    }

    //#4
    @Test
    public void enterSpaceInFirstName() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        //ЗАПОЛНЯЕМ ФОРМУ
        driver.findElement(By.name("first_name")).sendKeys(" ");
        driver.findElement(By.name("last_name")).sendKeys("Ivanova");
        driver.findElement(By.name("email")).sendKeys("test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        //НАЖАТЬ КНОПКУ REGISTER
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // ПРОВЕРКА УСПЕШНОЙ РЕГИСТРАЦИИ
        String text = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(text,
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Форма с пустым полем First Name прошла регистрацию");
        //ЗАКРЫТЬ БРАУЗЕР.
        driver.quit();
    }

    //Tests for Email Field
    //#5
    @Test
    public void enterEmptyEmail() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        //ЗАПОЛНЯЕМ ФОРМУ
        driver.findElement(By.name("first_name")).sendKeys("Vera");
        driver.findElement(By.name("last_name")).sendKeys("Ivanova");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        //НАЖАТЬ КНОПКУ REGISTER
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // ПРОВЕРКА УСПЕШНОЙ РЕГИСТРАЦИИ
        String text = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(text,
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Форма с пустым полем Email прошла регистрацию");
        //ЗАКРЫТЬ БРАУЗЕР.
        driver.quit();
    }

    //#6
    @Test
    public void enterEmailWithoutAt() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        //ЗАПОЛНЯЕМ ФОРМУ
        driver.findElement(By.name("first_name")).sendKeys("Vera");
        driver.findElement(By.name("last_name")).sendKeys("Ivanova");
        driver.findElement(By.name("email")).sendKeys("test.ru");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        //НАЖАТЬ КНОПКУ REGISTER
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // ПРОВЕРКА УСПЕШНОЙ РЕГИСТРАЦИИ
        String text = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(text,
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Форма с пустым полем Email прошла регистрацию");
        //ЗАКРЫТЬ БРАУЗЕР.
        driver.quit();
    }

    //#7
    @Test
    public void enterEmailWithoutDomain() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        //ЗАПОЛНЯЕМ ФОРМУ
        driver.findElement(By.name("first_name")).sendKeys("Vera");
        driver.findElement(By.name("last_name")).sendKeys("Ivanova");
        driver.findElement(By.name("email")).sendKeys("test@mail");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        //НАЖАТЬ КНОПКУ REGISTER
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // ПРОВЕРКА УСПЕШНОЙ РЕГИСТРАЦИИ
        String text = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(text,
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Форма с пустым полем Email прошла регистрацию");
        //ЗАКРЫТЬ БРАУЗЕР.
        driver.quit();
    }

    //Tests for Password fields
    //#8
    @Test
    public void enterEmptyPassword1() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        //ЗАПОЛНЯЕМ ФОРМУ
        driver.findElement(By.name("first_name")).sendKeys("Vera");
        driver.findElement(By.name("last_name")).sendKeys("Ivanova");
        driver.findElement(By.name("email")).sendKeys("test@test.com");
        driver.findElement(By.name("password2")).sendKeys("1234");
        //НАЖАТЬ КНОПКУ REGISTER
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // ПРОВЕРКА УСПЕШНОЙ РЕГИСТРАЦИИ
        String text = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(text,
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Форма с пустым полем Password прошла регистрацию");
        //ЗАКРЫТЬ БРАУЗЕР.
        driver.quit();
    }

    //#9
    @Test
    public void enretEmptyPassword2() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        //ЗАПОЛНЯЕМ ФОРМУ
        driver.findElement(By.name("first_name")).sendKeys("SERGEI");
        driver.findElement(By.name("last_name")).sendKeys("TEST");
        driver.findElement(By.name("email")).sendKeys("test@test.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        //НАЖАТЬ КНОПКУ REGISTER
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // ПРОВЕРКА УСПЕШНОЙ РЕГИСТРАЦИИ
        String text = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(text,
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Форма с пустым полем Confirm Password прошла регистрацию");
        //ЗАКРЫТЬ БРАУЗЕР.
        driver.quit();
    }

    //#10
    @Test
    public void enterUnequalPasswords() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        //ЗАПОЛНЯЕМ ФОРМУ
        driver.findElement(By.name("first_name")).sendKeys("SERGEI");
        driver.findElement(By.name("last_name")).sendKeys("TEST");
        driver.findElement(By.name("email")).sendKeys("test@test.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("4321");
        //НАЖАТЬ КНОПКУ REGISTER
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // ПРОВЕРКА УСПЕШНОЙ РЕГИСТРАЦИИ
        String text = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(text,
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Форма с пустым полем Confirm Password прошла регистрацию");
        //ЗАКРЫТЬ БРАУЗЕР.
        driver.quit();
    }


    //Privacy Tests
    //#12
    @Test
    public void password1FieldShouldHavePasswordType() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        //ЗАПОЛНЯЕМ ФОРМУ
        String attribute = driver.findElement(By.name("password1")).getAttribute("type");
        assertEquals(attribute, "password", "Поле Password незащищено атрибутом type=password");
        //ЗАКРЫТЬ БРАУЗЕР.
        driver.quit();
    }

    //#13
    @Test
    public void password2FieldShouldHavePasswordType() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        //ЗАПОЛНЯЕМ ФОРМУ
        String attribute = driver.findElement(By.name("password2")).getAttribute("type");
        assertEquals(attribute, "password", "Поле Confirm Password незащищено атрибутом type=password");
        //ЗАКРЫТЬ БРАУЗЕР.
        driver.quit();
    }

    //14
    @Test
    public void enterEmptyRegisterForm() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        //НАЖАТЬ КНОПКУ REGISTER
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // ПРОВЕРКА УСПЕШНОЙ РЕГИСТРАЦИИ
        String test = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(test,
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Пустая форма прошла регистрацию");
        //ЗАКРЫТЬ БРАУЗЕР.
        driver.quit();
    }
}
