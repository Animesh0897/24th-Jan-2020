import java.util.Scanner;
import java.time.LocalDate;

class String3{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String sysDate = (LocalDate.now()).toString();
		System.out.println(sysDate);

		System.out.println("Enter date in yyyy-mm-dd format: ");
		String userDate = sc.nextLine();

		String userDay, userMonth, userYear;
		String sysDay, sysMonth, sysYear;

		int integerSysYear = Integer.parseInt(sysDate.substring(0,4));
		int integerSysMonth = Integer.parseInt(sysDate.substring(5,7));
		int integerSysDay = Integer.parseInt(sysDate.substring(8,10));

		int integerUserYear = Integer.parseInt(userDate.substring(0,4));
		int integerUserMonth = Integer.parseInt(userDate.substring(5,7));
		int integerUserDay = Integer.parseInt(userDate.substring(8,10));
		// System.out.println(sysDay + " " + sysMonth + " " + sysYear);

		int finalDay, finalMonth, finalYear;

		if(integerUserDay<=integerSysDay){

			if(integerUserMonth<=integerSysMonth){

				if(integerUserYear<=integerSysYear){

					finalDay = (integerSysDay - integerUserDay);
					finalMonth = (integerSysMonth - integerUserMonth);
					finalYear = (integerSysYear - integerUserYear);

				}
				else{

					finalDay = (integerSysDay - integerUserDay);
					finalMonth = (integerSysMonth - integerUserMonth);
					finalYear = (integerUserYear - integerSysYear);

				}
			}
			else{

				if(integerUserYear<=integerSysYear){

					finalDay = (integerSysDay - integerUserDay);
					finalMonth = 12-(integerUserMonth - integerSysMonth);
					finalYear = (integerSysYear - integerUserYear-1);

				}
				else{

					finalDay = (integerSysDay - integerUserDay);
					finalMonth = (integerUserMonth - integerSysMonth);
					finalYear = (integerUserYear - integerSysYear);
				}
			}
		}
		else
		{
			if(integerUserMonth<=integerSysMonth){

				if(integerUserYear<=integerSysYear){

					finalDay = (integerUserDay - integerSysDay);
					finalMonth = (integerSysMonth - integerUserMonth-1);
					finalYear = (integerSysYear - integerUserYear-1);

				}
				else{

					finalDay = 30-(integerUserDay - integerSysDay);
					finalMonth = (integerSysMonth - integerUserMonth);
					finalYear = (integerUserYear - integerSysYear);

				}
			}
			else{

				if(integerUserYear<=integerSysYear){

					finalDay = (integerUserDay - integerSysDay);
					finalMonth = (integerUserMonth - integerSysMonth-1);
					finalYear = (integerSysYear - integerUserYear-1);

				}
				else{

					finalDay = 30-(integerUserDay - integerSysDay);
					finalMonth = (integerUserMonth - integerSysMonth);
					finalYear = (integerUserYear - integerSysYear);
				}
			}
		}
	
		System.out.println("The difference is: " + finalDay + " days " + finalMonth + " months "+ finalYear + " years.");
	
	}
}