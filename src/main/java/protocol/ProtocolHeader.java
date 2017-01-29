package protocol;

import gwtest.FormatRus;
import gwtest.ProtocolHeaderRow;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

/**
 * Created by micro on 19.01.2017.
 */
public class ProtocolHeader {
    private  UUID guid;
    private  LocalDate pfDate;
    private  LocalTime pfTime;
    private  boolean isOms;
    private  String pfDiagnosis;
    private  String pfHeaderNotes;
    private  String pfVRT;
    private  String pfDoctor;
    private  String fName;
    private  LocalDate fDOB;
    private  String fCode;
    private  String mName;
    private  LocalDate mDOB;
    private  String mCode;
    private  String ivfAttempt;


    private ProtocolHeader(ProtocolHeaderBuilder builder) {
        this.guid = builder.guid;
        this.pfDate = builder.pfDate;
        this.pfTime = builder.pfTime;
        this.pfDiagnosis = builder.pfDiagnosis;
        this.pfHeaderNotes = builder.pfHeaderNotes;

        this.pfVRT = builder.pfVRT;
        this.pfDoctor = builder.pfDoctor;
        this.isOms = builder.isOms;

        this.fName = builder.fName;
        this.fDOB = builder.fDOB;
        this.fCode = builder.fCode;

        this.mName = builder.mName;
        this.mDOB = builder.mDOB;
        this.mCode = builder.mCode;
        this.ivfAttempt = builder.ivfAttempt;

    }

    public UUID testNewGuid(){ this.guid = UUID.randomUUID(); return this.guid;}
    public void testNewDoc() {this.pfDoctor = "Шарфи Ю.Н.";}
    public UUID getGuid() {return this.guid;}
    public LocalDate getPfDate() {
        return pfDate;
    }
    public String getIvfAttempt() {return ivfAttempt;}
    public LocalTime getPfTime() {
        return pfTime;
    }

    public String getPfVRT() {
        return pfVRT;
    }

    public String getPfDoctor() {
        return pfDoctor;
    }

    public String getFName() {
        return fName;
    }

    public LocalDate getFDOB() {
        return fDOB;
    }

    public String getIsOms() {
        if (isOms)
        {
            return "1";
        }
        else {
            return "0";
        }
    }

    public String getMName() {
        return mName;
    }

    public LocalDate getMDOB() {
        return mDOB;
    }

    public String getMCode() {
        return mCode;
    }

    public String getFCode() {
        return fCode;
    }

    public String getPfDiagnosis() {
        return pfDiagnosis;
    }

    public String getPfHeaderNotes() {
        return pfHeaderNotes;
    }


    public static class ProtocolHeaderBuilder {
        private UUID guid;
        private String pfDiagnosis;
        private String pfHeaderNotes;
        private LocalDate pfDate;
        private LocalTime pfTime;

        private boolean isOms;
        private String pfVRT;
        private String pfDoctor;

        private String fName;
        private LocalDate fDOB;
        private String fCode;


        private String mName;
        private LocalDate mDOB;
        private String mCode;
         private String ivfAttempt;

        public ProtocolHeaderBuilder(UUID id){
            this.guid = id;
        }
        public ProtocolHeaderBuilder(){
        }
        public ProtocolHeaderBuilder(ProtocolHeaderRow resultSet){

                    buildFromRecordSet(resultSet);

        }

        public ProtocolHeaderBuilder buildFromRecordSet(ProtocolHeaderRow rs){


                guid = UUID.fromString(rs.getString("guid"));
                pfDate = FormatRus.rusDate(rs.getString("pfDate"));
                pfTime = FormatRus.rusTime(rs.getString("pfTime"));
                pfVRT = rs.getString("pfVRT");
                ivfAttempt = rs.getString("ivfAttempt");
                pfDoctor = rs.getString("pfDoctor");
                pfDiagnosis = rs.getString("pfDiagnosis");
                isOms = rs.getBoolean("isOms");
                pfHeaderNotes = rs.getString("pfHeaderNotes");

                fName = rs.getString("fName");
                fDOB = FormatRus.rusDate(rs.getString("fDOB"));
                fCode = rs.getString("fCode");

                mName = rs.getString("mName");
                mDOB = FormatRus.rusDate(rs.getString("mDOB"));
                mCode = rs.getString("mCode");

                return this;


        }
        public ProtocolHeaderBuilder guid(UUID guid) {
            this.guid = guid;
            return this;
        }
        public ProtocolHeaderBuilder ivfAttempt(String ivfAttempt) {
            this.ivfAttempt = ivfAttempt;
            return this;
        }
        public  ProtocolHeaderBuilder pfDiagnosis(String pfDiagnosis) {
            this.pfDiagnosis = pfDiagnosis;
            return this;
        }

        public ProtocolHeaderBuilder pfHeaderNotes(String pfHeaderNotes) {
            this.pfHeaderNotes = pfHeaderNotes;
            return this;
        }

        public ProtocolHeaderBuilder pfDate(LocalDate pfDate) {
            this.pfDate = pfDate;
            return this;
        }

        public ProtocolHeaderBuilder pfTime(LocalTime pfTime) {
            this.pfTime = pfTime;
            return this;
        }

        public ProtocolHeaderBuilder isOms(boolean isOms) {
            this.isOms = isOms;
            return this;
        }

        public ProtocolHeaderBuilder pfVRT(String pfVRT) {
            this.pfVRT = pfVRT;
            return this;
        }

        public ProtocolHeaderBuilder pfDoctor(String pfDoctor) {
            this.pfDoctor = pfDoctor;
            return this;
        }

        public ProtocolHeaderBuilder fName(String fName) {
            this.fName = fName;
            return this;
        }

        public ProtocolHeaderBuilder fDOB(LocalDate fDOB) {
            this.fDOB = fDOB;
            return this;
        }

        public ProtocolHeaderBuilder fCode(String fCode) {
            this.fCode = fCode;
            return this;
        }

        public ProtocolHeaderBuilder mName(String mName) {
            this.mName = mName;
            return this;
        }

        public ProtocolHeaderBuilder mDOB(LocalDate mDOB) {
            this.mDOB = mDOB;
            return this;
        }



        public ProtocolHeaderBuilder mCode(String mCode) {
            this.mCode = mCode;
            return this;
        }
        public ProtocolHeader build(){
            ProtocolHeader ph = new ProtocolHeader(this);

            return ph;
        }

    }

    @Override
    public String toString() {
        return "LabProtocol{" +
                "guid = " + getGuid().toString() + "\n" +
                "pfDate = " + getPfDate() + "\n" +
                ", pfTime = " + getPfTime() + "\n" +
                ", pfVRT = " + getPfVRT() + "\n" +
                ", ivfAttampt = " + getIvfAttempt() + "\n" +
                ", pfDoctor = " + getPfDoctor() + "\n" +
                ", isOms = " + getIsOms() + "\n" +
                ", pfDiagnosis = " + getPfDiagnosis() + "\n" +
                ", pfHeaderNotes = " + getPfHeaderNotes() + "\n" +
                ", fName = " + getFName() + "\n" +
                ", fDOB = " + getFDOB() + "\n" +
                ", fCode = " + getFCode() + "\n" +
                ", mName = " + getMName() + "\n" +
                ", mDOB = " + getMDOB() + "\n" +
                ", mCode = " + getMCode() + "\n" +
                "}";
    }
}

