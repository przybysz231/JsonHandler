******
Building:
To build the project use following command:
mvn install

Running After building the application run following command to start it:
java -Dparam=src/main/resources/data/books.json -jar target/HomeworkTask-0.0.1-SNAPSHOT.jar

******
Endpoints:
selecting a book by its ISBN number (returns 404 when there's no book with specified ISBN number) localhost:8080/api/book/{isbn}

selecting books by category (returns empty list when there's no book for selected category) localhost:8080/api/book/{categoryName}/books

ratings for all the authors in descending order localhost:8080/api/rating
******

