package Employee_1;
class Company{
    private static  int wage_per_hour ;
    private static int full_day_hour;


    Company(int wage_per_hour,int full_day_hour){
        this.wage_per_hour=wage_per_hour;
        this.full_day_hour=full_day_hour;


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
}

public class Employee_Wage {

    public static int  generate_random(){
        int present_or_absent= (int) Math.floor((Math.random()*10)%3);
        return present_or_absent;

    }
    public static int calculateDaily_Wage(int presentOrAbsent,Company company){
        if(presentOrAbsent==1 || presentOrAbsent==2) {
            return  Company.getWage_per_hour() * Company.getFull_day_hour();
        }
        else{
            return 0;
        }



    }

    public static void main(String[] args){
        System.out.println("Welcome to Employee Wage Computation Program");
        int presentOrabsent=generate_random();
        if( presentOrabsent==0){
            System.out.println("Absent");
        }
        else{
            System.out.println("present");
        }

        Company company1=new Company(20,8);
        int Daily_wage=calculateDaily_Wage(presentOrabsent,company1);
        System.out.println(Daily_wage);


    }

}

