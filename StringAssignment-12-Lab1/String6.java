import java.util.Scanner;
class String6{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		String str[] = new String[size];

		//String str[] = {"asdsa","dhfkjhd","basGFDS","GDHGAD","Cjslkdfj"};
		//int size = str.length;
		for(int i = 0 ; i < str.length ; i++)
		{
			str[i] = sc.nextLine();
		}


		for(int i = 0 ; i < str.length ; i++)
		{
			str[i] = str[i].toLowerCase();
		}

		for(int i = 0; i<size-1; i++) {
         for (int j = i+1; j<str.length; j++) {
            if(str[i].compareTo(str[j])>0) {
               String temp = str[i];
               str[i] = str[j];
               str[j] = temp;
            }
         }
      }

      if(size%2==0)
      {
	      for(int i = 0 ; i < size/2 ; i++)
	      {
	      	str[i] = str[i].toUpperCase();
	      }
	      for(int i = size/2 ; i < size; i++)
	      {
	      	str[i] = str[i].toLowerCase();
	      }
      }

      else
      {
      	for(int i = 0 ; i < (size/2)+1 ; i++)
      	{
      		str[i] = str[i].toUpperCase();
      	}
      	for(int i = (size/2)+1 ; i<size ; i++)
      	{
      		str[i] = str[i].toLowerCase();
      	}
      }

      

      for(int i = 0 ; i < size ; i++)
      {
      	System.out.print(str[i]+" ");
      }




	}
}