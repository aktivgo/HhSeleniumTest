import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MoreTvRegAuthTest {
    WebDriver driver;
    final String URL = "https://more.tv/";

    final String email = "aktivgo010620011@gmail.com";
    final String password = "0192837465";

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(URL);

        clickCloseTest();

        titleTest();
        clickSignInTest();
        clickSignUpTest();
        inputEmailTest();
        clickContinueTest();
        inputPasswordTest();
        clickCreateAccountTest();
    }

    public void titleTest() {
        Assert.assertEquals(driver.getTitle(), "Онлайн-сервис more.tv");
    }

    public void clickCloseTest() throws InterruptedException {
        var closeButton = driver
                .findElement(By.xpath("//img[@class='Offer-module__Close--7dyI2']"));
        Assert.assertNotNull(closeButton);
        closeButton.click();

        Thread.sleep(1000);
    }

    public void clickSignInTest() throws InterruptedException {
        var signinButton = driver
                .findElement(By.xpath("//a[@class='index-module__link--0IPrm HeaderView-module__subscribeBtn--Syo+y Button-module__text-white--KbFNk Button-module__bg-blue--h0yoI Button-module__noLabel--dOe5s Button-module__Button--z6EB4']"));
        Assert.assertNotNull(signinButton);
        signinButton.click();
        Thread.sleep(1000);

        signinButton = driver.findElement(By.xpath("//a[@class='index-module__link--0IPrm Subscription-module__affixButton--UeaQF Button-module__text-white--KbFNk Button-module__noLabel--dOe5s Button-module__Button--z6EB4']"));
        Assert.assertNotNull(signinButton);
        signinButton.click();

        Thread.sleep(3000);
    }

    public void clickSignUpTest() throws InterruptedException {
        var signupButton = driver
                .findElements(By.xpath("//div[@class='index-module__link--B7TIM']")).get(1);
        Assert.assertNotNull(signupButton);
        signupButton.click();

        Thread.sleep(1000);
    }

    public void inputEmailTest() throws InterruptedException {
        var email = driver.findElement(By.xpath("//input[@class='index-module__input--paYAZ']"));
        Assert.assertNotNull(email);
        email.sendKeys(this.email);

        Thread.sleep(1000);
    }

    public void clickContinueTest() throws InterruptedException {
        var continueButton = driver
                .findElement(By.xpath("//button[@class='index-module__btn--akert index-module__form_btn--hIZ4B Button-module__text-white--KbFNk Button-module__bg-blue--h0yoI Button-module__hasLabel--c51nv Button-module__Button--z6EB4']"));
        Assert.assertNotNull(continueButton);
        continueButton.click();

        Thread.sleep(1000);
    }

    public void inputPasswordTest() throws InterruptedException {
        var password = driver.findElement(By.xpath("//input[@class='index-module__input--paYAZ']"));
        Assert.assertNotNull(password);
        password.sendKeys(this.password);

        Thread.sleep(1000);
    }

    public void clickCreateAccountTest() throws InterruptedException {
        var createAccountButton = driver
                .findElement(By.xpath("//button[@class='index-module__btn--akert index-module__form_btn--hIZ4B Button-module__text-white--KbFNk Button-module__bg-blue--h0yoI Button-module__hasLabel--c51nv Button-module__Button--z6EB4']"));
        Assert.assertNotNull(createAccountButton);
        createAccountButton.click();

        Thread.sleep(10000);
    }

    @After
    public void quit() {
        driver.quit();
    }
}