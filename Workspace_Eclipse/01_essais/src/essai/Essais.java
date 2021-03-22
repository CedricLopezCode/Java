package essai;

public class Essais {

	public static void main(String[] args) {
		
		
		int[][] complet = {
			{1,2,3,4,5,6,7,8,9},
			{2,3,4,5,6,7,8,9,1},
			{3,4,5,6,7,8,9,1,2},
			{4,5,6,7,8,9,1,2,3},
			{5,6,7,8,9,1,2,3,4},
			{6,7,8,9,1,2,3,4,5},
			{7,8,9,1,2,3,4,5,6},
			{8,9,1,2,3,4,5,6,7},
			{9,1,2,3,4,5,6,7,8}
		};

		int[][] victoire = new int[81][3]; 
		for(int cellul = 0; cellul < 81; cellul++) {
			victoire[cellul][0] = Math.round((cellul)/ 9) + 1; 
			victoire[cellul][1] = (cellul % 9) + 1;
			victoire[cellul][2] = complet [Math.round((cellul)/ 9)][(cellul % 9)];
		}

		//Math.round((en_cours.getCoord_ligne() )/ 3); 
		for(int[] for_each1d:victoire) {
			for(int for_each2d:for_each1d) {
				System.out.print(for_each2d + " ");
			}
			System.out.println("");
		}System.out.println("");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//Fin Main

}//Fin essai
