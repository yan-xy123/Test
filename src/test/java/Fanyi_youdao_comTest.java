import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

import static org.junit.Assert.*;

public class Fanyi_youdao_comTest {
    static {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\xiehong\\Downloads\\chromedriver.exe");
    }
    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() throws Exception {
        driver.get("http://fanyi.youdao.com/");
    }
    @Test
    public void webTest1() throws InterruptedException {
        String currentHandle = driver.getWindowHandle();
        WebElement element1 = driver.findElement(By.id("inputOriginal"));
        //文本框输入
        driver.findElement(By.className("i-know")).click();
        element1.sendKeys("软件测试");
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("body>div.fanyi>div.fanyi__input>div.input__target>div.fanyi__input__bg>div.input__target__dict>a")).click();
        Thread.sleep(4000);
        Set<String> allHandles = driver.getWindowHandles();
        for (String s : allHandles) {
            if (s.equals(currentHandle))
                continue;
            else {
                driver.switchTo().window(s);
            }
        }
        driver.findElement(By.xpath("/html/body/div[7]/i/a[1]")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#webTrans>h3>span>a:nth-child(2)>span")).click();
        Thread.sleep(4000);
        Assert.assertEquals("http://dict.youdao.com/search?q=%E8%BD%AF%E4%BB%B6%E6%B5%8B%E8%AF%95&keyfrom=new-fanyi.smartResult",driver.getCurrentUrl());
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}