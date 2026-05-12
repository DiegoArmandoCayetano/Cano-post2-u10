package e2e;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.assertj.core.api.Assertions.assertThat;

class TareasE2ETest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");
        options.addArguments("--no-sandbox");

        driver = new ChromeDriver(options);

        driver.get("http://localhost:8080/tareas");
    }

    @Test
    void paginaTareas_cargaCorrectamente() {

        assertThat(driver.getTitle())
                .contains("Tareas");
    }

    @Test
    void listaTareas_existe() {

        TareasPage tareasPage = new TareasPage(driver);

        assertThat(tareasPage.contarTareas())
                .isGreaterThanOrEqualTo(0);
    }

    @AfterEach
    void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}