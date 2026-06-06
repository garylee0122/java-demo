package com.gary.demo.practice;

import com.gary.demo.animal.Dog;
import com.gary.demo.model.AdminUser;
import com.gary.demo.model.User;
import com.gary.demo.service.LoginService;
import com.gary.demo.service.LoginServiceImpl;
import com.gary.demo.model.UserRole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2Test {

    private static final Scanner scanner =
            new Scanner(System.in);

    /**
     * 題目1
     */
    public static void practice1() {

        User userA =
                new User(
                        "U1",
                        "USER-A",
                        "user-a@email.com"
                );

        User userB =
                new User();

        userB.setAccount("U2");
        userB.setName("USER-B");
        userB.setEmail("user-b@email.com");

        /**
         * 業界習慣：
         *
         * 左邊寫 Interface
         * 右邊寫實作類別
         *
         * 不要：
         * ArrayList<com.gary.demo.model.User>
         *
         * 要：
         * List<com.gary.demo.model.User>
         */
        List<User> users =
                new ArrayList<>();

        users.add(userA);
        users.add(userB);

        for (User user : users) {

            /**
             * 利用封裝後的方法
             */
            user.displayInfo();
        }
    }

    /**
     * 題目2
     */
    public static void practice2() {

        AdminUser adminA =
                new AdminUser();

        adminA.setAccount("adminA");
        adminA.setName("admin-A");
        adminA.setEmail("admin-a@mail.com");
        adminA.setRole(UserRole.ADMIN);

        AdminUser adminB =
                new AdminUser(
                        "adminB",
                        "admin-B",
                        "admin-b@mail.com",
                        UserRole.ADMIN
                );

        List<AdminUser> admins =
                new ArrayList<>();

        admins.add(adminA);
        admins.add(adminB);

        for (AdminUser admin : admins) {

            admin.displayInfo();
        }
    }

    /**
     * 題目3
     */
    public static void practice3() {

        Dog dog = new Dog();

        dog.makeSound();
    }

    /**
     * 題目4
     */
    public static void practice4() {

        /**
         * 真正發揮 Interface 的用途
         *
         * 不依賴實作類別
         * 而依賴抽象
         */
        LoginService loginService =
                new LoginServiceImpl();

        loginService.login(
                "userA",
                "12345"
        );

        loginService.login(
                "admin",
                "123456"
        );
    }

    /**
     * 題目5
     *
     * 多型示範
     */
    public static void practice5() {

        User userC =
                new AdminUser(
                        "adminC",
                        "admin-C",
                        "admin-c@mail.com",
                        UserRole.ADMIN
                );

        User userD =
                new AdminUser(
                        "userD",
                        "user-D",
                        "user-d@mail.com",
                        UserRole.USER
                );

        List<User> users =
                new ArrayList<>();

        users.add(userC);
        users.add(userD);

        /**
         * 這裡是 Day2 最重要的地方
         *
         * com.gary.demo.model.User 變數
         * 實際執行 com.gary.demo.model.AdminUser.displayInfo()
         *
         * 這就是 Runtime Polymorphism
         */
        for (User user : users) {

            user.displayInfo();
        }
    }
}