package server.requests;

import lombok.Data;

@Data
public class ClientRequest {
    private String type;
    private String key;
    Value value;

}
