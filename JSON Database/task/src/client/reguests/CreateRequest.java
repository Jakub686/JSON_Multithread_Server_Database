package client.reguests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class CreateRequest {
    Gson gson = new Gson();
    ObjectMapper mapper = new ObjectMapper();
    ClientRequestSet clientRequestSet = new ClientRequestSet();
    ClientRequestGetDelete clientRequestGetDelete = new ClientRequestGetDelete();
    ClientRequestExit clientRequestExit = new ClientRequestExit();
    String jsonRequest = "";

    public String create(String type, String key, String value) {

        if (type.equals("set")) {
            clientRequestSet.setType(type);
            clientRequestSet.setKey(key);
            clientRequestSet.setValue(value);
            jsonRequest = gson.toJson(clientRequestSet);
        }
        if (type.equals("get") | type.equals("delete")) {
            clientRequestGetDelete.setType(type);
            clientRequestGetDelete.setKey(key);
            jsonRequest = gson.toJson(clientRequestGetDelete);
        }
        if (type.equals("exit")) {
            clientRequestExit.setType(type);
            jsonRequest = gson.toJson(clientRequestExit);
        }
        return jsonRequest;
    }
    public String create(String file) throws IOException {

        if (file.equals("testSet.json")) {
            Map<String, String> map = mapper.readValue(new File("D:\\java examples\\JSON Database\\JSON Database\\task\\src\\client\\data\\testSet.json"), new TypeReference<Map<String, String>>() {});
            clientRequestSet.setType(map.get("type"));
            clientRequestSet.setKey(map.get("key"));
            clientRequestSet.setValue(map.get("value"));
            jsonRequest = gson.toJson(clientRequestSet);
        }
        if (file.equals("testGet.json")) {
            Map<String, String> map = mapper.readValue(new File("D:\\java examples\\JSON Database\\JSON Database\\task\\src\\client\\data\\testGet.json"), new TypeReference<Map<String, String>>() {});
            clientRequestSet.setType(map.get("type"));
            clientRequestSet.setKey(map.get("key"));
            jsonRequest = gson.toJson(clientRequestSet);
        }
        if (file.equals("testDelete.json")) {
            Map<String, String> map = mapper.readValue(new File("D:\\java examples\\JSON Database\\JSON Database\\task\\src\\client\\data\\testDelete.json"), new TypeReference<Map<String, String>>() {});
            clientRequestSet.setType(map.get("type"));
            clientRequestSet.setKey(map.get("key"));
            jsonRequest = gson.toJson(clientRequestSet);
        }


        return jsonRequest;
    }

}
