package com.gary.demo.model;

public class AdminUser extends User {

    /**
     * 使用 Enum
     *
     * 不再使用 String
     */
    private UserRole role;

    public AdminUser() {
    }

    public AdminUser(
            String account,
            String name,
            String email,
            UserRole role
    ) {

        super(
                account,
                name,
                email
        );

        this.role = role;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(
            UserRole role
    ) {
        this.role = role;
    }

    @Override
    public void displayInfo() {

        System.out.println(
                "Account : "
                        + getAccount()
                        + ", Name : "
                        + getName()
                        + ", Email : "
                        + getEmail()
                        + ", Role : "
                        + role
        );
    }
}