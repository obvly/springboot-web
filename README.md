# Online Book Store API

A Java backend learning project for managing a book catalog, developed as part of Mate Academy coursework.

> **Work in progress.** The implementation is in the [`submission` branch](https://github.com/obvly/springboot-web/tree/submission). The `main` branch currently contains this project overview.

[Browse the source code](https://github.com/obvly/springboot-web/tree/submission/src) · [Follow the coursework review](https://github.com/obvly/springboot-web/pull/3)

## What it demonstrates

- REST endpoints for creating books, listing the catalog, and finding a book by ID.
- Controller, service, and repository layers.
- Request and response DTOs mapped with MapStruct.
- Hibernate sessions and explicit transactions in the repository implementation.
- Maven build and Checkstyle checks in GitHub Actions.

## Stack

Java 17 · Spring Boot 3.3.4 · Hibernate · MapStruct 1.5.5.Final · Lombok · Maven

The project includes Spring Data JPA, MySQL, and H2 dependencies. Persistence in the current submission uses a custom Hibernate repository.

## API in the submission branch

| Method | Endpoint | Purpose |
| --- | --- | --- |
| GET | `/api/books` | List books |
| GET | `/api/books/{id}` | Find a book by ID |
| POST | `/api/books` | Create a book; returns HTTP 201 |

Example request body:

```json
{
  "title": "Effective Java",
  "author": "Joshua Bloch",
  "isbn": "978-0134685991",
  "price": 45.00,
  "description": "A guide to Java best practices.",
  "coverImage": "https://example.com/cover.jpg"
}
```

## Explore locally

```bash
git clone --branch submission https://github.com/obvly/springboot-web.git
cd springboot-web
```

Use JDK 17 and the included Maven wrapper. Review `src/main/resources/application.properties` and configure your local database before starting the application. Test configuration is in `src/test/resources/application.properties`.

## Project status

This repository documents an ongoing learning process and mentor review. It is not a complete online store: authentication, checkout, and payment processing are outside the current implementation.
