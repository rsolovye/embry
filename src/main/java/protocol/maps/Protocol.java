package protocol.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bobsol on 29.01.17.
 */
public class Protocol extends HashMap<String, String> {
    public Protocol(HashMap<String, String> m) {
        this.putAll(m);
    }

    public void setMap(HashMap<String, String> map){
             this.putAll(map);
        }
}
