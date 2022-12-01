import com.sun.source.tree.AssertTree;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

@TestInstance(Lifecycle.PER_CLASS)
public class NewPageTest {

  WebDriver webdriver;

  @BeforeAll
  public void setupAll(){
    System.setProperty("webdriver.chrome.driver",
        "src/test/resources/chromedriver.exe");
  }

  @BeforeEach
  public void setup(){
    webdriver = new ChromeDriver();
    webdriver.manage().window().maximize();
  }

  @AfterEach
  public void closeDriver(){
    webdriver.close();
  }


  @Test
  public void openNewPage(){
    webdriver.get("https://www.youtube.com");
    Assertions.assertEquals("https://www.youtube.com/",
        webdriver.getCurrentUrl());
  }

  @Test
  public void openAjudaPage(){
    webdriver.get("https://www.youtube.com/");
    WebElement botao = webdriver.findElement(
        By.xpath("//*[@id=\"guide-icon\"]"));
    botao.click();
    Assertions.assertTrue(botao.isEnabled());

  }

  @Test
  public void openProduct(){
    webdriver.get("https://shop.samsung.com/br");
    WebElement botaoFB = webdriver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[1]/a/div/img"));
    botaoFB.click();
    Assertions.assertEquals("https://shop.samsung.com/br/lava-e-seca-wd13t-13kg-branca-1953/p?skuId=2738",
                webdriver.getCurrentUrl());
  }

  @Test
  public void moverBotao(){
    webdriver.get("https://shop.samsung.com/br");
    Actions actions = new Actions(webdriver);
    WebElement botao = webdriver.findElement(
        By.xpath("//*[@id=\"headerSamsung\"]/div[2]/div/div/a"));
    actions.moveToElement(botao).perform();
  }



  @Test
  public void tooltipTest(){
    webdriver.get("https://shop.samsung.com/br");
    Actions actions = new Actions(webdriver);

    WebElement carrinho = webdriver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/ul[2]/li[3]/aside/div/div/button/div/span"));
    actions.moveToElement(carrinho).perform();
    Assertions.assertTrue(carrinho.isDisplayed());
  }


}
