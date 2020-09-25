package com.company;
import java.util.ArrayList;

public class Author extends Person{
    private int beg_year;
    private int end_year;
    private ArrayList<String> awards;

    public Author(){}

    public Author(String name, String surname, String parent, int age, Sex sex, int beg_year, int end_year){
        super(name, surname,parent, age, sex);
        this.setBeg_year(beg_year);
        this.setEnd_year(end_year);
    }

    public Author(String name, String surname, String parent, int age, Sex sex, int beg_year, int end_year, ArrayList<String> awards){
        super(name, surname, parent, age, sex);
        this.setBeg_year(beg_year);
        this.setEnd_year(end_year);
        this.setAwards(awards);
    }

    public Author(String name, String surname, String parent, int age, Sex sex, int beg_year, int end_year, String award) {
        super(name, surname,parent, age, sex);
        this.setBeg_year(beg_year);
        this.setEnd_year(end_year);
        this.setAwards(award);
    }

    public void setAwards(String award){ this.awards.add(award); }
    public void setAwards(ArrayList<String> awards) { this.awards.addAll(awards); }
    public void setBeg_year(int beg_year) { this.beg_year = beg_year; }
    public void setEnd_year(int end_year) { this.end_year = end_year; }

    public ArrayList<String> getAwards() { return awards; }
    public int getBeg_year() { return beg_year; }
    public int getEnd_year() { return end_year; }


    @Override
    public void show(boolean var) {
        System.out.println("Author\n");
        super.show();
        System.out.println("(" + beg_year + " " + end_year + ")");
        if(awards != null){
            System.out.println("List of awards:");
            for (Object element : awards) {
                System.out.println(" " + element + " ");
            }
        }
    }
}
