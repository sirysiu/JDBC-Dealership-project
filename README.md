
# JDBC-Dealership-project

## Overview

The **Car Dealership Management System** is a Java-based application that manages the operations of a car dealership, including managing vehicles, dealerships, inventory, sales contracts, and lease contracts. The system follows the **DAO (Data Access Object)** design pattern to separate database interactions from business logic, making the code more modular, maintainable, and testable.

The system uses **MySQL** as the database to store information about dealerships, vehicles, inventory, and contracts, while providing a simple user interface to interact with the system.

## Features

- **Dealership Management**: Add, remove, and list dealerships.
- **Vehicle Management**: Add, remove, and list vehicles in the inventory.
- **Search Vehicles**: Filter vehicles by price range, make/model, year, mileage, and type.
- **Sales Contracts**: Record sales transactions including tax, fees, and customer information.
- **Lease Contracts**: Record lease transactions with lease terms and amounts.
- **DAO Pattern**: The application utilizes the **DAO (Data Access Object)** pattern for separating database access logic from the business logic.

## Project Structure

The project is divided into several key components:

1. **Models**: The core business entities (e.g., `Dealership`, `Vehicle`, `SalesContract`, `LeaseContract`).
2. **DAO Layer**: The data access objects (DAOs) responsible for interacting with the MySQL database.
3. **Main Application**: The user interface where the dealership manager can interact with the system (e.g., via command-line interface).
4. **Database Schema**: The database tables used for storing and retrieving dealership data.

### 1. Models

These classes represent the entities of the system, such as Dealership, Vehicle, and Contract. Each class is designed to encapsulate the properties and behaviors of its respective entity.
## 2. DAO Layer

The DAO (Data Access Object) Layer is responsible for abstracting all database operations and providing a clean, consistent interface for the rest of the application to interact with the database. The DAO Layer helps decouple the business logic from the actual data persistence logic, allowing for easier maintenance and testing of the core application logic.

### Responsibilities

- **Abstract Database Operations**: The DAO Layer hides the complexities of the underlying database, providing simple methods for CRUD operations (Create, Read, Update, Delete).
- **Separation of Concerns**: Keeps database access code separate from business logic, making the system more modular and easier to modify or extend.
- **Error Handling**: Provides error handling mechanisms for database operations, ensuring that any issues with database access are properly managed and communicated.
- **Database Connection Management**: Manages the database connection lifecycle, including opening, closing, and reusing connections.

## 3. Database Schema

The project uses a **MySQL** database to store critical information regarding **vehicles**, **dealerships**, **inventory**, and **contracts**. Below is the SQL schema that defines the database tables and their relationships.

### Tables
**Dealerships Table**

   This table stores information about the dealerships that sell vehicles.

   ```sql
   CREATE TABLE dealerships (
       dealership_id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       address VARCHAR(255),
   );
   ```

## 4. Main Application

The user interacts with the system through a **Command-Line Interface (CLI)**, which serves as the main entry point of the application. The CLI allows users to perform various operations such as adding vehicles, searching for vehicles, and removing them from the inventory. This approach provides a simple, text-based interface that is both user-friendly and efficient.

### Overview of Operations

The CLI offers several commands for managing vehicles, dealerships, and inventory. Below are the key operations that users can perform through the application:

### 1. Add Vehicle

This command allows the user to add a new vehicle to the system. The user must provide details such as the make, model, year, VIN (Vehicle Identification Number), color, price, and dealership.

**Command Syntax:**
```bash
add_vehicle <make> <model> <year> <vin> <color> <price> <mileage> <dealership_id>
```
## Conclusion

The **Car Dealership Management System** is a complete, Java-based solution for managing dealership operations. It offers a robust, scalable way to handle key business processes, such as vehicle inventory management, customer contracts, and dealership operations. By using the **DAO (Data Access Object)** pattern for database interaction, the system separates business logic from data access, ensuring a more maintainable and flexible codebase.

### Key Features

- **Vehicle Management**: Easily add, search, and manage vehicles in the dealership inventory.
- **Inventory Tracking**: Keep track of vehicle stock and quantities for each dealership.
- **Contract Generation**: Record and manage customer contracts and sales transactions.
- **Simple CLI Interface**: Provides a user-friendly command-line interface (CLI) to interact with the system.

### Design and Architecture

The system follows the **DAO pattern** to abstract the database interactions, making it easier to modify or replace the database without affecting the core application logic. This separation of concerns improves **maintainability**, **scalability**, and **testability**.

- **Maintainability**: Changes in the database schema or queries can be made independently of the business logic, making future updates and debugging more straightforward.
- **Scalability**: The modular architecture allows easy addition of new features and the support for multiple dealerships and vehicles.
- **Testability**: DAO interfaces can be easily mocked in unit tests, making it simpler to test business logic without requiring a live database connection.

### Next Steps

1. **Customization**: Feel free to adjust the database schema, vehicle details, or commands to better fit the specific needs of your car dealership.
2. **Integration**: The system can be further integrated with external systems such as payment gateways or customer relationship management (CRM) tools.
3. **Expansion**: Additional features such as a web-based user interface (UI), reporting, or inventory forecasting could be added to enhance the system's capabilities.

By using the **DAO pattern** and a clear command-line interface, the system ensures a streamlined approach to managing a car dealership's daily operations while providing a solid foundation for future growth.

This README file provides a clear and structured overview of the project, covering its functionality, setup, and rationale behind the design choices, particularly the DAO pattern. Feel free to adjust the setup and examples to match the specifics of your project and enhance its usability!




