package org.example.exercise2;

public class Customers {
    private int userId;
    private String userName;
    private String email;
    private long mobileNumber;
    private String city;

    public Customers(int userId, String userName, String email, long mobileNumber, String city) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.city = city;
    }

    public Customers() {
    }

    @Override
    public String toString() {
        return "Customers{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", city='" + city + '\'' +
                '}';
    }
}
