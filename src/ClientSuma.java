
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ClientSuma {

	private static int SERVER_PORT = 9001; //Se crea el puerto del servidor
	
public static void main(String[] args) throws IOException{
		String serverAddress = JOptionPane.showInputDialog("Enter IP address pd machine that in \n"+
" runing the date service on port "+":"); //DECLARO DIRECCION IP DEL SERVIDOR
		Socket clienteSocket = new Socket(serverAddress, SERVER_PORT); 
		String datos; //Variable usada para almacenar los números ingresados antes de ser enviados
		DataOutputStream envioServer = new DataOutputStream(clienteSocket.getOutputStream()); //Canal de salida hacia el servidor
		DataInputStream salidaServidor = new DataInputStream(clienteSocket.getInputStream()); //Canal de entrada desde el servidor
		for(int i=0;i<2;i++){ //Lazo usado para que el cliente ingrese los 2 números a sumar
			datos=JOptionPane.showInputDialog(null, "Ingrese el valor del numero " +(i+1)); //Ingreso de los números mediante una JOptionPane
			envioServer.writeUTF(datos); //Envio los números ingresados hacia el servidor.
		}
		JOptionPane.showMessageDialog(null, salidaServidor.readLine()); //Imprime el resultado de la suma, enviado por el servidor
		System.exit(0);
		
	}
}
