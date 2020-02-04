import java.util.*;

abstract class Item{
	private int id;
	private String title;
	private int noc;

	Item(){
		this.id=0;
		this.title="";
		this.noc=0;
	}
	Item(int id,String s,int n){
		this.id = id;
		this.title = s;
		this.noc = n;
	}
	public void setId(int id){
		this.id = id; 
	}
	public int getId(){
		return this.id;
	}
	public void setTitle(String t){
		this.title = t; 
	}
	public String getTitle(){
		return this.title;
	}
	public void setNoc(int n){
		this.noc = n; 
	}
	public int getNoc(){
		return this.noc;
	}
	public void chechIn(){
		this.noc++;
	}
	public void checkOut(){
		this.noc--;
	}

	abstract int getCost();
	abstract void display();
}
abstract class WrittenItem extends Item{
	private String author;
	WrittenItem(){
		super();
		this.author="";
	}
	WrittenItem(int id,String s,int n,String a){
		super(id,s,n);
		this.author = a;
	}
	public void setAuthor(String a){
		this.author = a;
	}
	public String getAuthor(){
		return this.author;
	}
}
class Book extends WrittenItem{

	private int cost;

	Book(){
		super();
		this.cost=0;
	}

	Book(int id,String s,int n,String a,int cost){
		super(id,s,n,a);
		this.cost = cost;
	}
	@Override
	public void display(){
		System.out.println(this.getId()+" "+this.getTitle()+" "+this.getNoc()+" "+this.getAuthor());
	}
	@Override
	public int getCost(){
		return this.cost;
	}

}
class JournalPaper extends WrittenItem{
	private int year;
	private int cost;

	JournalPaper(){
		super();
		this.year=0;
		this.cost=0;
	}
	
	JournalPaper(int id,String s,int n,String a,int year,int cost){
		super(id,s,n,a);
		this.year = year;
		this.cost=cost;
	}
	public void setYear(int y){
		this.year = y;
	}
	public int getYear(){
		return this.year;
	}
	@Override
	public void display(){
		System.out.println(this.getId()+" "+this.getTitle()+" "+this.getNoc()+" "+this.getAuthor()+" "+this.getYear());
	}
	@Override
	public int getCost(){
		return this.cost;
	}

}
abstract class MediaItem extends Item{

	private int r;
	MediaItem(){
		super();
		this.r=0;
	}
	MediaItem(int id,String s,int n,int r){
		super(id,s,n);
		this.r = r;
	}
	public void setR(int a){
		this.r = a;
	}
	public int getR(){
		return this.r;
	}
	@Override
	public void display(){
		System.out.println(this.getId()+" "+this.getTitle()+" "+this.getNoc()+" "+this.getR());
	}
}
class Video extends MediaItem{
	private String director;
	private String genre;
	private int year;
	private int cost;

	Video(){
		super();
		this.director="";
		this.genre="";
		this.year=0;
	}
	Video(int id,String s,int n,int r,String director,String genre,int year){
		super(id,s,n,r);
		this.director=director;
		this.genre=genre;
		this.year=year;
	}
	public void setDirector(String d){
		this.director = d;
	}
	public String getDirector(){
		return this.director;
	}
	public void setGenre(String g){
		this.genre = g;
	}
	public String getGenre(){
		return this.genre;
	}
	public void setyear(int y){
		this.year = y;
	}
	@Override
	public void display(){
		System.out.println(this.getId()+" "+this.getTitle()+" "+this.getNoc()+" "+this.getR());
	}
	@Override
	public int getCost(){
		return this.cost;
	}

}
class Cd extends MediaItem{

	private String artist;
	private String genre;
	private int cost;

	Cd(){
		super();
		this.artist="";
		this.genre="";
	}
	Cd(int id,String s,int n,int r,String artist,String genre){
		super(id,s,n,r);
		this.artist=artist;
		this.genre=genre;
	}
	public void setArtist(String a){
		this.artist = a;
	}
	public String getArtist(){
		return this.artist;
	}
	public void setGenre(String g){
		this.genre = g;
	}
	public String getGenre(){
		return this.genre;
	}
	@Override
	public void display(){
		System.out.println(this.getId()+" "+this.getTitle()+" "+this.getNoc()+" "+this.getArtist()+" "+this.getGenre());
	}
	@Override
	public int getCost(){
		return this.cost;
	}

}
class Library{
	public static void main(String[] args) {
		
		Book b1 = new Book(1001,"Panchtantra",10,"Kabir",100);
		b1.display();
		System.out.println(b1.getCost());
		JournalPaper j = new JournalPaper(2001,"E-commerce and its benefits",1,"Ginni J Jesus",2019,2500);
		j.display();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of R in MediaItem");
		int r = sc.nextInt();
		Cd c = new Cd(3001,"I Want To Break Free",15,r,"Queen","Rock");
		c.display();
		c.getCost();
	}
}