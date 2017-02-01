package gwtest;

import protocol.maps.Protocol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by bobsol on 29.01.17.
 */
public class Registry {
   // private static HashMap<UUID, Protocol> guidSet = ProtocolHeaderGateway.findAll();
    private static HashMap<String, String[]> rowKeys = new HashMap<>();
    private static HashMap<String, String> typeNames = new HashMap<>();

    public static boolean containsGuid(Protocol protocol){
        boolean matchesType = false;
        for (Protocol p : DataBaseCopy.findProtocol(protocol.get("guid"))){
            matchesType = p.isTypeOf(protocol.getClass().getSimpleName());
            }
        return matchesType;
        }


    public static String getTypeSimpleName(String protocolType){
        typeNames.put("PROTOCOL_HEADER", "ProtocolHeader");
        return typeNames.get(protocolType);
    }

    public static String[] getRowKeys(String rowObjectName){
        if (rowKeys.keySet().size()==0){
            setUpRowKeysMap();
        }
        return rowKeys.get(rowObjectName);
    }

    public static final String[] PROTOCOL_HEADER_KEYS = {"guid", "pfDate", "pfTime", "pfVRT", "ivfAttempt", "pfDoctor", "isOms", "pfHeaderNotes", "pfDiagnosis", "fName", "fDOB", "fCode", "mName", "mDOB", "mCode"};
    private static final String[] FEMALE_SOURCES_KEYS={"guid", "source", "material_type", "cryo_date", "expected_follicle_count"};
    private static final String[] MALE_SOURCES_KEYS={"guid", "source", "material_type", "cryo_date", "biopsy_type"};
    private static final String[] FOLLICLE_PUNCTURE_KEYS = {"guid", "embryologist", "nurse", "harvested_count"};
    private static final String[] FERTILIZATION_KEYS = {"guid", "procedure_type", "embryologist", "time_1", "witness_1", "time_2", "witness_2"};
    private static final String[] ET_CRYO_PGS_KEYS = {"guid", "et_day", "et_note", "Vitrification_decision", "max_embryos_cryo", "max_straws_cryo", "pgs_type", "pgs_note"};
    private static final String[] CHECK_POINTS_KEYS = {"guid", "fertilization_check_by", "media_changed_by", "vitrified_by", "utilized_by"};
    private static final String[] SPERMIOGRAMM_KEYS = {"guid", "time_!", "time_2", "time_3", "concentration", "volume", "viscosity", "morphology", "ab_native", "c_native", "d_native", "method", "ab_postprep", "c_postprep", "d_postprep", "concentration_postprep", "add_to_700", "add_to_1000", "embryologist", "sperm_note"};
    private static final String[] CONDITIONS_KEYS = {"guid", "cleavage_lot", "blastocyst_lot", "sps_lot", "hepes_lot", "ovoil_lot", "incubator", "special_case_note"};
    private static final String[] EMBRYO_TRANSFER_KEYS = {"guid", "etDay", "etTime", "etDpf", "etCount", "etDoctor", "etNurse", "etEmbryologist", "catheter", "catheter_hard", "catheter_replacement", "mucus", "blood", "etRepeat", "visible", "no_ultra_sound", "surogate_mother"};
    private static final String[] CONCLUSION_KEYS = {"guid", "okk", "m2", "m1", "gv", "abn", "atr", "used_for_fertilization", "fertilized", "transfered", "vitrified", "pregnancy"};
    private static final String[] VITRIFICATION_KEYS = {"guid", "vitDate", "fName", "fDOB", "vitVRT", "fCode", "mName", "mDOB", "media_date", "dewar", "canister", "color", "embryo_count", "straw_count", "sections_count"};

    public  static void setUpRowKeysMap() {
        rowKeys.put("PROTOCOL_HEADER", PROTOCOL_HEADER_KEYS);
        rowKeys.put("FEMALE_SOURCE", FEMALE_SOURCES_KEYS);
        rowKeys.put("MALE_SOURCE", MALE_SOURCES_KEYS);
        rowKeys.put("FOLLICLE_PUNCTURE", FOLLICLE_PUNCTURE_KEYS);
        rowKeys.put("FERTILIZATION", FERTILIZATION_KEYS);
        rowKeys.put("ET_CRYO_PGS", ET_CRYO_PGS_KEYS);
        rowKeys.put("CHECK_POINTS", CHECK_POINTS_KEYS);
        rowKeys.put("SPERMIOGRAMM", SPERMIOGRAMM_KEYS);
        rowKeys.put("CONDITIONS", CONDITIONS_KEYS);
        rowKeys.put("EMBRYO_TRANSFER", EMBRYO_TRANSFER_KEYS);
        rowKeys.put("CONCLUSION", CONCLUSION_KEYS);
        rowKeys.put("VITRIFICATION", VITRIFICATION_KEYS);

    }
    public static ArrayList<String> insertRowKeystoSQL() {
        ArrayList<String> sqlInsert = new ArrayList<>();
        setUpRowKeysMap();
        for (String cl : rowKeys.keySet())
        {
            String classNAme = cl;
            String guid = UUID.randomUUID().toString();
            String commaString = "INSERT INTO pojo_keysets VALUES \n" +
                    "('"+guid+"', '" + classNAme + "', '";
            for (String ke: rowKeys.get(cl))
            {
                commaString = commaString + ke + ",";
            }
                commaString = commaString.substring(0, commaString.length() - 1) + "');";
               sqlInsert.add(commaString);
        }
        return sqlInsert;

    }

    private  static HashMap<String, String> mp = new HashMap<>();
    private static void initConversionMap() {
        mp.put("ProtocolHeaderMap", "PROTOCOL_HEADER");
        mp.put("FemaleGameteSourceMap", "FEMALE_SOURCE");
        mp.put("MaleGameteSourceMap", "MALE_SOURCE");
        mp.put("FolliclePunctureMap", "FOLLICLE_PUNCTURE");
        mp.put("FertilizationMap", "FERTILIZATION");
        mp.put("PgsCryoEtMap", "ET_CRYO_PGS");
        mp.put("CheckPointsMap", "CHECK_POINTS");
        mp.put("SpermiogrammMap", "SPERMIOGRAMM");
        mp.put("ConditionsMap", "CONDITIONS");
        mp.put("EmbryoTransferMap", "EMBRYO_TRANSFER");
        mp.put("ConclusionMap","CONCLUSION");
        mp.put("VitrificationMap", "VITRIFICATION");
    }
    public static String convertProtocolType(String simpleName) {
       if (mp.size() == 0) initConversionMap();

       return mp.get(simpleName);
    }
}
