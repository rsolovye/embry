package protocol.old.pojos;

public class PgsCryoEt{
    private String etDay;
    private String etNote;
    private String cryoPlans;
    private int cryoStraws;
    private int cryoEmbryos;
    private String pgsType;
    private String pgsNote1;
    private String pgsNote2;
    
    private PgsCryoEt(Builder b){
        this.etDay = b.etDay;

        this.etNote = b.etNote;
        this.cryoPlans = b.cryoPlans;   
        this.cryoStraws = b.cryoStraws;
        this.cryoEmbryos = b.cryoEmbryos;
        this.pgsType = b.pgsType;
        this.pgsNote1 = b.pgsNote1;
        this.pgsNote2 = b.pgsNote2;
    }

    public static class Builder{
         private String etDay;
    private String etNote;
    private String cryoPlans;
    private int cryoStraws;
    private int cryoEmbryos;
    private String pgsType;
    private String pgsNote1;
    private String pgsNote2;
    
        public Builder(){}


        public Builder etDay(String s){  this.etDay=s;   return this;}    
        public Builder etNote(String s){  this.etNote=s;   return this;}    
        public Builder cryoPlans(String s){  this.cryoPlans=s;   return this;}    
        public Builder cryoStraws(int s){  this.cryoStraws=s;   return this;}    
        public Builder cryoEmbryos(int s){  this.cryoEmbryos=s;   return this;}    
        public Builder pgsType(String s){  this.pgsType=s;   return this;}    
        public Builder pgsNote1(String s){  this.pgsNote1=s;   return this;}    
        public Builder pgsNote2(String s){  this.pgsNote2=s;   return this;}    
        public PgsCryoEt build(){
            PgsCryoEt pce = new PgsCryoEt(this);
            return pce;
        } 
    }
    @Override
    public String toString() {
        return "PgsCryoEt{" +
            "etDay = " + etDay +
            ", etNote = " + etNote +
            ", cryoPlans = " + cryoPlans +
            ", cryoStraws = " + cryoStraws +
            ", cryoEmbryos = " + cryoEmbryos +
            ", pgsType = " + pgsType +
            ", pgsNote1 = " + pgsNote1 +
            ", pgsNote2 = " + pgsNote2 +
            "}";
    }

    public String getEtDay() {
        return etDay;
    }

    public String getEtNote() {
        return etNote;
    }

    public String getCryoPlans() {
        return cryoPlans;
    }

    public int getCryoStraws() {
        return cryoStraws;
    }

    public int getCryoEmbryos() {
        return cryoEmbryos;
    }

    public String getPgsType() {
        return pgsType;
    }

    public String getPgsNote1() {
        return pgsNote1;
    }

    public String getPgsNote2() {
        return pgsNote2;
    }
}
