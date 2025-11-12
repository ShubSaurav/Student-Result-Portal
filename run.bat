@echo off
REM Student Result Portal - Run Script for Windows
REM This script starts the Spring Boot application

echo ==========================================
echo   Student Result Portal
echo ==========================================
echo.

REM Check if Java is installed
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo X Error: Java is not installed or not in PATH
    echo Please install Java 17 or higher and try again
    pause
    exit /b 1
)

REM Display Java version
echo [OK] Java version:
java -version
echo.

REM Check if MySQL service is running
sc query MySQL >nul 2>&1
if %errorlevel% equ 0 (
    echo [OK] MySQL service is installed
    sc query MySQL | find "RUNNING" >nul
    if %errorlevel% equ 0 (
        echo [OK] MySQL is running
    ) else (
        echo [!] Warning: MySQL service is not running
        echo Starting MySQL service...
        net start MySQL
    )
) else (
    echo [!] Warning: MySQL service not found
    echo Make sure MySQL is installed and running
)
echo.

REM Check and create database if needed
echo Checking database connection...
mysql -u root -pMARS*1979 -e "USE student_portal;" 2>nul
if %errorlevel% equ 0 (
    echo [OK] Database 'student_portal' exists
) else (
    echo [!] Database 'student_portal' not found
    echo Creating database...
    mysql -u root -pMARS*1979 -e "CREATE DATABASE IF NOT EXISTS student_portal;" 2>nul
    if %errorlevel% equ 0 (
        echo [OK] Database created successfully
    ) else (
        echo X Failed to create database. Please check MySQL credentials
        echo Expected password: MARS*1979
    )
)
echo.

REM Clean and build the project
echo Building the project...
call mvnw.cmd clean install -DskipTests
if %errorlevel% neq 0 (
    echo X Build failed! Please check the errors above
    pause
    exit /b 1
)
echo.

# Run the application
echo ==========================================
echo   Starting Application...
echo ==========================================
echo.
echo Application will be available at:
echo.
echo     http://localhost:8080
echo.
echo Quick Access Links:
echo     Login Page:    http://localhost:8080/login
echo     Signup Page:   http://localhost:8080/signup
echo.
echo Press Ctrl+C to stop the application
echo ==========================================
echo.

call mvnw.cmd spring-boot:run
