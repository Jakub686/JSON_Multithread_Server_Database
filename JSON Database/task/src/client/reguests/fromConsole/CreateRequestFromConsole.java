package client.reguests.fromConsole;

import client.reguests.fromConsole.RequestExitFromConsole;
import client.reguests.fromConsole.RequestGetDeleteFromConsole;
import client.reguests.fromConsole.RequestSetFormConsole;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class CreateRequestFromConsole {
    Gson gson = new Gson();
    RequestSetFormConsole requestSetFormConsole = new RequestSetFormConsole();
    RequestGetDeleteFromConsole requestGetDeleteFromConsole = new RequestGetDeleteFromConsole();
    RequestExitFromConsole requestExitFromConsole = new RequestExitFromConsole();
    String jsonRequest = "";

    public String create(String... jarg) {

        if (jarg[0].equals("set")) {
            requestSetFormConsole.setType(jarg[0]);
            requestSetFormConsole.setKey(jarg[1]);
            requestSetFormConsole.setValue(jarg[2]);
            jsonRequest = gson.toJson(requestSetFormConsole);
        }
        if (jarg[0].equals("get") | jarg[0].equals("delete")) {
            requestGetDeleteFromConsole.setType(jarg[0]);
            requestGetDeleteFromConsole.setKey(jarg[1]);
            jsonRequest = gson.toJson(requestGetDeleteFromConsole);
        }
        if (jarg[0].equals("exit")) {
            requestExitFromConsole.setType(jarg[0]);
            jsonRequest = gson.toJson(requestExitFromConsole);
        }
        return jsonRequest;
    }

}
