package protocol.maps;

import java.util.HashMap;

/**
 * Created by micro on 01.02.2017.
 */
public class VitrificationMap extends Protocol {
    public VitrificationMap(HashMap<String, String> map) {
        super(map);
    }

    public void print(){
        for (String k :this.keySet())
            System.out.println(k + "=" + this.get(k));
    }
}
