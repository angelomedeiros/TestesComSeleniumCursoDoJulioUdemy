package Suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {

    public static final String USERNAME = "angelomedeirosnb1";
    public static final String AUTOMATE_KEY = "jbmnaDsRGjfWoq2f1qEd";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createChrome() {
        // 1ª Parte do PageObject

        // Abrindo navegador
        System.setProperty("webdriver.chrome.driver", "/home/angelo/Testes/drivers/chromedriver");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.manage().window().maximize();

        navegador.get("http://www.juliodelima.com.br/taskit");
        return navegador;
    }

    public static WebDriver createBrowserStack(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Firefox");
        caps.setCapability("browser_version", "55.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "8.1");
        caps.setCapability("resolution", "1280x800");
        caps.setCapability("acceptSslCerts", "true");

        WebDriver navegador = null;

        try {
            navegador = new RemoteWebDriver(new URL(URL), caps);
            navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            navegador.get("http://www.juliodelima.com.br/taskit");
        } catch (MalformedURLException e){
            System.out.println("Houve problema com a url" + e.getMessage());
        }

        return navegador;
    }
}
