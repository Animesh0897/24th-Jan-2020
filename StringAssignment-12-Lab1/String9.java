
import java.util.Scanner;

class String9{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter nth Number");
		int nth = sc.nextInt();
		//int nth = 10;

		System.out.println(nSum(nth));



	}

	static int nSum(int nth)
	{
		
		int sum1 = ((nth/3)*((2*3 + (nth/3-1)*3))/2);

		int sum2 = ((nth/5)*((2*5) + (nth/5-1)*5)/2);

		int sum3 = ((nth/15)*((2*15) + (nth/15-1)*15)/2);

		int sum = sum1+sum2-sum3;

		return sum;
	}

}