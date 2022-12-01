
package crud.participantes;
import java.io.IOException;
import java.util.*;

public class MAIN {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Vector<Participantes> participantes = new Vector();
        //Cargar base datos
        try {
        	participantes = BaseDeDatos.CargarDatos();
        }
        catch(Exception ex) {
        	System.out.println("No hay encuentran datos");
        }
        //Opciones a tomar
    	String option = "";
        while(true) {
        	try {
                        MostrarOpciones();
        		option = scan.next();
        		if(RevisarOption(option)==true) {
        		switch(option) {
        			//Mostrar listado
        			case "1":
        				ObtenerListado(participantes);
        			break;
        			//Añadir nuevo asistente
        			case "2":
        				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        				System.out.println("Por favor introduzca los datos del nuevo asistente en este orden");
        				System.out.println("Nombre - Apellidos - CI - Edad");
        		        String name = scan.next();
        		        String apellido = scan.next();
        		        String CI = scan.next();
        		        String edadtemp = scan.next();
        		        int edad = Integer.valueOf(edadtemp);
        		        
        		        Participantes k = new Participantes(name,apellido,CI,edad);
        		        participantes.add(k);
        			break;
        			//Eliminar un asistente
        			case "3":
        				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
        				System.out.println("Por favor introduzca el numero del asistente que quiere eliminar");
        				ObtenerListado(participantes);
        				String eliminartemp = scan.next();
        				int eleminar = Integer.valueOf(eliminartemp);
        				participantes.remove(eleminar-1);
        			break;
        			//Guardar Datos
        			case "4":
        		    	BaseDeDatos.GuardarDatos(participantes);
        				System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        				System.out.println("Guardado con exito!");
        			break;
        			//Finalizar aplicacion
        			case "5":
        				return;
        		}
        		}
        	}
        	catch(NumberFormatException ex1){
        		System.out.println("Ha escrito una letra en lugar de un numero");
        	}
        	catch(Exception ex) {
        		System.out.println(ex.getMessage());
        	}

        }
	}
	//Mostrar opciones
	public static void MostrarOpciones() {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Por favor escriba el numero de la opcion deseada:");
		System.out.println("1-Mostrar listado.");
		System.out.println("2-Inscribir nuevo asistente.");
		System.out.println("3-Eliminar un asistente.");
		System.out.println("4-Guardar datos.");
		System.out.println("5-Cerrar aplicacion.");
	}
	
	//Mostrar listado
	public static void ObtenerListado(Vector<Participantes> participantes) {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Listado de asistentes al evento");
		System.out.println("#-Nombre_Apellidos_CI_Edad");
                for(int i =0;i<participantes.size();i++) {
        	System.out.println((i+1)+"-"+participantes.get(i).nombre+" "+participantes.get(i).apellido+
        			" "+participantes.get(i).CI+" "+participantes.get(i).edad);
                }
	}
	//Revisar q la opcion sea valida en el rango de opciones
	public static boolean RevisarOption(String k) {
		if(Integer.valueOf(k)>=1&&Integer.valueOf(k)<=5) {
			return true;
		}
		else {
			throw new InputMismatchException("La opcion es incorrecta");
		}
	}
}