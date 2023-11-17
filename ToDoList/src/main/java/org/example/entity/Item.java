package org.example.entity;

import java.time.LocalDateTime;

public class Item {

    private Integer id;
    private String name;
    private String content;
    private LocalDateTime creationDate;
    private static final int MAX_LENGTH = 1000;

    public Item(String name, String content) {
        this.name = name;
        this.content = content;
        this.creationDate = LocalDateTime.now();
    }

    public boolean isValid() {
        return isNameValid()
                && isContentValid();
    }

    private boolean isNameValid() {
        return this.name != null && !this.name.trim().isEmpty();
    }
    private boolean isContentValid() {
        return this.content != null
                && this.content.length() <= MAX_LENGTH
                && !this.content.trim().isEmpty();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

