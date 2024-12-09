# JUnit 2024 Course Repository

<p align="center">
  <img src="junit5-Logo.webp" alt="JUnit Logo" width="200">
</p>

Welcome to the **JUnit 2024 Course Repository**! This project serves as the foundation for learning and practicing JUnit testing concepts. It is a **Spring Boot** application built using **Maven** to demonstrate unit testing best practices.

## Project Overview

This repository is designed for the JUnit section of the course, providing examples and exercises to learn how to:
- Write effective unit tests
- Use assertions in JUnit
- Test Spring Boot applications
- Integrate JUnit with Maven for continuous testing
- Apply mocking frameworks like Mockito

## Prerequisites

To get started with this repository, make sure you have the following installed:
- **Java 21** (or a compatible version)
- **Maven** (version 3.8.1 or later)
- **Git**

## Setup Instructions

1. Clone this repository:
   ```bash
   git clone https://gitlab.com/joseCordobaCourses/junit2024.git
   ```
2. Navigate to the project directory:
   ```bash
   cd junit2024
   ```
3. Build the project with Maven:
   ```bash
   mvn clean install
   ```
4. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

## Learning Objectives

- Understand the fundamentals of JUnit testing
- Write unit tests for Java classes and Spring components
- Use annotations like `@Test`, `@BeforeEach`, and `@AfterEach`
- Explore test lifecycle and parameterized tests
- Learn to test service, controller, and repository layers
- Mock external dependencies with Mockito

## Project Structure

```plaintext
junit2024/
├── src/main/java        # Application source code
├── src/test/java        # JUnit test cases
├── pom.xml              # Maven configuration file
└── README.md            # Project documentation
```

## License

This project is distributed under the MIT License. See `LICENSE` for more information.

## Contributing

Contributions are welcome! Feel free to fork this repository and submit a pull request.

## Author

This repository is maintained by **José Córdoba** as part of the JUnit 2024 course.

## Contributers



---

Happy coding and testing! 🎉