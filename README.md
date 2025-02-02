# ZYNTRA-ELEVATE-EXPECTATIONS-
# Zyntra: Elevate Expectations

## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Installation](#installation)
5. [Database Configuration](#database-configuration)
6. [Usage](#usage)
7. [Screenshots](#screenshots)
8. [Contributing](#contributing)
9. [License](#license)

## Introduction

Zyntra is a Java Swing-based desktop application that provides a user-friendly interface for seamless social integration, networking, and productivity enhancement. Users can sync their accounts, navigate through different sections, and access various utilities to streamline their digital interactions.

## Features

- **Welcome Screen** with motivational messages and navigation buttons
- **User Syncing** via Instagram, Snapchat, WhatsApp, Facebook, and Phone Number
- **Database Connectivity** to store and manage user information
- **Multi-Section Interface** including Inner Circle, Social Circle, Professional Network, and Community Hub
- **Sidebar Menu** for quick access to features like Cloud Sync, Priority Alerts, Quick-Brief, and Meeting Mode
- **Interactive UI** with buttons, tooltips, and responsive actions

## Technologies Used

- **Java Swing** for GUI development
- **JDBC (Java Database Connectivity)** for database integration
- **MySQL** for storing user data

## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/zyntra.git
   ```
2. Open the project in an IDE like IntelliJ IDEA or Eclipse.
3. Ensure you have Java JDK 8+ installed.
4. Install MySQL and create the necessary database.

## Database Configuration

1. Open MySQL and create a database named `zyntradb`:
   ```sql
   CREATE DATABASE zyntradb;
   ```
2. Create the `Users` table:
   ```sql
   CREATE TABLE Users (
       id INT AUTO_INCREMENT PRIMARY KEY,
       username VARCHAR(100) UNIQUE NOT NULL,
       email VARCHAR(255),
       phoneNumber VARCHAR(20),
       platform VARCHAR(50)
   );
   ```
3. Update the database credentials in the `ZyntraWelcomeWithUnifiedMenu` class:
   ```java
   Connection conn = DriverManager.getConnection(
       "jdbc:mysql://localhost:3306/zyntradb", "root", "your-password"
   );
   ```

## Usage

1. Run the main class `ZyntraWelcomeWithUnifiedMenu`.
2. Sync your account by selecting a platform and entering user details.
3. Navigate using the forward button to access different sections.
4. Use the sidebar menu to explore various features.
5. Click "Sign Out" to exit the application.

## Screenshots

![image](https://github.com/user-attachments/assets/e16f7599-589e-4d6c-8b88-d600133dd6bc)
![image](https://github.com/user-attachments/assets/56f2e850-973f-4356-98fe-66b9fd882283)
![image](https://github.com/user-attachments/assets/a940578c-9f08-47b9-943b-9405ba215641)
![image](https://github.com/user-attachments/assets/d4b1c751-ab7c-4506-9b6e-4bcd6c0f8a2f)
![image](https://github.com/user-attachments/assets/ecf122dc-0836-4a16-ad0b-e4c962c12bb1)
![image](https://github.com/user-attachments/assets/9e5a5e26-c1d8-4d0d-acbf-e057b00232f8)

![image](https://github.com/user-attachments/assets/d2cd2551-873c-4d8f-b947-dd9454b91959)


## Contributing

Feel free to submit issues, feature requests, or pull requests to improve the project.

## License

This project is licensed under the MIT License. See `LICENSE` for details.

