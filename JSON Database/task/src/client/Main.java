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
        ClientRequestExit clientRequestExit = new ClientRequestExit();
        ClientRequestGetDelete clientRequestGetDelete = new ClientRequestGetDelete();
        ClientRequestSet clientRequestSet = new ClientRequestSet();

        Gson gson = new Gson();


        try (// czym sie rozni taki try catch od {}
             Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             DataInputStream input = new DataInputStream(socket.getInputStream());
             DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            try {
                if (jArgs.file.equals("testSet.json")) {
                    try {
                        Map<String, String> map = mapper.readValue(new File("D:\\java examples\\JSON Database\\JSON Database\\task\\src\\client\\data\\testSet.json"), new TypeReference<Map<String, String>>() {});
                        clientRequestSet.setType(map.get("type"));
                        clientRequestSet.setKey(map.get("key"));
                        clientRequestSet.setValue(map.get("value"));
                        jsonRequest = gson.toJson(clientRequestSet);
                        output.writeUTF(jsonRequest); // sending message to the server
                        System.out.println("Sent: " + jsonRequest);
                    } catch (IOException e) {
                    }
                }
            } catch (NullPointerException e) {
            }

            try {
                if (jArgs.file.equals("testGet.json")) {
                    try {
                        Map<String, String> map = mapper.readValue(new File("D:\\java examples\\JSON Database\\JSON Database\\task\\src\\client\\data\\testGet.json"), new TypeReference<Map<String, String>>() {});
                        clientRequestSet.setType(map.get("type"));
                        clientRequestSet.setKey(map.get("key"));
                        jsonRequest = gson.toJson(clientRequestSet);
                        output.writeUTF(jsonRequest); // sending message to the server
                        System.out.println("Sent: " + jsonRequest);
                    } catch (IOException e) {
                    }
                }
            } catch (NullPointerException e) {
            }
            try {
                if (jArgs.file.equals("testDelete.json")) {
                    try {
                        Map<String, String> map = mapper.readValue(new File("D:\\java examples\\JSON Database\\JSON Database\\task\\src\\client\\data\\testDelete.json"), new TypeReference<Map<String, String>>() {});
                        clientRequestSet.setType(map.get("type"));
                        clientRequestSet.setKey(map.get("key"));
                        jsonRequest = gson.toJson(clientRequestSet);
                        output.writeUTF(jsonRequest); // sending message to the server
                        System.out.println("Sent: " + jsonRequest);
                    } catch (IOException e) {
                    }
                }
            } catch (NullPointerException e) {
            }

            //--------------------------


            try {

                //set get delete
                jsonRequest = createRequest.create(jArgs.type, jArgs.key, jArgs.value);

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