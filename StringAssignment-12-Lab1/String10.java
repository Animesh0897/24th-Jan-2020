import java.util.Scanner;
class String10{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(diff(sc.nextInt()));
	}

	static int diff(int num){
	int sum1, sum2; 
    
    sum1 = (num * (num + 1) * (2 * num + 1)) / 6; 

    sum2 = (num * (num + 1)) / 2;
    int newSum2 = sum2 * sum2; 
      
    return Math.abs(sum1-newSum2);
	}
}