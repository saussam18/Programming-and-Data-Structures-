
import java.util.ArrayList;
import java.util.Scanner;
/*
CSE 17
Sam Sausville
sps222@lehigh.edu
Program Description: Takes tenant objects and prints out the data
Program #2
*/
public class Prog2{
    public static void main (String [] args){
        ArrayList<Tenant> residents = new ArrayList<>();
        Scanner scan = new Scanner (System.in);
        System.out.println("How many tenants are there?");
        while(!scan.hasNextInt()){
            String trash = scan.next();
            System.out.println("Error: please enter a numeric value");
            System.out.println("How many tenants are there?");
        }
        int numOfTenants = scan.nextInt();
        for(int i = 0; i < numOfTenants; i++){
            System.out.println("Enter First Name");
            String fName = scan.next();
            System.out.println("Enter Last Name");
            String lName = scan.next();
            System.out.println("Enter Apartment Number");
            String aptNum = scan.next();
            System.out.println("Enter Yearly Rent");
            while(!scan.hasNextDouble()){
                String trash = scan.next();
                System.out.println("Error: please enter a numeric value");
                System.out.println("Enter Yearly Rent");
            }
            double yRent = scan.nextDouble();
            Tenant t = new Tenant(fName, lName, aptNum, yRent);
            residents.add(t);
        }

        System.out.println();

        for(int i = 0; i < residents.size(); i++){
            Tenant temp = residents.get(i);
            System.out.println(temp.fullName());
            System.out.println(temp.getAptNumber());
            System.out.printf("%.2f", temp.firstPayment());
            System.out.println();
            System.out.println(temp.monthlyPayment());
            System.out.println();

        }

    }
}