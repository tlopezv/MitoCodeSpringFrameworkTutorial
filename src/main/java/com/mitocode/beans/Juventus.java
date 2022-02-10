package com.mitocode.beans;

import org.springframework.stereotype.Component;

import com.mitocode.interfaces.IEquipo;

@Component("juventus")
public class Juventus implements IEquipo {

	public String mostrar() {
		return "Juventus";
	}

}
