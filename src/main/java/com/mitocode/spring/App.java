package com.mitocode.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mitocode.beans.AppConfig;
import com.mitocode.beans.AppConfig2;
import com.mitocode.beans.Barcelona;
import com.mitocode.beans.Ciudad;
import com.mitocode.beans.Jugador;
import com.mitocode.beans.Mundo;
import com.mitocode.beans.Persona;
import com.mitocode.interfaces.IEquipo;

public class App {

	public static void main(String[] args) {
		/** Para configuración con el beans.xml de Spring **/
		// Cargamos el archivo de configuración dónde están los Beans que queremos que inyecte Spring
		//ApplicationContext appContext = new ClassPathXmlApplicationContext("com/mitocode/xml/beans.xml");
		
		/** Para configuración con anotaciones de Spring **/
		// Le pasamos la clase dónde está la configuración de los Beans a inyectar por Spring
		// NOTA: Podemos pasarle diferentes clases con Beans configurados
		//ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class, AppConfig2.class);
		
		/* Otra manera de registrar diferentes clases de Configuración sería así */
		//AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		//appContext.register(AppConfig.class);
		//appContext.register(AppConfig2.class);
		//appContext.refresh(); // Y con este método estamos reconstruyendo el archivo de configuración con todos los archivos .java que tienen las definiciones de los Beans
		
		//Mundo m = (Mundo) appContext.getBean("mundo");
		// Otra manera de hacerlo
		//Mundo m = (Mundo) appContext.getBean(Mundo.class);
		
		//System.out.println(m.getSaludo());
		
		//m = (Mundo) appContext.getBean("marte");
		
		//System.out.println(m.getSaludo());
		
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/mitocode/xml/beans.xml");
		Persona per = (Persona) appContext.getBean("persona");/*("personaBean2");*/
		Persona per2 = (Persona) appContext.getBean("persona");
		
		Ciudad ciu = (Ciudad) appContext.getBean("ciudad");
		
		System.out.println(ciu.getNombre());
		/*
		 * String nombresCiudades = "";
		 * 
		 * for(Ciudad ciu: per.getPais().getCiudades()) { nombresCiudades +=
		 * ciu.getNombre() + "-"; }
		 */
		
		System.out.println(per + " " +per.getId() + " " + per.getNombre() + " " + per.getApodo() + " " + per.getPais().getNombre() + " " + /*nombresCiudades*/ per.getCiudad().getNombre());
		System.out.println(per2 + " " +per2.getId() + " " + per2.getNombre() + " " + per2.getApodo() + " " + per2.getPais().getNombre() + " " + /*nombresCiudades*/ per2.getCiudad().getNombre());
		
		Jugador jug = (Jugador) appContext.getBean(/*"jugador"*/"messi");
		
		System.out.println(jug.getNombre() + " - " + jug.getEquipo().mostrar());
		
		//Barcelona bar = (Barcelona) appContext.getBean("barcelona");
		
		//System.out.println(bar.mostrar());
		
		IEquipo equipo = (IEquipo) appContext.getBean("juventus");
		
		System.out.println(equipo.mostrar());
		
		((ConfigurableApplicationContext)appContext).close();
	}

}
