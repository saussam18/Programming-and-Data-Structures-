
public abstract class Employee{
    private String fname;
    private String lname;
    private String ssn;
    protected int hours;

//Abstract methods for the subclasses to use
    public abstract String getType();

    public abstract double totalPay();

    //Base constructor for all employee objects
    public Employee(String fname, String lname, String ssn, int hours){
        this.fname = fname;
        this.lname = lname;
        this.ssn = ssn;
        this.hours = hours;
    }

    //Main method that makes the employee objects
    public static Employee factory(String fname, String
    lname, String ssn, int type, int hours, double wage,
    double salary){
        if(type == 1){
            return new HourlyEmployee(fname, lname, ssn, hours, wage);
        }else if(type == 2){
            return new SalariedEmployee(fname, lname, ssn, hours, salary);
        }else{
            System.out.println("Error, Invalid Type");
            throw new IllegalArgumentException();
        }
    }
    //Getters and Setters
    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }/**
     * @return the hours
     */
    public int getHours() {
        return hours;
    }/**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }/**
     * @return the ssn
     */
    public String getSsn() {
        return ssn;
    }

    //Simple Getter that just merges the first and last name to make the table easier for me
    public String getName(){
        String s = fname +" " +  lname;
        return s;
    }
    
}