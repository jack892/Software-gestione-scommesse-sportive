/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

/**
 *
 * @author Michelino
 */
import java.sql.*;
import javax.swing.JOptionPane;


public class FunzioniDB {

    private static Connection dbConnection = null;

    public static Connection getConnection() {
		if (dbConnection == null) {
			try {
				// carica il driver per la connessione al DB
				Class.forName("com.mysql.jdbc.Driver");
				// crea un riferimento al DB gestionecallcenter
				dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/sas", "root", "root");
			} catch (Exception e) {
				System.out.println("Connessione al database fallita!\n");
			}
		}
		return dbConnection;
	}

    public static boolean existField(String tabella, String campo, String valore) {
        boolean returnValue = false;
	dbConnection = getConnection();
	try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT " + campo + " FROM " + tabella + " WHERE UCASE(" + campo + ")='" + valore.toUpperCase() + "'");
            if (rs.next()) {
                returnValue = true;
            }
	} catch (Exception e) { e.printStackTrace();  }
            return returnValue;
    }

     public static Boolean loginUtenti(String cod,String pass) {
		try {
			dbConnection = getConnection();
			Statement stmt = dbConnection.createStatement();
                        boolean flag=false;
			// interroga il DB per visualizzare i dati di tutti gli utenti
			ResultSet rs = stmt.executeQuery("SELECT * FROM giocatore");
			while (rs.next()) {
				String codice=rs.getString(1);
				String password=rs.getString(5);
				if ( (codice.equals(cod)) && (password.equals(pass)) ){
                                        flag=true;
                             	}
			}
			rs.close();
			stmt.close();
                        return flag;
		} catch (Exception e) {
                        return false;
		}//fine visualizza tutti gli utenti
	}
public static Boolean loginCassiere(String cod,String pass) {
		try {
			dbConnection = getConnection();
			Statement stmt = dbConnection.createStatement();
                        boolean flag=false;
			// interroga il DB per visualizzare i dati di tutti gli utenti
			ResultSet rs = stmt.executeQuery("SELECT * FROM cassiere");
			while (rs.next()) {
				String codice=rs.getString(1);
				String password=rs.getString(2);
				if ( (codice.equals(cod)) && (password.equals(pass)) ){
                                        flag=true;
                             	}
			}
			rs.close();
			stmt.close();
                        return flag;
		} catch (Exception e) {
                        return false;
		}//fine visualizza tutti gli utenti
	}
public static Boolean loginGestore(String cod,String pass) {
		try {
			dbConnection = getConnection();
			Statement stmt = dbConnection.createStatement();
                        boolean flag=false;
			// interroga il DB per visualizzare i dati di tutti gli utenti
			ResultSet rs = stmt.executeQuery("SELECT * FROM gestore");
			while (rs.next()) {
				String codice=rs.getString(1);
				String password=rs.getString(2);
				if ( (codice.equals(cod)) && (password.equals(pass)) ){
                                        flag=true;
                             	}
			}
			rs.close();
			stmt.close();
                        return flag;
		} catch (Exception e) {
                        return false;
		}//fine visualizza tutti gli utenti
	}
public static Boolean loginAnonimo(String cod,String pass) {
		return null;
	}
}

