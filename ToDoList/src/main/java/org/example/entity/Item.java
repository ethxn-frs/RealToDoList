package org.example.entity;

import java.util.Date;

public class Item {
    private String name;
    private String content;
    private Date creationDate;
    private static final int MAX_LENGTH = 1000;
    private static final long TIME_BETWEEN_ITEMS = 30 * 60 * 1000;


    public Item(String name, String content) {
        this.name = name;
        this.content = content;
        this.creationDate = new Date();
    }

    public boolean isValid() {
        return isNameValid()
                && isContentValid()
                && isCreationDateValid();
    }

    private boolean isNameValid() {
        return this.name != null && !this.name.trim().isEmpty();
    }

    private boolean isContentValid() {
        return this.content != null && this.content.length() <= MAX_LENGTH;
    }

    private boolean isCreationDateValid() {

        long currentTime = System.currentTimeMillis();
        long itemCreationTime = this.creationDate.getTime();
        long timeDifference = currentTime - itemCreationTime;

        return timeDifference >= TIME_BETWEEN_ITEMS;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}

