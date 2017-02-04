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
//        String sql =    "CREATE TABLE VITRIFICATION_TABLE( "+
//        "guid STRING NOT NULL," +
//                "strawCol STRING NOT NULL," +
//                "embCol STRING NOT NULL,"+
//                "dpfCol STRING NOT NULL,"+
//                "devStage STRING NOT NULL," +
//                "vitNotes  STRING NOT NULL," +
//                "vitSignature STRING NOT NULL," +
//                "defrostDate STRING,"+
//                "defrostEmb STRING,"+
        //         "defrostMedia S
//                "defrostSignature STRING," +
//                "defrostSurvival STRING );";
//        String s1ql = "INSERT INTO VitrifiedEmbryo VALUES\n" +
//                "('61c7628a-2551-4ce5-b134-efd00289d72a', '1', '1', '5', 'BL3BA', '', 'Хандога А.О.', '10.10.14', 'BL3BB', 'ИНХАУЗ 08.10.15', 'Лямина И.В.', '+')," +
//                "('61c7628a-2551-4ce5-b134-efd00289d72a', '1', '2', '5', 'BL3BA', '', 'Хандога А.О.',  '10.10.14', 'BL3BB', 'ИНХАУЗ 08.10.15', 'Лямина И.В.', '+')," +
//                "('61c7628a-2551-4ce5-b134-efd00289d72a', '2', '3', '5', 'BL3BA', '', 'Хандога А.О.', '', '', '', '', '')," +
//                "('61c7628a-2551-4ce5-b134-efd00289d72a', '2', '4', '5', 'BL3BA', '', 'Хандога А.О.', '', '', '', '', '');";

        //String sql = "INSERT INTO pojo_keysets VALUES\n"+
         //       "('" + UUID.randomUUID().toString() + "', 'VITRIFICATION', 'guid,vitDate,vitVRT,fName,fDOB,fCode,mName,mDOB,mCode,vitMedia,dewar,canister,sectionColor,embryoCount,strawCount,sectionCount,isOms,isPostponed,fromAnotherClinic');";

//
//        String sql1 = "INSERT INTO VITRIFICATION (" +
//                "guid,vitDate,vitVRT,fName,fDOB,fCode,mName,mDOB,mCode,vitMedia,dewar,canister,sectionColor,embryoCount,strawCount,sectionCount,isOms,isPostponed,fromAnotherClinic) " +
//
//                "VALUES \n"+
//                "('61c7628a-2551-4ce5-b134-efd00289d72a', '10.10.11', 'C0101/111010/2010', 'Иванова Афродита Сергеевна','01.10.1987','111010','Белосельский Ибрагим Денисович','25.04.1984','654321','In house(28.09.11)','10','3','синий','4','3','1','1','0','0');";
//
//System.out.println(sql1);
//        String sql = "INSERT INTO SECTION_COLOR VALUES\n" +
//                "('" + UUID.randomUUID().toString() + "'," +  "'Белый')," +
//                "('" + UUID.randomUUID().toString() + "'," +  "'Черный')," +
//                "('" + UUID.randomUUID().toString() + "'," +  "'Синий')," +
//                "('" + UUID.randomUUID().toString() + "'," +  "'Красный')," +
//                "('" + UUID.randomUUID().toString() + "'," +  "'Т-Оранжевый')," +
//                "('" + UUID.randomUUID().toString() + "'," +  "'Оранжевый')," +
//                "('" + UUID.randomUUID().toString() + "'," +  "'Желтый')," +
//                "('" + UUID.randomUUID().toString() + "'," +  "'Сиреневый')," +
//                "('" + UUID.randomUUID().toString() + "'," +  "'Салатовый')," +
//                "('" + UUID.randomUUID().toString() + "'," +  "'Серый')," +
//                "('" + UUID.randomUUID().toString() + "'," +  "'Розовый')," +
//                "('" + UUID.randomUUID().toString() + "'," +  "'Бирюзовый');";
        String sql4 = "UPDATE VITRIFICATION SET doctor='Геркулов Д.А.' WHERE guid='61c7628a-2551-4ce5-b134-efd00289d72a';";
        String sql5 = "UPDATE VITRIFICATION SET sectionColor='Синий' WHERE guid='61c7628a-2551-4ce5-b134-efd00289d72a';";


//        "INSERT INTO default_lists \n" +
//                "VALUES('" + UUID.randomUUID().toString() + "'" + ", 'SECTION_COLOR', 'SELECT CONTROL_VALUE FROM SECTION_COLOR;');";
insertSQL(sql5);
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
