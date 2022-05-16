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
        SendObject myObject = new SendObject();
        Gson gson = new Gson();

        JCommander cmd = JCommander.newBuilder().addObject(jArgs).build();
        cmd.parse(args);

        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            String msg = "";
            if(jArgs.type!=null) {
                msg = jArgs.type;
                myObject.type=jArgs.type;
            }
            if(jArgs.type!=null & jArgs.key!=null) {
                msg = jArgs.type + " " + jArgs.key;
                myObject.type=jArgs.type;
                myObject.key=jArgs.key;
            }
            if(jArgs.type!=null & jArgs.key!=null & jArgs.value!=null) {
                msg = jArgs.type + " " + jArgs.key + " " +jArgs.value;
                myObject.type=jArgs.type;
                myObject.key=jArgs.key;
                myObject.value=jArgs.value;
            }


            //TO JSON //
            //Serlialization

            String json = gson.toJson(myObject);
            output.writeUTF(json); // sending message to the server

            // Czy takie infomacje tez dawac do View?
            System.out.println("Sent: " + json);
            String receivedMsg = input.readUTF(); // response message

            //Deserialization
            System.out.println("Received: " + receivedMsg);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





