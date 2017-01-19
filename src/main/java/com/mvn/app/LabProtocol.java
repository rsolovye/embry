
package com.mvn.app;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class LabProtocol{


    private final LocalDate pfDate;
    private final Time pfTime;

    private final boolean isOms;
    private final String pfVRT;

    private final String pfDoctor;
    private final String fName;

    private final LocalDate fDOB;
    private String mName;

    private LocalDate mDOB;
    private String mCode;

    private FolliclePuncture pf;
    private ArrayList<FemaleGameteSource> fgSource;
    private ArrayList<MaleGameteSource> mgSource;


    private Fertilization fertilization;
    private PgsCryoEt pgsCryoEt;
    private CheckPoints cp;
    private Spermiogramm sperm;
    private CultivationTable cultivation;




    private  LabProtocol(LabProtocolBuilder builder) {

        this.pfDate =builder.pfDate;
        this.pfTime = builder.pfTime;
        this.pfVRT =builder.pfVRT;
        this.pfDoctor = builder.pfDoctor;
        this.isOms = builder.isOms;
        this.fName =builder.fName;
        this.fDOB = builder.fDOB;
        this.fgSource = builder.fgSource;
        this.mgSource = builder.mgSource;
        this.pf = builder.pf;
        this.fertilization = builder.fertilization;
        this.pgsCryoEt = builder.pgsCryoEt;
        this.cp = builder.cp;
        this.sperm = builder.sperm;
        this.cultivation = builder.cultivation;
    }
    public Spermiogramm getSpermiogramm(){return sperm;}
    public PgsCryoEt getPgsCryoEt(){return pgsCryoEt;}
    public LocalDate getPfDate() {return pfDate;}
    public Time getPfTime() { return pfTime;  }
    public String getPfVRT() { return pfVRT;  }
    public String getPfDoctor() { return pfDoctor;  }
    public String getFName() {  return fName;    }
    public LocalDate getFDOB() { return fDOB;   }
    public boolean getIsOms(){ return isOms;    }
    public ArrayList<FemaleGameteSource> getFgSource() {return fgSource;    }
    public ArrayList<MaleGameteSource> getMgSource() { return mgSource;    }

public CheckPoints getCheckPoints(){return cp;}


    public static class LabProtocolBuilder{

        private final LocalDate pfDate;
        private final Time pfTime;
        private final String pfVRT;
        private final String pfDoctor;
        private final String fName;
        private final boolean isOms;
        private final LocalDate fDOB;

        private String mName;
        private LocalDate mDOB;
        private String mCode;
        private ArrayList<FemaleGameteSource> fgSource = new ArrayList<FemaleGameteSource>();
        private ArrayList<MaleGameteSource> mgSource = new ArrayList<MaleGameteSource>();
        private FolliclePuncture pf;

        private Fertilization fertilization;
        private PgsCryoEt pgsCryoEt;
        private CheckPoints cp;
        private Spermiogramm sperm;
        private CultivationTable cultivation;

        public LabProtocolBuilder(  LocalDate   pfDate,
                Time        pfTime,
                String      pfVRT,
                String      pfDoctor,
                boolean     isOms,
                String      fName,
                LocalDate   fDOB)
        {
            this.pfDate = pfDate;
            this.pfTime = pfTime;
            this.pfVRT = pfVRT;
            this.pfDoctor = pfDoctor;
            this.isOms = isOms;
            this.fName = fName;
            this.fDOB = fDOB;
        }

        public LabProtocolBuilder mName(String      mName,
                LocalDate   mDOB,
                String      mCode)
        {
            this.mName = mName;
            this.mDOB = mDOB;
            this.mCode = mCode;
            return this;
        }
        public LabProtocolBuilder cultivation(CultivationTable ct){this.cultivation = ct; return this;}
        public LabProtocolBuilder spermiogramm(Spermiogramm sp){this.sperm = sp; return this;}
        public LabProtocolBuilder checkPoints(CheckPoints cp){this.cp = cp; return this;}
        public LabProtocolBuilder fertilization(Fertilization fertilization){this.fertilization = fertilization;return this;}
        public LabProtocolBuilder pgsCryoEt(PgsCryoEt pgsCryoEt){this.pgsCryoEt = pgsCryoEt; return this;}
        public LabProtocolBuilder follicle_puncture(FolliclePuncture pf){this.pf = pf;return this;}

        public LabProtocolBuilder fGameteSource(ArrayList<FemaleGameteSource> f)
        { this.fgSource = f; return this;}

        public LabProtocolBuilder addFemaleGameteSource(FemaleGameteSource f){

            if (this.fgSource == null){
                fgSource = new ArrayList<FemaleGameteSource>();
                fgSource.add(f);

            }
            else {
                fgSource.add(f);
            }
            return this;}




        public LabProtocolBuilder mGameteSource(ArrayList<MaleGameteSource> m){
            this.mgSource = m;
            return this;
        }

        public LabProtocolBuilder addMaleGameteSource(MaleGameteSource m){

            if (this.mgSource == null){
                mgSource = new ArrayList<MaleGameteSource>();
                mgSource.add(m);

            }
            else {mgSource.add(m); }
            return this;
        }


        public LabProtocol build(){return new LabProtocol(this);}


    }

    @Override
    public String toString() {
        return "LabProtocol{" +
            "pfDate = " + getPfDate() + 
            ", pfTime = " + getPfTime() +
            ", pfVRT = " + getPfVRT() +
            ", pfDoctor = " + getPfDoctor() +
            ", isOms = " + getIsOms() + "\n" +
            ", fName = " + getFName() +
            ", fDOB = " + getFDOB() + "\n" +
            ", fGsource = " + getFgSource() +"\n"+
            ", mGsource = " + getMgSource() +"\n"+
            ", pf = " + getPf() +"\n" +
            ", fertilization = " + getFertilization() + "\n" +
            ", PgsCryoEt = " + getPgsCryoEt() + "\n" +
", CheckPoints = " + getCheckPoints()+ "\n" +
", Spermiogramm = " + getSpermiogramm()+ "\n" +
", CultivationTable = " + Arrays.deepToString(getDays()) +
            "}";

    }
    public String[][] getDays(){return cultivation.getDays();}
    public Fertilization getFertilization(){ return fertilization; }
    public String getMName() {return mName;}
    public FolliclePuncture getPf() {return pf;    }
}
