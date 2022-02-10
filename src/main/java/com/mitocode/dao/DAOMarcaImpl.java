package com.mitocode.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mitocode.beans.Marca;

@Repository
public class DAOMarcaImpl implements DAOMarca {

	@Autowired
	private DataSource dataSource;
	
	public void registrar(Marca marca) throws Exception {
		String sql = "INSERT INTO marca(nombre) values(?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,marca.getNombre());
			ps.executeUpdate();
			ps.close();
			System.out.println("INSERTADO >> "+ marca.getNombre());
		} catch(Exception e) {
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

}
