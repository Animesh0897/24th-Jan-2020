import java.util.Scanner;
class Pali{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s1 =  sc.nextLine();
	
		StringBuffer buffer = new StringBuffer(s1);
		buffer.reverse();
		String data = buffer.toString();

		if(s1.equals(data))
		{
			System.out.println("Palindrome");
		}
		else{
			System.out.println("Not");
		}




	}
}
	