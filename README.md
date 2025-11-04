# Expense Tracker REST API

A RESTful API for tracking personal expenses built with Spring Boot and Spring Data JPA.

## Features

- Create, read, update, and delete expenses
-  Track expense amount, category, description, and date
-  RESTful API with proper HTTP methods and status codes
-  Three-layer architecture (Controller, Service, Repository)
-  JPA/Hibernate for database operations

## Technologies

- **Java 25**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **H2 Database**
- **Maven**
- **Lombok**

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/expenses` | Get all expenses |
| GET | `/api/expenses/{id}` | Get expense by ID |
| POST | `/api/expenses` | Create new expense |
| PUT | `/api/expenses/{id}` | Update expense |
| DELETE | `/api/expenses/{id}` | Delete expense |

## Getting Started

### Prerequisites
- Java 17+
- Maven

### Run the Application
```bash
# Clone the repository
git clone https://github.com/YOUR-USERNAME/expense-tracker-api.git
cd expense-tracker-api

# Run with Maven
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

## Example Usage

### Create an Expense (POST)
```json
{
  "amount": 50.00,
  "category": "Food",
  "description": "Lunch",
  "date": "2025-11-03"
}
```

### Response
```json
{
  "id": 1,
  "amount": 50.0,
  "category": "Food",
  "description": "Lunch",
  "date": "2025-11-03"
}
```

## Project Structure
```
src/main/java/com/example/expense_tracker/
├── controller/      # REST API endpoints
├── service/         # Business logic
├── repository/      # Database access
└── model/          # Entity classes
```

## Future Enhancements

- [ ] User authentication (JWT)
- [ ] Expense filtering by date range
- [ ] Statistics and analytics
- [ ] Budget tracking
- [ ] Frontend integration

## Author

[Teerth Patel] 

## License

MIT License
