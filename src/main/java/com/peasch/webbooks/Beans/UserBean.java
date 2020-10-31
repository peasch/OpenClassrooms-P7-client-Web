package com.peasch.webbooks.Beans;


import java.util.HashSet;
import java.util.Set;

public class UserBean {
    private static final long serialVersionUID = 1L;
    private int id;
    private String userName;
    private String password;
    private String email;
    private String name;
    private String firstName;
    private String birthDate;
    private Set<BorrowingBean> borrowings = new HashSet<>();

    public UserBean() {
    }

    public UserBean(int id, String userName, String password, String email, String name, String firstName, String birthDate, Set<BorrowingBean> borrowings) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.name = name;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.borrowings = borrowings;
    }



    public Set<BorrowingBean> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(Set<BorrowingBean> borrowings) {
        this.borrowings = borrowings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
