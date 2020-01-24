import java.util.*;
class Assignment1q2
{
	public static void main(String[] args) {
		int low = 1;
		int high = 89;
		int A = 0;
		int B = 1;
		int C;
	
		while(A<high)
		{
			if (A>low)
			{
				System.out.println(" "+A);
			}
			C = A+B;
			A = B;
			B = C;
		}
		
	}
}