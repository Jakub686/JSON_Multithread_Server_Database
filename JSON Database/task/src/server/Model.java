package server;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Model {

    //private String[] data = new String[1000];

    ObjectMapper mapper = new ObjectMapper();
    HashMap<String, String> data = new HashMap<String, String>();


    public void setList(String index, String text) throws IOException {
        data.put(index, text);

    }
    public void deleteList(String index) throws IOException {

        data.remove(index);

    }

    public String getList(String index) {

        return data.get(index);
    }



}