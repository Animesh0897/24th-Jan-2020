import java.util.Scanner;

class charcheck{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char c = sc.next().charAt(0);

		String s = sc.nextLine();

		System.out.println(s.contains(Character.toString(c)));




	}
}