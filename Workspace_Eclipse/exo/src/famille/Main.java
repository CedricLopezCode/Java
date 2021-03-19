package famille;

public class Main {

	public static void main(String[] args) {
		
		Enfant moi = new Enfant();
		System.out.println(moi.fils());
		System.out.print(" mon pere est ");
		System.out.println(moi.pere());
		System.out.print(" ma mere est ");
		System.out.println(moi.mere());
		System.out.print(" mon grand-pere est ");
		System.out.println(moi.grand_pere());
		System.out.print(" ma grand-mere est ");
		System.out.println(moi.grand_mere());
		}

}
