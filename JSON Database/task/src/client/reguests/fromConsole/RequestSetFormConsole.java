package client.reguests.fromConsole;

import client.reguests.fromFile.Value;
import lombok.Data;

@Data
public class RequestSetFormConsole {
    private String type;
    private String key;
    private String value;
    //private Value value;

}