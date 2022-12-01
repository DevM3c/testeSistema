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
        By.xpath("//*[@id=\"icon\"]"));
    botao.click();
    Assertions.assertTrue(botao.isEnabled());

  }
  @Test
  public void openPageFalse(){
    webdriver.get("");
    WebElement vendidos = webdriver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[3]"));
    vendidos.click();
    Assertions.assertFalse(vendidos.isEnabled(),"");

  }

  @Test
  public void openProduct(){
    webdriver.get("https://www.youtube.com/");
    WebElement botaoFB = webdriver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[1]/ytd-topbar-logo-renderer/a/ytd-yoodle-renderer/picture/img"));
    botaoFB.click();
    Assertions.assertEquals("https://www.youtube.com/?bp=wgUCEAE%3D",
                webdriver.getCurrentUrl());
  }

  @Test
  public void selectCadastroTest(){
    webdriver.get("https://vihhllopes.github.io/StudioMW-vihhllopes-willinny-s/cadastro.html");
    WebElement botaoSelect = webdriver.findElement(By.xpath("/html/body/div/fieldset/form/div[4]/select"));
    Select select = new Select(botaoSelect);
    select.selectByIndex(0);
    Assertions.assertTrue(botaoSelect.isEnabled());

  }


  @Test
  public void openPaginaCelular (){
    webdriver.get("https://www.youtube.com");

    WebElement search = webdriver.findElement(By.xpath("//*[@id=\"hover-overlays\"]"));

    search.sendKeys("musica");
    search.submit();



  }

  @Test
  public void moverBotao(){
    webdriver.get("https://www.youtube.com");
    Actions actions = new Actions(webdriver);
    WebElement botao = webdriver.findElement(
        By.xpath("/html/body/ytd-app/div[1]/ytd-mini-guide-renderer/div/ytd-mini-guide-entry-renderer[4]/a/span"));
    actions.moveToElement(botao).perform();
  }



  @Test
  public void tooltipTest(){
    webdriver.get("https://www.youtube.com");
    Actions actions = new Actions(webdriver);

    WebElement livros = webdriver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-mini-guide-renderer/div/ytd-mini-guide-entry-renderer[4]/a/span"));
    actions.moveToElement(livros).perform();
    Assertions.assertTrue(livros.isEnabled());
  }


}
