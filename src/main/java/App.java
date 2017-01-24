import protocol.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {

//        LabProtocol lb;
//        //FEMALE GAMETE TEST
//        FemaleGameteSource fgs;
//        fgs = new FemaleGameteSource.Builder("Patient")
//            .state("Fresh")
//            .count("8+2")
//            .build();
//        System.out.println(fgs.toString());
//
//        //FEMALE GAMETE TEST
//        FemaleGameteSource fgs2;
//        fgs2 = new FemaleGameteSource.Builder("Donor - 82")
//
//            .state("Frozen")
//            .cryoDate("2013-5-6")
//            .count("4")
//            .build();
//        System.out.println(fgs2.toString());
//
//
//
//
//
//        //Male Gamete TEST
//        MaleGameteSource mgs;
//        mgs = new MaleGameteSource.Builder("Patient")
//            .state("Fresh")
//            .procedure("TESE")
//            .build();
//        System.out.println(mgs.toString());
//
//
//        MaleGameteSource mgs2;
//        mgs2 = new MaleGameteSource.Builder("Donor 59")
//            .state("Frozen")
//            .cryoDate("2011-2-15")
//            .build();
//        System.out.println(mgs2.toString());
//
//
//        FolliclePuncture fol_punc= new FolliclePuncture.Builder()
//            .embryologist("Solovyev R.S.")
//            .nurse("Shefer O.D.")
//            .eggCount(11)
//            .build();
//        System.out.println(fol_punc.toString());
//Fertilization fert;
//fert= new Fertilization.Builder("ICSI")
//                .time1(Time.valueOf("14:30:00"))
//                .witness1("Handoga A.O.")
//                .embryologist("Lyamina I.V.")
//                .build();
//PgsCryoEt pcv;
//pcv = new PgsCryoEt.Builder()
//            .etDay("d4")
//            .etNote("morula")
//            .cryoPlans("Yes")
//            .cryoStraws(4)
//            .cryoEmbryos(8)
//            .pgsType("FISH")
//            .pgsNote1("All")
//            .pgsNote2("Male")
//            .build();
//System.out.println(pcv.toString());
//CheckPoints cp = new CheckPoints.Builder()
//                .fertilizationCheck_embryologist("Murza G.V.")
//                .mediaChange_embryologist("Chernoshtan K.V.")
//                .cryo_embryologist("Handoga A.O.")
//                .utilization_embryologist("Lyamina I.V.")
//                .build();
//System.out.println(cp.toString());
//Spermiogramm sperm = new Spermiogramm.Builder()
//            .time1(Time.valueOf("10:45:00"))
//            .time2(Time.valueOf("10:57:00"))
//            .time3(Time.valueOf("11:40:00"))
//            .concentration("75")
//            .volume("2.7")
//            .viscosity("0.2")
//            .morphology("5")
//            .ab1("47")
//            .c1("22")
//            .d1("31")
//            .method("Gradient")
//            .embryologist("Chernoshtan K.V.")
//            .comment("Stinky")
//            .build();
//System.out.println(sperm.toString());
//String[][] ta = {{"MII","2pn", "4A2", "8A1", "M", "BL2AA", "BL3AA", "", "", "", ""},
// {"MII","2pn", "4A2", "8A1", "M", "BL2AA", "BL3AA", "", "", "", ""},
// {"MII","2pn", "4A2", "8A1", "M", "BL2AA", "BL3AA", "", "", "", ""}};
//CultivationTable ct = new CultivationTable.Builder(ta)
//                       //.addAll(ta)
//                       .build();
//for (String[] arr: ct.getDays())
//{
//    System.out.println(Arrays.toString(arr));
//}
////System.out.println(ct.toString());
////System.out.println(Arrays.deepToString(ta));
//        LocalDate date1 = LocalDate.of(2014, Month.DECEMBER, 12);
//        LocalDate date2 = LocalDate.of(1973, Month.OCTOBER, 1);
//        lb =new LabProtocol.LabProtocolBuilder(date1,
//                Time.valueOf("09:00:00"),
//                "C444/2016/123456",
//                "Gerkulov D.A.",
//                false,
//                "AnnaSmith",
//                date2)
//            .addFemaleGameteSource(fgs)
//            .addFemaleGameteSource(fgs2)
//            .follicle_puncture(fol_punc)
//            .addMaleGameteSource(mgs)
//            .addMaleGameteSource(mgs2)
//            .fertilization(fert)
//            .pgsCryoEt(pcv)
//            .checkPoints(cp)
//            .spermiogramm(sperm)
//            .cultivation(ct)
//            .build();
//        System.out.println(lb.toString());
    }
}
