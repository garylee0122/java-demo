package com.gary.demo.practice;

import com.gary.demo.model.AdminUser;
import com.gary.demo.model.User;

import java.util.*;
import java.util.stream.IntStream;

public class Day3Test {

    public static void main(String[] args) {

        /**
         * try-with-resources
         *
         * Scanner 用完自動關閉
         * Java 面試常考
         */
        try (Scanner input = new Scanner(System.in)) {

            System.out.print(
                    "Please enter the Day3 practice number : "
            );

            int day3Num = input.nextInt();

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
                        Day3Test.class.getMethod(
                                "practice" + day3Num
                        );

                method.invoke(null);

            } catch (NoSuchMethodException e) {

                System.out.println(
                        "No practice method for number "
                                + day3Num
                );

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    /**
     * 題目1
     *
     * List 可重複
     */
    public static void practice1() {

        List<String> users = new ArrayList<>();

        users.add("Gary");
        users.add("Tom");
        users.add("Mary");
        users.add("Gary");

        /**
         * Method Reference
         *
         * 比：
         * user -> System.out.println(user)
         *
         * 更簡潔
         */
        users.forEach(System.out::println);
    }

    /**
     * 題目2
     *
     * Set 不可重複
     */
    public static void practice2() {

        Set<String> users = new HashSet<>();

        users.add("Gary");
        users.add("Tom");
        users.add("Mary");
        users.add("Gary");

        /**
         * HashSet 不保證順序
         *
         * 若要求維持加入順序：
         * LinkedHashSet
         */
        users.forEach(System.out::println);
    }

    /**
     * 題目3
     *
     * Map<Key, Value>
     */
    public static void practice3() {

        Map<String, String> users =
                new HashMap<>();

        users.put("A001", "Gary");
        users.put("A002", "Tom");
        users.put("A003", "Mary");

        /**
         * Java 8 Map forEach
         *
         * 業界常見寫法
         */
        users.forEach(
                (key, value)
                        -> System.out.println(
                        key + " : " + value
                )
        );
    }

    /**
     * 題目4
     *
     * 找出所有偶數
     */
    public static void practice4() {

        /**
         * IntStream 建立 1~20
         *
         * 比手動 for-loop 更現代
         */
        List<Integer> numbers =
                IntStream.rangeClosed(1, 20)
                        .boxed()
                        .toList();

        numbers.stream()
                .filter(
                        number ->
                                number % 2 == 0
                )
                .forEach(
                        System.out::println
                );
    }

    /**
     * 題目5
     *
     * 字串轉大寫
     */
    public static void practice5() {

        List<String> users =
                List.of(
                        "gary",
                        "tom",
                        "mary"
                );

        users.stream()
                /**
                 * Method Reference
                 */
                .map(String::toUpperCase)
                .forEach(
                        System.out::println
                );
    }

    /**
     * 題目6
     *
     * 找出所有 AdminUser
     */
    public static void practice6() {

        List<User> users =
                new ArrayList<>();

        users.add(
                new User(
                        "U1",
                        "USERA",
                        "usera@test.com"
                )
        );

        users.add(
                new AdminUser(
                        "U2",
                        "USERB",
                        "userb@test.com",
                        "admin"
                )
        );

        users.add(
                new User(
                        "U3",
                        "USERC",
                        "userc@test.com"
                )
        );

        users.add(
                new AdminUser(
                        "U4",
                        "USERD",
                        "userd@test.com",
                        "admin"
                )
        );

        users.add(
                new AdminUser(
                        "U5",
                        "USERE",
                        "usere@test.com",
                        "employee"
                )
        );

        users.stream()
                /**
                 * Java17 Pattern Matching
                 *
                 * 傳統：
                 *
                 * u instanceof AdminUser
                 * &&
                 * ((AdminUser)u).getRole()
                 *
                 * 新寫法：
                 *
                 * u instanceof AdminUser admin
                 */
                .filter(
                        u ->
                                u instanceof AdminUser admin
                                        &&
                                        "admin".equals(
                                                admin.getRole()
                                        )
                )
                /**
                 * Method Reference
                 */
                .forEach(
                        User::displayInfo
                );
    }
}