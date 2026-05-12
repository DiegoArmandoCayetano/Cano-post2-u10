package e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NuevaTareaPage {

    private final WebDriver driver;

    private final By txtTitulo = By.id("titulo");
    private final By btnGuardar = By.id("btn-guardar");

    public NuevaTareaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void escribirTitulo(String titulo) {
        driver.findElement(txtTitulo).sendKeys(titulo);
    }

    public void guardar() {
        driver.findElement(btnGuardar).click();
    }
}