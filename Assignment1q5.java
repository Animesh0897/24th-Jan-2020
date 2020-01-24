
class Assignment1q5
{
	public static void main(String[] args) {
		int firstNum = 23 , secondNum = 75 , thirdNum = 65;
		int sum = firstNum + secondNum + thirdNum;

		if((firstNum >= 40 || secondNum>=40 || thirdNum>=40) && (firstNum+secondNum+thirdNum>=125))
		{
			System.out.print("Pass");
		}
		else
		{
			System.out.print("Fail");
		}
	}
}