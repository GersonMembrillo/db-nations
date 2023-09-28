package org.lessons.java;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
	
public static void main(String[] args) {
		

	final String url = "jdbc:mysql://   localhost:3306/db_aeroporto";
	final String user = "root";
	final String password = "root";
	
	try (Connection conn = DriverManager.getConnection(url, user, password)) {
		
		System.out.println("Connessione stabilita correttamente");
		
		
	} catch (Exception e) {
		
		System.out.println("Errore di connessione: " + e.getMessage());
	}
	
	System.out.println("\n----------------------------------\n");
	System.out.println("The end");
		
	}
	
}

//   SELECT
//   cy.country_id, cy.name, r.name, c.name
//   FROM countries cy
//   	JOIN regions r 
//   		ON cy.region_id = r.region_id
//   	JOIN continents c 
//   		ON r.continent_id = c.continent_id
//   ORDER BY cy.name;