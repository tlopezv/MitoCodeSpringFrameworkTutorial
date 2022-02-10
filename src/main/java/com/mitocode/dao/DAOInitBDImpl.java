package com.mitocode.dao;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAOInitBDImpl implements DAOInitBD {

	@Autowired
	private DataSource dataSource;
	
	public void initBD() throws Exception {
		poblarBD();
	}

	private void createNewTable(String createSQL) throws Exception{
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			stmt.execute(createSQL);
			System.out.println("DONE: "+ createSQL);
			stmt.close();
		} catch(Exception e) {
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	private void poblarBD() throws Exception {
		createNewTable(DAOInitBD.EquipoDBTable);
		createNewTable(DAOInitBD.MarcaDBTable);
		createNewTable(DAOInitBD.CamisetaDBTable);
		createNewTable(DAOInitBD.JugadorDBTable);
	}
}
