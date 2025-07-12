INSERT INTO `STUDENTS`(id, `firstName`, `lastName`, marks) VALUES 
(1, "Pham", "Van", 7),
(3, "Nguyen", "Lan", 9);

INSERT INTO `BOOKS`(id, author, isbn, title) VALUES
(2, "Christian Bauer", "9781617293452", "Java Persistence with Hibernate");

INSERT INTO `STUDENT_BOOKS`(student_id, book_id) VALUES
(1, 2), (3, 2);