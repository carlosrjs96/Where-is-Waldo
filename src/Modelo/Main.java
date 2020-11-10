/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.*;
import Modelo.*;
import Controlador.*;
import Vista.Escenario;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author Carlos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DataAccess data = DataAccess.getInstance();
        Escenario escenario = new Escenario();
        FondoPanel panel = new FondoPanel("Menu.png","Menu");
        //EscenarioController escenarioControlador = new EscenarioController(escenario,panel);
        MenuController escenarioControlador = new MenuController(escenario,panel,data);
        escenario.setVisible(true);
    }

}
