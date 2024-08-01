package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleTryCatch {
    public static void main(String[] args) {
        Scanner scannerobject=new Scanner(System.in);
        System.out.println("Enter a number");

        try{
            int number1=scannerobject.nextInt();
            int number2=scannerobject.nextInt();
            int result=number1/number2;
            System.out.println(result);
        }catch (InputMismatchException input){
            System.out.println(input);
        }catch (ArithmeticException e)
        {
            System.out.println(e);
        }
    }
}
