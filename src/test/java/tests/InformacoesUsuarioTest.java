package tests;

import static org.junit.Assert.*;

import Suporte.Generator;
import Suporte.Screenshot;
import Suporte.Web;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioTest.csv")

public class InformacoesUsuarioTest {

    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();

    @Before
    public void SetUp() {
        navegador = Web.createChrome();

        // Clicar no link com texto "Sign in"
        WebElement linkSignIn = navegador.findElement(By.linkText("Sign in"));
        linkSignIn.click();

        // Indentificando o formulario de login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        // Digitar no campo com name "login" que está dentro do formulário de id "signinbox" o texto "julio0001"

        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

        // Digitar no campo com name "password" que está dentro do formulário de id "signinbox" o texto "123456"

        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        // Clicar no link com texto "SIGN IN"

        formularioSignInBox.findElement(By.linkText("SIGN IN")).click();

        // Validar que dentro do elemento com class "me" está como texto "Hi, Julio"

//        WebElement me = navegador.findElement(By.className("me"));
//        String textoNoElementoMe = me.getText().toLowerCase();
//        assertEquals("hi, julio",textoNoElementoMe);

        // Clicar no link com texto "Hi, Julio"

        navegador.findElement(By.linkText("Hi, Julio")).click();

        // Clicar no link com texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
    }


    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(
            @Param(name="type")String tipo,
            @Param(name="contact")String contato,
            @Param(name="mensagem")String mensagemEsperada
    ) {

        // Clicar no button com xpath "//button[@data-target="addmoredata"]"
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        // Identificar o popup de id "addmoredata"
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        // No select de name "type" escolher a opção "Phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));

        // Método para manipular select
        new Select(campoType).selectByVisibleText(tipo);

        // No campo de name "contact" digitar "+5583986000000
        popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);

        // Clicar no link de text "SAVE" que está na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        // Validar no id de "toast-container" que o texto é "Your contact has been added!"
        WebElement mensagemPopup = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPopup.getText();
        assertEquals(mensagemEsperada, mensagem);

        // Validando teste!
        // Assert.assertEquals( 1,2); // Se no import for -> import org.junit.Assert;
        // assertEquals(1, 1);
    }

    @Test
    public void removerContato() {
        // Remover +55123456
        navegador.findElement(By.xpath("//span[text()=\"+vaisefuder\"]/following-sibling::a")).click();

        // Confirmar na janela js
        navegador.switchTo().alert().accept();

        // Validar que a mensagem foi Rest in peace, dear phone!
        WebElement mensagemPopup = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPopup.getText();
        assertEquals("Rest in peace, dear phone!", mensagem);

        // Tirar Screenshot

        String screenshotArquivo = "/home/angelo/IdeaProjects/webdriverJava/screenshot/" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirarScreenshot(navegador, screenshotArquivo);

        // aguardar 10s que a jenla desapareça
        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemPopup));

        // Deslogar
        navegador.findElement(By.linkText("Logout")).click();

    }

    @After
    public void tearDown() {
        // Fechar navegador;
        navegador.quit();
    }
}

