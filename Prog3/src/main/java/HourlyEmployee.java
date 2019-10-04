public class HourlyEmployee extends Employee{
    private double wage;
    //Constructor that calls the super
    public HourlyEmployee(String fname, String lname, String ssn, int hours, double wage){
        super(fname, lname, ssn, hours);
        this.wage = wage;
    }
//Overides for the abstract methods
    @Override
    public String getType(){
        return "HOURLY";
    }
    @Override
    public double totalPay(){
        return wage * hours;
    }
}