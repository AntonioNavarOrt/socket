package client;

import java.io.IOException;

//El main sacado del ejercicio de la vt de sockets

public class Main{

        public static void main(String[] args) throws IOException {
        	
        	//Creamos objeto de Cliente
            Client cli = new Client();
            System.out.println("Cliente se conecta");
            
            //Iniciamos la conexión
            cli.iniciarClient();
        }
}
