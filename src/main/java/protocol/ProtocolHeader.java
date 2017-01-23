package protocol;

import java.sql.Time;
import java.time.LocalDate;

/**
 * Created by micro on 19.01.2017.
 */
public class ProtocolHeader {

    private final LocalDate pfDate;
    private final Time pfTime;
    private final boolean isOms;
    private final String pfDiagnosis;
    private final String pfHeaderNotes;
    private final String pfVRT;
    private final String pfDoctor;
    private final String fName;
    private final LocalDate fDOB;
    private final int fCode;
    private final String mName;
    private final LocalDate mDOB;
    private int mCode;


    private ProtocolHeader(ProtocolHeaderBuilder builder) {

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

    }

    public LocalDate getPfDate() {
        return pfDate;
    }

    public Time getPfTime() {
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

    public boolean getIsOms() {
        return isOms;
    }

    public String getMName() {
        return mName;
    }

    public LocalDate getMDOB() {
        return mDOB;
    }

    public int getMCode() {
        return mCode;
    }

    public int getFCode() {
        return fCode;
    }

    public String getPfDiagnosis() {
        return pfDiagnosis;
    }

    public String getPfHeaderNotes() {
        return pfHeaderNotes;
    }


    public static class ProtocolHeaderBuilder {

        private String pfDiagnosis;
        private String pfHeaderNotes;
        private LocalDate pfDate;
        private Time pfTime;

        private boolean isOms;
        private String pfVRT;
        private String pfDoctor;

        private String fName;
        private LocalDate fDOB;
        private int fCode;


        private String mName;
        private LocalDate mDOB;
        private int mCode;

        private ProtocolHeaderBuilder pfDiagnosis(String pfDiagnosis) {
            this.pfDiagnosis = pfDiagnosis;
            return this;
        }

        private ProtocolHeaderBuilder pfHeaderNotes(String pfHeaderNotes) {
            this.pfHeaderNotes = pfHeaderNotes;
            return this;
        }

        private ProtocolHeaderBuilder pfDate(LocalDate pfDate) {
            this.pfDate = pfDate;
            return this;
        }

        private ProtocolHeaderBuilder pfTime(Time pfTime) {
            this.pfTime = pfTime;
            return this;
        }

        private ProtocolHeaderBuilder isOms(boolean isOms) {
            this.isOms = isOms;
            return this;
        }

        private ProtocolHeaderBuilder pfVRT(String pfVRT) {
            this.pfVRT = pfVRT;
            return this;
        }

        private ProtocolHeaderBuilder pfDoctor(String pfDoctor) {
            this.pfDoctor = pfDoctor;
            return this;
        }

        private ProtocolHeaderBuilder fName(String fName) {
            this.fName = fName;
            return this;
        }

        private ProtocolHeaderBuilder fDOB(LocalDate fDOB) {
            this.fDOB = fDOB;
            return this;
        }

        private ProtocolHeaderBuilder fCode(int fCode) {
            this.fCode = fCode;
            return this;
        }

        private ProtocolHeaderBuilder mName(String mName) {
            this.mName = mName;
            return this;
        }

        private ProtocolHeaderBuilder mDOB(LocalDate mDOB) {
            this.mDOB = mDOB;
            return this;
        }

        private ProtocolHeaderBuilder mCode(int mCode) {
            this.mCode = mCode;
            return this;
        }

    }

    @Override
    public String toString() {
        return "LabProtocol{" +
                "pfDate = " + getPfDate() + "\n" +
                ", pfTime = " + getPfTime() + "\n" +
                ", pfVRT = " + getPfVRT() + "\n" +
                ", pfDoctor = " + getPfDoctor() + "\n" +
                ", isOms = " + getIsOms() + "\n" +
                ", pfDiagnosis = " + getPfDiagnosis() + "\n" +
                ", pfHeaderNotes = " + getPfHeaderNotes() + "\n" +
                ", fName = " + getFName() + "\n" +
                ", fDOB = " + getFDOB() + "\n" +
                ", fCode = " + getFCode() + "\n" +
                ", mName = " + getMName() + "\n" +
                ", mDOB = " + getMDOB() + "\n" +
                ", mCode = " + getMCode() +
                "}";
    }
}

