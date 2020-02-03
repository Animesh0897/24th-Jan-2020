//Write a Java program that prompts the user for an integer and then prints out all the prime numbers up to that Integer?

import java.util.Scanner;

class PrimeNumbers
{
	public static void main(String[] args)
	{
		
		
		Scanner sc =new Scanner(System.in);
		int n = 13;//sc.nextInt();
		System.out.println("Enter a number: ");
		int p;
		for(int i=2;i<n;i++)
		{
			p=0;
			for(int j=2;j<i;j++)
			{
				if(i%j==0)
				p=1;
			}
			if(p==0)
				System.out.println(i);
		}
	}
} 