package Employee_1;


import java.util.ArrayList;
import java.util.Scanner;

interface CompanyEmpWage{
    public  int generate_random();


    public int calculateDaily_Wage(int presentOrAbsent, Company company);

    public void  multiple_companyWage(Company c);





}

class Company {
    private static int total_wage;
    private  int wage_per_hour ;
    private  int full_day_hour;
    private  int part_time_hour;
    private  int working_day_per_month;
    private  String Name;
    private int total_wage1;


    Company(String Name,int wage_per_hour,int full_day_hour,int part_time_hour,int working_day_per_month){
        this.Name=Name;
        this.wage_per_hour=wage_per_hour;
        this.full_day_hour=full_day_hour;
        this.part_time_hour=part_time_hour;
        this.working_day_per_month=working_day_per_month;
        this.total_wage1=0;



    }


    public  int getWage_per_hour() {
        return wage_per_hour;
    }





    public void setWage_per_hour(int wage_per_hour) {
       this.wage_per_hour = wage_per_hour;
    }

    public  int getFull_day_hour() {
        return full_day_hour;
    }

    public void setFull_day_hour(int full_day_hour) {
        this.full_day_hour = full_day_hour;
    }

    public  int getPart_time_hour() {
        return part_time_hour;
    }

    public void setPart_time_hour(int part_time_hour) {
        this.part_time_hour = part_time_hour;
    }

    public  int getWorking_day_per_month() {
        return working_day_per_month;
    }

    public void setWorking_day_per_month(int working_day_per_month) {
        this.working_day_per_month = working_day_per_month;
    }

    public  String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public  int getTotal_wage1() {
        return total_wage;
    }

    public void setTotal_wage1(int total_wage) {
        this.total_wage = total_wage;
    }



}

public class Employee_Wage implements CompanyEmpWage{
    /*
    Employee is
    Present or Absent
     */
    public  int  generate_random(){
        int present_or_absent= (int) Math.floor((Math.random()*10)%3);
        return present_or_absent;

    }

    /*
    Calculate Daily
    Employee Wage
     */

    public int calculateDaily_Wage(int presentOrAbsent,Company company){
        switch (presentOrAbsent){
            case 1:
                return company.getFull_day_hour()*company.getWage_per_hour();

            case 2:
                return company.getPart_time_hour()*company.getWage_per_hour();

            default:
                return 0;


        }



    }
    public void multiple_companyWage(Company c){


        int monthly_wage = 0;
        int no_of_days_present = 0;
        int no_of_days_absent = 0;
        int no_of_hours_worked = 0;
        /*
        Calculate Wages till
         condition of total
        working hours or
        days is reached for
        a month
         */

        while (no_of_days_present <= c.getWorking_day_per_month() && no_of_hours_worked <= 100) {
            int presentOrabsent = generate_random();
            if (presentOrabsent == 0) {
                no_of_days_absent++;
            } else {
                no_of_days_present++;
                if (presentOrabsent == 1) {
                    no_of_hours_worked += c.getFull_day_hour();
                } else {
                    no_of_hours_worked += c.getPart_time_hour();
                }
            }

            int Daily_wage = calculateDaily_Wage(presentOrabsent, c);
            monthly_wage += Daily_wage;





        }
        System.out.println("Company_name:"+c.getName());
        System.out.println("monthly_wage:"+monthly_wage);
        c.setTotal_wage1(c.getTotal_wage1()+monthly_wage);
        System.out.println("Total wage:"+c.getTotal_wage1());

        System.out.println("Absent:" + no_of_days_absent + " " + "present:" + no_of_days_present);
        System.out.println("no_of_hours_worked:"+no_of_hours_worked);



    }




    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        /*
        display message
         */
        System.out.println("Welcome to Employee Wage Computation ");
        Company company1=new Company("company1",20,8,4,20);
        Company company2=new Company("company2",25,7,3,25);
        Company company3=new Company("company3",25,7,3,25);

        Store_company.companies.add(company1);
        Store_company.companies.add(company3);
        Store_company.companies.add(company2);



        Employee_Wage Emp_wage=new Employee_Wage();

        System.out.println("Enter the Name of company :");
        String name=sc.nextLine();
        Company name1=Store_company.search(name);





        Emp_wage.multiple_companyWage(name1);





    }

}
class Store_company{

    public static ArrayList<Company> companies=new ArrayList<>();
    public static void add_info(Company c){
        companies.add(c);


    }

    public static Company search(String name){
        for (Company c:companies){

            if(c.getName().equals(name)){

               return c;


            }
        }
        return null;
    }





}



