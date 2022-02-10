package com.mitocode.springXMLAnotaciones;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mitocode.beans.Barcelona;
import com.mitocode.beans.Jugador;
import com.mitocode.beans.Juventus;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Elija un equipo: 1- Barcelona 2-Juventus");
    	int respuesta = sc.nextInt();
    	
        ApplicationContext appContext = new ClassPathXmlApplicationContext("com/mitocode/xml/beans.xml");
        
        Jugador jug = (Jugador) appContext.getBean("jugador1");
        
        switch (respuesta) {
    	case 1:
    		jug.setEquipo(new Barcelona());
    		break;
    	case 2:
    		jug.setEquipo(new Juventus());
    		break;
    	default:
    		break;
    	}
        
        System.out.println(jug.getNombre() + " - " + jug.getEquipo().mostrar() + " - " + jug.getCamiseta().getNumero() + " - " + jug.getCamiseta().getMarca().getNombre());
        
        ((ConfigurableApplicationContext) appContext).close();
    }
}
