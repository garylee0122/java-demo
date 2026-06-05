package com.gary.demo.model;

public class User {

    private String account;
    private String name;
    private String email;

    public User() {
    }

    public User(String account, String name, String email) {
        this.account = account;
        this.name = name;
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 提供統一的顯示方式
     *
     * 好處：
     * 1. 避免每次都寫 getAccount() + getName()...
     * 2. 展現 OOP 封裝概念
     * 3. 後續子類別可以 Override
     */
    public void displayInfo() {
        System.out.println(
                "Account : " + account +
                        ", Name : " + name +
                        ", Email : " + email
        );
    }

    /**
     * Java 常用覆寫方法
     *
     * 之後直接：
     * System.out.println(user);
     *
     * 就會自動呼叫 toString()
     */
    @Override
    public String toString() {
        return "com.gary.demo.model.User{" +
                "account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    /**
     * 是否為管理員
     * 預設不是
     */
    public boolean isAdmin() {
        return false;
    }
}