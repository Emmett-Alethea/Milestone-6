package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class AdminApp {
	
	//client?
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	private static String jsonString;
	private static Inventory list = new Inventory();

	public void start(String ip, int port) throws UnknownHostException, IOException{
		clientSocket = new Socket(ip, port);
		
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}
	
/*	public String sendMessage(String msg) throws IOException{
		out.println(msg);
		return in.readLine();
	}
	 */
	public void cleanup() throws IOException{
		in.close();
		out.close();
		clientSocket.close();
	}
	public void returnCommand() {
		// r returns the json string from inventory
		AdminServer.receive();
		System.out.println("Received command R");
	}
	public static String returnJson() {
		return jsonString;
	}
	public String sendCommand(Product item) throws JsonProcessingException {
		//u send json string to inventory
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		jsonString = ow.writeValueAsString(item);
		System.out.println("U|" + jsonString);
		return jsonString;
	}
	public static void main(String [] args) throws IOException, InterruptedException{
		AdminApp client = new AdminApp();
		client.start("127.0.0.1", 6666);
		AdminServer adminServer = new AdminServer();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Press U to create a new product and send it. Press R to return/display the current inventory");
		String curr = input.next();
		while(!curr.equals("x")) {
		if(curr.equals("r")|| curr.equals("R")) { // return
			client.returnCommand();
			curr = input.next();
		
		}
		else if (curr.equals("U")||curr.equals("u")) { //send/update
			Product item = new Armor("Name","description", 12, 0, 3.5, 4);   //(String name, String description, int quantity, int cartQuant, double price, int defense)
			client.sendCommand(item);
			String rec = client.returnJson();
			
			adminServer.update(rec);
			curr = input.next();
		
		}
		else {
			System.out.println("Please input one of the commands");
			curr = input.next();
		}
		}
		client.cleanup();
	}
	}


