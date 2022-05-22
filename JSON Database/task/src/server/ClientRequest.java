package server;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ClientRequest {
    String type;
    String key;
    String value;

}
