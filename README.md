# Product Management System

This project provides a system to manage products and their relationships with clients. It uses Spring Boot and includes functionalities for creating and retrieving product details via a REST API.

## Key Components

### Entities

#### `Product`
- Represents a product in the system.
- Fields:
  - `id` (Long): Unique identifier for the product.
  - `name` (String): Name of the product.
  - `price` (float): Price of the product.
  - `status` (boolean): Availability status of the product.
  - `client` (Client): The client associated with the product.
- Annotations:
  - `@Entity`: Marks the class as a JPA entity.
  - `@Table(name="products")`: Maps the entity to the `products` table.
  - `@ManyToOne`: Defines the relationship with the `Client` entity.

#### `Client`
- Represents a client in the system (assumed to be defined elsewhere).

### DTO

#### `ProductDto`
- A data transfer object for transferring product data between the client and server.
- Fields:
  - `name` (String): Name of the product.
  - `price` (float): Price of the product.
  - `status` (boolean): Availability status of the product.
  - `client_id` (int): ID of the associated client.
- Annotations:
  - `@JsonProperty`: Maps the JSON property `client_id` to the `client_id` field and ensures consistent serialization/deserialization.

### Controller

#### `addNewProduct`
- Endpoint: `POST /products`
- Request Body: `ProductDto`
- Functionality:
  - Retrieves the client using `client_id` from `ProductDto`.
  - Creates a new `Product` entity and populates it with data from the DTO.
  - Saves the new product using the `ProductService`.
  - Returns the created product.
- Example Request:
  ```json
  {
      "name": "Sample Product",
      "price": 99.99,
      "status": true,
      "client_id": 1
  }
  ```
- Example Response:
  ```json
  {
      "name": "Sample Product",
      "price": 99.99,
      "status": true,
      "client_id": 1
  }
  ```

### Services

#### `ClientService`
- Provides functionality to retrieve a `Client` by its ID.

#### `ProductService`
- Handles business logic for managing products, including saving new products.

## Development Notes

### Issues and Fixes
- **Problem**: `client_id` was not being deserialized properly from the JSON payload.
  - **Solution**: Added `@JsonProperty("client_id")` annotation to both the `client_id` field and its getter in `ProductDto` to ensure proper mapping.

- **Problem**: Duplicate properties `client_id` and `clientId` in JSON responses.
  - **Solution**: Explicitly defined `@JsonProperty("client_id")` for both serialization and deserialization to use only `client_id` consistently.

### Example cURL Request
To add a new product:
```bash
curl -X POST -H "Content-Type: application/json" \
-d '{"name": "Sample Product", "price": 99.99, "status": true, "client_id": 1}' \
http://localhost:8080/products
```

## Getting Started

### Prerequisites
- Java 17+
- Maven
- A running database (e.g., MySQL) configured in `application.properties`.

### Running the Application
1. Clone the repository.
2. Configure database connection in `application.properties`.
3. Build the project:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## License
This project is open-source and available under the [MIT License](LICENSE).

