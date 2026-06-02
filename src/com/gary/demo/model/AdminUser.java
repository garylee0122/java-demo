package com.gary.demo.model;

public class AdminUser extends User {

    private String role;

    public AdminUser() {
    }

    public AdminUser(
            String account,
            String name,
            String email,
            String role
    ) {

        /**
         * super 必須放在 Constructor 第一行
         *
         * 因為父類別必須先初始化完成
         */
        super(account, name, email);

        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Override 父類別方法
     *
     * 這就是 Polymorphism（多型）
     */
    @Override
    public void displayInfo() {

        System.out.println(
                "Account : " + getAccount() +
                        ", Name : " + getName() +
                        ", Email : " + getEmail() +
                        ", Role : " + role
        );
    }
}