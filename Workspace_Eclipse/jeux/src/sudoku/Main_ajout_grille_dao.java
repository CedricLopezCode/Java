package sudoku;

public class Main_ajout_grille_dao {

	public static void main(String[] args) {
		Grille_dao ajoutDao = new Grille_dao();
		
		int[][] tab_cell_connues = {
				{1,1,8},
				{1,3,3},
				{1,4,1},
				{1,7,9},
				{1,9,4},
				{2,4,4},
				{2,3,5},
				{2,8,7},
				{2,9,3},
				{3,2,2},
				{3,4,3},
				{3,6,4},
				{3,7,1},
				{3,9,5},
				{4,1,6},
				{4,2,7},
				{4,5,3},
				{4,2,8},
				{4,3,9},
				{5,2,3},
				{5,3,1},
				{5,4,6},
				{5,5,4},
				{5,8,5},
				{6,5,5},
				{6,8,4},
				{7,4,7},
				{7,7,5},
				{7,9,8},
				{8,3,6},
				{8,4,1},
				{8,6,8},
				{8,7,5},
				{9,3,4},
				{9,4,7},
				{9,5,5},
				{9,7,6},
				{9,8,9}
			};
		ajoutDao.ajout_nv_grille_ds_DB(tab_cell_connues);

	}

}