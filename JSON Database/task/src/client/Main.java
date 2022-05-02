package client;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 34522;

    public static void main(String[] args) {
        System.out.println("Client started");
        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            Scanner scanner = new Scanner(System.in);
            String msg = scanner.nextLine();

            output.writeUTF(msg); // sending message to the server
            System.out.println("Client sent "+ msg);
            String receivedMsg = input.readUTF(); // response message

            System.out.println("Received from server: " + receivedMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





