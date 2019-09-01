create database mybatis;
use mybatis;

CREATE TABLE teacher(
    t_id INT PRIMARY KEY AUTO_INCREMENT,
    t_name VARCHAR(20),
    t_class_id INT
);
INSERT INTO teacher(t_name, t_class_id) VALUES('teacher_one', 1);
INSERT INTO teacher(t_name, t_class_id) VALUES('teacher_two', 1);
INSERT INTO teacher(t_name, t_class_id) VALUES('teacher_three', 1);
INSERT INTO teacher(t_name, t_class_id) VALUES('teacher_four', 2);
INSERT INTO teacher(t_name, t_class_id) VALUES('teacher_five', 2);
INSERT INTO teacher(t_name, t_class_id) VALUES('teacher_six', 2);