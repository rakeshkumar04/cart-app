# Cart App — E-Commerce Backend API

A production-ready **Spring Boot E-Commerce Backend** that provides APIs for managing products, orders, and reviews.

This project demonstrates real-world backend architecture including:

* Product catalog management
* Order creation & tracking
* Product reviews
* Search & filtering
* Pagination
* DTO-based request handling
* MySQL database integration

---

# Tech Stack

* **Java 17+**
* **Spring Boot**
* **Spring Data JPA**
* **Hibernate**
* **MySQL**
* **OpenAPI / Swagger**
* **Maven**

---

# Base URL

```
http://localhost:8080
```

Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

OpenAPI Spec:

```
http://localhost:8080/v3/api-docs
```

---

# API Endpoints

---

## Products

---

### Get All Products (Paginated)

```
GET /api/product
```

### Query Params

| Param | Type | Default |
| ----- | ---- | ------- |
| page  | int  | 0       |
| size  | int  | 5       |

### Example

```
GET /api/product?page=0&size=10
```

---

### Get Product By ID

```
GET /api/product/{id}
```

### Example

```
GET /api/product/1
```

### Response (200)

```json
{
  "id": 1,
  "name": "Apple iPhone 15 Pro",
  "price": 999.0,
  "description": "A17 Pro Chip Titanium Design",
  "category": "Smartphones",
  "ratings": 4.9,
  "seller": "Apple Store",
  "stock": 5
}
```

---

### Search Products

```
GET /api/product/search
```

### Query Params

| Param    | Type   | Description             |
| -------- | ------ | ----------------------- |
| category | string | Filter by category      |
| minPrice | double | Minimum price           |
| maxPrice | double | Maximum price           |
| keyword  | string | Name/description search |
| ratings  | double | Minimum rating          |

### Example

```
GET /api/product/search?category=Smartphones&minPrice=500
```

---

## Product Reviews

---

### Add Review

```
POST /api/products/reviews
```

### Request Body

```json
{
  "productId": 1,
  "comment": "Excellent product!",
  "rating": 4.5
}
```

### Response

```json
{
  "message": "Review added successfully"
}
```

---

## Orders

---

### Create Order

```
POST /api/orders
```

### Request Body

```json
{
  "orderItems": [
    {
      "name": "Apple iPhone 15 Pro",
      "quantity": 1,
      "image": "/product/1.jpg",
      "price": 999.0,
      "productId": 1
    },
    {
      "name": "Samsung Galaxy S24 Ultra",
      "quantity": 1,
      "image": "/product/2.jpg",
      "price": 1199.0,
      "productId": 2
    }
  ]
}
```

### Response

```json
{
  "orderItems": ["..."],
  "status": "PENDING",
  "taxAmount": 10.0,
  "totalItemAmount": 2198.0,
  "totalAmount": 2208.0
}
```

---

### Get Order By Reference ID

```
GET /api/orders/{referenceId}
```

### Example

```
GET /api/orders/ORD-2026-0001
```

---

# Data Models

---

## ProductReviewDTO

```json
{
  "productId": 1,
  "comment": "Great product",
  "rating": 4.5
}
```

---

## CreateOrderRequest

```json
{
  "orderItems": [
    {
      "name": "Product Name",
      "quantity": 1,
      "image": "/img.jpg",
      "price": 100,
      "productId": 1
    }
  ]
}
```

---

## OrderItemDTO

| Field     | Type   |
| --------- | ------ |
| name      | string |
| quantity  | int    |
| image     | string |
| price     | double |
| productId | long   |

---

## Product

| Field       | Type   |
| ----------- | ------ |
| id          | long   |
| name        | string |
| price       | double |
| description | string |
| category    | string |
| ratings     | double |
| seller      | string |
| stock       | int    |

---

# Running Locally

### Clone Repo

```bash
git clone https://github.com/rakeshkumar04/cart-app.git
cd cart-app
```

### Configure Environment

`.env`

```
DB_URL=jdbc:mysql://localhost:3306/cart-app
DB_USER=root
DB_PASS=yourpassword
```

### Run

```bash
mvn spring-boot:run
```

---

# Features

* DTO-based API design
* Order total & tax calculation
* Product search filters
* Review system
* Pagination support
* Environment-based configs
* Swagger documentation

---

# Environment Profiles

| Profile | Purpose           |
| ------- | ----------------- |
| dev     | Local development |
| prod    | Production config |

Run with:

```
-Dspring.profiles.active=prod
```

---

# License

MIT License — Free to use and modify.

---

# 👨Author

**Rakesh Kumar**

Developer & Designer

---
