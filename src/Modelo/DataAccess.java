/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import personajeswaldo.Personaje;
import personajeswaldo.PersonajesEnum;
/**
 *
 * @author Carlos
 */
public class DataAccess{
    private static DataAccess dataAccess;
    private ArrayList<FondoPanel> listaEscenarios;
    private ArrayList<Personaje> listaPrincipales;
    private ArrayList<Personaje> listaDummy;
    private PersonajeFactory fabrica;
    private PersonajesEnum tipoPersonaje;
    
    private DataAccess(){
        listaEscenarios = new ArrayList<FondoPanel>();
        listaPrincipales = new ArrayList<Personaje>();
        listaDummy  = new ArrayList<Personaje>();
        fabrica = new PersonajeFactory();
        getArrayFondos();
        getArrayPrincipales();
        getArrayDummy();    
    }

    public static DataAccess getInstance(){
        if (dataAccess == null){
            dataAccess = new DataAccess();
        }
        return dataAccess;
    }
    
    public void getArrayFondos(){
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("escenarios.json"));
            JSONObject jsonObject = (JSONObject)obj;
            System.out.println("JSON LEIDO: "+jsonObject);
            JSONArray array = (JSONArray)jsonObject.get("Escenarios");
            System.out.println("");
            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject1 = (JSONObject)array.get(i);
                System.out.println("DATOS DEL ESCENARIO: "+i);
                System.out.println("Nombre Imagen: "+jsonObject1.get("imgName"));
                System.out.println("name: "+jsonObject1.get("name"));
                System.out.println("minX: "+jsonObject1.get("minX"));
                System.out.println("maxX: "+jsonObject1.get("maxX"));
                System.out.println("minY: "+jsonObject1.get("minY"));
                System.out.println("maxY: "+jsonObject1.get("maxY"));
                listaEscenarios.add(new FondoPanel(
                        Integer.parseInt(jsonObject1.get("minX").toString()),
                        Integer.parseInt(jsonObject1.get("maxX").toString()),
                        Integer.parseInt(jsonObject1.get("minY").toString()), 
                        Integer.parseInt(jsonObject1.get("maxY").toString()), 
                        jsonObject1.get("imgName").toString(),
                        jsonObject1.get("name").toString()));
                System.out.println("");
            }
            
        } 
        catch (FileNotFoundException ex) {}
        catch (IOException ex) {}
        catch (ParseException ex) {}
        System.out.println(">>>> "+listaEscenarios.size());
       // return listaEscenarios;
    }
    
    //public ArrayList<Personaje> getArrayPrincipales(){
    public void getArrayPrincipales(){
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("principales.json"));
            JSONObject jsonObject = (JSONObject)obj;
            System.out.println("JSON LEIDO: "+jsonObject);
            JSONArray array = (JSONArray)jsonObject.get("Principales");
            System.out.println("");
            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject1 = (JSONObject)array.get(i);
                System.out.println("DATOS DEL PRINCIPAL: "+i);
                System.out.println("Nombre Imagen: "+jsonObject1.get("img"));
                System.out.println("Nombre Imagen Encontrado: "+jsonObject1.get("imgEncontrado"));
                Personaje personaje = fabrica.getInstance(tipoPersonaje.PRINCIPAL);
                personaje.setImage(jsonObject1.get("img").toString());
                personaje.addEvent(jsonObject1.get("imgEncontrado").toString());
                personaje.setImgNameFounded(jsonObject1.get("imgEncontrado").toString());
                System.out.println("**DATOS DEL OBJETO PRINCIPAL**: "+i);
                System.out.println("Nombre Imagen: "+personaje.getImgName());
                System.out.println("Nombre Imagen Encontrado: "+personaje.getImgNameFounded());
                listaPrincipales.add(personaje);
                System.out.println("");
            }            
        } 
        catch (FileNotFoundException ex) {}
        catch (IOException | ParseException ex) {}
        System.out.println(">>>> "+listaPrincipales.size());
       // return listaPrincipales;
    }
    
    //public ArrayList<Personaje> getArrayDummy(){
    public void getArrayDummy(){
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("dummy.json"));
            JSONObject jsonObject = (JSONObject)obj;
            System.out.println("JSON LEIDO: "+jsonObject);
            JSONArray array = (JSONArray)jsonObject.get("Dummy");
            System.out.println("");
            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject1 = (JSONObject)array.get(i);
                System.out.println("DATOS DEL DUMMY: "+i);
                System.out.println("Nombre Imagen: "+jsonObject1.get("img"));
                Personaje personaje = fabrica.getInstance(tipoPersonaje.DUMMY);
                personaje.setImage(jsonObject1.get("img").toString());
                listaDummy.add(personaje);
                System.out.println("");
            }            
        } 
        catch (FileNotFoundException ex) {}
        catch (IOException | ParseException ex) {}
        System.out.println(">>>> "+listaDummy.size());
       // return listaDummy1;
    }   

    public static DataAccess getDataAccess() {
        return dataAccess;
    }

    public static void setDataAccess(DataAccess dataAccess) {
        DataAccess.dataAccess = dataAccess;
    }

    public ArrayList<FondoPanel> getListaEscenarios() {
        return listaEscenarios;
    }

    public void setListaEscenarios(ArrayList<FondoPanel> listaEscenarios) {
        this.listaEscenarios = listaEscenarios;
    }

    public ArrayList<Personaje> getListaPrincipales() {
        return listaPrincipales;
    }

    public void setListaPrincipales(ArrayList<Personaje> listaPrincipales) {
        this.listaPrincipales = listaPrincipales;
    }

    public ArrayList<Personaje> getListaDummy() {
        return listaDummy;
    }

    public void setListaDummy(ArrayList<Personaje> listaDummy) {
        this.listaDummy = listaDummy;
    }

    public PersonajesEnum getTipoPersonaje() {
        return tipoPersonaje;
    }

    public void setTipoPersonaje(PersonajesEnum tipoPersonaje) {
        this.tipoPersonaje = tipoPersonaje;
    }
    
    
}