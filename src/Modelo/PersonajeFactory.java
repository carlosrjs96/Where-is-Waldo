/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import personajeswaldo.FabricaAbstracta;
import personajeswaldo.Personaje;
import personajeswaldo.PersonajesEnum;
/**
 *
 * @author Carlos
 */
public class PersonajeFactory implements FabricaAbstracta{
   PersonajesEnum tipoPersonaje;
    @Override
    public Personaje getInstance(PersonajesEnum tipo) {
        if(tipo == tipoPersonaje.DUMMY){
           return new Dummy();
       }
       if(tipo == tipoPersonaje.PRINCIPAL){
           return new Principales();
       }
       System.out.println("FABRICA NO PERSONAJE");
       return null; //To change body of generated methods, choose Tools | Templates.
    }
}
