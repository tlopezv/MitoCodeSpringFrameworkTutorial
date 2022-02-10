package com.mitocode.dao;

public interface DAOInitBD {
	
	public static final String EquipoDBTable = "CREATE TABLE IF NOT EXISTS equipo ( "
			+ "id integer PRIMARY KEY AutoIncrement, "
			+ "nombre text NOT NULL);";
	public static final String MarcaDBTable = "CREATE TABLE IF NOT EXISTS marca ( "
			+ "id integer PRIMARY KEY AutoIncrement, "
			+ "nombre text NOT NULL);";
	public static final String CamisetaDBTable = "CREATE TABLE IF NOT EXISTS camiseta ( "
			+ "id integer PRIMARY KEY AutoIncrement, "
			+ "numero integer NOT NULL, "
			+ "marca integer, "
			+ "FOREIGN KEY(marca) REFERENCES marca(id));";
	public static final String JugadorDBTable = "CREATE TABLE IF NOT EXISTS jugador ( "
			+ "id integer PRIMARY KEY AutoIncrement, "
			+ "nombre text NOT NULL, "
			+ "equipo integer, "
			+ "camiseta integer, "
			+ "FOREIGN KEY(equipo) REFERENCES equipo(id), "
			+ "FOREIGN KEY(camiseta) REFERENCES camiseta(id));";

	public void initBD() throws Exception;
}
