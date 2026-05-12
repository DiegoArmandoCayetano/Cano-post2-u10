# 🧪 Proyecto ToDoApp - Pruebas E2E, API y CI/CD

## 📌 Descripción

Este proyecto implementa pruebas automatizadas para una aplicación **Spring Boot ToDoApp**, utilizando:

- Selenium WebDriver (pruebas E2E)
- Page Object Model (POM)
- Postman (pruebas de API REST)
- Newman (ejecución por consola)
- GitHub Actions (CI/CD)

---

# ⚙️ Requisitos

Antes de ejecutar el proyecto asegúrate de tener instalado:

- Java 17+
- Maven 3+
- Node.js 18+
- Google Chrome (versión estable)
- Postman Desktop o Web
- Newman (instalar con npm)

```bash
npm install -g newman
🚀 Ejecución del proyecto Spring Boot

Ejecutar la aplicación localmente:

mvn spring-boot:run

La aplicación estará disponible en:

http://localhost:8080
🧪 1. Pruebas E2E con Selenium
📂 Ubicación
src/test/java/e2e
▶️ Ejecutar pruebas
mvn test
📌 Qué validan
Carga de la página de tareas
Interacción con la interfaz
Conteo de elementos
Flujo básico de navegación
🧱 Patrón usado

Page Object Model (POM)

Clases principales:

TareasPage
NuevaTareaPage
TareasE2ETest
📬 2. Pruebas API con Postman
📂 Ubicación
postman/
📌 Archivos incluidos
ColeccionToDo.json
env-local.json
env-ci.json
▶️ Ejecución en Postman Runner
Abrir Postman
Seleccionar colección "API ToDoApp"
Seleccionar entorno "ToDoApp-Local"
Ejecutar Runner

✔ Resultado esperado: 0 failures

📌 Requests incluidos
POST crear tarea
GET obtener tarea
PATCH completar tarea
GET verificar completada
GET tarea inexistente (404)
⚡ 3. Ejecución con Newman (CLI)
▶️ Ejecutar colección
newman run postman/ColeccionToDo.json --environment postman/env-local.json

✔ Resultado esperado: tests en verde sin errores

🔄 4. Integración continua con GitHub Actions
📂 Ubicación
.github/workflows/api-tests.yml
⚙️ Funcionalidad del pipeline

Cada push o pull request ejecuta:

Checkout del código
Configuración de Java 17
Compilación del proyecto
Ejecución del backend Spring Boot
Verificación del estado del servicio
Instalación de Newman
Ejecución de pruebas API
▶️ Ver resultados

Ir a:

GitHub → Actions

✔ Estado esperado: check verde (passing)
