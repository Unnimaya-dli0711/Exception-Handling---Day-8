package exception;

import java.util.Scanner;

public class ArithmeticExceptionExample {
    public static void main(String[] args) {
        Scanner scannerobject=new Scanner(System.in);
        System.out.println("Enter a number");
        int number=scannerobject.nextInt();
        try{
            int result=100/number;
            System.out.println(result);
        }catch (ArithmeticException e)
        {
            System.out.println("Divide by zero error");
        }
    }
}
