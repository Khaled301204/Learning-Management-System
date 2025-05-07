
---

### 📘 Learning Management System (LMS) – Extended Description

This project is a **Learning Management System (LMS)** built using **Spring Boot**. It enables structured management of users, courses, and enrollments in a way that supports distinct user roles such as **Admins**, **Instructors**, and **Students**. The system is role-based and provides access control for secure operations.

---

### 🎯 System Purpose

The LMS is designed to help educational institutions or online platforms manage digital courses, user registrations, and learning workflows efficiently. Admins can create user accounts, instructors can manage course-related content (currently limited), and students can enroll in courses. The system aims to be modular, extendable, and secure.

---

### 🧑‍💻 User Roles and Behavior

* **Admins** are the only users allowed to register new accounts in the system. They must be logged in to create users and can register users as students, instructors, or other admins.
* **Instructors** are associated with courses. Currently, their functionality is mostly structural, but the design supports future expansions for content creation, lesson management, and student tracking.
* **Students** can be enrolled in courses and have personal profiles. They can update their own data but are restricted from accessing or modifying information that belongs to others.

All users are authenticated via session-based authentication using Spring Security, and access control is handled programmatically in the service layer.

---

### 🛠️ Backend Architecture

The project is organized into standard Spring layers:

* **Controller Layer:** Handles incoming HTTP requests. For example, `AuthController` provides endpoints for signing up, logging in, and logging out.
* **Service Layer:** Implements business logic, such as password validation, session verification, and user role enforcement.
* **Entity Layer:** Contains JPA entities that map to the database tables, like `Users`, `Course`, and `Enrollment`.
* **Repository Layer:** Uses Spring Data JPA to perform CRUD operations on the database.

---

### ⚙️ Key Functional Features

* **User Signup:** Only logged-in Admins can create new users. The system verifies that the email is unique and that the user type exists.
* **User Login:** Validates email and password, sets the session, and uses `SecurityContextHolder` to manage security context.
* **User Logout:** Clears the authentication context and invalidates the session.
* **User Type Control:** Each user has a `UsersType` associated with them, which determines what they’re allowed to do.
* **Course Management:** Courses are assigned to instructors. Each course can have multiple lessons (implementation assumed).
* **Enrollment:** Students can be enrolled in courses, and their enrollment date is recorded.

---

### 🔐 Security and Validation

The project uses Spring Security to handle authentication. Sessions are used to manage logged-in users, and only authorized users can access protected actions. Passwords are encrypted using a `PasswordEncoder`.

Before performing sensitive actions like user creation or student profile editing, the system checks whether the logged-in user is authorized to do so.

---

### 🗂️ Entities Overview

* `Users`: The base user entity containing login credentials and metadata like registration date and role type.
* `UsersType`: Represents user roles such as Admin, Student, and Instructor.
* `Course`: Represents a course with details like instructor, media, and duration.
* `Enrollment`: Represents the association between a student and a course.
* `Instructor`, `Student`, `Admin`: Entities that extend functionality by linking to the base `Users` table.

---

### 🔧 Future Enhancements

The architecture supports clean expansion. Here are some planned or possible features:

* Lesson content creation and editing for instructors.
* Assignment and quiz modules with grading features.
* Progress tracking and student dashboards.
* Certificate generation upon course completion.
* API documentation using Swagger.
* Conversion from session-based to JWT-based stateless authentication.
* Frontend integration using React, Angular, or Thymeleaf.

---

