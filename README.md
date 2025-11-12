# 🎓 Student Result Portal

A modern, full-featured web application for managing student academic results with role-based authentication. Built with Spring Boot, MySQL, and Thymeleaf.

![Java](https://img.shields.io/badge/Java-17+-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.4-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-9.5-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)

## 📖 About This Project

**Student Result Portal** is a full-stack web application designed to modernize academic result management in educational institutions. This comprehensive platform provides a secure, intuitive solution for both teachers and students to manage and access academic records efficiently.

### 🎯 Purpose

Traditional result management systems often struggle with security, accessibility, and user experience. This portal addresses these challenges by providing a role-based authentication system, automated grade calculation, and a modern, responsive interface that works seamlessly across all devices.

### ✨ Key Highlights

**For Teachers:**
- Upload and manage student results with automated grade calculation (A-F system)
- Comprehensive dashboard with real-time statistics and analytics
- Advanced search and filtering capabilities across all records
- Support for multiple classes and sections
- Secure role-based access control ensuring data integrity

**For Students:**
- Personalized dashboard displaying only relevant academic records
- Performance analytics including average marks, highest scores, and overall grades
- Subject-wise result history with easy filtering
- Real-time access to results without manual intervention

**Technical Excellence:**
- Built with industry-standard Spring Boot 3.5.4 framework
- MySQL database with Hibernate ORM for efficient data management
- Thymeleaf templating engine for dynamic, server-side rendering
- Session-based authentication with role-based access control (RBAC)
- Responsive design with CSS3 animations and vector illustrations
- Zero external image dependencies—all graphics created with pure CSS
- Automatic database schema creation and management

---

## ✨ Features

### 🔐 Authentication System
- **Role-Based Access Control**: Separate interfaces for Teachers and Students
- **Secure Login/Signup**: Session-based authentication
- **Password Protection**: Secure user credentials

### 👨‍🏫 Teacher Features
- Upload student results with marks, subject, class, and section
- View all student records in a beautiful dashboard
- Search students by name
- Delete and manage results
- Real-time grade calculation (A, B, C, D, F)
- Statistics overview (total records, subjects, students)

### 👨‍🎓 Student Features
- View personal results only
- Statistics dashboard (average marks, highest score, grade)
- Search through personal subjects
- Modern, responsive UI with animations

### 🎨 UI/UX
- Professional college-level gradient design
- CSS-based vector illustrations
- Smooth animations and transitions
- Responsive layout for all devices
- Color-coded grade badges

## 📋 Prerequisites

Before running this project, ensure you have the following installed based on your operating system:

### 1. **Java Development Kit (JDK)**
- **Version**: Java 17 or higher
- **Download**: 
  - [Oracle JDK](https://www.oracle.com/java/technologies/downloads/)
  - [OpenJDK](https://openjdk.org/)

### 2. **Apache Maven**
- **Version**: Maven 3.6 or higher
- **Download**: [Maven Official Website](https://maven.apache.org/download.cgi)
- **Note**: This project includes Maven Wrapper (`mvnw`), so Maven installation is optional.

### 3. **MySQL Database**
- **Version**: MySQL 8.0 or higher
- **Download**: [MySQL Community Server](https://dev.mysql.com/downloads/mysql/)

### 4. **Git** (Optional, for cloning)
- **Download**: [Git Official Website](https://git-scm.com/downloads)

### 5. **IDE** (Recommended)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
- [Eclipse](https://www.eclipse.org/downloads/)
- [Visual Studio Code](https://code.visualstudio.com/) with Java extensions

---

## 🚀 Installation & Setup

Choose your operating system for specific instructions:

<details>
<summary><b>🪟 Windows Configuration</b></summary>

### Step 1: Install Java JDK

1. **Download JDK 17+**:
   - Go to [Oracle JDK Downloads](https://www.oracle.com/java/technologies/downloads/)
   - Download Windows x64 Installer

2. **Install JDK**:
   - Run the `.exe` installer
   - Follow installation wizard
   - Note the installation path (e.g., `C:\Program Files\Java\jdk-17`)

3. **Set JAVA_HOME Environment Variable**:
   ```cmd
   # Open Command Prompt as Administrator
   setx JAVA_HOME "C:\Program Files\Java\jdk-17"
   setx PATH "%PATH%;%JAVA_HOME%\bin"
   ```

   **Or via GUI**:
   - Right-click "This PC" → Properties → Advanced System Settings
   - Click "Environment Variables"
   - Under "System Variables", click "New":
     - Variable name: `JAVA_HOME`
     - Variable value: `C:\Program Files\Java\jdk-17`
   - Edit "Path" variable → Add: `%JAVA_HOME%\bin`

4. **Verify Installation**:
   ```cmd
   java -version
   javac -version
   ```

### Step 2: Install Maven (Optional)

1. **Download Maven**:
   - Go to [Maven Downloads](https://maven.apache.org/download.cgi)
   - Download Binary zip archive (e.g., `apache-maven-3.9.5-bin.zip`)

2. **Extract Maven**:
   - Extract to `C:\Program Files\Apache\maven`

3. **Set MAVEN_HOME Environment Variable**:
   ```cmd
   setx MAVEN_HOME "C:\Program Files\Apache\maven"
   setx PATH "%PATH%;%MAVEN_HOME%\bin"
   ```

4. **Verify Installation**:
   ```cmd
   mvn -version
   ```

### Step 3: Install MySQL

1. **Download MySQL Installer**:
   - Go to [MySQL Downloads](https://dev.mysql.com/downloads/installer/)
   - Download MySQL Installer for Windows

2. **Install MySQL**:
   - Run the installer
   - Choose "Developer Default" setup type
   - Set root password (remember this!)
   - Configure MySQL Server as Windows Service

3. **Start MySQL Service**:
   ```cmd
   # Open Command Prompt as Administrator
   net start MySQL80
   ```

4. **Verify MySQL Installation**:
   ```cmd
   mysql --version
   ```

### Step 4: Clone and Setup Project

1. **Clone Repository**:
   ```cmd
   cd C:\Users\YourUsername\Desktop
   git clone https://github.com/ShubSaurav/Student-Result-Portal.git
   cd Student-Result-Portal
   ```

2. **Create MySQL Database**:
   ```cmd
   # Login to MySQL
   mysql -u root -p
   ```

   ```sql
   -- Create database
   CREATE DATABASE IF NOT EXISTS student_portal;
   
   -- Verify database creation
   SHOW DATABASES;
   
   -- Exit MySQL
   EXIT;
   ```

   **Or use single command**:
   ```cmd
   mysql -u root -p"YOUR_PASSWORD" -e "CREATE DATABASE IF NOT EXISTS student_portal;"
   ```

3. **Configure Database Connection**:
   - Open `src/main/resources/application.properties`
   - Update with your MySQL password:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/student_portal
   spring.datasource.username=root
   spring.datasource.password=YOUR_MYSQL_PASSWORD
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
   
   server.port=8080
   ```

4. **Build the Project**:
   ```cmd
   # Using Maven Wrapper (recommended)
   mvnw.cmd clean install
   
   # Or using Maven if installed
   mvn clean install
   ```

5. **Run the Application**:
   ```cmd
   # Using Maven Wrapper
   mvnw.cmd spring-boot:run
   
   # Or using Maven
   mvn spring-boot:run
   
   # Or run the JAR file
   java -jar target\StudentResultPortal-0.0.1-SNAPSHOT.jar
   ```

6. **Access Application**:
   - Open browser: `http://localhost:8080`

### 🛠️ Windows Troubleshooting

**Issue: "java is not recognized"**
```cmd
# Verify JAVA_HOME
echo %JAVA_HOME%

# Check PATH
echo %PATH%

# Restart Command Prompt after setting environment variables
```

**Issue: "mvn is not recognized"**
```cmd
# Verify MAVEN_HOME
echo %MAVEN_HOME%

# Add to PATH if missing
setx PATH "%PATH%;C:\Program Files\Apache\maven\bin"
```

**Issue: MySQL Connection Refused**
```cmd
# Check if MySQL service is running
sc query MySQL80

# Start MySQL service
net start MySQL80
```

**Issue: Port 8080 Already in Use**
```cmd
# Find process using port 8080
netstat -ano | findstr :8080

# Kill process (replace PID)
taskkill /PID <PID> /F
```

</details>

<details>
<summary><b>🍎 macOS Configuration</b></summary>

### Step 1: Install Java JDK

1. **Install via Homebrew (Recommended)**:
   ```bash
   # Install Homebrew if not installed
   /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
   
   # Install OpenJDK 17
   brew install openjdk@17
   ```

2. **Or Download from Oracle**:
   - Go to [Oracle JDK Downloads](https://www.oracle.com/java/technologies/downloads/)
   - Download macOS installer (.dmg)
   - Run installer and follow instructions

3. **Set JAVA_HOME**:
   ```bash
   # For Bash (older macOS)
   echo 'export JAVA_HOME=$(/usr/libexec/java_home -v 17)' >> ~/.bash_profile
   echo 'export PATH=$JAVA_HOME/bin:$PATH' >> ~/.bash_profile
   source ~/.bash_profile
   
   # For Zsh (macOS Catalina and later)
   echo 'export JAVA_HOME=$(/usr/libexec/java_home -v 17)' >> ~/.zshrc
   echo 'export PATH=$JAVA_HOME/bin:$PATH' >> ~/.zshrc
   source ~/.zshrc
   ```

4. **Verify Installation**:
   ```bash
   java -version
   javac -version
   echo $JAVA_HOME
   ```

### Step 2: Install Maven (Optional)

1. **Install via Homebrew**:
   ```bash
   brew install maven
   ```

2. **Or Manual Installation**:
   ```bash
   # Download Maven
   curl -O https://dlcdn.apache.org/maven/maven-3/3.9.5/binaries/apache-maven-3.9.5-bin.tar.gz
   
   # Extract
   tar -xvf apache-maven-3.9.5-bin.tar.gz
   
   # Move to /opt
   sudo mv apache-maven-3.9.5 /opt/maven
   
   # Set environment variables
   echo 'export MAVEN_HOME=/opt/maven' >> ~/.zshrc
   echo 'export PATH=$MAVEN_HOME/bin:$PATH' >> ~/.zshrc
   source ~/.zshrc
   ```

3. **Verify Installation**:
   ```bash
   mvn -version
   ```

### Step 3: Install MySQL

1. **Install via Homebrew**:
   ```bash
   # Install MySQL
   brew install mysql
   
   # Start MySQL service
   brew services start mysql
   ```

2. **Or Download from Official Website**:
   - Go to [MySQL Downloads](https://dev.mysql.com/downloads/mysql/)
   - Download macOS DMG Archive
   - Run installer and follow instructions

3. **Secure MySQL Installation**:
   ```bash
   # Run security script
   mysql_secure_installation
   
   # Follow prompts:
   # - Set root password
   # - Remove anonymous users: Y
   # - Disallow root login remotely: Y
   # - Remove test database: Y
   # - Reload privilege tables: Y
   ```

4. **Verify MySQL Installation**:
   ```bash
   mysql --version
   
   # Check if MySQL is running
   brew services list | grep mysql
   ```

### Step 4: Clone and Setup Project

1. **Clone Repository**:
   ```bash
   cd ~/Desktop
   git clone https://github.com/ShubSaurav/Student-Result-Portal.git
   cd Student-Result-Portal
   ```

2. **Create MySQL Database**:
   ```bash
   # Login to MySQL (use your root password)
   mysql -u root -p
   ```

   ```sql
   -- Create database
   CREATE DATABASE IF NOT EXISTS student_portal;
   
   -- Verify database creation
   SHOW DATABASES;
   
   -- Optional: Create a dedicated user
   CREATE USER 'studentadmin'@'localhost' IDENTIFIED BY 'your_password';
   GRANT ALL PRIVILEGES ON student_portal.* TO 'studentadmin'@'localhost';
   FLUSH PRIVILEGES;
   
   -- Exit MySQL
   EXIT;
   ```

   **Or use single command**:
   ```bash
   mysql -u root -p'YOUR_PASSWORD' -e "CREATE DATABASE IF NOT EXISTS student_portal;"
   ```

3. **Configure Database Connection**:
   - Open `src/main/resources/application.properties`
   - Update with your MySQL password:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/student_portal
   spring.datasource.username=root
   spring.datasource.password=YOUR_MYSQL_PASSWORD
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
   
   server.port=8080
   ```

4. **Build the Project**:
   ```bash
   # Using Maven Wrapper (recommended)
   ./mvnw clean install
   
   # Or using Maven if installed
   mvn clean install
   ```

5. **Run the Application**:
   ```bash
   # Using Maven Wrapper
   ./mvnw spring-boot:run
   
   # Or using Maven
   mvn spring-boot:run
   
   # Or run the JAR file
   java -jar target/StudentResultPortal-0.0.1-SNAPSHOT.jar
   ```

6. **Access Application**:
   - Open browser: `http://localhost:8080`

### 🛠️ macOS Troubleshooting

**Issue: "java: command not found"**
```bash
# Check Java installation
/usr/libexec/java_home -V

# Verify JAVA_HOME
echo $JAVA_HOME

# If not set, add to shell config
echo 'export JAVA_HOME=$(/usr/libexec/java_home)' >> ~/.zshrc
source ~/.zshrc
```

**Issue: "mvn: command not found"**
```bash
# Check Maven installation
brew list | grep maven

# Reinstall if needed
brew reinstall maven

# Verify PATH
echo $PATH | grep maven
```

**Issue: MySQL Connection Refused**
```bash
# Check MySQL status
brew services list | grep mysql

# Start MySQL if not running
brew services start mysql

# Or restart
brew services restart mysql

# Check MySQL process
ps aux | grep mysql
```

**Issue: Port 8080 Already in Use**
```bash
# Find process using port 8080
lsof -i :8080

# Kill process (replace PID)
kill -9 <PID>

# Or change port in application.properties
# server.port=8081
```

**Issue: Permission Denied on MySQL**
```bash
# Reset MySQL root password
sudo mysql

# In MySQL prompt:
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'new_password';
FLUSH PRIVILEGES;
EXIT;
```

**Issue: Homebrew Installation Problems**
```bash
# Update Homebrew
brew update

# Check for issues
brew doctor

# Fix permissions
sudo chown -R $(whoami) /usr/local/Cellar
```

</details>

---

## 📊 Database Schema

The application automatically creates the following tables:

### `users` Table
| Column | Type | Description |
|--------|------|-------------|
| id | BIGINT (PK) | Auto-generated user ID |
| username | VARCHAR(50) | Unique username |
| password | VARCHAR(255) | Encrypted password |
| full_name | VARCHAR(100) | Full name of the user |
| email | VARCHAR(100) | Unique email address |
| role | VARCHAR(20) | TEACHER or STUDENT |
| class_name | VARCHAR(20) | Student's class (nullable for teachers) |
| section | VARCHAR(10) | Student's section (nullable for teachers) |

### `students` Table
| Column | Type | Description |
|--------|------|-------------|
| id | BIGINT (PK) | Auto-generated result ID |
| name | VARCHAR(100) | Student name |
| subject | VARCHAR(100) | Subject name |
| marks | INT | Marks obtained (0-100) |
| grade | VARCHAR(2) | Auto-calculated grade (A, B, C, D, F) |
| date | DATE | Date of result entry |
| class_name | VARCHAR(20) | Class |
| section | VARCHAR(10) | Section |

**Grade Calculation Logic:**
- **A**: 90-100 marks
- **B**: 80-89 marks
- **C**: 70-79 marks
- **D**: 60-69 marks
- **F**: 0-59 marks

## 👤 User Guide

### First-Time Setup

1. **Create a Teacher Account:**
   - Go to `http://localhost:8080/signup`
   - Select "Teacher" role
   - Fill in: Full Name, Email, Username, Password
   - Click "Create Account"

2. **Login as Teacher:**
   - Username: `<your_username>`
   - Password: `<your_password>`
   - You'll be redirected to the main dashboard

3. **Upload Student Results:**
   - Click "Upload Result" button
   - Fill in: Student Name, Class, Section, Subject, Marks
   - Grade is calculated automatically
   - Submit the form

### Creating Student Accounts

1. **Register as Student:**
   - Go to `http://localhost:8080/signup`
   - Select "Student" role
   - Fill in: Full Name, Email, Username, Password, Class, Section
   - Click "Create Account"

2. **Login as Student:**
   - Use your credentials
   - You'll see only YOUR results in "My Results" dashboard
   - View your statistics: Average, Highest Score, Grade

## 📱 Application URLs

| URL | Description | Access |
|-----|-------------|--------|
| `http://localhost:8080/login` | Login page | Public |
| `http://localhost:8080/signup` | Sign up page | Public |
| `http://localhost:8080/` | Teacher dashboard | Teachers only |
| `http://localhost:8080/upload` | Upload new result | Teachers only |
| `http://localhost:8080/my-results` | Student dashboard | Students only |
| `http://localhost:8080/history?name=<studentname>` | View student history | Teachers only |
| `http://localhost:8080/delete/{id}` | Delete result | Teachers only |
| `http://localhost:8080/logout` | Logout | Authenticated users |

## 🛠️ Technology Stack

| Category | Technology |
|----------|-----------|
| **Backend Framework** | Spring Boot 3.5.4 |
| **Language** | Java 17+ |
| **Build Tool** | Maven 3.6+ |
| **Database** | MySQL 9.5 |
| **ORM** | Hibernate (JPA) |
| **Template Engine** | Thymeleaf |
| **Frontend** | HTML5, CSS3, JavaScript |
| **Authentication** | Spring Session |
| **Server** | Apache Tomcat (Embedded) |
| **Icons** | Font Awesome 6.4.0 |
| **Fonts** | Google Fonts (Poppins) |

## 📁 Project Structure

```
StudentResultPortal/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/StudentResultPortal/
│   │   │       ├── StudentResultPortalApplication.java
│   │   │       ├── controller/
│   │   │       │   ├── AuthController.java
│   │   │       │   └── StudentController.java
│   │   │       ├── model/
│   │   │       │   ├── Student.java
│   │   │       │   └── User.java
│   │   │       ├── repository/
│   │   │       │   ├── StudentRepository.java
│   │   │       │   └── UserRepository.java
│   │   │       └── service/
│   │   │           ├── StudentService.java
│   │   │           └── UserService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   │           ├── login.html
│   │           ├── signup.html
│   │           ├── student.html
│   │           ├── my-results.html
│   │           └── upload.html
│   └── test/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## 🔧 Technologies Used

- **Backend**: Spring Boot 3.5.4
- **Frontend**: Thymeleaf, HTML5, CSS3, JavaScript
- **Database**: MySQL 9.5
- **ORM**: Hibernate/JPA
- **Build Tool**: Maven
- **Server**: Embedded Tomcat
- **Icons**: Font Awesome 6.4.0
- **Fonts**: Google Fonts (Poppins)

## 📝 Configuration Details

### application.properties

```properties
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/student_portal
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Server
server.port=8080
```

### Maven Dependencies (Key)

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter Thymeleaf
- MySQL Connector/J
- Spring Boot DevTools

## 🎨 Features in Detail

### Grading System

- **A**: 90-100 marks (Excellent)
- **B**: 80-89 marks (Very Good)
- **C**: 70-79 marks (Good)
- **D**: 60-69 marks (Satisfactory)
- **F**: Below 60 marks (Fail)

### Security Features

- Session-based authentication
- Role-based access control (RBAC)
- Password validation
- Duplicate username/email prevention
- Automatic session management

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👨‍💻 Author

**Shubham Saurav**

## 🙏 Acknowledgments

- Spring Boot Team for the excellent framework
- Thymeleaf for server-side templating
- Font Awesome for beautiful icons
- MySQL for reliable database management

## 📞 Support

For issues, questions, or suggestions:
- Open an issue in the repository
- Contact: [Email: shubhamsaurav2264@gmail.com]
           [Linkedin id: https://www.linkedin.com/in/shubsaurav/]

---

**Happy Coding! 🚀**
