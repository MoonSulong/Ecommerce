# Ecommerce Web Application
- Developed a web application based on Spring MVC to support item search and listing (dependency injection, inversion of control, etc.)

## Table of contents
* [1. Project Description](#1-project-descriptions)
* [2. Infrastructure Design](#2-infrastructure-design)
* [3. Java Servlet Design](#3-java-servlet-design)
* [4. Database Implementation](#4-database-implementation)
* [5. Design pattern](#5-design-pattern)

## 1. Project Description 
- [Link to the web application](http://13.58.22.177:8080/Jupiter/)
- `Spring Web MVC` provides Model-View-Controller architecture to develop flexible web applications
   * **Model** carries application data
   * **View** renders User interface (UI)
   * **Controller** takes care of processing user request and calling back end services.
   
![Spring MVC framework](https://raw.githubusercontent.com/MoonSulong/Ecommerce/master/img/SpringMVC.png)
> Spring MVV framework

## 2. Infrastructure Design
- 3-tier architecture
   * Presentation tier: XML
   * Data tier: MySQL
   * Logic tier: Java, Hibernate

## 3. MVC Implementation
- Controller
   * Registration
   * HomePage
   * Product
   * Cart
   * CartItem
- Model
   * Authorities
   * BillingAddress
   * Cart
   * CartItem   
   * Customer
   * Product
   * SalesOrder
   * ShippingAddress
   * User

## 4. Database Implementation
- MySQL
   * **ShippingAddress** - store shipping address
   * **BillingAddress** - store billing address
   * **Customer** - store full information of a customer
   * **User** - store user email and password separately 
   * **SalesOrder** - store sales order 
   * **Cart** - store total price of products in the cart
   * **CartItem** - store detail infomation for all items in the cart 
   * **Product** - store product information
   * **Authorities** - store authorities of users
   

![mysql](https://raw.githubusercontent.com/MoonSulong/Ecommerce/master/img/DatabaseSchema.png)
> MySQL database design

## 5. Continue...
   * **Singleton pattern**: 
      * ...
