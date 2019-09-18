# E-Commerce Application 

A simple e-commerce application with the the functionality of adding products and placing orders. Using MySQL for the database and Java for the server.

# Getting Started 
## Installation
To start the development server, you need the following prerequisites:
- Openjdk 11.0.4
- OpenJDK Runtime Environment
- MySQL (5.6 +)
- Eclipse EE (for installing dependencies automatically)

## Setting up
- Select import project > Maven > \<project folder\> to import the project and install the sources / dependencies.
- Open the **application.properties** file in **src/main/properties** to set the credentials for **MySQL**.
- Change the **spring.datasource.username** to the username of your MySQL instance. The default username is root
> spring.datasource.username=\<your-mysql-username\>

- Change the **spring.datasource.password** to the corresponding password of your MySQL instance. The default password is root1234
> spring.datasource.password=\<your-mysql-password\>

- Click on Run to run the server
- Open http://localhost:8080/ on a browser to explore data

## Usage
- Adding a product
> curl -XPOST -d '{
	"remainingQuantity": 10,
	"product": {
		"name": "screwdriver",
		"type": "hardware"
	}
}' 'localhost:8080/inventory/new'
- Viewing all the products
> curl -XGET 'localhost:8080/product/all'
- Placing an order
> curl -XGET 'localhost:8080/order/new?name=screwdriver&quantity=5'
