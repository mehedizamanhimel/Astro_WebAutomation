# Astro_WebAutomation

![Java](https://img.shields.io/badge/Java-11-blue) ![Selenium](https://img.shields.io/badge/Selenium-4.x-green) ![TestNG](https://img.shields.io/badge/TestNG-7.x-orange) ![Maven](https://img.shields.io/badge/Build-Maven-red)

A web automation test assignment targeting the **Astro** platform. Built with Selenium WebDriver and TestNG using the Page Object Model (Page Factory) pattern. Test data is managed centrally via a properties file.

---

## 🛠 Tech Stack

| Tool | Details |
|---|---|
| Java | 11 |
| Selenium WebDriver | 4.x |
| TestNG | 7.x |
| Maven | 3.x |
| Pattern | Page Object Model (Page Factory) |
| Test Data | Properties file |

---

## 📁 Project Structure

```
src/
├── main/java/
│   ├── page/           → Page classes with WebElements and actions
│   └── util/           → TestProperties (centralized test data)
├── test/java/
│   └── tests/          → Test execution classes
└── test/resources/
    └── config.properties
```

---

## ⚙️ Prerequisites

- Java JDK 11+
- Maven 3.x
- IDE: IntelliJ IDEA or Eclipse
- Chrome, Firefox, or Edge browser installed

---

## ▶️ How to Run

### Via Command Line

```bash
# Clone the project
git clone https://github.com/mehedizamanhimel/Astro_WebAutomation.git
cd Astro_WebAutomation

# Run all tests
mvn clean test

# Run via TestNG XML
mvn test -DsuiteXmlFile=testng.xml
```

### Via IDE

1. Open the project by navigating to `pom.xml` in IntelliJ IDEA or Eclipse
2. Select **Open as Project** if prompted, and trust the project
3. Right-click any test class → Run, or run `testng.xml`

> Browser can be changed via `config.properties`.

---

## ✅ Test Coverage

- Astro platform login and authentication
- Navigation and page element validation
- User interaction flows

---

## 📊 Reports

After execution, test reports are available at:

```
output/index.html
```

Open in any browser for full detailed results.
