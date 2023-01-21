package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	//Especificamos el puerto "9876"
    private final int PUERTO = 9876; 
    private ServerSocket serverSocket;
    private Socket socket;
    
    //Definimos el constructor
    public Server() throws IOException {
        serverSocket = new ServerSocket(PUERTO); //Definimos la conexión
        socket = new Socket(); //Iniciamos el cliente
    }
    
    //Aqui iniciamos lla funcion
    public void iniciarServer() throws IOException {
    	//Sacamos por consola que espera al cliente
    	System.out.println("Esperando la conexion del cliente");
    	socket = serverSocket.accept();
    	//Al cliente le saldra la pregunta sobre su nombre
    	System.out.println("Pregunta nombre del cliente");
    	DataInputStream entrada = new DataInputStream(socket.getInputStream());
    	//Leemos la respuesta del cliente y
    	//Declaramos la variable nom_client
    	String nom_client = entrada.readUTF();
    	DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
    	//Sacamos por pantalla el nombre del cliente
    	System.out.println("El nombre del cliente que se ha conectado es: " + nom_client);
    	//Preguntamos el numero de las tareas
    	System.out.println("¿Cuanta tareas tienes que realizar?");
    	//Declaramos la variable tarea
    	int tarea = entrada.readInt();
    	//Sacamos por pantalla la respuesta del cliente
    	System.out.println("El numero de tarea a realizar son: " + tarea);
    	
    	//Sacamos un arraylist con el numero de las tareas
    	ArrayList<Tarea> list_tarea = new ArrayList<Tarea>();
    	
    	for(int i = 0; i<tarea; i++) {
    		
    		salida.writeUTF("La tarea numero: " + (i+1));
  
    		
    		salida.writeUTF("Dime la descripcion de la tarea");
    		String descripcion = (entrada.readUTF());
    		
    		salida.writeUTF("Dime el estado de la tarea");
    		String estado = entrada.readUTF();
    		
    		
    		list_tarea.add(new Tarea(descripcion, estado));
    	}
    	
    	System.out.println("Las tareas que tienes que realizar son: " + list_tarea);
    	salida.writeUTF("Sus tareas son: " + list_tarea);
    	socket.close();
    	entrada.close();
    	salida.close();
    	
    	
    }
    //Cerramos el servidor
    	public void finalizarServer() throws IOException {
            serverSocket.close();
            System.out.println("Fin del programa");
            
    	}
    
}