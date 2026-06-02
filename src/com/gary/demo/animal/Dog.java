package com.gary.demo.animal;

public class Dog extends Animal {

    @Override
    public void makeSound() {

        /**
         * println 比 print 更適合 Console 輸出
         *
         * print 不換行
         * println 會換行
         */
        System.out.println(
                "我是狗，我的叫聲是 Woof! Woof!"
        );
    }
}