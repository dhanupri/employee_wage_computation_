package Employee_1;

import java.util.ArrayList;

class Company{
    private  int wage_per_hour ;
    private  int full_day_hour;
    private  int part_time_hour;
    private  int working_day_per_month;
    private int total_wage1;


    Company(int wage_per_hour,int full_day_hour,int part_time_hour,int working_day_per_month){
        this.wage_per_hour=wage_per_hour;
        this.full_day_hour=full_day_hour;
        this.part_time_hour=part_time_hour;
        this.working_day_per_month=working_day_per_month;
	this.total_wage1=0;
	


    }


    public  int getWage_per_hour() {
        return wage_per_hour;
    }

    public  void setWage_per_hour(int wage_per_hour) {
        this.wage_per_hour = wage_per_hour;
    }

    public  int getFull_day_hour() {
        return full_day_hour;
    }

    public  void setFull_day_hour(int full_day_hour) {
        this.full_day_hour = full_day_hour;
    }

    public  int getPart_time_hour() {
        return part_time_hour;
    }

    public void setPart_time_hour(int part_time_hour) {
        this.part_time_hour = part_time_hour;
    }

    public int getWorking_day_per_month() {
        return working_day_per_month;
    }

    public  void setWorking_day_per_month(int working_day_per_month) {
        this.working_day_per_month = working_day_per_month;
    }
    public  int getTotal_wage1() {
        return total_wage;
    }

    public void setTotal_wage1(int total_wage) {
        this.total_wage = total_wage;
    }
}

public class Employee_Wage {

    public static int  generate_random(){
        int present_or_absent= (int) Math.floor((Math.random()*10)%3);
        return present_or_absent;

    }
    public static int calculateDaily_Wage(int presentOrAbsent,Company company){
       switch (presentOrAbsent){
           case 1:
               return Company.getFull_day_hour()*Company.getWage_per_hour();

           case 2:
               return Company.getPart_time_hour()*Company.getWage_per_hour();

           default:
               return 0;


       }



    }

    public static void main(String[] args){
        System.out.println("Welcome to Employee Wage Computation Program");
        Company company1=new Company(20,8,4,20);
        Company company2=new Company(25,7,3,25);
        ArrayList<Company> companies=new ArrayList<>();
        companies.add(company1);
        companies.add(company2);
        int n=1;
        for(Company company:companies) {
            System.out.println("company"+n);
            n++;


            int monthly_wage = 0;
            int no_of_days_present = 0;
            int no_of_days_absent = 0;
            int no_of_hours_worked = 0;
            while (no_of_days_present <= 20 && no_of_hours_worked <= 100) {
                int presentOrabsent = generate_random();
                if (presentOrabsent == 0) {
                    no_of_days_absent++;
                } else {
                    no_of_days_present++;
                    if (presentOrabsent == 1) {
                        no_of_hours_worked += company.getFull_day_hour();
                    } else {
                        no_of_hours_worked += company.getPart_time_hour();
                    }
                }

                int Daily_wage = calculateDaily_Wage(presentOrabsent, company);
                monthly_wage += Daily_wage;


            }
            System.out.println("monthly_wage:"+monthly_wage);
	    c.setTotal_wage1(c.getTotal_wage1()+monthly_wage);
            System.out.println("Total wage:"+c.getTotal_wage1());

            System.out.println("Absent:" + no_of_days_absent + " " + "present:" + no_of_days_present);
            System.out.println("no_of_hours_worked"+no_of_hours_worked);
        }


    }

}



