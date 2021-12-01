import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CdsVyatkaTest {
    WebDriver driver;
    final String URL = "https://m.cdsvyatka.com/";

    final int bus = 23;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(URL);

        titleTest();
        chooseBusTest();
        clickSearchButtonTest();
    }

    public void titleTest() {
        Assert.assertEquals(driver.getTitle(), "Мониторинг пассажирского транспорта в Кирове");
    }

    public void chooseBusTest() throws InterruptedException {
        var dataSelectables = driver.findElements(By.xpath("//option[@value='1023']"));
        Assert.assertNotNull(dataSelectables);
        dataSelectables.get(1).click();

        Thread.sleep(1000);
    }

    public void clickSearchButtonTest() throws InterruptedException {
        var searchButton = driver.findElements(By.xpath("//input[@value='Найти']")).get(1);
        searchButton.click();

        Thread.sleep(10000);
    }

    @After
    public void quit() {
        driver.quit();
    }
}