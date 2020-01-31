import java.util.Scanner;
class Reverse{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();
		StringBuffer buff = new StringBuffer(s);

		buff.reverse();

		System.out.println(buff);
	}
}