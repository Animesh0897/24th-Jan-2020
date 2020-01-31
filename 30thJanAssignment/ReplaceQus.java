import java.util.Scanner;
class ReplaceQus{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();

		String rep = sc.nextLint();
		
		StringBuffer buff = new StringBuffer(str);

		buff.replace(2,5,rep);

		System.out.println(buff);
	}
}