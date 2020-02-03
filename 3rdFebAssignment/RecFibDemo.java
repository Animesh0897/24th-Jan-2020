import java.util.Scanner;
class Demo {
	int fib(int n) {
		if(n==1)
			return (1);
		else if(n==2)
			return (1);
		else
			return (fib(n-1)+fib(n-2));
	}
}


class RecFibDemo {
	public static void main(String args[]){
		
		System.out.println("enter last number");
		Scanner sc = new Scanner(System.in);
		int n= 23;//sc.nextInt();
		Demo ob=new Demo();
		System.out.println("fibonacci series is as follows");
		int res=0;
		for(int i=1;i<=n;i++) {
			res=ob.fib(i);
			System.out.println(" "+res);
		}
		System.out.println();
		System.out.println(n+"th value of the series is "+res);
	}
}