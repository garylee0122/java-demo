package com.gary.demo.practice;

import java.util.Scanner;

public class Day1Test {

    // 建議：Scanner 共用，不要每個 method 都 new / close
    // 因為 close() 會把 System.in 一起關掉
    // 後面的輸入可能會失效
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * 題目 1：判斷奇偶數
     */
    public static void practice1() {

        System.out.print("請輸入一個數字：");

        // 變數名稱盡量語意化
        int number = scanner.nextInt();

        // % 2 == 0 代表可被 2 整除 => 偶數
        if (number % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }

    /**
     * 題目 2：找最大值與最小值
     */
    public static void practice2() {

        int[] numbers = {5, 9, 2, 15, 3};

        // 正確寫法：
        // 用第一個元素當初始值
        // 避免陣列全部都是負數時出錯
        int max = numbers[0];
        int min = numbers[0];

        // Enhanced for loop（Java 很常用）
        // 可讀性比 index 版本更高
        for (int number : numbers) {

            if (number > max) {
                max = number;
            }

            if (number < min) {
                min = number;
            }
        }

        System.out.println("MAX : " + max);
        System.out.println("MIN : " + min);
    }

    /**
     * 題目 3：1 加總到 N
     */
    public static void practice3() {

        System.out.print("請輸入一個數字：");

        int n = scanner.nextInt();

        // 面試加分寫法：
        // 使用數學公式
        //
        // 1 + 2 + 3 + ... + n
        // = n * (n + 1) / 2
        //
        // 時間複雜度：
        // O(1)
        //
        // 比 for 迴圈的 O(n) 更好
        int total = n * (n + 1) / 2;

        System.out.println("從 1 加總到 " + n + " 的結果 = " + total);
    }

    /**
     * 題目 4：字串反轉
     */
    public static void practice4() {

        System.out.print("請輸入一個字串：");

        String text = scanner.next();

        // StringBuilder 是 Java 常用字串處理工具
        // reverse() 可直接反轉字串
        //
        // Java 的 String 是 immutable（不可變）
        // 每次修改都會建立新物件
        //
        // StringBuilder 效率會更好
        StringBuilder sb = new StringBuilder(text);

        String reversedText = sb.reverse().toString();

        System.out.println("原字串：" + text);
        System.out.println("反轉結果：" + reversedText);
    }

    /**
     * 題目 5：判斷質數
     */
    public static void practice5() {

        System.out.print("請輸入一個數字：");

        int number = scanner.nextInt();

        // 質數定義：
        // 大於 1
        // 且只能被 1 和自己整除

        // 先假設是質數
        boolean isPrime = true;

        // 1 和負數都不是質數
        if (number <= 1) {
            isPrime = false;
        } else {

            // 面試常見優化：
            // 只需要檢查到 sqrt(number) 平方根
            //
            // 例如：
            // 36 的因數：
            // 2 * 18
            // 3 * 12
            // 4 * 9
            // 6 * 6
            //
            // 超過 sqrt 後會開始重複
            for (int i = 2; i <= Math.sqrt(number); i++) {

                // 代表可整除
                // 不是質數
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println(number + " 是 Prime.");
        } else {
            System.out.println(number + " 不是 Prime.");
        }
    }
}