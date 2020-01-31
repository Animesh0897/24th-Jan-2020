import java.util.Scanner;
class String5
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();
		
		System.out.println(sumcube(input));


	}

	static int sumcube(int input)
	{
		int sum = 0;
		int num = input;
		while(num>0)
		{
			int digit = num%10;
			sum+=(digit*digit*digit);
			num = num/10;
		}

		return sum;
	}
}