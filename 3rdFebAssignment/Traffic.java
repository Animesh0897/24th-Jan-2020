import java.util.*;
class Traffic
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		System.out.println("Enter your option");
		System.out.println("Press 1 for red light");
		System.out.println("Press 2 for yellow light");
		System.out.println("Press 3 for green light");
		int opt = sc.nextInt();
		switch(opt)
		{
			case 1:
				System.out.println("red. STOP");
				break;
			case 2:
				System.out.println("Yellow WAIT");
				break;
			case 3:
				System.out.println("Green GO");
				break;
			default:
				throw new ArithmeticException("Invalid Choice");
		}

		


	}
}