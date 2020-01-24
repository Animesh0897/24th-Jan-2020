import java.math.BigInteger;
import java.util.*;
class Assignment1q1
{
    static BigInteger factorial(int N) 
    { 
        BigInteger f = new BigInteger("1"); 
 
        for (int i = 2; i <= N; i++) 
            f = f.multiply(BigInteger.valueOf(i)); 
  
        return f; 
    } 
  
    public static void main(String args[]) throws Exception 
    { 

        int N = Integer.parseInt(args[0]); 
        System.out.println(factorial(N));
    } 
} 
        