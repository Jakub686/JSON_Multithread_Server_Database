package server;
// chyba moge wykozystac ta sama klase MyObject ktora jest w Cilient? Czy ta klasa jest nie potrzebna?

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ServerRespond {
    String response;
    String reason;
    String value;

}
