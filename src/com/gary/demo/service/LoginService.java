package com.gary.demo.service;

public interface LoginService {

    /**
     * Interface 只定義規格
     *
     * 不關心怎麼實作
     */
    boolean login(
            String account,
            String password
    );
}