package puissance4;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class projet {
	
	public static int grille[][];
	
	public static int entierAleatoire(int a, int b){
		//Retourne un entier alÃ©atoire entre a (inclus) et b (inclus)
		return ThreadLocalRandom.current().nextInt(a, b + 1);	
	}
	
	public static void initialiseGrille() {
		grille = new int[6][7];
	}
	
	public static void jouer(int j,int c) {
		int l=0;
		while(grille[l][c]!=0) {
			l++;
		}
		grille[l][c]=j;
	}
	
	public static void afficheGrille() {
		for(int i=grille.length-1; i>=0;i--) {
			for(int j=0; j<grille[i].length;j++) {
				System.out.print("|");
				if(grille[i][j]==0) System.out.print(" ");
				if(grille[i][j]==1) System.out.print("X");
				if(grille[i][j]==2) System.out.print("O");
			}
			System.out.print("|");
			System.out.println();
		}
		for(int l=0;l<=grille.length;l++) {
			System.out.print(" "+l);
		}
	}

	public static void main(String[] args) {
		initialiseGrille();
		jouer(1,3);
		jouer(2,4);
		afficheGrille();
	}
}
