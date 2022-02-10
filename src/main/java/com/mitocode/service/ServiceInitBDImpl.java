package com.mitocode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dao.DAOInitBD;

@Service
public class ServiceInitBDImpl implements ServiceInitBD {

	@Autowired
	private DAOInitBD daoInitBD;
	
	public void initBD() throws Exception {
		try {
			daoInitBD.initBD();
		} catch (Exception e) {
			throw e;
		}

	}

}
