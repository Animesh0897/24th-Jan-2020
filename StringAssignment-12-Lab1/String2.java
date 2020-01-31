import java.util.*;
class String2
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextInt();
		//String input = "ant";
		System.out.println(check(input));

	}


	static boolean check(String input)
	{

		String prevString = input;
		char tempArray[] = input.toCharArray();
		Arrays.sort(tempArray);
		String newString = String.valueOf(tempArray);

		if(prevString.equals(newString))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}