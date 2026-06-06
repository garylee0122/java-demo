package com.gary.demo.exception;

/**
 * 自訂登入失敗例外
 */
public class LoginFailedException
        extends RuntimeException {

    public LoginFailedException(
            String message
    ) {

        super(message);
    }
}