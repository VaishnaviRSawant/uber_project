# Uber Project

## Description
The **Uber Project** is a Spring Boot-based ride-hailing system that facilitates seamless ride booking, driver management, and fare calculations. The application integrates **Spring Data JPA** for database management and provides RESTful APIs for core functionalities.

## Features
- **User Management**: Register, authenticate, and manage users (riders and drivers).
- **Ride Booking**: Request, assign, and complete rides.
- **Driver Management**: Register and update driver details.
- **Fare Calculation**: Dynamic pricing based on distance and demand.
- **Real-Time Tracking**: Track ongoing rides.
- **Database Integration**: Uses **MySQL** for data persistence.

## Tech Stack
- **Backend**: Spring Boot, Spring Data JPA
- **Database**: MySQL
- **Build Tool**: Maven
- **IDE**: IntelliJ IDEA
- **Version Control**: GitHub

## Project Structure
```
Uber_Project/
│── src/
│   ├── main/java/com/example/uber/
│   │   ├── entity/        # Entity classes (User, Driver, Ride, etc.)
│   │   ├── repository/    # Repository interfaces for database operations
│   │   ├── service/       # Business logic layer
│   │   ├── controller/    # REST API controllers
│   ├── main/resources/
│   │   ├── application.properties  # Database configurations
│── pom.xml  # Maven dependencies
│── README.md  # Project documentation
```

## Installation & Setup
1. **Clone the repository:**
   ```sh
   git clone https://github.com/VaishnaviRSawant/uber_project.git
   ```
2. **Navigate to the project directory:**
   ```sh
   cd uber_project
   ```
3. **Configure the database in `application.properties`:**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/uber_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```
4. **Run the application:**
   ```sh
   mvn spring-boot:run
   ```

## API Endpoints
| Endpoint | Method | Description |
|----------|--------|-------------|
| `/users/register` | POST | Register a new user |
| `/drivers/register` | POST | Register a new driver |
| `/rides/request` | POST | Request a ride |
| `/rides/{id}` | GET | Get ride details |
| `/rides/{id}/complete` | PUT | Mark ride as complete |

## Contributions
Feel free to contribute by creating issues or submitting pull requests!

## License
This project is **MIT Licensed**.

## Author
[Vaishnavi R Sawant](https://github.com/VaishnaviRSawant)

