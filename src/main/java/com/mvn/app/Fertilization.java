package com.mvn.app;

import java.sql.Time;

public class Fertilization{

    private final  String type;
    private String embryologist;
    private Time time1, time2;
    private String witness1, witness2;

    private Fertilization(Builder b){
        this.type = b.type;
        this.embryologist = b.embryologist;
        this.time1 = b.time1;
        this.time2 = b.time2;
        this.witness1 = b.witness1;
        this.witness2 = b.witness2;
    }
    public static class Builder{

        private final  String type;
        private String embryologist;
        private Time time1, time2;
        private String witness1, witness2;
        public Builder(String type){
            this.type = type;
        }

        public Fertilization build(){return new Fertilization(this);}

        public Builder time1(Time time1){ this.time1 = time1; return this; }
        public Builder time2(Time time2){ this.time2 = time2; return this; }

        public Builder embryologist(String embryologist){ this.embryologist = embryologist; return this; }


        public Builder witness2(String witness2){ this.witness2 = witness2; return this; }
        public Builder witness1(String witness1){ this.witness1 = witness1; return this; }


    }
    @Override
    public String toString() {
        return "Fertilization{" +
            "type = " + type +
            ", embryologist = " + embryologist +
            ", time1 = " + time1 +
            ", time2 = " + time2 +
            ", witness1 = " + witness1 +
            ", witness2 = " + witness2 +
            "}";
    }
}
