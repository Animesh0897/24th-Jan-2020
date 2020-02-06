import java.util.*;

class ComputerShop{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Computer> list = new ArrayList<Computer>();
		int button = 1;
	
		while(button!=0){
			System.out.println("Please select an option : \n1. Add new computer\n2. Display all the computers\n3. Search the computers\n4. Delete a computer\n5. Update computer details\n6. Exit");
			int n1 = sc.nextInt();
			switch(n1)
			{

			
				case 1:
				
					System.out.print("Enter the ID : ");
					int id = sc.nextInt();
					int flag = 0;
					for(int i=0;i<list.size();i++){
						if(list.get(i).getID()==id){
							System.out.print("Sorry the IDs cannot be same!!");
							flag = 1;
							break;
						}
					}


					if(flag==0){
						System.out.print("Enter the brand name : ");
						String brand = sc.next();
						sc.nextLine();
						System.out.print("Enter the color : ");
						String color = sc.next();
						System.out.print("Enter the HDD size : ");
						int hdd = sc.nextInt();
						System.out.print("Enter the RAM size : ");
						int ram = sc.nextInt();
						list.add(new Computer(id,brand,color,hdd,ram));
					}
					break;
				
				case 2:
					System.out.println("All the computers in Shop: ");
					System.out.print(list);
				
					break;

				case 3:
					System.out.println("A. brand\nB. color\nC. HDD size\nD. RAM size");
					
					String sea = sc.next();
					sc.nextLine();
					char search = sea.charAt(0);

					if(search=='A'){
						System.out.print("Enter the brand name: ");
						String searching = sc.nextLine();
						flag = 0;
						for(int i=0;i<list.size();i++){
							if(list.get(i).getBrand().contains(searching)){
								System.out.println(list.get(i));
								flag = 1;
							}
						}
						if(flag==0){
							System.out.println("Sorry no such brand Computer exists in our database");
						}
					}
					else if(search=='B'){
						System.out.print("Enter the color: ");
						String searching = sc.next();
						sc.nextLine();
						flag = 0;
						for(int i=0;i<list.size();i++){
							if(list.get(i).getColor().contains(searching)){
								System.out.println(list.get(i));
								flag = 1;
							}
						}
						if(flag==0){
							System.out.println("Sorry no such color Computer exists in our database ");
						}
					}
					else if(search=='C'){
						System.out.print("Enter the HDD size: ");
						int searching = sc.nextInt();
						flag = 0;
						for(int i=0;i<list.size();i++){
							if(list.get(i).getHDDSize()==searching){
								System.out.println(list.get(i));
								flag = 1;
							}
						}
						if(flag==0){
							System.out.println("Sorry no such HDD size Computer exists in our database");
						}
					}
					else{
						System.out.print("Enter the RAM size: ");
						int searching = sc.nextInt();
						flag = 0;
						for(int i=0;i<list.size();i++){
							if(list.get(i).getRam()==searching){
								System.out.println(list.get(i));
								flag = 1;
							}
						}
						if(flag==0){
							System.out.print("Sorry no such RAM size Computer exists in our database");
						}
					}
					break;


				case 4:

					System.out.print("Please enter the computer ID which you want to delete : ");
					id = sc.nextInt();
					flag = 0;
					for(int i=0;i<list.size();i++){
						if(list.get(i).getID()==id){
							list.remove(i);
							System.out.println("Successfully removed!!");
							flag = 1;
							break;
						}
					}
					if(flag==0){
							System.out.println("No such Computer ID is there in the database");
					}
					break;



				case 5:
						System.out.print("Please enter the computer ID which you want to update : ");
						id = sc.nextInt();
						flag = 0;
						int index = 0;
						for(int i=0;i<list.size();i++){
							if(list.get(i).getID()==id){
								flag = 1;
								index = i;
								break;
							}
						}
						if(flag==1){
							System.out.println("What do you want to update : ");
							System.out.println("a. By brand\nb. By color\nc. By HDD size\nd. By RAM size");
							
							sea = sc.next();
							sc.nextLine();
							
							search = sea.charAt(0);
							if(search=='a'){
								System.out.print("Enter the new brand : ");
								String newBrand = sc.next();
								sc.nextLine();
								list.set(index,new Computer(list.get(index).getID(),newBrand,list.get(index).getColor(),list.get(index).getHDDSize(),list.get(index).getRam()));
							}
							else if(search=='b'){
								System.out.print("Enter the new color : ");
								String newColor = sc.next();
								sc.nextLine();
								list.set(index,new Computer(list.get(index).getID(),list.get(index).getBrand(),newColor,list.get(index).getHDDSize(),list.get(index).getRam()));
							}
							else if(search=='c'){
								System.out.print("Enter the new HDD size : ");
								int newHdd = sc.nextInt();
								list.set(index,new Computer(list.get(index).getID(),list.get(index).getBrand(),list.get(index).getColor(),newHdd,list.get(index).getRam()));
							}
							else if(search=='d'){
								System.out.print("Enter the new RAM : ");
								int newRam = sc.nextInt();
								list.set(index,new Computer(list.get(index).getID(),list.get(index).getBrand(),list.get(index).getColor(),list.get(index).getHDDSize(),newRam));
							}
						}
						else{
								System.out.println("No such Computer ID is there in the database");
						}
						break;


				case 6:
					System.out.println("Thank you for using the Computer Shop");
					button = 0 ;

			}
		}
	}
}
class Computer{
	int id,hddSize,ram;
	String brand,color;
	Computer(int id,String brand,String color,int hddSize,int ram){
		this.id = id;
		this.brand = brand;
		this.color = color;
		this.hddSize = hddSize;
		this.ram = ram;
	}
	public int getID(){
		return this.id;
	}
	public String getBrand(){
		return this.brand;
	}
	public String getColor(){
		return this.color;
	}
	public int getHDDSize(){
		return this.hddSize;
	}
	public int getRam(){
		return this.ram;
	}
	public String toString(){
		return this.getID() +  " " + this.getBrand() + " " + this.getColor() + " " + this.getHDDSize() + " " + this.getRam();
	}
}