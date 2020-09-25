package com.company;

public class Librarian extends Person {
    private int idContract;
    private String phoneNumber;
    private double salary;
    private static int lastContr;


    @Override
    public void show(boolean var) {
        System.out.println("Librarian");
        super.show();
        System.out.println("Id contract: " + idContract);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Salary: " + salary);
    }

    public Librarian(){
        this.lastContr += 1;
    }
    public Librarian(String name, String surname, String parent, int age, Sex sex, String phoneNumber, double salary){
        super(name, surname,parent, age, sex);
        this.setIdContract(lastContr);
        this.setPhoneNumber(phoneNumber);
        this.lastContr += 1;
        this.setSalary(salary);
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
    public int getIdContract() {
        return idContract;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
}

