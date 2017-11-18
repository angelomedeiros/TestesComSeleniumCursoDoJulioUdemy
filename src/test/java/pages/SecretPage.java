package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecretPage {
    private WebDriver navegador;

    public SecretPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public Me clickHiUser(){
        navegador.findElement(By.linkText("Hi, Julio")).click();
        return new Me(navegador);
    }

}
