package server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {


    public static void main(String[] args) {
        //multithread
        ExecutorService excr = Executors.newCachedThreadPool();

        //assaint sever to executor (multithreading)
        excr.submit( new Server(34522,"database/db.json"));

    }
}
