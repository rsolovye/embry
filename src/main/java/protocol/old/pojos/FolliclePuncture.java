package protocol.old.pojos;



import gwtest.RowObject;

import java.util.UUID;

public class FolliclePuncture{


    private final String embryologist;
    private final String nurse;
    private final String egg_count;
    private final UUID guid;

    private FolliclePuncture(Builder b){

        this.embryologist = b.embryologist;
        this.nurse = b.nurse;
        this.egg_count = b.egg_count;
        this.guid = b.guid;
    }

    public String getEmbryologist() {
        return embryologist;
    }

    public String getNurse() {
        return nurse;
    }

    public String getEgg_count() {
        return egg_count;
    }
    public UUID getGuid() {return guid;}
    @Override
    public String toString() {
        return "FolliclePuncture{" +
            "labProtocolID = " + getGuid().toString() +
                "embryologist = " + getEmbryologist() +
            ", nurse = " + getNurse() +
            ", egg_count = " + getEgg_count() +
            "}";
    }
    public static class Builder{
        private String embryologist;
        private String nurse;
        private String egg_count;
        private UUID guid;

        public Builder(){

        }

        public Builder builderFromRowSet(RowObject row){
            this.guid = UUID.fromString(row.get("guid"));
            this.embryologist = row.get("embryologist");
            this.nurse = row.get("nurse");
            this.egg_count = row.get("harvested_count");
            return this;
        }

        public Builder guid(UUID guid){
            this.guid = guid;
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
        public Builder eggCount(String egg_count){
            this.egg_count = egg_count;
            return this;
        }
        public FolliclePuncture build(){
            return new FolliclePuncture(this);
        }
    }}
