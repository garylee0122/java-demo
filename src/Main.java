import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the question number : ");
        int num = input.nextInt();

        switch (num) {
            case 1:
                Day1Test.practice1();
                break;

            case 2:
                Day1Test.practice2();
                break;

            case 3:
                Day1Test.practice3();
                break;

            case 4:
                Day1Test.practice4();
                break;

            case 5:
                Day1Test.practice5();
                break;

            default:
                System.out.println("you didn't chose any question!");
        }

        input.close();
    }
}