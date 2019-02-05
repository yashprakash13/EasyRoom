# EasyRoom
EasyRoom lets you have a simple and easy integration of Room Database into your Android app.

Room provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite. Read all about it [here.](https://developer.android.com/training/data-storage/room/)

### What does EasyRoom offer?
This module offers an introductory integration of Room database into your app. Sample components of Room have been provided for your ease of building your first project with Room. Just download this module and import it into your android project to get started!
Import module by : File -> New -> Import Module, and then select the downloaded easyroom module from your download location. 
#### Components
A Room database has these components:
* Entity class - The model class for your database table. This module gives you one already prepared in the **entity** folder! You can edit any SQL column you want in the table too!
* DAO interface - Data Access Object for executing SQL Queries by Room. The DAO interface is included in the **dao** folder in the module. Customize it as you like!
* Database Astract Class - This module has one too!
* Repository class - This is the class that is used to define the methods to be used in your actitiy to execute queries through the DAO object. EasyRoom has one included for basic **CRUD** operations (**Insert, Update, Delete, Query**)!

#### Other Utility Classes include for your convenience:
* A TimeStamp Converter class- One of the useful feature of Room is Type Converters. When you have to store in database some custom types, you can use Type Converters. It converts from a unknown type into a known type in terms of database types.
  * Through this class, the type Date is stored as a String type into the database. It is located in the **Utilities** folder of the module.
  * You can see 2 defined methods: 
    * toDate: converts a String value into a Date type
    * toString: converts a Date value into a String type 
  
* Time Class - This class is also in the **Utilities** folder of the module. 
  * It has a method **getFormattedDateString** that lets you get a date in your preferred format.
  * Also, get the current date and time to store in the database directly from the **getCurrentDateTime** method.
