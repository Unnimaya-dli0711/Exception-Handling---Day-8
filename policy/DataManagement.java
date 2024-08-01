package policy;

import java.util.ArrayList;
import java.util.Scanner;

class Policy1{
    int policy_number;
    String policy_holdername;
    int age;
    String type_insurance;
    long coverage_amount;
    Policy1 (int policy_number,String policy_holdername,int age,String type_insurance,long coverage_amount){
        this.policy_number=policy_number;
        this.policy_holdername=policy_holdername;
        this.type_insurance=type_insurance;
        this.coverage_amount=coverage_amount;
        this.age=age;
    }

    public int getPolicy_number() {
        return policy_number;
    }

    public void setPolicy_number(int policy_number) {
        this.policy_number = policy_number;
    }

    public String getPolicy_holdername() {
        return policy_holdername;
    }

    public void setPolicy_holdername(String policy_holdername) {
        this.policy_holdername = policy_holdername;
    }

    public String getType_insurance() {
        return type_insurance;
    }

    public void setType_insurance(String type_insurance) {
        this.type_insurance = type_insurance;
    }

    public long getCoverage_amount() {
        return coverage_amount;
    }

    public void setCoverage_amount(long coverage_amount) {
        this.coverage_amount = coverage_amount;
    }

    @Override
    public String toString() {
        return "Name : "+policy_holdername+"\n"+"Number : "+policy_number+"\n"+"Type : "+type_insurance+"\n"+"Coverage Amount : "+coverage_amount+"\n";
    }
}
class CustomerNotFoundException extends Exception{
    CustomerNotFoundException(){
        System.out.println("Customer not found");
    }
}
class InvalidCustomerDataException extends Exception{
    InvalidCustomerDataException(){
        System.out.println("Age is less");
    }
}
public class DataManagement {
    static ArrayList<Policy1> policies=new ArrayList<>();
    static int policy_number;
    static int age;
    static String policy_holdername;
    static String type_insurance;
    static long coverage_amount;
    public static void main(String[] args) throws CustomerNotFoundException,InvalidCustomerDataException{
        int choice;
        do{
            System.out.println("Enter the choice");
            System.out.println("1.Add new policy");
            System.out.println("2.Remove Policy by number");
            System.out.println("3.Update policy details");
            System.out.println("4.Display policies");
            System.out.println("5.Exit");
            Scanner scannerobject=new Scanner(System.in);
            choice=scannerobject.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter the details of new policy");
                    System.out.println("Name of Policy holder");
                    scannerobject.nextLine();
                    policy_holdername=scannerobject.nextLine();
                    System.out.println("Enter Age");
                    try{
                        age=scannerobject.nextInt() ;
                        if(age<18){
                            throw new InvalidCustomerDataException();
                        }
                    }catch (InvalidCustomerDataException ex)
                    {
                        System.out.println(ex);
                    }

                    System.out.println("Name of Policy number");
                    policy_number=scannerobject.nextInt();
                    System.out.println("Type of insurance");
                    type_insurance=scannerobject.next();
                    System.out.println("Coverage Amount");
                    coverage_amount=scannerobject.nextLong();
                    Policy1 policyobject=new Policy1(policy_number,policy_holdername,age,type_insurance,coverage_amount);
                    policies.add(policyobject);
                    System.out.println(policies);
                    break;
                case 2:
                    System.out.println("Enter the policy number to remove");
                    int remove_policy=scannerobject.nextInt();
                    try{
                        for(int i=0;i<policies.size();i++){
                            if(remove_policy==policies.get(i).policy_number){
                                policies.remove(i);
                            }else {
                                throw new CustomerNotFoundException();
                            }
                        }
                    }catch (CustomerNotFoundException e){
                        System.out.println(e);
                    }

                    System.out.println("Removed");
                    System.out.println(policies);
                    break;
                case 3:
                    System.out.println("Update policy details");
                    int field_update;
                    System.out.println("Enter the policy number of which should be edited");
                    int policy_editing_number=scannerobject.nextInt();
                    do{
                        System.out.println("Enter which field to update");
                        System.out.println("1.Name");
                        System.out.println("2.Policy Number");
                        System.out.println("3.Type");
                        System.out.println("4.Coverage amount");
                        System.out.println("5.Exit");
                        field_update=scannerobject.nextInt();
                        Policy1 policyobject_editing=null;
                        for(int i=0;i<policies.size();i++)
                        {
                            if(policy_editing_number==policies.get(i).policy_number)
                            {
                                policyobject_editing=policies.get(i);
                            }
                        }
                        switch (field_update){
                            case 1:
                                System.out.println("Enter the new name");
                                scannerobject.nextLine();
                                String new_name=scannerobject.nextLine();
                                policyobject_editing.setPolicy_holdername(new_name);
                                break;
                            case 2:
                                System.out.println("Enter the new Policy Number");
                                int new_number=scannerobject.nextInt();
                                policyobject_editing.setPolicy_number(new_number);
                                break;
                            case 3:
                                System.out.println("Enter the new Policy Type");
                                String new_type=scannerobject.next();
                                policyobject_editing.setType_insurance(new_type);
                                break;
                            case 4:
                                System.out.println("Enter the new Coverage Amount");
                                Long new_coverage=scannerobject.nextLong();
                                policyobject_editing.setCoverage_amount(new_coverage);
                                break;
                            case 5:
                                System.out.println("Exiting");
                                break;
                            default:
                                System.out.println("Invalid ");
                        }
                    }while (field_update<5);
                    System.out.println("Updation Completed");
                    break;
                case 4:
                    System.out.println("Displaying Details");
                    System.out.println("Enter which type to display");
                    String type_display=scannerobject.next();
                    for(int i=0;i<policies.size();i++){
                        if(type_display.equals(policies.get(i).type_insurance)){
                            System.out.println(policies.get(i));
                        }
                    }
                    break;
                case 5:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid ");

            }

        }while (choice<5);
    }
}
