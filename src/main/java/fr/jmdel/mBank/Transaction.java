package fr.jmdel.mBank;

public class Transaction {

	public boolean transfert(Compte compte1, Compte compte2, int amount) {
		boolean transactionOK = false;
		if ((compte1 != null) && (compte1 != null)) {
			int initialSold1 = compte1.getSolde();
			if (amount <= initialSold1) {
				try{
				compte1.setSolde(initialSold1 - amount);

				int initialSold2 = compte2.getSolde();
				compte2.setSolde(initialSold2 + amount);

				transactionOK = true;
				}
				catch(Exception e){
					
				}
			}
		}

		return transactionOK;
	}

}
