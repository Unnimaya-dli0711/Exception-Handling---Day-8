package policy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

class PolicyClaim {
    String policynumber;
    String policyholder;
    LocalDate expiry_date;
    LocalDate start_date;
    String type;
    long amount;

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(LocalDate expiry_date) {
        this.expiry_date = expiry_date;
    }

    public PolicyClaim(String policynumber, String policyholder, String type, LocalDate expiry_date, long coverage, LocalDate start_date) {
        this.policynumber = policynumber;
        this.policyholder = policyholder;
        this.expiry_date = expiry_date;
        this.type = type;
        this.amount = coverage;
        this.start_date = start_date;
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
        return "Policy Number:" + policynumber + "\nPolicy holder name:" + policyholder + "\nStart Date:" + start_date + "\nExpiry Date:" + expiry_date + "\nType:" + type + "\nPremium amount:" + amount;
    }
}
class FraudulentClaimException extends Exception
{

}

class InvalidClaimAmountException extends Exception
{

}

public class ClaimProcessing {
    static ArrayList<PolicyClaim> policies=new ArrayList<>();
    public  static void addPolicy(PolicyClaim policy)
    {
        policies.add(policy);
    }

    public static void removePolicy(String policyNumber)
    {
        for(int i=0;i<policies.size();i++)
        {
            if(policies.get(i).policynumber.equals(policyNumber))
                policies.remove(i);
        }
    }

    public static PolicyClaim findPolicy(String policyNumber)
    {
        for(int i=0;i<policies.size();i++)
        {
            if(policies.get(i).policynumber.equals(policyNumber))
                return policies.get(i);
        }
        return null;
    }

    public static void viewAll()
    {
        for (int i=0;i<policies.size();i++)
        {
            System.out.println(policies.get(i));
        }
    }

    public static void processClaim(PolicyClaim policy,long claim) throws FraudulentClaimException,InvalidClaimAmountException
    {
        LocalDate thirtyDaysfromStart=policy.start_date.plusDays(30);
        if(LocalDate.now().isBefore(thirtyDaysfromStart))
            throw new FraudulentClaimException();
        if(claim>policy.amount)
            throw new InvalidClaimAmountException();
        System.out.println("Claim processed!");
    }
    public static void main(String[] args)
    {
        //Policies policies=new Policies();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1.Add new policy\n2.Claim policy\n3.Exit");
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
                    PolicyClaim policy = new PolicyClaim(policyNumber, policyHolder, policyType,expiry_date, policyCoverage,start_date);
                    addPolicy(policy);
                    break;
                case 2:
                    System.out.println("Enter thr policy number :");
                    String policynumber = scanner.next();
                    System.out.println("Enter the amount:");
                    long claim=scanner.nextInt();
                    PolicyClaim policy1=findPolicy(policynumber);
                    try
                    {
                        processClaim(policy1,claim);
                    }catch (FraudulentClaimException e)
                    {
                        System.out.println("Amount can be claimed only after 30 days from start date!");
                    }catch (InvalidClaimAmountException e)
                    {
                        System.out.println("Invalid claim amount!");
                    }
                    break;
                case 3:
                    System.out.println("Exiting!");
                    break;

            }

        } while (choice != 3);

    }

}
