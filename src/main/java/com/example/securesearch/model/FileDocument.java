package com.example.securesearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "files")
public class FileDocument {
    @Id
    private String id;
    private String filename;
    private String content;

    public FileDocument() {}

    public FileDocument(String filename, String content) {
        this.filename = filename;
        this.content = content;
    }

    public String getId() { 
        return id; 
    }

    public void setId(String id) { 
        this.id = id; 
    }

    public String getFilename() { 
        return filename; 
    }

    public void setFilename(String filename) { 
        this.filename = filename; 
    }
}
