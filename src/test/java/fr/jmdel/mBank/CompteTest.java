package fr.jmdel.mBank;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.framework.TestCase;

public class CompteTest {
	private final int ACOUNT_NR=12345;
	
	@Test
	public void consultSoldeTest(){
		//Given
		Compte acount=new Compte(ACOUNT_NR);
		//When
		Integer solde = acount.consultSolde();
		//Then
		assertEquals(20500,(int)solde);
	}
	
	@Test
	public void existTest(){
		//Given
		Compte acount=new Compte(ACOUNT_NR);
		//When
		boolean exist = acount.exist();
		//Then
		assertEquals(exist,true);
	}
	
}
