package fr.jmdel.mBank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Compte {
	private int id;
	private int numero;
	private int solde;

	public Compte(int numero) {
		this.numero = numero;

	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}

	public boolean exist(){
		boolean exist = false;
		try {
			Connection myConnection = this.dbConnectBank();
			String request = "SELECT * FROM compte WHERE numero = " + this.numero;
			Statement stmt = myConnection.createStatement();
			ResultSet resultSet = stmt.executeQuery(request);
			exist = resultSet.next();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return exist;
	}
	
	public Integer consultSolde() {
		try {
			Connection myConnection = this.dbConnectBank();
			String request = "SELECT * FROM compte WHERE numero = " + this.numero;
			Statement stmt = myConnection.createStatement();
			ResultSet resultSet = stmt.executeQuery(request);
			if (resultSet.next()) {
				this.setId(resultSet.getInt("id"));
				this.numero = resultSet.getInt("numero");
				this.solde = resultSet.getInt("solde");
			} else {
				return null;
			}

		} catch (Exception e) {
			//System.out.println(e);
			e.printStackTrace();
		}
		return solde;
	}

	private Connection dbConnectBank() throws Exception {
		String url = "jdbc:postgresql://localhost:5432/BankSys";
		String user = "jmdev";
		String passwd = "jmdev";
		try {
			Connection connection = DriverManager.getConnection(url, user, passwd);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
			e.printStackTrace();
			return null;
		}

	}
}
