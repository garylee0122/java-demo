package com.gary.demo.model;

/**
 * Enum
 *
 * 避免 Magic String
 *
 * 不要再寫：
 * "ADMIN"
 * "USER"
 * "EMPLOYEE"
 */
public enum UserRole {

    ADMIN,

    EMPLOYEE,

    USER;

    /**
     * 是否為管理員
     *
     * 面試官常問：
     * Enum 可以有方法嗎？
     *
     * 答案：可以
     */
    public boolean isAdmin() {

        return this == ADMIN;
    }
}