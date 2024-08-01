package exception;

import java.util.Scanner;
class  InsufficientFundsException extends Exception{
    InsufficientFundsException(int amount){
        System.out.println("Insufficient Balance");
    }
}
public class CheckBalance {
    public static void main(String[] args) throws  InsufficientFundsException  {
        int balance=100;
        System.out.println("Enter the amount to withdraw");
        Scanner scannerobject=new Scanner(System.in);
        int amount=scannerobject.nextInt();
        if(amount>balance)
            throw new InsufficientFundsException(amount);
    }
}
