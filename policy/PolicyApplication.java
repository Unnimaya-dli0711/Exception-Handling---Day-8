package policy;

import javax.naming.ldap.SortKey;
import java.util.Scanner;

class Policy{
    String name;
    int age;
    String driving_history;
    String health_status;
    Policy(String name,int age,String driving_history,String health_status){
        this.name=name;
        this.age=age;
        this.driving_history=driving_history;
        this.health_status=health_status;
    }
}
class HealthIssueException extends Exception{
    HealthIssueException(){
        System.out.println("Health status poor");
    }
}
class InvalidAgeException extends Exception{
    InvalidAgeException(){
        System.out.println("Age is less");
    }
}
class PoorDrivingRecordException extends Exception{
    PoorDrivingRecordException(){
        System.out.println("Driving history poor");
    }
}
public class PolicyApplication {
    public static void main(String[] args) throws HealthIssueException,InvalidAgeException,PoorDrivingRecordException{
        Scanner scannerobject=new Scanner(System.in);
        System.out.println("Enter the details of new policy");
        System.out.println("Name of Policy holder");
        String name=scannerobject.nextLine();
        System.out.println("Enter age");
        int age=scannerobject.nextInt();
        System.out.println("Enter driving history good/poor");
        String driving_history=scannerobject.next();
        System.out.println("Enter health history good/poor");
        String health_history=scannerobject.next();
        Policy policy=new Policy(name,age,driving_history,health_history);
        try{
            if(policy.health_status.equals("poor")){
                throw new HealthIssueException();
            }
            if(policy.driving_history.equals("poor")){
                throw new PoorDrivingRecordException();
            }
            if(policy.age<18){
                throw new InvalidAgeException();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
