package protocol.maps;

import javafx.beans.property.SimpleStringProperty;
import services.Visitable;

/**
 * Created by micro on 02.02.2017.
 */
public class VitrifiedEmbryo {


    public String getGuid() {
        return guid.get();
    }

    public String getStrawNumber() {
        return strawNumber.get();
    }

    public String getEmbryoNumber() {
        return embryoNumber.get();
    }

    public String getCryoDpf() {
        return cryoDpf.get();
    }

    public String getCryoStage() {
        return cryoStage.get();
    }

    public String getCryoNotes() {
        return cryoNotes.get();
    }

    public String getCryoEmbryologist() {
        return cryoEmbryologist.get();
    }

    public String getDefrostDate() {
        return defrostDate.get();
    }

    public String getDefrostEmbryo() {
        return defrostEmbryo.get();
    }

    public String getDefrostEmbryologist() {
        return defrostEmbryologist.get();
    }

    public String getDefrostSurvival() {
        return defrostSurvival.get();
    }
    public String getDefrostMedia() {
        return defrostMedia.get();
    }

    private final SimpleStringProperty guid;
    private final SimpleStringProperty strawNumber;
    private final SimpleStringProperty embryoNumber;
    private final SimpleStringProperty cryoDpf;
    private final SimpleStringProperty cryoStage;
    private final SimpleStringProperty cryoNotes;
    private final SimpleStringProperty cryoEmbryologist;

    private final SimpleStringProperty defrostDate;
    private final SimpleStringProperty defrostEmbryo;
    private final SimpleStringProperty defrostEmbryologist;
    private final SimpleStringProperty defrostSurvival;
    private final SimpleStringProperty defrostMedia;

    private VitrifiedEmbryo(VitrifiedEmbryoBuilder b){
          guid = b.guid;
          strawNumber = b.strawNumber;
          embryoNumber=b.embryoNumber;
          cryoDpf=b.cryoDpf;
          cryoStage=b.cryoStage;
          cryoNotes=b.cryoNotes;
          cryoEmbryologist=b.cryoEmbryologist;
          defrostDate=b.defrostDate;
          defrostEmbryo=b.defrostEmbryoQuality;
          defrostMedia = b.defrostMedia;
          defrostEmbryologist=b.defrostEmbryologist;
          defrostSurvival=b.defrostSurvival;
    }

    public static class  VitrifiedEmbryoBuilder{
        private final SimpleStringProperty guid;
        private final SimpleStringProperty strawNumber;
        private final SimpleStringProperty embryoNumber;
        private  SimpleStringProperty cryoDpf;
        private  SimpleStringProperty cryoStage;
        private  SimpleStringProperty cryoNotes;
        private  SimpleStringProperty cryoEmbryologist;

        private  SimpleStringProperty defrostDate;
        private  SimpleStringProperty defrostEmbryoQuality;
        private  SimpleStringProperty defrostEmbryologist;
        private  SimpleStringProperty defrostSurvival;
        private  SimpleStringProperty defrostMedia;

        public VitrifiedEmbryoBuilder(String guid, String strawNumber, String embryoNumber){
            this.guid = new SimpleStringProperty(guid);
            this.strawNumber =  new SimpleStringProperty(strawNumber);
            this.embryoNumber = new SimpleStringProperty(embryoNumber);
        }

        public VitrifiedEmbryoBuilder cryoDpf(String s){this.cryoDpf = new SimpleStringProperty(s); return this;}
        public VitrifiedEmbryoBuilder cryoStage(String s){this.cryoStage = new SimpleStringProperty(s); return this;}
        public VitrifiedEmbryoBuilder cryoNotes(String s){this.cryoNotes = new SimpleStringProperty(s); return this;}
        public VitrifiedEmbryoBuilder cryoEmbryologist(String s){this.cryoEmbryologist = new SimpleStringProperty(s); return this;}
        public VitrifiedEmbryoBuilder defrostDate(String s){this.defrostDate = new SimpleStringProperty(s); return this;}
        public VitrifiedEmbryoBuilder defrostEmbryoQuality(String s){this.defrostEmbryoQuality = new SimpleStringProperty(s); return this;}
        public VitrifiedEmbryoBuilder defrostEmbryologist(String s){this.defrostEmbryologist = new SimpleStringProperty(s); return this;}
        public VitrifiedEmbryoBuilder defrostSurvival(String s){this.defrostSurvival = new SimpleStringProperty(s); return this;}
        public VitrifiedEmbryoBuilder defrostMedia(String s){this.defrostMedia = new SimpleStringProperty(s); return this;}

        public VitrifiedEmbryo build(){
            VitrifiedEmbryo ve = new VitrifiedEmbryo(this);
            //System.out.println("I AM BUILTTTTT " + defrostEmbryoQuality);
            return ve;
        }
    }
}
