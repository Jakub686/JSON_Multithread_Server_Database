package client;

import com.beust.jcommander.JCommander;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;



public class Main {

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 34522;

    public static void main(String[] args) {
        System.out.println("Client started");// Clinet tez musi miec swoja klase View?

        Args jArgs = new Args();
        ClientRequest clientRequest = new ClientRequest();
        Gson gson = new Gson();

        JCommander cmd = JCommander.newBuilder().addObject(jArgs).build();
        cmd.parse(args);

        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {

            if(jArgs.type!=null) {
                clientRequest.type=jArgs.type;
            }
            if(jArgs.type!=null & jArgs.key!=null) {
                clientRequest.type=jArgs.type;
                clientRequest.key=jArgs.key;
            }
            if(jArgs.type!=null & jArgs.key!=null & jArgs.value!=null) {
                clientRequest.type=jArgs.type;
                clientRequest.key=jArgs.key;
                clientRequest.value=jArgs.value;
            }

            //Serlialization
            String jsonRequest = gson.toJson(clientRequest);
            output.writeUTF(jsonRequest); // sending message to the server

            // Czy takie infomacje tez dawac do View?
            System.out.println("Sent: " + jsonRequest);
            String jsonRespond = input.readUTF(); // response message

            System.out.println("Received: " + jsonRespond);
            //Deserialization

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





