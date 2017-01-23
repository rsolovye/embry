
package com.mvn.app.protocol;

import java.util.ArrayList;
import java.util.Arrays;

public class LabProtocol {


    private ArrayList<FemaleGameteSource> fgSource;
    private ArrayList<MaleGameteSource> mgSource;

    private FolliclePuncture pf;
    private Fertilization fertilization;
    private PgsCryoEt pgsCryoEt;
    private CheckPoints cp;
    private Spermiogramm sperm;
    private CultivationTable cultivation;


    private LabProtocol(LabProtocolBuilder builder) {


        this.fgSource = builder.fgSource;
        this.mgSource = builder.mgSource;
        this.pf = builder.pf;
        this.fertilization = builder.fertilization;
        this.pgsCryoEt = builder.pgsCryoEt;
        this.cp = builder.cp;
        this.sperm = builder.sperm;
        this.cultivation = builder.cultivation;
    }

    public Spermiogramm getSpermiogramm() {
        return sperm;
    }

    public PgsCryoEt getPgsCryoEt() {
        return pgsCryoEt;
    }

    public ArrayList<FemaleGameteSource> getFgSource() {
        return fgSource;
    }

    public ArrayList<MaleGameteSource> getMgSource() {
        return mgSource;
    }

    public CheckPoints getCheckPoints() {
        return cp;
    }


    public static class LabProtocolBuilder {


        private ArrayList<FemaleGameteSource> fgSource = new ArrayList<FemaleGameteSource>();
        private ArrayList<MaleGameteSource> mgSource = new ArrayList<MaleGameteSource>();
        private FolliclePuncture pf;

        private Fertilization fertilization;
        private PgsCryoEt pgsCryoEt;
        private CheckPoints cp;
        private Spermiogramm sperm;
        private CultivationTable cultivation;


        public LabProtocolBuilder cultivation(CultivationTable ct) {
            this.cultivation = ct;
            return this;
        }

        public LabProtocolBuilder spermiogramm(Spermiogramm sp) {
            this.sperm = sp;
            return this;
        }

        public LabProtocolBuilder checkPoints(CheckPoints cp) {
            this.cp = cp;
            return this;
        }

        public LabProtocolBuilder fertilization(Fertilization fertilization) {
            this.fertilization = fertilization;
            return this;
        }

        public LabProtocolBuilder pgsCryoEt(PgsCryoEt pgsCryoEt) {
            this.pgsCryoEt = pgsCryoEt;
            return this;
        }

        public LabProtocolBuilder follicle_puncture(FolliclePuncture pf) {
            this.pf = pf;
            return this;
        }

        public LabProtocolBuilder fGameteSource(ArrayList<FemaleGameteSource> f) {
            this.fgSource = f;
            return this;
        }

        public LabProtocolBuilder addFemaleGameteSource(FemaleGameteSource f) {

            if (this.fgSource == null) {
                fgSource = new ArrayList<FemaleGameteSource>();
                fgSource.add(f);

            } else {
                fgSource.add(f);
            }
            return this;
        }


        public LabProtocolBuilder mGameteSource(ArrayList<MaleGameteSource> m) {
            this.mgSource = m;
            return this;
        }

        public LabProtocolBuilder addMaleGameteSource(MaleGameteSource m) {

            if (this.mgSource == null) {
                mgSource = new ArrayList<MaleGameteSource>();
                mgSource.add(m);

            } else {
                mgSource.add(m);
            }
            return this;
        }


        public LabProtocol build() {
            return new LabProtocol(this);
        }


    }

    @Override
    public String toString() {
        return "LabProtocol{" +
                ", fGsource = " + getFgSource() + "\n" +
                ", mGsource = " + getMgSource() + "\n" +
                ", pf = " + getPf() + "\n" +
                ", fertilization = " + getFertilization() + "\n" +
                ", PgsCryoEt = " + getPgsCryoEt() + "\n" +
                ", CheckPoints = " + getCheckPoints() + "\n" +
                ", Spermiogramm = " + getSpermiogramm() + "\n" +
                ", CultivationTable = " + Arrays.deepToString(getDays()) +
                "}";

    }

    public String[][] getDays() {
        return cultivation.getDays();
    }

    public Fertilization getFertilization() {
        return fertilization;
    }

    public FolliclePuncture getPf() {
        return pf;
    }
}
