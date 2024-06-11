package com.prj;

import java.io.Serializable;

public class PackageData implements Serializable {
    private int operationType;
    private User user;
    private Book book;

    public PackageData(int operationType) {
        this.operationType = operationType;
    }

    public PackageData(int operationType, User user) {
        this.operationType = operationType;
        this.user = user;
    }

    public PackageData(int operationType, Book book) {
        this.operationType = operationType;
        this.book = book;
    }

    public int getOperationType() {
        return operationType;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() { return book;}
}

