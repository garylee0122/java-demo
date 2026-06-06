package com.gary.demo.practice;

import com.gary.demo.exception.LoginFailedException;
import com.gary.demo.model.AdminUser;
import com.gary.demo.model.Box;
import com.gary.demo.model.User;
import com.gary.demo.model.UserRole;
import com.gary.demo.service.LoginService;
import com.gary.demo.service.LoginServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Day4Test {

    public static void main(String[] args) {

        /**
         * try-with-resources
         *
         * Scanner 使用完畢自動關閉
         * Java 面試常考
         */
        try (Scanner input = new Scanner(System.in)) {

            System.out.print(
                    "Please enter the Day4 practice number : "
            );

            int day4Num = input.nextInt();

            try {

                /**
                 * Reflection
                 *
                 * 動態呼叫：
                 * practice1()
                 * practice2()
                 * practice3()
                 * ...
                 */
                java.lang.reflect.Method method =
                        Day4Test.class.getMethod(
                                "practice" + day4Num
                        );

                method.invoke(null);

            } catch (NoSuchMethodException e) {

                System.out.println(
                        "No practice method for number "
                                + day4Num
                );

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    /**
     * 題目1
     * try-catch
     * 避免除以0
     */
    public static void practice1() {

        try (Scanner input =
                     new Scanner(System.in)) {

            System.out.print("請輸入被除數 : ");
            int dividend = input.nextInt();

            System.out.print("請輸入除數 : ");
            int divisor = input.nextInt();

            int result =
                    dividend / divisor;

            System.out.println(
                    dividend
                            + " / "
                            + divisor
                            + " = "
                            + result
            );

        }
        /**
         * 精準捕捉 Exception
         *
         * 不建議直接 catch Exception
         */
        catch (ArithmeticException e) {

            System.out.println(
                    "除數不可為 0"
            );
        }
    }

    /**
     * 題目2
     * NullPointerException
     */
    public static void practice2() {

        try {

            String text = null;

            System.out.println(
                    "字串長度 = "
                            + text.length()
            );

        } catch (NullPointerException e) {

            System.out.println(
                    "發生 NullPointerException"
            );

            System.out.println(
                    e.getMessage()
            );
        }
    }

    /**
     * 題目3
     * 自訂 Exception
     */
    public static void practice3() {

        try (Scanner input =
                     new Scanner(System.in)) {

            System.out.print("請輸入帳號 : ");
            String account =
                    input.next();

            System.out.print("請輸入密碼 : ");
            String password =
                    input.next();

            LoginService loginService =
                    new LoginServiceImpl();

            /**
             * 登入失敗
             * 丟出自訂 Exception
             */
            if (!loginService.login(
                    account,
                    password
            )) {

                throw new LoginFailedException(
                        "帳號或密碼錯誤"
                );
            }

            System.out.println(
                    "登入成功"
            );

        } catch (LoginFailedException e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    /**
     * 題目4
     * Generic
     */
    public static void practice4() {

        Box<String> stringBox =
                new Box<>("Java 衝刺寶典");

        String book =
                stringBox.get();

        System.out.println(book);

        Box<Integer> intBox =
                new Box<>(12345);

        Integer number =
                intBox.get();

        System.out.println(number);
    }

    /**
     * 題目5
     * Optional
     */
    public static void practice5() {

        User user1 =
                new User(
                        "U1",
                        "USER1",
                        "user1@mail.com"
                );

        String name1 =

                Optional.ofNullable(user1)

                        .map(User::getName)

                        .orElse(
                                "找不到使用者"
                        );

        System.out.println(name1);

        User user2 = null;

        String name2 =

                Optional.ofNullable(user2)

                        .map(User::getName)

                        .orElse(
                                "找不到使用者"
                        );

        System.out.println(name2);
    }

    /**
     * 題目6
     * Enum
     */
    public static void practice6() {

        List<AdminUser> users =
                new ArrayList<>();

        users.add(
                new AdminUser(
                        "U1",
                        "Gary",
                        "gary@mail.com",
                        UserRole.ADMIN
                )
        );

        users.add(
                new AdminUser(
                        "U2",
                        "Tom",
                        "tom@mail.com",
                        UserRole.USER
                )
        );

        users.forEach(
                AdminUser::displayInfo
        );
    }
}