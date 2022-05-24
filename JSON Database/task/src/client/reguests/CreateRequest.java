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

    public String create(String... jarg) {

        if (jarg[0].equals("set")) {
            clientRequestSet.setType(jarg[0]);
            clientRequestSet.setKey(jarg[1]);
            clientRequestSet.setValue(jarg[2]);
            jsonRequest = gson.toJson(clientRequestSet);
        }
        if (jarg[0].equals("get") | jarg[0].equals("delete")) {
            clientRequestGetDelete.setType(jarg[0]);
            clientRequestGetDelete.setKey(jarg[1]);
            jsonRequest = gson.toJson(clientRequestGetDelete);
        }
        if (jarg[0].equals("exit")) {
            clientRequestExit.setType(jarg[0]);
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
