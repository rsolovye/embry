package gwtest;

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

       RowObjectMapper.rowObjectsFromDB();
//       for (RowObectImpl r: RowObjectMapper.rowArray) {
//           for (String k : r.getKeySet()) {
//               System.out.println("Name-" + r.getName() + ":" + k);
//           }
//       }
       MasterMapper.findByGuid(UUID.fromString("61c7628a-2551-4ce5-b134-efd00289d72a"));
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
