package protocol;

public class MaleGameteSource{
        private final  String source;
    private String state;
    private String cryoDate;
    private String witness;
    private String procedure;

    private MaleGameteSource(Builder b){
        this.source = b.source;
        this.state = b.state;
        this.cryoDate = b.cryoDate;
        this.witness = b.witness;
            this.procedure = b.procedure;

    }
    public static class Builder{
        private final  String source;
        private String state;
        private String cryoDate;
        private String witness;
        private String procedure;

        public Builder(String source){
            this.source = source;
        }


        public Builder state(String s){this.state=s;   return this;  }
        public Builder cryoDate(String s){this.cryoDate=s;   return this;  }
        public Builder witness(String s){this.witness=s;   return this;  }
        public Builder procedure(String s){this.procedure=s;   return this;  }

        public MaleGameteSource build(){
            return new MaleGameteSource(this);
        }

   }
    public String getProcedure() {
        return procedure;
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


    public void setProcedure(String procedure) {
        this.procedure = procedure;
    
    }
    
    @Override
    public String toString() {
        return "MaleGameteSource{" +
            "source = " + source +
            ", state = " + state +
            ", cryoDate = " + cryoDate +
            ", witness = " + witness +
            ", procedure = " + procedure +
            "}";
    }
 
}
