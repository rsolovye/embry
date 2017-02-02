package gwtest;

import protocol.maps.Protocol;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by bobsol on 28.01.17.
 */
public class TestGW {


    public static void main(String[] args) {

        //UUID guid = UUID.fromString("ba32f427-38fa-4915-80f1-fa21be68f121");
        //System.out.println(guid);
        //ProtocolHeader ph = ProtocolHeaderMapper.findByGUID(guid);

        //System.out.println(ph.toString());
//SQLRegistry.initialize();
//SQLRegistry.load_control_defaults();
//
//for (String k : SQLRegistry.getDefaultValues().keySet()){
//System.out.println("'" + k + "'-'" +SQLRegistry.getDefaultList(k)+"'");
//}


        // /System.out.println(ph.testNewGuid().toString());
        //ProtocolHeader.ProtocolHeaderBuilder().build();
        // ph.testNewDoc();
        // ProtocolHeaderMapper.updateByGuid(ph);
        //ProtocolHeaderMapper.insert(ph);
        //SQLRegistry.getSQL().getSqlRegistry();
        //.getSQL("control_list_names");
        //  DefaultValues.getDefaultList("DOCTORS");//printMap(); //.getDefaultList("DOCTORS");
        //MasterModel m = new MasterModel();
        //m.getHeader(UUID.fromString((mapedInput().get("guid"))));
        //m.saveProtocolHeader(mapedInput());

        //  ProtocolHeaderGateway.findByGUID(UUID.fromString(
        //        "61c7628a-2551-4ce5-b134-efd00289da2a"));

        // RowObjectMapper.rowObjectsFromDB();
//       for (RowObectImpl r: RowObjectMapper.rowArray) {
//           for (String k : r.getKeySet()) {
//               System.out.println("Name-" + r.getName() + ":" + k);
//           }
//       }
//       for (Protocol l: MasterMapper.findByGuid(UUID.fromString("61c7628a-2551-4ce5-b134-efd00289da2a")))
//          // System.out.print(l.keySet().size());
//       {
//           if (l == null) System.out.print("NULLL PROTOCOL");
//
//           for (String k : l.keySet()) {
//               System.out.println("l.get(k) " + l.get(k));// + " - " + s + "-" + l.get(s));
//           }
//       }
//
//        for (Protocol p : DataBaseCopy.findProtocol("61c7628a-2551-4ce5-b134-efd00289d72a")){
//            System.out.print("DataBaseCopy.findProtocol(guid) TEST\n");
//
//            System.out.print(p.getClass().getSimpleName() + " : " + p.get("fName") + " guid:" + p.get("guid"));
//
//
////        }
//        for (Protocol p : DataBaseCopy.findProtocol("61c7628a-2551-4ce5-b134-efd00289d72a")){
//            for (String key: p.keySet())
//                System.out.println(p.getClass().getSimpleName() + " key:" + key + "=" + p.get(key));
//        }

//        for (String guid : DataBaseCopy.getProtocolMap().keySet()) {
//            for (Protocol p: DataBaseCopy.getProtocolMap().get(guid)){
//                System.out.println("guid:\n'" + guid + "'");
//                System.out.println(p.getClass().getSimpleName() + " " + p.get("fName"));
//            }
//        }
//        String sql="INSERT INTO FERTILIZATION VALUES('61c7628a-2551-4ce5-b134-efd00289d72a', 'ИКСИ', 'Хандога А.О.', '14:10', 'Мурза Г.В.', '', '');";
//        insertSQL(sql);
        String sql =    "CREATE TABLE VITRIFICATION_TABLE( "+
        "guid STRING NOT NULL," +
                "strawCol STRING NOT NULL," +
                "embCol STRING NOT NULL,"+
                "dpfCol STRING NOT NULL,"+
                "devStage STRING NOT NULL," +
                "vitNotes  STRING NOT NULL," +
                "vitSignature STRING NOT NULL," +
                "defrostDate STRING,"+
                "defrostEmb STRING,"+
                "defrostSignature STRING," +
                "defrostSurvival STRING );";
        insertSQL(sql);
    }

    private static HashMap<String, String> mapedInput(){
        HashMap<String, String> input= new HashMap<>();
        input.put("guid", "61c7628a-2551-4ce5-b134-efd00289d72a");
        input.put("pfDate", "2011-11-11");
        input.put("pfTime", "10:00");
        input.put("pfVRT", "C010/101010/2010");
        input.put("ivfAttempt", "10");
        input.put("pfDoctor", "Гвасалия Р.Г.");
        input.put("isOms", "1");
        input.put("pfDiagnosis", "97.1");
        input.put("pfHeaderNotes", "HepC female");
        input.put("fName", "Десятникова Анна Петровна");
        input.put("fCode", "101010");
        input.put("fDOB", "1957-01-10");
        input.put("mName", "Десятников Петр Григорьевич");
        input.put("mCode", "919191");
        input.put("mDOB", "1937-01-19");
        return input;

    }
    private static void insertSQL(String sql){
        Connection c = null;
        Statement stmt = null;

        try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:embry-test.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            stmt.execute(sql);

            stmt.close();

            c.commit();
            c.close();


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
