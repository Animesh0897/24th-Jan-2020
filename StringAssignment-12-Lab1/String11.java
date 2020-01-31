import java.util.Scanner;
class String11
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 13378;
		System.out.println(check(num));
	}

	static boolean check(int num)
	{
		String s = Integer.toString(num);
		char ch;
		int flag = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			ch = s.charAt(i);
			if (ch > s.charAt(i + 1))
			{
				flag = 1;
				break;
			}
		}
		if (flag == 1)
			return false;
		else
			return true;
	}
	
}