# Route Optimisation Project (Java + Spring Boot)

This project provides a **route optimisation system** designed to reduce travel time in heavy-traffic conditions by generating efficient route paths.  
It is built using **Java (JDK 21)** and **Spring Boot**.

---

## Getting Started

Before running the project, make sure the required tools are installed.

---

## 1. Install Java (JDK 21)

Ensure **Java 21 (LTS)** is installed on your system.

Download JDK 21 from the official Oracle website:  
🔗 https://www.oracle.com/java/technologies/downloads/#jdk21-windows

### Set JAVA_HOME

1. Open **Environment Variables**  
2. Create a new system variable:
`JAVA_HOME=C:\Program Files\Java\jdk-21...`  
3. Edit the **Path** variable → Add:

### Verify installation

Run:

`java --version`  
  

It should display **Java 21.x.x**.


## 2. Install Maven (Optional but Recommended)

Maven is used for managing dependencies and running the project.

Download Maven:  
🔗 https://maven.apache.org

### Add Maven to PATH

Add this entry in **System Variables → Path**:

`C:\Program Files\Apache\Maven\bin`  
  

### Verify installation

run :  
`mvn -v`  
  

---

## 3. VS Code Setup

Install the following extensions in **VS Code**:

- **Java Extension Pack**
- **Extension Pack for Java**
- **Spring Boot Tools** (optional but useful)

---

## 4. Clone or Fork the Repository

### Option A: Fork the repository

1. Go to the project repo:  
   🔗 https://github.com/Abdullah-there/route-optimisation
2. Click **Fork**
3. Open your forked repo and copy the HTTPS link

---

### Option B: Clone the repository in VS Code

1. Open **VS Code**
2. Press **Ctrl + Shift + P**
3. Type: **Git: Clone**
  

5. Choose a folder → Open in VS Code

---

## Running the Application

You can run this project using Maven or using the VS Code debugger.

---

### Option 1: Run with Maven

`mvn spring-boot:run`  
  

---

### Option 2: Run without Maven (Through VS Code Debugger)

1. Open `BackendApplication.java`
2. Click **Run ▶** at the top
3. Or press **F5** to start the application

VS Code (Java Extension Pack) handles build and execution automatically.

--  

---

## Support

If you face issues, open an **Issue** in the GitHub repository.

---

## Repository Link

🔗 https://github.com/Abdullah-there/route-optimisation
