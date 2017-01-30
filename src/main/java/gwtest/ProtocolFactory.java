package gwtest;

import protocol.maps.*;

import java.util.HashMap;

/**
 * Created by bobsol on 29.01.17.
 */
public class ProtocolFactory {
    private static SpermiogrammMap sm = null;

    public static Protocol get(String name, HashMap<String, String> map) {
        System.out.println("Protocol get " + name);
        if (name.compareTo("SPERMIOGRAMM") == 0) return new SpermiogrammMap(map);
        if (name.compareTo("PROTOCOL_HEADER") == 0) return new ProtocolHeaderMap(map);
        if (name.compareTo("FOLLICLE_PUNCTURE") == 0) return new FolliclePunctureMap(map);
        if (name.compareTo("FERTILIZATION") == 0) return new FertilizationMap(map);
        if (name.compareTo("ET_CRYO_PGS") == 0) return new PgsCryoEtMap(map);
        if (name.compareTo("CHECK_POINTS") == 0) return new CheckPointsMap(map);
        if (name.compareTo("CONDITIONS") == 0) return new ConditionsMap(map);
        if (name.compareTo("FEMALE_SOURCE") == 0) return new FemaleGameteSourceMap(map);
        if (name.compareTo("MALE_SOURCE") == 0) return new MaleGameteSourceMap(map);
        if (name.compareTo("VITRIFICATION") == 0) return new VitrificationMap(map);
        if (name.compareTo("CULTIVATION") == 0) return new CultivationMap(map);

        return null;
    }

}
