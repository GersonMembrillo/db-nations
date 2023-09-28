package org.lessons.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Milestone3 {

    public static void main(String[] args) throws SQLException {

        final String url = "jdbc:mysql://localhost:3306/db_nations";
        final String user = "root";
        final String password = "root";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            System.out.println("Connessione stabilita correttamente");

            // Chiedere all'utente di inserire una stringa di ricerca
            Scanner scanner = new Scanner(System.in);
            System.out.println("Inserisci una stringa di ricerca: ");
            String searchString = scanner.nextLine();

            // Creazione dello statement preparato
            String query = "SELECT cy.country_id, cy.name, r.name, c.name FROM countries cy INNER JOIN regions r ON cy.region_id = r.region_id INNER JOIN continents c ON r.continent_id = c.continent_id WHERE cy.name LIKE ? ORDER BY cy.name";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + searchString + "%");

            ResultSet rs = stmt.executeQuery();

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

            stmt.close();

        } catch (Exception e) {

            System.out.println("Errore di connessione: " + e.getMessage());

        }

        System.out.println("\n----------------------------------\n");
        System.out.println("The end");

    }

}

