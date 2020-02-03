// Write a Java Program to validate the full name of an employee. Create and throw a user defined exception if firstName and lastName is blank
import java.util.Scanner;

class nameException extends Exception
{
	public nameException(String str)
	{
		System.out.println(str);
	}
}


class ValidName
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// String firstName = sc.nextLine();
		// String lastName = sc.nextLine();
		String firstName = "anim";
		String lastName = "";

		try{
			if(firstName == "" || lastName =="") throw new nameException("Invalid name");
			else
			{
				System.out.println("Valid name");
			}

		}catch(nameException ne)
		{
			System.out.println(ne);
		}
		
	}
}