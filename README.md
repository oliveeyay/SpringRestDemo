RestDemo using Spring, Hibernate, Jersey, JPA2
======================

Prerequisites:
--
- MySQL
- Eclipse
- JDK 1.7 (if you want to use Jetty 9 with the jetty-maven-plugin from project)
- Maven

Technologies used
--
- Spring 3.2
- JPA 2
- Maven 4
- Tomcat 7
- Jetty 9
- MySql 6
- Hibernate 4
- Jersey 2.4

Install
--
Create database schema using the files in src/main/resources/data

Run the example
--
- Clone the project 
- Import in Eclipse 
- Run Configuration -> Maven Goals "clean install jetty:run -DskipTests=true"

Make some requests
--

```
GET REQUEST to http://localhost:8080/test/orders (have the complete list of orders)
GET REQUEST to http://localhost:8080/test/orders/1 (have the order with primary key "1")
```

```
POST REQUEST to http://localhost:8080/test/orders with json :
{
	"order_date" : "2014-03-17 00:00",
	"order_object" : "2 sushis, 2 sashimis etc",
	"customer" : {
		"idcustomer" : 1
		},
	"restaurant" : {
		"idrestaurant" : 1
		}
}
```

```
PUT REQUEST to http://localhost:8080/test/orders (to edit an order using previous json modified)
```

```
DELETE REQUEST to http://localhost:8080/test/orders (for deleting all the base)
DELETE REQUEST to http://localhost:8080/test/orders/1 (for deleting the order with primary key "1")
```

 
======================

License

    Copyright 2013 Olivier Goutay.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.