SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS school (
  id int PRIMARY KEY auto_increment,
  location VARCHAR,
);

CREATE TABLE IF NOT EXISTS students (
  id int PRIMARY KEY auto_increment,
  courseId int,
  name VARCHAR,
  age int,
  enrolled BOOLEAN,
);

CREATE TABLE IF NOT EXISTS courses (
  courseId int PRIMARY KEY auto_increment,
  name VARCHAR,
  cost int,
  description VARCHAR,
);

CREATE TABLE IF NOT EXISTS alumni (
  id int PRIMARY KEY auto_increment,
  studentId int,
  age int,
);

CREATE TABLE IF NOT EXISTS school_courses (
  id int PRIMARY KEY auto_increment,
  location VARCHAR,
  courseId int,
);
