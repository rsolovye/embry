package protocol.old.pojos;

import gwtest.FormatRus;

import java.util.UUID;

public class FemaleGameteSource{
    private final  String source;
    private String materialType;
    private String cryoDate;
    private String witness;
    private String expectedFollicleCount;

    private FemaleGameteSource(Builder b){
        this.source = b.source;
        this.materialType = b.materialType;
        this.cryoDate = b.cryoDate;
        this.witness = b.witness;
        this.expectedFollicleCount = b.expectedFollicleCount;

    }
   
           @Override
        public String toString() {
            return "FemaleGameteSource{" +
                "source = " + source +
                ", state = " + materialType +
                ", cryoDate = " + cryoDate +
                ", witness = " + witness +
                ", count = " + expectedFollicleCount +
                "}";
        }
 
    public String getExpectedFollicleCount() {
        return expectedFollicleCount;
    }

    public String getSource() {
        return source;
    }

    public String getMaterialType() {
        return materialType;
    }


    public String getCryoDate() {
        return cryoDate;
    }


    public String getWitness() {
        return witness;
    }


    public void setCount(String count) {
        this.expectedFollicleCount = count;

    }
 public static class Builder{
        private UUID guid;
        private String source;
        private String materialType;
        private String cryoDate;
        private String witness;
        private String expectedFollicleCount;

        public Builder() {

        }

//        public Builder buildFromRowSet(FemaleGameteSourceRow row){
//            this.guid = UUID.fromString(row.get("guid"));
//            this.source = row.get("source");
//            this.materialType = row.get("material_type");
//            this.cryoDate = FormatRus.rusDate(row.get("cryo_date")).toString();
//            this.expectedFollicleCount = row.get("expected_follicle_count");
//            return this;
//            // private static final String[] FEMALE_SOURCES_KEYS={"guid",
//            // "source", "material_type", "cryo_date", "expected_follicle_count"};

//        }
//        public Builder setSource(String source){
//            this.source = source; return this;
//        }
//
//        public Builder setGuid(UUID guid){ this.guid = guid; return this;}
//
//        public Builder materialType(String s){this.materialType=s;   return this;  }
//        public Builder cryoDate(String s){this.cryoDate=s;   return this;  }
//        public Builder witness(String s){this.witness=s;   return this;  }
//        public Builder expectedFollicleCount(String s){this.expectedFollicleCount=s;   return this;  }
//
//        public FemaleGameteSource build(){
//            return new FemaleGameteSource(this);
//        }


   }
}
