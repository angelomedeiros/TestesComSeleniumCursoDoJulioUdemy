package tests;

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
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioPageObjectTest.csv")

public class InformacoesUsuarioPageObjectTest {
    private WebDriver navegador;

    /*
     * 1ª Parte do PageObject:
     *
     * - Criar a variavel de instancia navegador como private;
     * - Chamar a o método criado na classe Web, responsavel por retornar
     * as configurações do navegador no before;
     * - Fechar o navegador no After;
     *
     * Obs: Na clase "Me" conceito de herança com a clase BasePage...
     *
     */

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp(){
        navegador = Web.createChrome();

        // navegador = Web.createBrowserStack();
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(
            @Param(name="tipo")String tipo,
            @Param(name="contato")String contato,
            @Param(name="mensagem")String mensagemEsperada
            ){

        String textoToast = new LoginPage(navegador)
                .clickSignIn()
                .autenticacao("julio0001","123456")
                .clickHiUser()
                .clickMoreDataAboutYou()
                .clickAddMoreAddAboutMe()
                .adicionarContato(tipo, contato)
                .capturarTextoToast();

        assertEquals(mensagemEsperada, textoToast);

        String screenshotArquivo = "/home/angelo/IdeaProjects/webdriverJava/screenshot/" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        System.out.println(test.getMethodName());
        Screenshot.tirarScreenshot(navegador, screenshotArquivo);
    }

    @After
    public void tearDown(){
        navegador.quit();
    }
}
