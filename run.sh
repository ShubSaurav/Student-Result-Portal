#!/bin/bash

# Student Result Portal - Run Script
# This script starts the Spring Boot application

echo "=========================================="
echo "  Student Result Portal"
echo "=========================================="
echo ""

# Check if Java is installed
if ! command -v java &> /dev/null
then
    echo "❌ Error: Java is not installed or not in PATH"
    echo "Please install Java 17 or higher and try again"
    exit 1
fi

# Display Java version
echo "✓ Java version:"
java -version
echo ""

# Check if MySQL is running
if ! command -v mysql &> /dev/null
then
    echo "⚠️  Warning: MySQL command not found in PATH"
    echo "Make sure MySQL is installed and running"
else
    if ! pgrep -x "mysqld" > /dev/null
    then
        echo "⚠️  Warning: MySQL server doesn't appear to be running"
        echo "Start MySQL with: brew services start mysql"
    else
        echo "✓ MySQL is running"
    fi
fi
echo ""

# Check if database exists
echo "Checking database connection..."
mysql -u root -pMARS*1979 -e "USE student_portal;" 2>/dev/null
if [ $? -eq 0 ]; then
    echo "✓ Database 'student_portal' exists"
else
    echo "⚠️  Database 'student_portal' not found"
    echo "Creating database..."
    mysql -u root -pMARS*1979 -e "CREATE DATABASE IF NOT EXISTS student_portal;" 2>/dev/null
    if [ $? -eq 0 ]; then
        echo "✓ Database created successfully"
    else
        echo "❌ Failed to create database. Please check MySQL credentials"
        echo "Expected password: MARS*1979"
    fi
fi
echo ""

# Clean and build the project
echo "Building the project..."
./mvnw clean install -DskipTests
if [ $? -ne 0 ]; then
    echo "❌ Build failed! Please check the errors above"
    exit 1
fi
echo ""

# Run the application
echo "=========================================="
echo "  Starting Application..."
echo "=========================================="
echo ""
echo "🌐 Application will be available at:"
echo ""
echo "    http://localhost:8080"
echo ""
echo "📌 Quick Access Links:"
echo "    Login Page:    http://localhost:8080/login"
echo "    Signup Page:   http://localhost:8080/signup"
echo ""
echo "⏹  Press Ctrl+C to stop the application"
echo "=========================================="
echo ""

./mvnw spring-boot:run
