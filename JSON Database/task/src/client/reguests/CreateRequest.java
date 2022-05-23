package client.reguests;

import com.google.gson.Gson;

public class CreateRequest {
    Gson gson = new Gson();
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

}
