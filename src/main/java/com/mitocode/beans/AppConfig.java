package com.mitocode.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	/**
	 * Vendría a sustituir a la etiqueta <bean> del fichero de configuración "com/mitocode/xml/beans.xml"
	 * @return
	 */
	@Bean
	public Mundo mundo() {
		return new Mundo();
	}
}
