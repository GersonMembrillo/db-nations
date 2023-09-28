package org.lessons.java;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.Statement;

public class Milestone2 {
	
public static void main(String[] args) {
		

	final String url = "jdbc:mysql://localhost:3306/db_nations";
	final String user = "root";
	final String password = "root";
	
	try (Connection conn = DriverManager.getConnection(url, user, password)) {
		
		System.out.println("Connessione stabilita correttamente");
		
		// Creazione dello statement
        Statement stmt = conn.createStatement();

        // Esecuzione della query SQL
        String query = "SELECT cy.country_id, cy.name, r.name, c.name FROM countries cy INNER JOIN regions r ON cy.region_id = r.region_id INNER JOIN continents c ON r.continent_id = c.continent_id ORDER BY cy.name";

        ResultSet rs = stmt.executeQuery(query);

        // Stampa dei risultati
        while (rs.next()) {
            int countryId = rs.getInt("country_id");
            String countryName = rs.getString("name");
            String regionName = rs.getString("r.name");
            String continentName = rs.getString("c.name");

            System.out.println("Country ID: " + countryId);
            System.out.println("Country name: " + countryName);
            System.out.println("Region name: " + regionName);
            System.out.println("Continent name: " + continentName);
            System.out.println();
        }

        // Chiusura dello statement
        stmt.close();
		
	} catch (Exception e) {
		
		System.out.println("Errore di connessione: " + e.getMessage());
	}
	
	System.out.println("\n----------------------------------\n");
	System.out.println("The end");
		
	}
	
}


