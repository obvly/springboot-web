# 📚 Online Book Store API

This is a robust RESTful API designed for managing an online book catalog. Built with **Spring Boot 3.3.4**, this project demonstrates a multi-layered architecture, data transfer isolation using DTOs, and automated object mapping.

## 🚀 Key Features

- **Layered Architecture**: Clean separation between Controller, Service, and Repository layers.
- **DTO Pattern**: Uses separate Data Transfer Objects for API requests and responses to ensure data security and integrity.
- **Automated Mapping**: Utilizes **MapStruct** for type-safe and efficient conversion between Entities and DTOs.
- **Data Integrity**: Enforced database constraints and validation at the Entity level.
- **Manual Session Management**: Demonstrates low-level database interactions using Hibernate `SessionFactory` and `Transaction` management.
- **Robust Exception Handling**: Custom `EntityNotFoundException` to provide clear API error responses.

## 🛠 Technologies & Tools

*   **Java 17** (Temurin JDK)
*   **Spring Boot 3.3.4**
*   **Spring Data JPA & Hibernate**
*   **MapStruct 1.5.5.Final** (mapping automation)
*   **Lombok** (boilerplate reduction)
*   **MySQL** (Production/Dev Database)
*   **H2 Database** (Testing Environment)
*   **Maven** (Dependency management)
*   **Checkstyle** (Code quality control)

## 📖 API Documentation

### Book Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/api/books` | Retrieve the full book catalog |
| **GET** | `/api/books/{id}` | Get detailed information about a specific book |
| **POST** | `/api/books` | Add a new book to the store (**Returns 201 Created**) |

#### Sample Request Body (POST /api/books):
```json
{
  "title": "Effective Java",
  "author": "Joshua Bloch",
  "isbn": "978-0134685991",
  "price": 45.00,
  "description": "A comprehensive guide to best practices for the Java platform.",
  "coverImage": "http://example.com/effective_java.jpg"
}
