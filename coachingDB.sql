CREATE DATABASE coachingDB;
USE coachingDB;

CREATE TABLE reviews (
    review_id INT PRIMARY KEY,
    coaching_name VARCHAR(100),
    faculty_name VARCHAR(100),
    rating INT,
    review_text VARCHAR(255),
    student_name VARCHAR(100)
);

select* from reviews;