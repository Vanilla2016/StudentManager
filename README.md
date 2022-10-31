# StudentManager
Unique X assignment to parse file of student details into the app and offer sort functions on it.
A maven app compiled with Java 18.0.1.1, inclucding the Tomcat 7 plugin that it will deploy onto.
A basic Spring Boot servlet app, references 2 key servlets via POST requests. 

The first delegates to Commons FileUpload classes to enable browsing and uploading of the relevant text file, 
which is saved in local application space. 
This is parsed into an array of beans and the results displayed in a table. 
The File parseing relies on the File structure outlined in the spec. 
It could be more robust but returns general errors if a problem occurs.

The second servlet delegates to what was going to be a suite of classes to perform Bubble, Heap and Merge sort on the array.
Was only able to implement the first of these in the time constraints, but confident could easily implement the other two. 
Also missing is the number of records, time taken and a Save File option. 
Just ran out of time - these can be easily added and Save option achievable through the FileUpload API.

As was developing locally, didn't use Logging library, relied on console output

Assuming maven is installed on the host system and all dependencies fulfilled it can be run within the project folder using 

mvn tomcat7:run

It should then be available at localhost:8080