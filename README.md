# Bookstore

#### Technology Stack
	 Backend (REST) => SpringBoot 
	 Security => Token Based (Spring Security and JWT )
	 In Memory DB => H2
	 Server Build Tools => Maven

#### StartWebAPI
	mvn clean install
	mvn spring-boot:run

#### API Provide
	http://localhost:8080/login
	http://localhost:8080/addOrders
	http://localhost:8080/getUser
	http://localhost:8080/createUser
	http://localhost:8080/deleteUser
	http://localhost:8080/books

#### Database 
	http://localhost:8080/h2-console/

#### Database Design Table

##### User

| Name           | Type             |
| :------------- | ---------------- |
| USERNAME             | VARCHAR(255) NOT NULL  |
| PASSWORD      | VARCHAR(255)     |
| FIRST_NAME | VARCHAR(255) |
| LAST_NAME          | DOUBLE NOT NULL  |
| ROLE  | VARCHAR(255)     |
|  BIRTHDAY  | TIMESTAMP    |

##### OrderBook

| Name           | Type             |
| :------------- | ---------------- |
| ID             | BIGINT NOT NULL  |
| USERNAME      | VARCHAR(255)     |
| BOOKID | BOOLEAN NOT NULL |

##### Book

| Name           | Type             |
| :------------- | ---------------- |
| ID             | BIGINT NOT NULL  |
| BOOK_NAME      | VARCHAR(255)     |
| IS_RECOMMENDED | BOOLEAN NOT NULL |
| PRICE          | DOUBLE NOT NULL  |
| AUTHOR_NAME    | VARCHAR(255)     |




