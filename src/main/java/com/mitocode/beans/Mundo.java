package com.mitocode.beans;

import org.springframework.beans.factory.annotation.Value;

public class Mundo {

	// Para las configuraciones por defecto, equivalente a la etiqueta <property> del fichero "com/mitocode/xml/beans.xml"
	// usamos la etiqueta @Value
	@Value("Hola Mundo!")
	private String saludo;

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}
	
}
