package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InformacoesUsuarioTest {

    private WebDriver navegador;

    @Before
    public void SetUp(){
        // Abrindo navegador
        System.setProperty("webdriver.chrome.driver", "/home/angelo/Testes/drivers/chromedriver");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        navegador.manage().window().maximize();
    }


    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {

        navegador.get("http://www.juliodelima.com.br/taskit");

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

        WebElement me = navegador.findElement(By.className("me"));
        String textoNoElementoMe = me.getText().toLowerCase();
        assertEquals("hi, julio",textoNoElementoMe);




        // Validando teste!
        // Assert.assertEquals( 1,2); // Se no import for -> import org.junit.Assert;
        // assertEquals(1, 1);
    }

    @After
    public void tearDown(){
        // Fechar navegador;
       // navegador.quit();
    }
}

