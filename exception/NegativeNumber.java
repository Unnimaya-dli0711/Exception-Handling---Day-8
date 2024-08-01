package exception;

import java.util.Scanner;

class NegativeNumberException extends Exception{

}
public class NegativeNumber {
    public static void main(String[] args) throws NegativeNumberException {
        try {
            System.out.println("Enter a number");
            Scanner scannerobject=new Scanner(System.in);
            int number=scannerobject.nextInt();
            if(number<0)
                throw new NegativeNumberException();
        }catch (NegativeNumberException e)
        {
            System.out.println("Exception - Number is negative");
        }
    }
}
