import java.util.Scanner;
import com.cg.eis.exception.SalaryException;
// class SalaryException extends Exception
// {
// 	public SalaryException(String str)
// 	{
// 		System.out.println(str);
// 	}

// }

class salaryExpDemo
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Salary");
		int salary = 3500;

		try
		{
			if (salary < 3000) throw new SalaryException("Invalid Salary");
			else
			{
				System.out.println("Valid");
			}

		}catch(SalaryException se)
		{
			System.out.println(se);
		}
	}
}