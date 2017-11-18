package tests;

import Suporte.Web;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class InformacoesUsuarioPageObjectTest {
    private WebDriver navegador;

    /*
     * 1ª Parte do PageObject:
     *
     * - Criar a variavel de instancia navegador como private;
     * - Chamar a o método criado na classe Web, responsavel por retornar
     * as configurações do navegador no before;
     * - Fechar o navegador no After;
     */
    
    @Before
    public void setUp(){
        navegador = Web.createChrome();
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){

    }

    @After
    public void tearDown(){
        navegador.quit();
    }
}
