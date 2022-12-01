/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.participantes;
import java.io.*;
import java.util.*;
/**
 *
 * @author nayel
 */
public class BaseDeDatos {
    static String direc ="C:\\data.bin";
    //GuardarDatos de CLIENTES
    public static void GuardarDatos(Vector<Participantes> datos) throws FileNotFoundException,IOException{

        File file = new File(direc);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        DataOutputStream outStream = new DataOutputStream(fileOutputStream);
        
        outStream.writeInt(datos.size());
        
        for(int i =0;i<datos.size();i++){
            outStream.writeUTF(datos.get(i).nombre);
            outStream.writeUTF(datos.get(i).apellido);
            outStream.writeUTF(datos.get(i).CI);
            outStream.writeInt(datos.get(i).edad);
        }

        outStream.flush();
        outStream.close();
    }
    //CargarDatos de CLIENTES
    public static Vector<Participantes> CargarDatos() throws FileNotFoundException,IOException{
        File file = new File(direc);
        FileInputStream fileInputStream = new FileInputStream(file);
        DataInputStream InStream = new DataInputStream(fileInputStream);
        
        int capacidad = InStream.readInt();
        
        Vector<Participantes> users = new Vector();
        
        for(int i =0;i<capacidad;i++){
            String nombre =InStream.readUTF();
            String apellido =InStream.readUTF();
            String CI =InStream.readUTF();
            int edad =InStream.readInt();

            Participantes nuevoUser = new Participantes(nombre,apellido,CI,edad);
        	users.add(nuevoUser);
        }
        
        InStream.close();
        return users;
    }
}
