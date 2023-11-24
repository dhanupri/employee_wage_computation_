public class Employee_Wage {
    
    public static int  generate_random(){
        int present_or_absent= (int) Math.floor((Math.random()*10)%3);
        return present_or_absent;
        
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

    }

}
