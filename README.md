### DEMONSTRATION OF CRUD OPERATION
---
CRUD operations are basic database operations which are Cread, Read, Update and Delete. This application fetch data from the database and show it in the table format to the user. Furthermore, it also also allows viewer to edit, add and delete any entry from the table and update the database accordingly.

## Table of contents
---
- [What is included](#what-is-included)
- [Database and server](#database-and-server)
- [How to use project](#how-to-use-project)
- [Purpose](#purpose)
- [Bug and feature request](#bug-and-feature-request)
- [Creator & References](#creator-&-references)

## What is included?
---
Within your download you will find following directory, grouping all classes in logical manner and in packages.
![directory] (directory.JPG)
Also it is worth mentioning the fact that entire project is develop in Java.

## Database and server
---
The project was originally ran on "Tomcat v9.0 Server at localhost" but you can run it on any server provided you have configuration files necessary for it. 
As for the database H2 database was used jar file of which is present in the "WEB-INF/lib" folder. Make sure to use configurations mentioned in"DBUtil.java" files or you can change configurations as per your preference and even database but make sure to make changes accordingly. In addition to this, you will find "database.sql" file in the directory in which all require sql queries you will need will be mentioned. For application to work properly, remember to create an emplloyee table first and add some values manually through database and then run the program on the server.

## How to use project
---
1. First of all fork the project and then clone or download the zip
2. Open the project in your IDE and check whether "WEB-INF/lib" folder has h2 driver jar file or not if it is not present you can download it from [here](http://www.h2database.com/html/download.html) or you can use any database you have required files of.
3. Once this is done open h2 driver console on your browser and use configurations mentioned in "DBUtil.java" file of directory and connect to the database.
4. Open "database.sql" file and use sql queries within to create a table name employee, and insert some values in it. Remember this application will be unless you create a table name "employee"
5. Once this is done run the project on your server. You should be able to add, edit and delete any employee from this project by following above steps.

## Purpose
---
There are 2 main reasons for uploading such a basic and simple project on github:
* To learn myself how CRUD operations are perform and understanding their operations and working also to practice uploading projects on GitHub and creating a good README files for your repository.
* To help others who are beginners in the programming and help them understand and learn CRUD operations themselves.

## Bugs and features request
---
As this is simple program to perform CRUD and understand it for the beginners there might not be any feature request and even though application has tested before uploading if you found any bugs, errors, exceptions then create a new issue [here](https://github.com/avadhoot-athalye/JSFCRUDDemo/issues/new)

## Creator & References
Even though this entire project was done by [my own self](https://avadhoot-athalye.github.io/) it was not easy for beginner like me to do it in first attempt and without any reference and help, I admit that. This is why I would like to mentioned here people who I contacted for reference.
1. My mentor [Khozema Nullwala](https://khozema-nullwala.github.io/)
2. My talented friend [Faisal Ansari](https://github.com/ansarifaisal)

Please check out projects they have created and follow them if possible.

Also if you are completely new to programming and need more information about CRUD then click [here](http://www.sqlshack.com/creating-using-crud-stored-procedures/).