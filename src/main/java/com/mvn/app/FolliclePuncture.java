package com.mvn.app;

public class FolliclePuncture{


    private final String embryologist;
    private final String nurse;
    private final int egg_count;
    private final int labProtocolID;

    private FolliclePuncture(Builder b){

        this.embryologist = b.embryologist;
        this.nurse = b.nurse;
        this.egg_count = b.egg_count;
        this.labProtocolID = b.labProtocolID;
    }

    public String getEmbryologist() {
        return embryologist;
    }

    public String getNurse() {
        return nurse;
    }

    public int getEgg_count() {
        return egg_count;
    }
    public int getLabProtocolID() {return labProtocolID;}
    @Override
    public String toString() {
        return "FolliclePuncture{" +
            "labProtocolID = " + getLabProtocolID() +
                "embryologist = " + getEmbryologist() +
            ", nurse = " + getNurse() +
            ", egg_count = " + getEgg_count() +
            "}";
    }
    public static class Builder{
        private String embryologist;
        private String nurse;
        private int egg_count;
        private int labProtocolID;

        public Builder(String embryologist, String nurse, int egg_count){
            this.embryologist = embryologist;
            this.nurse = nurse;
            this.egg_count = egg_count;

        }
        public Builder(){
        //    this.egg_count = egg_count;

        }
        public Builder labProtocolID(int labProtocolID){
            this.labProtocolID = labProtocolID;
            return this;
        }
        public Builder embryologist(String embryologist){

            this.embryologist = embryologist;
            return this;
        }
        public Builder nurse(String nurse){

            this.nurse = nurse;
            return this;
        }
        public Builder eggCount(int egg_count){
            this.egg_count = egg_count;
            return this;
        }
        public FolliclePuncture build(){
            return new FolliclePuncture(this);
        }
    }}
