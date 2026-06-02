import com.gary.demo.practice.Day1Test;
import com.gary.demo.practice.Day2Test;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the Day number : ");
        int dateNum = input.nextInt();

        switch (dateNum) {
            case 1:
                System.out.print("Please enter the Day1 practice number : ");
                int day1Num = input.nextInt();
                try {
                    java.lang.reflect.Method m = Day1Test.class.getMethod("practice" + day1Num);
                    m.invoke(null); // static method -> null instance
                } catch (NoSuchMethodException e) {
                    System.out.println("No practice method for number " + day1Num);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case 2:
                System.out.print("Please enter the Day2 practice number : ");
                int day2Num = input.nextInt();
                try {
                    java.lang.reflect.Method m = Day2Test.class.getMethod("practice" + day2Num);
                    m.invoke(null); // static method -> null instance
                } catch (NoSuchMethodException e) {
                    System.out.println("No practice method for number " + day2Num);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            default:
                System.out.println("you didn't chose any question!");
        }

        input.close();
    }
}