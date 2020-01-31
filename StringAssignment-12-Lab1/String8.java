import java.util.*;
class String8
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int arr[] = new int[size];
		//int arr[] = {5,2,4,8,2};
		for(int i = 0 ; i < size ; i++)
		{
			arr[i] = sc.nextInt();
		}

		System.out.println(secondLast(arr));
	}

	static int secondLast(int arr[])
	{
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i : arr)
		{
			set.add(i);
		}

		List<Integer> list = new ArrayList<Integer>(set);
		int value = list.get(1);

		return value;

		
	}
}