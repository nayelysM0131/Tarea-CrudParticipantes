/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.participantes;

import java.io.Serializable;

/**
 *
 * @author nayel
 */
public class Participantes implements Serializable{
    protected String nombre;
    protected String apellido;
    protected String CI;
    protected int edad;
    
    
    public Participantes(){
        nombre="";
        apellido="";
        CI="";
        edad=0;
    }
    public Participantes(String nombre,String apellido,String CI,int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.CI = CI;
        this.edad = edad;
    }
    @Override
    public String toString() {
        return "{" + "nombre: " + nombre + " }";
    }
}