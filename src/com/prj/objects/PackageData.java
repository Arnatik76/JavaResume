package com.prj;

import java.io.Serializable;

public class PackageData implements Serializable {
    /* 0 - check user password
     * 1 - add user
     * 2 - true result
     * 3 - false result
     * 4 - send genre list
     * 5 - check admin password

     * 7 - add book
     * 8 - delete book */

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
