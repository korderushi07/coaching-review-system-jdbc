# 🎓 CoachRate — Coaching Review System

> A full-stack web application for discovering and reviewing coaching institutes. Built with **Java Spring Boot**, **MySQL**, and a modern **HTML/CSS/JS** frontend.

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-green?style=flat-square&logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=flat-square&logo=mysql)
![HTML5](https://img.shields.io/badge/HTML5-CSS3-red?style=flat-square&logo=html5)
![License](https://img.shields.io/badge/License-MIT-purple?style=flat-square)

---

## 📸 Preview

> A dark-themed, glassmorphism UI with aurora gradient backgrounds, animated review cards, live stats, and full CRUD functionality.

---

## ✨ Features

- ➕ **Add Reviews** — Submit detailed reviews with star ratings for any coaching institute
- 📋 **View All Reviews** — Browse all student reviews in a beautiful card grid layout
- ✏️ **Update Reviews** — Modify the rating of any existing review by ID
- 🗑️ **Delete Reviews** — Remove reviews permanently from the database
- 🔍 **Search Reviews** — Find all reviews for a specific coaching institute by name
- 📊 **Live Stats Dashboard** — Real-time stats showing total reviews, average rating, institutes, and faculty count
- 🌐 **REST API** — Full RESTful backend built with Spring Boot

---

## 🏗️ Project Structure

```
coaching-review-system-jdbc/
│
├── 📁 backend/                          # Spring Boot REST API
│   ├── src/main/java/com/coaching/review/
│   │   ├── CoachingReviewSystemApplication.java   # Main entry point
│   │   ├── model/
│   │   │   └── Review.java                        # JPA Entity
│   │   ├── repository/
│   │   │   └── ReviewRepository.java              # JPA Repository
│   │   └── controller/
│   │       └── ReviewController.java              # REST Controller
│   ├── src/main/resources/
│   │   └── application.properties                 # DB configuration
│   └── pom.xml                                    # Maven dependencies
│
├── 📁 frontend/
│   └── index.html                       # Full frontend (HTML + CSS + JS)
│
├── CoachingReviewSystem.java            # Original JDBC-based console app
├── coachingDB.sql                       # Database schema & seed data
└── README.md
```

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Backend Framework | Spring Boot 3.5 |
| Database ORM | Spring Data JPA + Hibernate |
| Database | MySQL 8.0 |
| Frontend | HTML5, CSS3, Vanilla JavaScript |
| Build Tool | Maven |
| Version Control | Git + GitHub |

---

## ⚙️ Prerequisites

Make sure the following are installed on your system:

- [Java JDK 21+](https://www.oracle.com/java/technologies/downloads/)
- [MySQL 8.0+](https://dev.mysql.com/downloads/)
- [Maven](https://maven.apache.org/) (or use the included `mvnw` wrapper)
- Any modern web browser (Chrome, Firefox, Edge)

---

## 🚀 Getting Started

### Step 1 — Clone the Repository

```bash
git clone https://github.com/korderushi07/coaching-review-system-jdbc.git
cd coaching-review-system-jdbc
```

### Step 2 — Set Up the Database

Open MySQL Workbench or your MySQL terminal and run:

```sql
CREATE DATABASE IF NOT EXISTS coachingDB;
USE coachingDB;

CREATE TABLE IF NOT EXISTS reviews (
    review_id     INT PRIMARY KEY,
    coaching_name VARCHAR(255),
    faculty_name  VARCHAR(255),
    rating        INT,
    review_text   VARCHAR(255),
    student_name  VARCHAR(255)
);
```

### Step 3 — Configure Database Credentials

Open `backend/src/main/resources/application.properties` and update if needed:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/coachingDB
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Step 4 — Run the Backend

```bash
cd backend
.\mvnw spring-boot:run        # Windows
./mvnw spring-boot:run        # Mac/Linux
```

You should see:
```
Started CoachingReviewSystemApplication on port 8080
```

### Step 5 — Open the Frontend

Open `frontend/index.html` in your browser.

> The frontend connects to `http://localhost:8080/api/reviews` automatically.

---

## 📡 API Endpoints

Base URL: `http://localhost:8080/api/reviews`

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/reviews` | Get all reviews |
| `POST` | `/api/reviews` | Add a new review |
| `PUT` | `/api/reviews/{id}` | Update rating by ID |
| `DELETE` | `/api/reviews/{id}` | Delete review by ID |
| `GET` | `/api/reviews/search?name=` | Search reviews by coaching name |

### Sample Request — Add Review

```json
POST /api/reviews
Content-Type: application/json

{
  "id": 1,
  "coachingName": "Aakash Institute",
  "facultyName": "Dr. Rajesh Sharma",
  "rating": 5,
  "review": "Excellent teaching methodology!",
  "studentName": "Rahul Verma"
}
```

### Sample Response

```json
{
  "id": 1,
  "coachingName": "Aakash Institute",
  "facultyName": "Dr. Rajesh Sharma",
  "rating": 5,
  "review": "Excellent teaching methodology!",
  "studentName": "Rahul Verma"
}
```

---

## 🌱 Sample Data

Run this in MySQL to populate the database with dummy reviews:

```sql
USE coachingDB;

INSERT INTO reviews (review_id, coaching_name, faculty_name, rating, review_text, student_name) VALUES
(1, 'Aakash Institute', 'Dr. Rajesh Sharma', 5, 'Excellent teaching methodology. Study material is top-notch.', 'Rahul Verma'),
(2, 'ALLEN Career Institute', 'Prof. Suresh Gupta', 5, 'Best for NEET preparation. Very motivating environment.', 'Ankit Patel'),
(3, 'FIITJEE', 'Dr. Vinod Kumar', 5, 'Cracked JEE Advanced AIR 245 thanks to amazing faculty.', 'Arjun Reddy'),
(4, 'Vedantu', 'Ms. Pooja Iyer', 5, 'Online classes are very interactive. Can re-watch anytime.', 'Karan Joshi'),
(5, 'Resonance', 'Prof. Deepak Mishra', 5, 'Best institute in Kota. Peer group is incredibly talented.', 'Siddharth Tomar');
```

---

## 🖥️ Original Console Version

The original JDBC-based console application (`CoachingReviewSystem.java`) is preserved in the root directory. It connects directly to MySQL using JDBC and supports all CRUD operations via a terminal menu.

To run it:
1. Ensure the MySQL JDBC driver (Connector/J) is in the classpath
2. Compile and run `CoachingReviewSystem.java`

---

## 🐛 Common Issues & Fixes

| Error | Fix |
|---|---|
| `No suitable driver found` | Add MySQL Connector/J to classpath or `pom.xml` |
| `Failed to determine a suitable driver class` | Check `application.properties` has correct DB URL |
| `Access denied for user 'root'` | Verify MySQL username and password in properties file |
| `ClassNotFoundException` for main class | Run via terminal: `.\mvnw spring-boot:run` inside `backend/` |
| Review shows `"null"` in UI | Add `@Column(name = "review_text")` to `review` field in `Review.java` |
| `CORS error` in browser | Ensure `@CrossOrigin(origins = "*")` is on `ReviewController` |

---

## 🔮 Future Improvements

- [ ] User authentication (JWT-based login/signup)
- [ ] Image upload for coaching institute logos
- [ ] Pagination for large number of reviews
- [ ] Filter reviews by rating, subject, or city
- [ ] Admin dashboard with analytics charts
- [ ] Mobile app (React Native / Flutter)
- [ ] Deploy on AWS / Railway / Render

---

## 👨‍💻 Author

**Rushikesh Korde**
- GitHub: [@korderushi07](https://github.com/korderushi07)

---

## 📄 License

This project is licensed under the **MIT License** — feel free to use, modify, and distribute.

---

<div align="center">
  <strong>⭐ If you found this project helpful, please give it a star on GitHub! ⭐</strong>
</div>
