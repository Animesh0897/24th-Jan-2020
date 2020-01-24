import java.util.*;
class Assignment1q6{
    public static void main(String[] args) {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);
        int sum = num1 + num2 + num3;
        int trigger = 0;
        if(num1<40){
            trigger = 1;
        }
        if(num2<40){
            trigger = 1;
        }
        if(num3<40){
            trigger = 1;
        }
        if(sum<125){
            trigger = 1;
        }
        if(trigger==0){
            System.out.print("PASS");
        }
        if(trigger==1){
            System.out.print("FAIL");
        }
    }
}