package server.requests;

import lombok.Data;

@Data
public class RequestString {
    private String type;
    private String key;
    private String value;

}
