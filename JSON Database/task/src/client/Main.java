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

        //Jcommaneder
        Args jArgs = new Args();
        JCommander cmd = JCommander.newBuilder().addObject(jArgs).build();
        cmd.parse(args);
        //Create Object Request
        ClientRequestExit clientRequestExit = new ClientRequestExit();
        ClientRequestGetDelete clientRequestGetDelete = new ClientRequestGetDelete();
        ClientRequestSet clientRequestSet = new ClientRequestSet();
        Gson gson = new Gson();


        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            //TODO refactor into method
            //Create Object Request
            if(jArgs.type.equals("exit")) {
                clientRequestExit.type=jArgs.type;
                String jsonRequest = gson.toJson(clientRequestExit);
                output.writeUTF(jsonRequest); // sending message to the server
                System.out.println("Sent: " + jsonRequest);
            }
            if(jArgs.type.equals("get") | jArgs.type.equals("delete")) {
                clientRequestGetDelete.type=jArgs.type;
                clientRequestGetDelete.key=jArgs.key;
                String jsonRequest = gson.toJson(clientRequestGetDelete);
                output.writeUTF(jsonRequest); // sending message to the server
                System.out.println("Sent: " + jsonRequest);
            }
            if(jArgs.type.equals("set")) {
                clientRequestSet.type = jArgs.type;
                clientRequestSet.key = jArgs.key;
                clientRequestSet.value = jArgs.value;
                String jsonRequest = gson.toJson(clientRequestSet);
                output.writeUTF(jsonRequest); // sending message to the server
                System.out.println("Sent: " + jsonRequest);
            }

              String jsonRespond = input.readUTF(); // response message

            System.out.println("Received: " + jsonRespond);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





