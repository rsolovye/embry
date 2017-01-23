package protocol;

public class FemaleGameteSource{
    private final  String source;
    private String state;
    private String cryoDate;
    private String witness;
    private String count;

    private FemaleGameteSource(Builder b){
        this.source = b.source;
        this.state = b.state;
        this.cryoDate = b.cryoDate;
        this.witness = b.witness;
        this.count = b.count;

    }
   
           @Override
        public String toString() {
            return "FemaleGameteSource{" +
                "source = " + source +
                ", state = " + state +
                ", cryoDate = " + cryoDate +
                ", witness = " + witness +
                ", count = " + count +
                "}";
        }
 
    public String getCount() {
        return count;
    }

    public String getSource() {
        return source;
    }

    public String getState() {
        return state;
    }


    public String getCryoDate() {
        return cryoDate;
    }


    public String getWitness() {
        return witness;
    }


    public void setCount(String count) {
        this.count = count;

    }
 public static class Builder{
        private final  String source;
        private String state;
        private String cryoDate;
        private String witness;
        private String count;

        public Builder(String source){
            this.source = source;
        }


        public Builder state(String s){this.state=s;   return this;  }
        public Builder cryoDate(String s){this.cryoDate=s;   return this;  }
        public Builder witness(String s){this.witness=s;   return this;  }
        public Builder count(String s){this.count=s;   return this;  }

        public FemaleGameteSource build(){
            return new FemaleGameteSource(this);
        }


   }
}
