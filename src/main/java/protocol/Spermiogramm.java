package protocol;

import java.sql.Time;

public class Spermiogramm{

    private Time time1, time2, time3;
    private String concentration, volume, viscosity, morphology, ab1, c1, d1, ab2, c2, d2, concentration2, volume07, volume10, method, embryologist, comment;

    private Spermiogramm(Builder b){ this.time1 = b.time1;
        this.time2= b.time2;
        this.time3 = b.time3;
        this.concentration = b.concentration;
        this.volume = b.volume;
        this.viscosity = b.viscosity;
        this.morphology = b.morphology;
        this.ab1 = b.ab1;
        this.c1 = b.c1;
        this.d1 = b.d1;
        this.ab2 = b.ab2;
        this.c2 =b.c2;
        this.d2=b.d2;
        this.concentration2 = b.concentration2;
        this.volume07 = b.volume07;
        this.volume10 = b.volume10;
        this.method = b.method;
        this.embryologist = b.embryologist;
        this.comment = b.comment;
    }

    public static class Builder{

        private Time time1, time2, time3;
        private String concentration, volume, viscosity, morphology, ab1, c1, d1, ab2, c2, d2, concentration2, volume07, volume10, method, embryologist, comment;

        public Builder() {}

        public Builder concentration(String s){this.concentration = s; return this;}
        public Builder volume(String s){this.volume= s; return this;}
        public Builder morphology(String s){this.morphology= s; return this;}
        public Builder viscosity(String s){this.viscosity = s; return this;}
        public Builder ab1(String s){this.ab1 = s; return this;}
        public Builder c1(String s){this.c1 = s; return this;}
        public Builder d1(String s){this.d1 = s; return this;}

        public Builder ab2(String s){this.ab2 = s; return this;}
        public Builder c2(String s){this.c2 = s; return this;}
        public Builder d2(String s){this.d2 = s; return this;}
        public Builder concentration2(String s){this.concentration2 = s; return this;}
        public Builder volume07(String s){this.volume07 = s; return this;}
        public Builder volume10(String s){this.volume10 = s; return this;}
        public Builder method(String s){this.method = s; return this;}

        public Builder embryologist(String s){this.embryologist = s; return this;}
        public Builder comment(String s){this.comment = s; return this;}
        public Builder time1(Time s){this.time1 = s; return this;}
        public Builder time2(Time s){this.time2 = s; return this;}
        public Builder time3(Time s){this.time3 = s; return this;}
        public Spermiogramm build(){
            Spermiogramm sp = new Spermiogramm(this);
            return sp;
        }
    }

    @Override
    public String toString() {
        return "Spermiogramm{" +
            "time1 = " + time1 +
            ", time2 = " + time2 +
            ", time3 = " + time3 +
            ", concentration = " + concentration +
            ", volume = " + volume +
            ", viscosity = " + viscosity +
            ", morphology = " + morphology +
            ", ab1 = " + ab1 +
            ", c1 = " + c1 +
            ", d2 = " + d2 +
            ", ab2 = " + ab2 +
            ", c2 = " + c2 +
            ", d2 = " + d2 +
            ", concetration2 = " + concentration2 +
            ", volume07 = " + volume07 +
            ", volume10 = " + volume10 +
            ", method = " + method +
            ", embryologist = " + embryologist +
            ", comment = " + comment +
            "}";
    }

    public Time getTime1() {
        return time1;
    }

    public Time getTime2() {
        return time2;
    }

    public Time getTime3() {
        return time3;
    }

    public String getConcentration() {
        return concentration;
    }

    public String getVolume() {
        return volume;
    }

    public String getViscosity() {
        return viscosity;
    }

    public String getMorphology() {
        return morphology;
    }

    public String getAb1() {
        return ab1;
    }

    public String getC1() {
        return c1;
    }

    public String getD2() {
        return d2;
    }

    public String getAb2() {
        return ab2;
    }

    public String getC2() {
        return c2;
    }

    public String getD1() {
        return d1;
    }

    public String getConcentration2() {
        return concentration2;
    }

    public String getVolume07() {
        return volume07;
    }

    public String getVolume10() {
        return volume10;
    }

    public String getMethod() {
        return method;
    }

    public String getEmbryologist() {
        return embryologist;
    }

    public String getComment() {
        return comment;
    }
}
