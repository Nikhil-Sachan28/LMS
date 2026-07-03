# Product Requirements Document — Learning Management System

Build a Learning Management System where:

1. The system supports two types of users:

    * Students
    * Instructors

2. Instructors can create courses and manage course content.

3. Students can enroll in courses and submit reviews.

4. Courses are divided into Modules and Modules contain Lessons.

5. The system tracks enrollments and course progress.

6. Every entity in the system must have a UUID as its primary key.

---

# Milestone A : User Structure and Inheritance

## Task 1: Create Base User Entity

### Objective

Learn inheritance, mapped superclass, and common fields.

Create an abstract User entity with:

* UUID id
* String name
* String email
* LocalDateTime createdAt

The User entity should never be instantiated directly.

---

## Task 2: Create Student Entity

Student extends User.

Fields:

* collegeName
* graduationYear

Requirements:

* Student can enroll in courses.
* Student can review courses.

---

## Task 3: Create Instructor Entity

Instructor extends User.

Fields:

* specialization
* experienceYears

Requirements:

* Instructor can create courses.
* Instructor can update courses.
* Instructor can delete their own courses.

---

## Acceptance Criteria

* User should be abstract.
* Student and Instructor should inherit from User.
* UUID should be used as primary key.
* Proper inheritance strategy should be used.

---

# Milestone B : Course Management

## Task 1: Create Course Entity

Fields:

* UUID id
* title
* description
* price
* createdAt

Relationships:

* One Instructor can create multiple Courses.
* One Course belongs to exactly one Instructor.

Relationship:

Instructor (1) ---- (*) Course

---

## Task 2: Course APIs

Create APIs:

POST /courses

GET /courses/{id}

GET /courses

PUT /courses/{id}

DELETE /courses/{id}

---

## Acceptance Criteria

* Course creation requires instructorId.
* Course list should support pagination.
* Course list should support sorting by:

    * title
    * price
    * creation date

---

# Milestone C : Modules and Lessons

## Task 1: Create Module Entity

Fields:

* UUID id
* title
* orderNumber

Relationship:

Course (1) ---- (*) Module

---

## Task 2: Create Lesson Entity

Fields:

* UUID id
* title
* content
* durationInMinutes

Relationship:

Module (1) ---- (*) Lesson

---

## Acceptance Criteria

Deleting a course should automatically delete:

* Modules
* Lessons

This milestone should introduce:

* Cascade operations
* orphanRemoval

---

# Milestone D : Enrollment System

## Task 1: Create Enrollment Entity

Do NOT use ManyToMany directly.

Create an Enrollment entity.

Fields:

* UUID id
* enrollmentDate
* progressPercentage

Relationships:

Student (1) ---- (*) Enrollment

Course (1) ---- (*) Enrollment

---

## Task 2: Enrollment APIs

POST /courses/{courseId}/enroll/{studentId}

GET /students/{studentId}/courses

GET /courses/{courseId}/students

DELETE /courses/{courseId}/unenroll/{studentId}

---

## Acceptance Criteria

* A student cannot enroll twice in the same course.
* Enrollment date must be stored.
* Progress percentage defaults to 0.

---

# Milestone E : Reviews

## Task 1: Create Review Entity

Fields:

* UUID id
* rating
* comment
* createdAt

Relationships:

Student (1) ---- (*) Review

Course (1) ---- (*) Review

---

## APIs

POST /courses/{courseId}/reviews

GET /courses/{courseId}/reviews

---

## Acceptance Criteria

* Rating must be between 1 and 5.
* Only enrolled students can review a course.
* Instructor cannot review their own course.

---

# Milestone F : DTO Layer

Create DTOs for all request and response objects.

Examples:

CourseRequestDTO

CourseResponseDTO

StudentDTO

InstructorDTO

EnrollmentDTO

ReviewDTO

---

## Acceptance Criteria

* Entities should never be returned directly from controllers.
* Controllers should only use DTOs.

---

# Milestone G : Repository Layer

Create repositories:

* StudentRepository
* InstructorRepository
* CourseRepository
* ModuleRepository
* LessonRepository
* EnrollmentRepository
* ReviewRepository

---

## Derived Query Methods

Implement:

findByTitle()

findByPriceLessThan()

findByInstructorId()

findByRatingGreaterThan()

findByStudentId()

findByCourseId()

---

# Milestone H : Lazy vs Eager Loading

Configure relationships using Lazy Loading.

Experiment with Eager Loading for:

Course -> Instructor

Compare generated SQL queries.

---

## Acceptance Criteria

You should be able to explain:

* N+1 Query Problem
* LazyInitializationException
* Why DTO mapping exists

---

# Milestone I : Validation

Add validations:

Student:

* email cannot be blank

Course:

* title cannot be empty
* price cannot be negative

Review:

* rating must be between 1 and 5

---

# Milestone J : Business Rules

Implement:

1. Maximum 5 active enrollments per student.

2. Course price cannot be negative.

3. Duplicate module names inside a course are not allowed.

4. Duplicate lesson names inside a module are not allowed.

5. An instructor cannot delete a course with active enrollments.

---

# Bonus Tasks

1. Search courses by title.

2. Search courses by instructor name.

3. Return average rating of each course.

4. Return total enrolled students for each course.

5. Return top 5 most popular courses.

6. Add soft delete support.

7. Add auditing fields:

    * createdBy
    * updatedBy
    * updatedAt

---

# Final Entity Diagram

User
├── Student
└── Instructor

Instructor (1) -------- (*) Course

Course (1) -------- (*) Module

Module (1) -------- (*) Lesson

Student (1) -------- (*) Enrollment (*) -------- (1) Course

Student (1) -------- (*) Review (*) -------- (1) Course

---

# Concepts Covered

* REST Controllers
* Service Layer
* Repository Pattern
* DTOs
* UUID
* JPA Inheritance
* OneToMany
* ManyToOne
* Cascading
* orphanRemoval
* Lazy Loading
* Eager Loading
* Derived Queries
* Validation
* Pagination
* Sorting
* Business Rules
