<<<<<<< HEAD
package com.example.demo.model;
=======
package com.example.securesearch.model;
>>>>>>> ff75c05 (Added mvnw.cmd and updated Dockerfile for Render deployment)

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

<<<<<<< HEAD
@Document(collection = "test_collection")
public class TestDocument {
    @Id
    private String id;
    private String message;

    public TestDocument() {}

    public TestDocument(String message) {
        this.message = message;
    }

    public String getId() { return id; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
=======
@Document(collection = "testDocuments") // MongoDB collection name
public class TestDocument {

    @Id
    private String id;
    private String name;
    private int age;

    // Constructors
    public TestDocument() {}

    public TestDocument(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
>>>>>>> ff75c05 (Added mvnw.cmd and updated Dockerfile for Render deployment)
}
