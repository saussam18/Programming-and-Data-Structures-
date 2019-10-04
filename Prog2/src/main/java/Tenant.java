
/*
CSE 17
Sam Sausville
sps222@lehigh.edu
Program Description: Takes tenant objects and prints out the data
Program #2
*/
public class Tenant{
    //Object varibales 
    private String firstName;
    private String lastName;
    private String aptNumber;
    private double yearlyRent;

//Constructor method, sets the object
public Tenant (String fName, String lName, String aptNum, double yRent ){
    firstName = fName;
    lastName = lName;
    aptNumber = aptNum;
    yearlyRent = yRent;
}

//Returns first payment by taking yearly cost, dividing it by cost and multiplying by 3
public double firstPayment (){
    double payment = yearlyRent / 12.0;
    payment = payment * 3;
    return payment;
}

//Returns monthlyPayment for each month
public double monthlyPayment (){
   double monthlyRent = ((yearlyRent - (yearlyRent/12 *2))/11);
   double round = Math.round(monthlyRent * 100.0) / 100.0;
   return round;
}
//Returns full name of tenant
public String fullName(){
    String name = firstName + " " + lastName;
    return name;
}

    //Getters and Setters

    /**
     * @return the aptNumber
     */
    public String getAptNumber() {
        return aptNumber;
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }/**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }/**
     * @return the yearlyRent
     */
    public double getYearlyRent() {
        return yearlyRent;
    }/**
     * @param aptNumber the aptNumber to set
     */
    public void setAptNumber(String aptNumber) {
        this.aptNumber = aptNumber;
    }/**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }/**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }/**
     * @param yearlyRent the yearlyRent to set
     */
    public void setYearlyRent(double yearlyRent) {
        this.yearlyRent = yearlyRent;
    }
}