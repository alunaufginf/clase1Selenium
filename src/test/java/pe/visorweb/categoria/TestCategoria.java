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

            WebElement btnIniciarSesion = driver.findElement(By.id("btnIniciarSesion"));
            btnIniciarSesion.click();

            //clic en el boton hamburguesa
            Thread.sleep(2000); //una demora de dos segundos
            driver.findElement(By.xpath("/html/body/section/div[1]/div")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/section/div[1]/nav/ul/li/span")).click();
            Thread.sleep(1000);
            driver.findElement(By.linkText("Mnt. de Categoría")).click();
            driver.findElement(By.id("btnNuevo")).click();
            driver.findElement(By.id("txtNombre")).clear();
            driver.findElement(By.id("txtNombre")).sendKeys("Selenium Web Driver2");
            driver.findElement(By.id("btnGuardar")).click();

            Thread.sleep(2000);

            String mensajeEsperado= "Se guardó de manera correcta la Categoría";
            String mensajeObtenido= driver.findElement(By.id("messages")).getText();

            //Es un punto de verificación, si son iguales los mensajes el TEST PASA
            assertEquals(mensajeEsperado, mensajeObtenido);

            driver.close();



        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }
    @Test
    public void testInsertarCategoriaDatosVacios(){
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

            WebElement btnIniciarSesion = driver.findElement(By.id("btnIniciarSesion"));
            btnIniciarSesion.click();

            //clic en el boton hamburguesa
            Thread.sleep(2000); //una demora de dos segundos
            driver.findElement(By.xpath("/html/body/section/div[1]/div")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/section/div[1]/nav/ul/li/span")).click();
            Thread.sleep(1000);
            driver.findElement(By.linkText("Mnt. de Categoría")).click();
            driver.findElement(By.id("btnNuevo")).click();
            driver.findElement(By.id("txtNombre")).clear();
         //   driver.findElement(By.id("txtNombre")).sendKeys("");
            driver.findElement(By.id("btnGuardar")).click();

            Thread.sleep(2000);

            String mensajeEsperado= "Nombre: Error de validación: se necesita un valor.";
            String mensajeObtenido= driver.findElement(By.id("messages")).getText();

            //Es un punto de verificación, si son iguales los mensajes el TEST PASA
            assertEquals(mensajeEsperado, mensajeObtenido);

            driver.close();



        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }
}
