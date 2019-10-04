import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

/*
 CSE 17
 Sam Sausville
 sps222
 Employees data objects to learn abstraction, inheritance and string formatting
 Program 3
*/
public class Prog3{
    public static void main(String [] args) throws IOException{
    ArrayList<Employee> employees = new ArrayList<>();
    File file = new File("myData.txt"); //File object
    FileReader f = new FileReader(file); //File reader
    BufferedReader br = new BufferedReader(f);
    String line;
    while ((line = br.readLine()) != null){
        StringTokenizer tk = new StringTokenizer(line); //Used String tokenizer since I am more familar with it and its easy to use
        String fname = tk.nextToken();
        String lname = tk.nextToken();
        String ssn = tk.nextToken();
        int type = Integer.parseInt(tk.nextToken()); //Need to parse the numbers from the string tokens
        int hours = Integer.parseInt(tk.nextToken());
        double wage = Double.parseDouble(tk.nextToken());
        double salary = Double.parseDouble(tk.nextToken());
        Employee e = Employee.factory(fname, lname, ssn, type, hours, wage, salary); //Create and add the employees line by line
        employees.add(e);
    }
    br.close(); //Make sure to close the reader
        //Table header with formating
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-20s %-10s %10s %-5s %10s", "Name", "SSN", "Type", "Hours", "", "Total Pay");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------");
        double grandTotalPay = 0.0;
    for(int i = 0; i < employees.size(); i++){ //Loop to fill in the table
        Employee e = employees.get(i);
        System.out.printf("%-20s %-20s %-10s %10s %-5s %10s", //Added extra empty header and string to make sure the table was even
                e.getName(), e.getSsn(), e.getType(), String.format("%d",e.getHours()),"", String.format("%.2f", e.totalPay()));
        System.out.println();
        grandTotalPay += e.totalPay();
    }
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Grand Total Pay is: " + String.format("%.2f", grandTotalPay));
        System.out.println();

    }
}