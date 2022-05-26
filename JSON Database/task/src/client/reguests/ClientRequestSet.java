package client.reguests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ClientRequestSet {
    String type;
    String key;
    String value;
}