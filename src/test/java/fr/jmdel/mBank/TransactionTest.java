package fr.jmdel.mBank;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransactionTest {

	@Test
	public void TranfertNotEnouthMoneyTest() {
		//Given
		Compte compte1 = new Compte(00001);
		compte1.setSolde(500);
		Compte compte2 = new Compte(00002);
		
		Transaction transaction = new Transaction();
		
		//When
		boolean valid=transaction.transfert(compte1, compte2, 700);
		//Then
		assertEquals(valid,false);
		
	}
	
	@Test
	public void TranfertOneNullAcountTest() {
		//Given
		Compte compte1 = new Compte(00001);
		
		Compte compte2 = null;
		
		Transaction transaction = new Transaction();
		
		//When
		boolean valid=transaction.transfert(compte1, compte2, 0);
		//Then
		assertEquals(valid,false);
		
	}
	
	@Test
	public void depotNullAcountTest() {
		//Given
		
		Compte acount = null;
		
		Transaction transaction = new Transaction();
		
		//When
		boolean valid=transaction.depot(acount,100);
		//Then
		assertEquals(valid,false);
		
	}
	
	@Test
	public void retraitNullAcountTest() {
		//Given
		
		Compte acount = null;
		
		Transaction transaction = new Transaction();
		
		//When
		boolean valid=transaction.retrait(acount,100);
		//Then
		assertEquals(valid,false);
		
	}
	
	@Test
	public void retraitNotEnouthMoneyTest() {
		//Given
		
		Compte acount = new Compte(00001);
		acount.setSolde(50);
		
		Transaction transaction = new Transaction();
		
		//When
		boolean valid=transaction.retrait(acount,100);
		//Then
		assertEquals(valid,false);
		
	}
	
	@Test
	public void retraitEnouthMoneyTest() {
		//Given
		
		Compte acount = new Compte(00001);
		acount.setSolde(50);
		
		Transaction transaction = new Transaction();
		
		//When
		boolean valid=transaction.retrait(acount,100);
		//Then
		assertEquals(acount.getSolde(),50);
		
	}
}
