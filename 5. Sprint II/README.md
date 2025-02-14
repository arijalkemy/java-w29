<div align="center">
<a href="https://git.io/typing-svg"><img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=450&size=30&pause=1000&color=2798F7&width=435&lines=Welcome!+We+are+Group+7" alt="Typing SVG" /></a>
</div>

# Project be_java_hisp_w29_g07

Welcome to the **be_java_hisp_w29_g07** project. This repository contains sprint two of bootcamp java wave 29.

---

## 📚 Table of Contents

- [Completed Sprints](#-completed-sprints)
- [Test Coverage](#-test-coverage)
- [Seeds](#-seeds)
- [Postman Collection](#-postman-collection)
- [Functional Requirements](#-functional-requirements)
- [Swagger](#-swagger)
- [Class Diagram](#-class-diagram)

---

## 📋 Completed Sprints
- [x] **Sprint 1**
- [x] **Sprint 2**

---

## 🧪 Test Coverage
![img.png](img.png)

---

## 🌱 Seeds

- **[Users](./src/main/resources/users.json)**  
- **[Posts](./src/main/resources/posts.json)**  

---

## 🛠 Postman Collection
- **[Postman Collection](./src/main/resources/postman_collection.json)**  


---

## 📊 Swagger

You can access the API documentation through the following URL:

- **[Swagger UI](http://localhost:8080/swagger-ui/index.html#/)**

---

## 📝 Functional Requirements

- **[Functional Requirements Document](./src/main/resources/functional_requirements.docx)**
- **[Testing Requirements Document](./src/main/resources/testing_requirements.docx)**

---

## 📈 Class Diagram

To view the class diagram, check the following file:

- **[classDiagram.md](./src/main/resources/classDiagram.md)**

### Class Diagram

```mermaid
classDiagram
    class User {
        -Integer id
        -String username
        -String name
        -String lastname
        -String email
        -Enum userType
    }
    class Follow {
        -Integer id
        -User follower
        -User followed
        -LocalDate followDate
    }
    class Product {
        -Integer id
        -String name
        -String type
        -String brand
        -String color
        -String notes
    }
    class Post {
        -Integer id
        -Integer userId
        -LocalDate date
        -Product product
        -Integer category
        -Double price
        -Boolean hasPromo
        -Double discount
    }
    Post --> Product
    Follow --> User
    Post --> User