import java.util.Scanner;

class String4{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		//String id = "fgdsgf87_job";
		System.out.println(Check(id));
		
	}

	static boolean Check (String id)
	{
		if(id.length()<12 && !(id.endsWith("_job")))
		{	
			return false;
		}
		else
		{
			return true;
		}

	}
}