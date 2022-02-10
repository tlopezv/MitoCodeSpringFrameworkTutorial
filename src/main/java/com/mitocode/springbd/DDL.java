package com.mitocode.springbd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DDL {

	private static String EquipoDBTable = "CREATE TABLE IF NOT EXIST equipo ( "
										+ "id integer PRIMARY KEY AutoIncrement, "
										+ "nombre text NOT NULL);";
	private static String MarcaDBTable = "CREATE TABLE IF NOT EXIST marca ( "
										+ "id integer PRIMARY KEY AutoIncrement, "
										+ "nombre text NOT NULL);";
	private static String CamisetaDBTable = "CREATE TABLE IF NOT EXIST camiseta ( "
										+ "id integer PRIMARY KEY AutoIncrement, "
										+ "numero integer NOT NULL, "
										+ "marca integer, "
										+ "FOREIGN KEY(marca) REFERENCES marca(id));";
	private static String JugadorDBTable = "CREATE TABLE IF NOT EXIST jugador ( "
										+ "id integer PRIMARY KEY AutoIncrement, "
										+ "nombre text NOT NULL, "
										+ "equipo integer, "
										+ "FOREIGN KEY(equipo) REFERENCES equipo(id), "
										+ "camiseta integer, "
										+ "FOREIGN KEY(camiseta) REFERENCES camiseta(id));";
	
	public static void createNewTable(String createSQL) {
		Connection conn = Connect.connect();
		// https://www.youtube.com/watch?v=tjSzhUGB1LE&list=PLvimn1Ins-42o8Ms1G2SuRloD01nnXn31&index=48
		try (Statement stmt = conn.createStatement()){
			stmt.execute(createSQL);
			
			System.out.println("DONE: "+ createSQL);
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} finally {
			Connect.disConnect(conn);
		}
	}
	
	public static void poblarBD() {
		createNewTable(EquipoDBTable);
		createNewTable(MarcaDBTable);
		createNewTable(CamisetaDBTable);
		createNewTable(JugadorDBTable);
	}
}
