package client;

import client.reguests.ClientRequestExit;
import client.reguests.ClientRequestSet;
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

        //Jcommaneder
        Args jArgs = new Args();
        JCommander cmd = JCommander.newBuilder().addObject(jArgs).build();
        cmd.parse(args);
        //Create Object Request
        ClientRequestExit clientRequestExit = new ClientRequestExit();
        ClientRequestGetDelete clientRequestGetDelete = new ClientRequestGetDelete();
        ClientRequestSet clientRequestSet = new ClientRequestSet();
        Gson gson = new Gson();


        try (// czym sie rozni taki try catch od {}
             Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             DataInputStream input = new DataInputStream(socket.getInputStream());
             DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            //TODO refactor into methods
            //TODO service!!!!!!! tam sie wszystko dzieije, logika
            //TODO MVC
            //Create Object Request

            //TODO to jest dobre podejscie? zeby nie tworzyc metody statycznej to musze stworzyc obiekt, a w tym przypadku obiektem jest Main.


            //--------------------------

            try {
                if (jArgs.file.equals("testSet.json")) {
                    try {
                        Map<String, String> map = mapper.readValue(new File("D:\\java examples\\JSON Database\\JSON Database\\task\\src\\client\\data\\testSet.json"), new TypeReference<Map<String, String>>() {});
                        clientRequestSet.setType(map.get("type"));
                        clientRequestSet.setKey(map.get("key"));
                        clientRequestSet.setValue(map.get("value"));
                        String jsonRequest = gson.toJson(clientRequestSet);
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
                        String jsonRequest = gson.toJson(clientRequestSet);
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
                        String jsonRequest = gson.toJson(clientRequestSet);
                        output.writeUTF(jsonRequest); // sending message to the server
                        System.out.println("Sent: " + jsonRequest);
                    } catch (IOException e) {
                    }
                }
            } catch (NullPointerException e) {
            }

            //--------------------------


            try {
                if (jArgs.type.equals("exit")) {
                    clientRequestExit.setType( jArgs.type);
                    String jsonRequest = gson.toJson(clientRequestExit);
                    output.writeUTF(jsonRequest); // sending message to the server
                    System.out.println("Sent: " + jsonRequest);
                }
                if (jArgs.type.equals("get") | jArgs.type.equals("delete")) {
                    //TODO getters and setters
                    clientRequestGetDelete.setType(jArgs.type);
                    clientRequestGetDelete.setKey(jArgs.key);
                    String jsonRequest = gson.toJson(clientRequestGetDelete);
                    output.writeUTF(jsonRequest); // sending message to the server
                    System.out.println("Sent: " + jsonRequest);
                }
                if (jArgs.type.equals("set")) {
                    clientRequestSet.setType(jArgs.type);
                    clientRequestSet.setKey(jArgs.key);
                    clientRequestSet.setValue(jArgs.value);
                    String jsonRequest = gson.toJson(clientRequestSet);
                    output.writeUTF(jsonRequest); // sending message to the server
                    System.out.println("Sent: " + jsonRequest);
                }
            } catch (NullPointerException e) {
            }
            String jsonRespond = input.readUTF(); // response message

            System.out.println("Received: " + jsonRespond);

        } catch (IOException e) {

        }
    }


}