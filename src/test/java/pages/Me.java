package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Me extends BasePage{

    public Me(WebDriver navegador) {
        super(navegador);
    }

//    Herdado da Classe BasePage
//    private WebDriver navegador;
//
//    public Me(WebDriver navegador){
//        this.navegador = navegador;
//    }

    public Me clickMoreDataAboutYou(){
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
        return this;
    }

    public PageAddMoreData clickAddMoreAddAboutMe(){
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
        return new PageAddMoreData(navegador);
    }
}
