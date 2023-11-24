package Employee_1;
class Company{
    private static  int wage_per_hour ;
    private static int full_day_hour;
    private static int part_time_hour;
    private static int working_day_per_month;


    Company(int wage_per_hour,int full_day_hour,int part_time_hour,int working_day_per_month){
        this.wage_per_hour=wage_per_hour;
        this.full_day_hour=full_day_hour;
        this.part_time_hour=part_time_hour;
        this.working_day_per_month=working_day_per_month;


    }


    public static int getWage_per_hour() {
        return wage_per_hour;
    }

    public static void setWage_per_hour(int wage_per_hour) {
        Company.wage_per_hour = wage_per_hour;
    }

    public static int getFull_day_hour() {
        return full_day_hour;
    }

    public static void setFull_day_hour(int full_day_hour) {
        Company.full_day_hour = full_day_hour;
    }

    public static int getPart_time_hour() {
        return part_time_hour;
    }

    public static void setPart_time_hour(int part_time_hour) {
        Company.part_time_hour = part_time_hour;
    }

    public static int getWorking_day_per_month() {
        return working_day_per_month;
    }

    public static void setWorking_day_per_month(int working_day_per_month) {
        Company.working_day_per_month = working_day_per_month;
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



        int monthly_wage=0;
        int no_of_days_present=0;
        int no_of_days_absent=0;
        int no_of_hours_worked=0;
        while (no_of_days_present<=Company.getWorking_day_per_month() && no_of_hours_worked<=100){
            int presentOrabsent=generate_random();
            if( presentOrabsent==0){
                no_of_days_absent++;
            }
            else{
                no_of_days_present++;
               if(presentOrabsent==1){
                   no_of_hours_worked+=Company.getFull_day_hour();
               }
               else{
                   no_of_hours_worked+=Company.getPart_time_hour();
               }
            }




            int Daily_wage=calculateDaily_Wage(presentOrabsent,company1);
            monthly_wage+=Daily_wage;


        }
        System.out.println(monthly_wage);
        System.out.println("Absent:"+no_of_days_absent+" "+"present:"+no_of_days_present);
        System.out.println(no_of_hours_worked);


    }

}


