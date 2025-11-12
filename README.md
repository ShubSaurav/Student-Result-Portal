# 🎓 Student Result Portal

A modern, full-featured web application for managing student academic results with role-based authentication. Built with Spring Boot, MySQL, and Thymeleaf.

![Java](https://img.shields.io/badge/Java-25-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.4-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-9.5-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)

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

Before running this project, ensure you have the following installed:

### 1. **Java Development Kit (JDK)**
- **Version**: Java 17 or higher (Java 25 recommended)
- **Download**: [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/)
- **Verify Installation**:
  ```bash
  java -version
  ```

### 2. **Apache Maven**
- **Version**: Maven 3.6 or higher
- **Download**: [Maven Official Site](https://maven.apache.org/download.cgi)
- **Verify Installation**:
  ```bash
  mvn -version
  ```
- **Note**: This project includes Maven Wrapper (`mvnw`), so Maven installation is optional.

### 3. **MySQL Database**
- **Version**: MySQL 8.0 or higher (MySQL 9.5 recommended)
- **Download**: [MySQL Community Server](https://dev.mysql.com/downloads/mysql/)
- **Verify Installation**:
  ```bash
  mysql --version
  ```

### 4. **Git** (Optional)
- For cloning the repository
- **Download**: [Git Official Site](https://git-scm.com/downloads)

## 🚀 Installation & Setup

### Step 1: Clone the Repository

```bash
git clone <repository-url>
cd StudentResultPortal
```

Or download and extract the ZIP file.

### Step 2: Configure MySQL Database

#### 2.1 Start MySQL Service

**macOS/Linux:**
```bash
# Using Homebrew on macOS
brew services start mysql

# Or using systemctl on Linux
sudo systemctl start mysql
```

**Windows:**
```cmd
# Start MySQL from Services or using MySQL Workbench
net start MySQL
```

#### 2.2 Create Database

Open your terminal and run:

```bash
# Login to MySQL (default root user)
mysql -u root -p
```

Enter your MySQL root password when prompted, then execute:

```sql
-- Create the database
CREATE DATABASE IF NOT EXISTS student_portal;

-- Verify database creation
SHOW DATABASES;

-- Exit MySQL
EXIT;
```

**Or use a single command:**

```bash
# Replace 'YOUR_PASSWORD' with your actual MySQL root password
mysql -u root -p'YOUR_PASSWORD' -e "CREATE DATABASE IF NOT EXISTS student_portal;"
```

#### 2.3 Configure Database Credentials

Open the file `src/main/resources/application.properties` and update with your MySQL credentials:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/student_portal
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# Server Configuration
server.port=8080
```

**Important**: Replace `YOUR_MYSQL_PASSWORD` with your actual MySQL root password.

### Step 3: Build the Project

```bash
# Using Maven Wrapper (recommended)
./mvnw clean install

# Or using Maven (if installed)
mvn clean install
```

This will:
- Download all dependencies
- Compile the source code
- Run tests (if any)
- Create a JAR file in the `target/` directory

### Step 4: Run the Application

```bash
# Using Maven Wrapper
./mvnw spring-boot:run

# Or using Maven
mvn spring-boot:run

# Or run the JAR directly
java -jar target/StudentResultPortal-0.0.1-SNAPSHOT.jar
```

The application will start and create all necessary database tables automatically using Hibernate.

### Step 5: Access the Application

Open your web browser and navigate to:

```
http://localhost:8080/login
```

## 📊 Database Schema

The application automatically creates the following tables:

### `user` Table
| Column     | Type         | Description                          |
|------------|--------------|--------------------------------------|
| id         | BIGINT       | Primary Key (Auto-increment)         |
| username   | VARCHAR(255) | Unique username                      |
| password   | VARCHAR(255) | User password                        |
| full_name  | VARCHAR(255) | Full name of the user                |
| email      | VARCHAR(255) | Unique email address                 |
| role       | VARCHAR(50)  | User role (STUDENT/TEACHER)          |
| class_name | VARCHAR(50)  | Class (for students only)            |
| section    | VARCHAR(50)  | Section (for students only)          |

### `student` Table
| Column     | Type         | Description                          |
|------------|--------------|--------------------------------------|
| id         | BIGINT       | Primary Key (Auto-increment)         |
| name       | VARCHAR(255) | Student name                         |
| subject    | VARCHAR(255) | Subject name                         |
| marks      | INTEGER      | Marks obtained (0-100)               |
| grade      | VARCHAR(2)   | Calculated grade (A/B/C/D/F)         |
| date       | DATE         | Date of record creation              |
| class_name | VARCHAR(50)  | Class of the student                 |
| section    | VARCHAR(50)  | Section of the student               |

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

## 🎯 Application URLs

| URL                          | Description                    | Access          |
|------------------------------|--------------------------------|-----------------|
| `/login`                     | Login page                     | Public          |
| `/signup`                    | Registration page              | Public          |
| `/`                          | Teacher Dashboard (All Results)| Teachers only   |
| `/my-results`                | Student Dashboard              | Students only   |
| `/upload`                    | Upload Result Form             | Teachers only   |
| `/history?name=<studentname>`| View Student History           | Teachers only   |
| `/delete/{id}`               | Delete Result                  | Teachers only   |
| `/logout`                    | Logout                         | Authenticated   |

## 🛠️ Troubleshooting

### Port 8080 Already in Use

```bash
# Find process using port 8080
lsof -i :8080

# Kill the process (replace PID with actual process ID)
kill -9 <PID>
```

### MySQL Connection Error

1. **Check MySQL is running:**
   ```bash
   # macOS/Linux
   mysql.server status
   
   # Or
   sudo systemctl status mysql
   ```

2. **Verify credentials in `application.properties`**

3. **Check database exists:**
   ```bash
   mysql -u root -p -e "SHOW DATABASES;"
   ```

### Build Errors

```bash
# Clean and rebuild
./mvnw clean install -U

# Skip tests if needed
./mvnw clean install -DskipTests
```

### Hibernate/JPA Errors

- Ensure `spring.jpa.hibernate.ddl-auto=update` is set
- Check database connection and credentials
- Verify MySQL version compatibility

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
