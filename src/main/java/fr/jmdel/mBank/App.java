package fr.jmdel.mBank;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.print("No de compte :");
		Scanner keyinput = new Scanner(System.in);
		String compte = keyinput.nextLine();
		
		int nocompte = -1;
		try {
			nocompte = Integer.valueOf(compte);
		} catch (Exception e) {
			System.out.println("Le compte saisi invalide");
		}

		if (nocompte >= 0) {
			Compte compte1 = new Compte(nocompte);
			Integer solde = compte1.consultSolde();
			if (solde != null) {
				System.out
						.println("Votre solde (" + String.valueOf(compte1.getId()) + ") : " + Integer.toString(solde));
			} else {
				System.out.println("Le compte saisi est inexistant");
			}
		}

	}

}
