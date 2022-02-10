package com.mitocode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.beans.Jugador;
import com.mitocode.dao.DAOJugador;

@Service
public class ServiceJugadorImpl implements ServiceJugador {

	@Autowired
	private DAOJugador daoJugador;
	
	public void registrar(Jugador jug) throws Exception {
		try {
			daoJugador.registrar(jug);
		} catch (Exception e) {
			throw e;
		}
	}

}
