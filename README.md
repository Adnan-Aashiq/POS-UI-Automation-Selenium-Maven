# Selenium UI Automation Maven Project
Below is the IDE run of the Project

https://github.com/user-attachments/assets/c4c85f80-43b7-4b9b-a1de-8c6db9b5c818

## Project Overview
This project is a Selenium-based UI automation framework using Maven, designed for end-to-end testing of web applications. The framework supports test execution and generates detailed ExtentReports.

---

## Prerequisites
Before cloning and running this project, ensure the following are installed on your machine:
1. **Java Development Kit (JDK)** (Version 8 or higher)
2. **Apache Maven** (Verify installation by running `mvn -version` in the terminal)
3. **ChromeDriver/GeckoDriver** (Matching the browser version installed on your machine)
4. **Git** (For cloning the repository)

---

## Clone and Setup Instructions

### 1. Clone the Repository
Run the following commands in your terminal to clone the code:
```bash
git clone https://github.com/Adnan-Aashiq/POS-UI-Automation-Selenium-Maven.git
```

Goto the Project diretory like the below command that will let you go to the Project directory.
```bash
cd POS-UI-Automation-Selenium-Maven
```

This command will install all the local dependencies
```bash
mvn dependency:purge-local-repository 
```

### 2. Run Maven Commands
Clean, compile, and test the project using Maven:
```bash
mvn clean install
mvn test
```
### 3. View the Test Reports
After running the tests, navigate to the Project folder and open the extentReports.html file in a browser to view detailed execution results.
