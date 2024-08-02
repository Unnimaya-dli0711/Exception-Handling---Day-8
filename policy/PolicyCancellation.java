package policy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

class PolicyNotFoundException extends Exception { }

class CancellationNotAllowedException extends Exception{}

class PolicyCancel {
    String policynumber;
    String policyholder;
    LocalDate expiry_date;
    LocalDate start_date;
    String type;
    long amount;


    public PolicyCancel(String policynumber, String policyholder, String type,LocalDate expiry_date, long coverage,LocalDate start_date)
    {
        this.policynumber=policynumber;
        this.policyholder=policyholder;
        this.expiry_date=expiry_date;
        this.type=type;
        this.amount =coverage;
        this.start_date=start_date;
    }

    public String getPolicynumber() {
        return policynumber;
    }

    public void setPolicynumber(String policynumber) {
        this.policynumber = policynumber;
    }

    public String getPolicyholder() {
        return policyholder;
    }

    public void setPolicyholder(String policyholder) {
        this.policyholder = policyholder;
    }

    public LocalDate getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(LocalDate expiry_date) {
        this.expiry_date = expiry_date;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Policy Number:"+policynumber+"\nPolicy holder name:"+policyholder+"\nStart Date:"+start_date+"\nExpiry Date:"+expiry_date+"\nType:"+type+"\nPremium amount:"+ amount;
    }
}

class Policies
{
    ArrayList<PolicyCancel> policies=new ArrayList<>();
    public void addPolicy(PolicyCancel policy)
    {
        policies.add(policy);
    }

    public void removePolicy(String policyNumber)
    {
        for(int i=0;i<policies.size();i++)
        {
            if(policies.get(i).getPolicynumber().equals(policyNumber))
                policies.remove(i);
        }
    }

    public PolicyCancel findPolicy(String policyNumber)
    {
        for(int i=0;i<policies.size();i++)
        {
            if(policies.get(i).getPolicynumber().equals(policyNumber))
                return policies.get(i);
        }
        return null;
    }

    public void viewAll()
    {
        for (int i=0;i<policies.size();i++)
        {
            System.out.println(policies.get(i));
        }
    }

}


public class PolicyCancellation
{
    public static void cancelPolicy(PolicyCancel policy) throws CancellationNotAllowedException,PolicyNotFoundException
    {
        if(policy==null)
            throw new PolicyNotFoundException();
        if(LocalDate.now().isBefore(policy.getStart_date().plusYears(1)))
            throw new CancellationNotAllowedException();
        System.out.println("Cancellation successful!");
    }

    public static void main(String[] args)
    {
        Policies policies=new Policies();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1.Add new policy\n2.Cancel policy\n3.Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter policy details:");
                    System.out.println("Policy number:");
                    String policyNumber = scanner.next();
                    System.out.println("Policy holder name:");
                    scanner.nextLine();
                    String policyHolder = scanner.nextLine();
                    System.out.println("Type:");
                    String policyType = scanner.next();
                    System.out.println("Expiry date(yyyy-mm-dd):");
                    scanner.nextLine();
                    String date=scanner.nextLine();
                    LocalDate expiry_date= LocalDate.parse(date);
                    System.out.println("Coverage:");
                    long policyCoverage = scanner.nextLong();
                    System.out.println("Start Date(yyyy-mm-dd):");
                    LocalDate start_date=LocalDate.parse(scanner.next());
                    PolicyCancel policy = new PolicyCancel(policyNumber, policyHolder, policyType,expiry_date, policyCoverage,start_date);
                    policies.addPolicy(policy);
                    break;
                case 2:
                    System.out.println("Enter thr policy number :");
                    String policynumber = scanner.next();
                    PolicyCancel policy1=policies.findPolicy(policynumber);
                    try
                    {
                        cancelPolicy(policy1);
                    }catch ( CancellationNotAllowedException e)
                    {
                        System.out.println("Cancellation allowed only after a year!");
                    }catch (PolicyNotFoundException e)
                    {
                        System.out.println("Policy not found!");
                    }
                    break;
                case 3:
                    System.out.println("Exiting!");
                    break;

            }

        } while (choice != 3);
    }
}