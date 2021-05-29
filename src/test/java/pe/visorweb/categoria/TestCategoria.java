package pe.visorweb.categoria;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.fail;

public class TestCategoria
{
    private static WebDriver driver;
    private String url = "http://localhost:8080/VisorWeb/index.xhtml";

    @Test
    public void testInsertarCategoriaExitosa(){
        try{
            //1. configurar el driver
            WebDriverManager.firefoxdriver().setup();
            //lo descarga y lo enlaza al proyecto para poder usarlo
            //2- instanciamos el driver
            driver = new FirefoxDriver();
            //3. maximizar el navegador
            driver.manage().window().maximize();

            //1.  cargar página visorweb
            driver.get(url);
            driver.findElement(By.id("txtUsuario")).clear();
            driver.findElement(By.id("txtUsuario")).sendKeys("admin");

            WebElement txtClave = driver.findElement(By.id("txtClave"));
            txtClave.clear();
            txtClave.sendKeys("clave");

        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }
    @Test
    public void testInsertarCategoriaDatosVacios(){
        System.out.println("Se ejecuta método insertarCategoriadatosvacios ");
    }
}
