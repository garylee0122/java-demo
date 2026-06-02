package com.gary.demo.service;

public class LoginServiceImpl implements LoginService {

    @Override
    public boolean login(
            String account,
            String password
    ) {

        /**
         * 常數放前面
         *
         * 避免：
         * account == null
         *
         * 造成 NullPointerException
         */
        if (
                "admin".equals(account)
                        &&
                        "123456".equals(password)
        ) {

            System.out.println("登入成功");

            return true;
        }

        System.out.println("登入失敗");

        return false;
    }
}