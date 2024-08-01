package exception;
class InvalidAgeException extends Exception{

}
public class AgeValidation {
    public static void validateAge(int age) throws InvalidAgeException {
        if(age<18){
            throw new InvalidAgeException();
        }else {
            System.out.println("Welcome");
        }
    }
    public static void main(String[] args) {
        try{
            validateAge(15);
        }catch (InvalidAgeException e){
            System.out.println("Age Invalid");}

    }
}
