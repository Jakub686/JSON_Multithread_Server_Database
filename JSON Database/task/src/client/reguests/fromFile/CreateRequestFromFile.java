package client.reguests.fromFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class CreateRequestFromFile {
    Gson gson = new Gson();
    ObjectMapper mapper = new ObjectMapper();
    RequestSetFormFile requestSetFormFile = new RequestSetFormFile();

    String jsonRequest = "";

    public String create(String file) throws IOException {

//TODO path
        if (file.equals("setFile.json")) {
            requestSetFormFile = mapper.readValue(new File("D:\\java examples\\JSON Database\\JSON Database\\task\\src\\client\\data\\setFile.json"),RequestSetFormFile.class);
            //Value value = new value;
            jsonRequest = gson.toJson(requestSetFormFile);

        }

        if (file.equals("testGet.json")) {
            Map<String, String> map = mapper.readValue(new File("D:\\java examples\\JSON Database\\JSON Database\\task\\src\\client\\data\\testGet.json"), new TypeReference<Map<String, String>>() {});
            requestSetFormFile.setType(map.get("type"));
            requestSetFormFile.setKey(map.get("key"));
            jsonRequest = gson.toJson(requestSetFormFile);
        }
        if (file.equals("testDelete.json")) {
            Map<String, String> map = mapper.readValue(new File("D:\\java examples\\JSON Database\\JSON Database\\task\\src\\client\\data\\testDelete.json"), new TypeReference<Map<String, String>>() {});
            requestSetFormFile.setType(map.get("type"));
            requestSetFormFile.setKey(map.get("key"));
            jsonRequest = gson.toJson(requestSetFormFile);
        }

        return jsonRequest;
    }

}
