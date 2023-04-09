# Library Management System RESTful API Project
This project is a RESTful API for a library management system built using Spring Boot. The API provides endpoints for managing authors, books, and cards. Lombok is used to reduce boilerplate code, and Mail Sender functionality in Spring Boot is used to send email notifications to students when book transactions are done. The API is documented using Swagger, and the database schema is designed and implemented using MySQL and JPA Hibernate.

## Technologies Used
  Spring Boot
  REST API
  MySQL
  JPA Hibernate
  Lombok
  JavaMail API
  Swagger
## Features
  Create, read, update, and delete operations for authors, books, and cards
  Send email notifications to students when book transactions are done
  Documented using Swagger
  Efficient storage and retrieval of customer and product data using MySQL and JPA Hibernate.

## Usage
Authors
Get all authors
bash
Copy code
GET /authors
Returns a list of all authors.

#### Example Response:
[
    {
        "id": 1,
        "name": "Jane Austen",
        "email": "jane.austen@example.com"
    },
    {
        "id": 2,
        "name": "Charles Dickens",
        "email": "charles.dickens@example.com"
    }
]
### Get author by ID
JSON code:
#### GET /authors/{id}
Returns the author with the specified ID.

### Example Response:

json code
{
    "id": 1,
    "name": "Jane Austen",
    "email": "jane.austen@example.com"
}

## Demo
![Screenshot (135)](https://user-images.githubusercontent.com/61372250/230760007-e962175f-af02-4a2f-af39-a01c1f08bff3.png)
![Screenshot (136)](https://user-images.githubusercontent.com/61372250/230760012-f44dd3a4-9bc9-49d8-9234-348fb0a40a75.png)
![Screenshot (136)](https://user-images.githubusercontent.com/61372250/230760023-ac67a22d-7360-4347-b72e-73287bbd8c44.png)
![Screenshot (136)](https://user-images.githubusercontent.com/61372250/230760031-9029afbb-3c6a-4d5e-aded-4e16d14f2027.png)
