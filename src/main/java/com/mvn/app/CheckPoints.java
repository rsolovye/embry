package com.mvn.app;

public class CheckPoints{

    private String fertilizationCheck_embryologist;
    private String mediaChange_embryologist;
    private String cryo_embryologist;
    private String utilization_embryologist;
    private CheckPoints(Builder b){
        this.fertilizationCheck_embryologist = b.fertilizationCheck_embryologist;
        this.mediaChange_embryologist=b.mediaChange_embryologist;
        this.cryo_embryologist = b.cryo_embryologist;
        this.utilization_embryologist = b.utilization_embryologist;
    }

    public static class Builder{
private String fertilizationCheck_embryologist;
    private String mediaChange_embryologist;
    private String cryo_embryologist;
    private String utilization_embryologist;
    public Builder(){}

        public Builder fertilizationCheck_embryologist(String s){
        this.fertilizationCheck_embryologist = s; return this;}
        public Builder mediaChange_embryologist(String s){ 
        this.mediaChange_embryologist=s; return this;}
        public Builder cryo_embryologist(String s){ 
        this.cryo_embryologist = s; return this; }
        public Builder utilization_embryologist(String s){
        this.utilization_embryologist =s;return this;}

        public CheckPoints build(){
            CheckPoints cp = new CheckPoints(this);
            return cp;
        }
    }
    public String getFertilizationCheck_embryologist() {
        return fertilizationCheck_embryologist;
    }

    public String getMediaChange_embryologist() {
        return mediaChange_embryologist;
    }

    public String getCryo_embryologist() {
        return cryo_embryologist;
    }

    public String getUtilization_embryologist() {
        return utilization_embryologist;
    }

    @Override
    public String toString() {
        return "CheckPoints{" +
            "fertilizacionCheck_embryologist = " + getFertilizationCheck_embryologist() +
            ", mediaChange_embryologist = " + getMediaChange_embryologist() +
            ", cryo_embryologist = " + getCryo_embryologist() +
            ", utilization_embryologist = " + getUtilization_embryologist() +
            "}";
    }
}
