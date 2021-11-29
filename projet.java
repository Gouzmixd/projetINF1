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
		while(grille[l][c]!=0 || l<=6 || c<=7) {
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
	
	public static boolean aGagneHor(int j, int x,int y) {
		if(y+4>=grille.length) return false;
		for(int i=0;i<4;i++){
			if(grille[x][y+i]!=j) return false;
		}
		return true;
	}	
	
	public static boolean aGagne(int j) {
		for(int x=0; x<grille.length;x++) {
			for(int y=0; y<grille[x].length;y++) {
				if(aGagneHor(j,x,y)==true) return true;
				if(aGagneVer(j,x,y)==true) return true;
				if(aGagneDiagMont(j,x,y)==true) return true;
				if(aGagneDiagDesc(j,x,y)==true) return true;
			}
		}
		return false;
	}

	public static boolean matchNul() {
		if(aGagne(1)==true||aGagne(2)==true) return false;
		for(int x=0; x<grille.length;x++) {
			for(int y=0; y<grille[x].length;y++) {
				if(grille[x][y]==0) return false;
			}
		}
		return true;
	}
	
	public static void jeu() {
		initialiseGrille();
		Scanner sc=new Scanner(System.in);
		int j=1;
		boolean fini=false;
		while(!fini) {
			afficheGrille();
			System.out.println("Quel coup pour le joueur "+j+"?");
			int c = sc.nextInt();
			jouer(j,c);
			
			if(aGagne(j)==true) {
				fini=true;
				System.out.println("Le joueur "+j+" a gagné");
			}
			if(matchNul()==true) {
				fini=true;
				System.out.println("Match nul");
			}

			if(j==1) j=2;
			else j=1;
		}
		sc.close();
	}

	public static void main(String[] args) {
		initialiseGrille();
		jouer(1,3);
		jouer(2,4);
		afficheGrille();
	}
}
