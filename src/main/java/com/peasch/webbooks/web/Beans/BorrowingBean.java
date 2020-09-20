package com.peasch.webbooks.web.Beans;

public class BorrowingBean {
    private static final long serialVersionUID = 1L;
    private int id;
    private String borrowingDate;
    private String returnDate;
    private boolean extended;
    private UserBean user;

    public BorrowingBean() {
    }

    public BorrowingBean(int id, String borrowingDate, String returnDate, boolean extended, UserBean user) {
        this.id = id;
        this.borrowingDate = borrowingDate;
        this.returnDate = returnDate;
        this.extended = extended;
        this.user = user;
    }

    @Override
    public String toString() {
        return "BorrowingBean{" +
                "id=" + id +
                ", borrowingDate='" + borrowingDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", extended=" + extended +
                ", user=" + user +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(String borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isExtended() {
        return extended;
    }

    public void setExtended(boolean extended) {
        this.extended = extended;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }
}
