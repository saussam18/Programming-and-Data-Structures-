public class SalariedEmployee extends Employee{
private double salary;

    //Constructor that calls the super
    public SalariedEmployee(String fname, String lname, String ssn, int hours, double salary){
        super(fname, lname, ssn, hours);
        this.salary = salary;
    }

    //Overide methods for the abstract class
    @Override
    public String getType(){
        return "SALARIED";
    }
    @Override
    public double totalPay(){
        return salary / 52.0;
    }
}