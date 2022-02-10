package com.mitocode.beans;

import org.springframework.stereotype.Component;

import com.mitocode.interfaces.IEquipo;

@Component("equipo")
public class Barcelona implements IEquipo{

	public String mostrar() {
		return "Barcelona FC";
	}

}
