package client;

import client.reguests.ClientRequestExit;
import client.reguests.ClientRequestGetDelete;
import client.reguests.ClientRequestSet;
import client.reguests.CreateRequest;
import com.beust.jcommander.JCommander;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.util.Map;
//TODO Lista argumentow w InteliJ

public class Main {

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 34522;

    public static void main(String[] args) {
        System.out.println("Client started");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonRequest = "";

        //Jcommaneder
        Args jArgs = new Args();
        JCommander cmd = JCommander.newBuilder().addObject(jArgs).build();
        cmd.parse(args);

        //Create Object Request
        CreateRequest createRequest = new CreateRequest();

        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            try {
                if (jArgs.file != null) {
                    jsonRequest = createRequest.create(jArgs.file);
                }
                //set get delete
                if (jArgs.file == null) {
                    jsonRequest = createRequest.create(jArgs.type, jArgs.key, jArgs.value);
                }
                output.writeUTF(jsonRequest); // sending message to the server
                System.out.println("Sent: " + jsonRequest);
                //createRequest.create(jArgs.file);


            } catch (NullPointerException e) {
            }
            String jsonRespond = input.readUTF(); // response message

            System.out.println("Received: " + jsonRespond);

        } catch (IOException e) {

        }
    }


}