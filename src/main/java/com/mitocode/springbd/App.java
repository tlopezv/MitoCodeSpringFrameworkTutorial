package com.mitocode.springbd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mitocode.beans.Equipo;
import com.mitocode.beans.Jugador;
import com.mitocode.beans.Marca;
import com.mitocode.service.ServiceInitBD;
import com.mitocode.service.ServiceJugador;
import com.mitocode.service.ServiceMarca;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("com/mitocode/xml/beans.xml");
        
        ServiceInitBD sbd = (ServiceInitBD) appContext.getBean("serviceInitBDImpl");
        
        Marca mar = new Marca();
        mar.setNombre("Marca1");
        
        //ServiceMarca sm = (ServiceMarca) appContext.getBean("serviceMarcaImpl");
        
        //Marca mar3 = (Marca) appContext.getBean("marca3");
        //Equipo eq1 = (Equipo) appContext.getBean("equipo1");
        Jugador jugador = (Jugador) appContext.getBean("jugador1");
        
        ServiceJugador sj = (ServiceJugador) appContext.getBean("serviceJugadorImpl");
        
        try {
        	sbd.initBD();
        	//sm.registrar(mar);
        	sj.registrar(jugador);
        } catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        
        ((ConfigurableApplicationContext)appContext).close();
    }
}
