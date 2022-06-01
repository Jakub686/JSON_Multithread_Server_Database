package server;

import client.reguests.fromFile.Value;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Model {


    private static String PATH ="D:\\java examples\\JSON Database\\JSON Database\\task\\src\\server\\data\\db.json";
    ObjectMapper mapper = new ObjectMapper();
    HashMap<String, Object> data = new HashMap<>();

    public  void setList(String index, String text) throws IOException {
        //get hashmap from Json file
        HashMap data = getData();
        //add object to hashmap
        data.put(index, text);
        //send hashmap to Json file
        setData(data);
    }



    public  void setList(String index, server.requests.Value text) throws IOException {
        //get hashmap from Json file
        HashMap data = getData();
        //add object to hashmap
        data.put(index, text);
        //send hashmap to Json file
        setData(data);
    }

    public  void deleteList(String index) throws IOException {
        //get hashmap from Json file
        //getData(index, data);

        //remove object from hashmap
        data.remove(index);
        //send hashmap to Json file
        setData(data);
    }
    //get
    public  Object getList(String index) throws IOException {
        //get hashmap from Json file
        data = getData();
        System.out.println(data);
        return data.get(index);
    }

    //get hashmap from Json file
    public HashMap getData() throws IOException{


        return data = mapper.readValue(new File(PATH), new TypeReference<HashMap<String, Object>>() {});
    }
    //send hashmap to Json file
    public void setData(HashMap data) throws IOException{
        String jsonStr = mapper.writeValueAsString(data);
        BufferedWriter write = new BufferedWriter(new FileWriter(PATH));
        write.write(jsonStr);
        write.close();
    }



}