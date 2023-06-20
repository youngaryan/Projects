//package com.bankSystem.bms.user;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//
//
//@Entity
//public class User {
//    @Id
//    private Long userId;
//
//    @Column(name = "Name", nullable = false)
//    private String name;
//
//    @Column(name = "Email")
//    private String email;
//
//    @Column(name = "Balance")
//    private Long balance;
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "userId=" + userId +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", balance=" + balance +
//                '}';
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Long getBalance() {
//        return balance;
//    }
//
//    public void setBalance(Long balance) {
//        this.balance = balance;
//    }
//
//
//    public User(){
//
//    }
//    public User(String name, String email, Long balance) {
//        this.name = name;
//        this.email = email;
//        this.balance = balance;
//    }
//}
