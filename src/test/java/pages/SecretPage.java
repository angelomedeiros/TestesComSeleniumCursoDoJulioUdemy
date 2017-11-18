package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecretPage extends BasePage{

    public SecretPage(WebDriver navegador) {
        super(navegador);
    }

    public Me clickHiUser(){
        navegador.findElement(By.linkText("Hi, Julio")).click();
        return new Me(navegador);
    }

}
