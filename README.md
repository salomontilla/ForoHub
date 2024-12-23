# 📚 Forum API REST
### 🚀 Description
Forum API REST is a project designed to manage discussion forums. It provides secure endpoints for creating, reading, updating, and deleting topics. The system implements authentication and authorization using **JWT** and **Spring Security**, is documented with **Swagger UI**, and uses **MySQL** as a relational database.

---
## 🛠️ Technologies used
- **Java 17**
- **Spring Boot**
- **Spring Security**
- **JWT (JSON Web Tokens)**
- **Swagger UI** for interactive documentation.
- **JPA/Hibernate** for database interaction.
- **MySQL** as a relational database.
---
## ✨ Main features
1. **Authentication and Authorization:**
- JWT implementation for secure sessions.
- Role management for access control.
2. **Topics CRUD:**
- **Create, **R**etrive, **Update, and **D**elete topics.
- Input data validation with **Bean Validation**.
3. **Interactive Documentation:**
- Complete and accessible documentation with Swagger UI.
- Direct testing of endpoints from the browser.
4. **Database:**
- Data persistence with **MySQL**.
- Relationships configured with **JPA**.
---
## 🚦 Main endpoints
| Method | Endpoint | Description | Authentication |
|----------|--------------------|--------------------------------|---------------|
| `POST` | `/login` | Generates a JWT | No |
| `GET` | `/topics` | Gets all topics | Yes |
| `GET` | `/topic/{id}` | Gets one topic | Yes |
| `POST` | `/topics` | Create a new topic | Yes |
| `PUT` | `/topics/{id}` | Update a topic by ID | Yes |
| `DELETE` | `/topics/{id}` | Delete a topic by ID | Yes |
