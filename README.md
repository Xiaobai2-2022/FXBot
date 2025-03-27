# FXBot (Backend Server)

FXBot is the backend service for **Fangxia Technology Ltd.**'s automation bot system.  

---

## 🚀 Features

- 🔧 Built with Spring Boot 3.4 and Java 21
- ⏱️ Quartz Scheduler integration for automated tasks
- 🧠 Data persistence using MyBatis-Plus and MySQL
- 📖 Auto-generated REST API documentation with OpenAPI (SpringDoc)
- 📊 Actuator endpoints for system monitoring
- ⚡ Fast development with Lombok and code generation tools

---

## 📦 Tech Stack

| Technology        | Usage                                  |
|-------------------|----------------------------------------|
| Java 21           | Core language                          |
| Spring Boot       | Backend framework                      |
| Quartz            | Task scheduling                        |
| MyBatis-Plus      | Database ORM                           |
| MySQL             | Relational database                    |
| SpringDoc OpenAPI | REST API docs                          |
| Lombok            | Boilerplate reduction                  |

---

## 🛠️ Getting Started

### Prerequisites

- Java 21+
- Maven 3.8+
- MySQL instance running
- IDE (IntelliJ recommended)

### Installation

```bash
git clone https://github.com/your-org/fxbot.git
cd fxbot
./mvnw clean install
```

### Running the Application

```bash
./mvnw spring-boot:run
```

Or package and run:

```bash
./mvnw package
java -jar target/fxbot-0.0.1-SNAPSHOT.jar
```

### Accessing the API Docs

Once running, access the API docs at:  
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 📄 License

This project is licensed under a **Custom Non-Commercial Open Source License**.

You may:
- Use, modify, and share the code **non-commercially**
- Must **attribute** the original author
- Must share under the **same license**

**Commercial use is prohibited** without permission.

See [LICENSE.md](./LICENSE.md) for full terms.

---

## 📚 Third-Party Licenses

This project uses several open-source libraries.  
For a full list of included dependencies and their licenses, see:  
[THIRD-PARTY.txt](./THIRD-PARTY.txt)

---

## 🧑‍💻 Author

**Zhifan Li**  
Fangxia Technology Ltd.

---

## 🌐 Contact

For business inquiries or licensing questions, please contact:  
[`z2367li@uwaterloo.ca`](mailto:z2367li@uwaterloo.ca)

