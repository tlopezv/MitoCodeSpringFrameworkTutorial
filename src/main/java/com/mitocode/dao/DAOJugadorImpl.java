package com.mitocode.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mitocode.beans.Jugador;

@Repository
public class DAOJugadorImpl implements DAOJugador {

	@Autowired
	private DataSource dataSource;
	
	public void registrar(Jugador jugador) throws Exception {
		String sql = "INSERT INTO jugador(nombre, equipo, camiseta) values (?,?,?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, jugador.getNombre());
			ps.setInt(2, jugador.getEquipo().getId());
			ps.setInt(3, jugador.getCamiseta().getId());
			ps.executeUpdate();
			ps.close();
			System.out.println("INSERTADO >> "+ jugador.getNombre());
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

}
