import java.util.*;
import java.lang.*;


class mySplitFunc{

	public static String[] mySplit(String str,String deli){
		StringBuilder sb1 = new StringBuilder("");
		if(index(str,deli)!=-1){
			int m = str.indexOf(deli);
			if(str.substring(0,m).length()!=0){
				arr[count] = str.substring(0,m);
				count++;
			}
			sb1.append(str.substring(m+deli.length(),str.length()));
			return mySplit(sb1.toString(),deli);
		}
		else{
			for(int i=0;i<str.length();i++){
				sb1.append(str.charAt(i));
			}
			if(sb1.length()!=0){
				arr[count] = sb1.toString();
				count++;
			}
			return arr;
		}
	}

	public static int index(String str,String deli){
		int n = str.indexOf(deli);
		return n;
	}

	public static String[] arr = new String[100];
	public static int count = 0;



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String deli = sc.nextLine();
		String arr[] = mySplit(str,deli);
		for(int i=0;i<arr.length;i++){
			if(arr[i]==null){
				break;
			}
			System.out.println(arr[i]);
		}
	}


	





	

}