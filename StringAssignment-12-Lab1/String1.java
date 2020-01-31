import java.util.Scanner;
import java.util.StringTokenizer;

class String1{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringTokenizer stringTok = new StringTokenizer(str);
		String[] stringArray = new String[100];
		int i = 0, sum = 0;
		while(stringTok.hasMoreTokens()){
			stringArray[i] = stringTok.nextToken();
			int x  = Integer.parseInt(stringArray[i]);
			sum += x;
			i++;
		}

		System.out.println("The numbers are: ");
		for(int j=0; j<i; j++){
			System.out.println(stringArray[j] + " ");
		}

		System.out.print("The sum is: " + sum);
	}
}