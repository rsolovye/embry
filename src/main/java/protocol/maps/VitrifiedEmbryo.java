package protocol.maps;

import javafx.beans.property.SimpleStringProperty;

import java.util.HashMap;

/**
 * Created by micro on 02.02.2017.
 */
public class VitrifiedEmbryo {


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
    private HashMap<String, SimpleStringProperty> map = new HashMap<>();
    private VitrifiedEmbryo(VitrifiedEmbryoBuilder b) {
        guid = b.guid;
        strawNumber = b.strawNumber;
        embryoNumber = b.embryoNumber;
        cryoDpf = b.cryoDpf;
        cryoStage = b.cryoStage;
        cryoNotes = b.cryoNotes;
        cryoEmbryologist = b.cryoEmbryologist;
        defrostDate = b.defrostDate;
        defrostEmbryo = b.defrostEmbryo;
        defrostMedia = b.defrostMedia;
        defrostEmbryologist = b.defrostEmbryologist;
        defrostSurvival = b.defrostSurvival;
        map.put("guid", b.guid);
        map.put("strawNumber", b.strawNumber);
        map.put("embryoNumber", b.embryoNumber);
        map.put("cryoDpf", b.cryoDpf);
        map.put("cryoStage", b.cryoStage);
        map.put("cryoNotes", b.cryoNotes);
        map.put("cryoEmbryologist", b.cryoEmbryologist);
        map.put("defrostDate", b.defrostDate);
        map.put("defrostEmbryo", b.defrostEmbryo);
        map.put("defrostMedia", b.defrostMedia);
        map.put("defrostEmbryologist", b.defrostEmbryologist);
        map.put("defrostSurvival", b.defrostSurvival);
    }
    public HashMap<String, SimpleStringProperty> getMap(){
        return this.map;
    }
    public String getGuid() {
        return guid.get();
    }

    public void setGuid(String guid) {
        this.guid.set(guid);
    }

    public String getStrawNumber() {
        return strawNumber.get();
    }

    public void setStrawNumber(String strawNumber) {
        this.strawNumber.set(strawNumber);
    }

    public String getEmbryoNumber() {
        return embryoNumber.get();
    }

    public void setEmbryoNumber(String embryoNumber) {
        this.embryoNumber.set(embryoNumber);
    }

    public String getCryoDpf() {
        return cryoDpf.get();
    }

    public void setCryoDpf(String cryoDpf) {
        this.cryoDpf.set(cryoDpf);
    }

    public String getCryoStage() {
        return cryoStage.get();
    }

    public void setCryoStage(String cryoStage) {
        this.cryoStage.set(cryoStage);
    }

    public String getCryoNotes() {
        return cryoNotes.get();
    }

    public void setCryoNotes(String cryoNotes) {
        this.cryoNotes.set(cryoNotes);
    }

    public String getCryoEmbryologist() {
        return cryoEmbryologist.get();
    }

    public void setCryoEmbryologist(String cryoEmbryologist) {
        this.cryoEmbryologist.set(cryoEmbryologist);
    }

    public String getDefrostDate() {
        return defrostDate.get();
    }

    public void setDefrostDate(String defrostDate) {
        this.defrostDate.set(defrostDate);
    }

    public String getDefrostEmbryo() {
        return defrostEmbryo.get();
    }

    public void setDefrostEmbryo(String defrostEmbryo) {
        this.defrostEmbryo.set(defrostEmbryo);
    }

    public String getDefrostEmbryologist() {
        return defrostEmbryologist.get();
    }

    public void setDefrostEmbryologist(String defrostEmbryologist) {
        this.defrostEmbryologist.set(defrostEmbryologist);
    }

    public String getDefrostSurvival() {
        return defrostSurvival.get();
    }

    public void setDefrostSurvival(String defrostSurvival) {
        this.defrostSurvival.set(defrostSurvival);
    }

    public String getDefrostMedia() {
        return defrostMedia.get();
    }

    public void setDefrostMedia(String defrostMedia) {
        this.defrostMedia.set(defrostMedia);
    }

    public SimpleStringProperty getDefrostEmbryologistProperty() {
        return this.defrostEmbryologist;

    }

    public SimpleStringProperty get(String columnName) {
        return map.get(columnName);
    }

    public void set(String columnName, SimpleStringProperty value) {
        map.put(columnName, value);
    }

    public static class VitrifiedEmbryoBuilder {
        private final SimpleStringProperty guid;
        private final SimpleStringProperty strawNumber;
        private final SimpleStringProperty embryoNumber;
        private SimpleStringProperty cryoDpf;
        private SimpleStringProperty cryoStage;
        private SimpleStringProperty cryoNotes;
        private SimpleStringProperty cryoEmbryologist;

        private SimpleStringProperty defrostDate;
        private SimpleStringProperty defrostEmbryo;
        private SimpleStringProperty defrostEmbryologist;
        private SimpleStringProperty defrostSurvival;
        private SimpleStringProperty defrostMedia;

        public VitrifiedEmbryoBuilder(String guid, String strawNumber, String embryoNumber) {
            this.guid = new SimpleStringProperty(guid);
            this.strawNumber = new SimpleStringProperty(strawNumber);
            this.embryoNumber = new SimpleStringProperty(embryoNumber);
        }

        public VitrifiedEmbryoBuilder cryoDpf(String s) {
            this.cryoDpf = new SimpleStringProperty(s);
            return this;
        }

        public VitrifiedEmbryoBuilder cryoStage(String s) {
            this.cryoStage = new SimpleStringProperty(s);
            return this;
        }

        public VitrifiedEmbryoBuilder cryoNotes(String s) {
            this.cryoNotes = new SimpleStringProperty(s);
            return this;
        }

        public VitrifiedEmbryoBuilder cryoEmbryologist(String s) {
            this.cryoEmbryologist = new SimpleStringProperty(s);
            return this;
        }

        public VitrifiedEmbryoBuilder defrostDate(String s) {
            this.defrostDate = new SimpleStringProperty(s);
            return this;
        }

        public VitrifiedEmbryoBuilder defrostEmbryo(String s) {
            this.defrostEmbryo = new SimpleStringProperty(s);
            return this;
        }

        public VitrifiedEmbryoBuilder defrostEmbryologist(String s) {
            this.defrostEmbryologist = new SimpleStringProperty(s);
            return this;
        }

        public VitrifiedEmbryoBuilder defrostSurvival(String s) {
            this.defrostSurvival = new SimpleStringProperty(s);
            return this;
        }

        public VitrifiedEmbryoBuilder defrostMedia(String s) {
            this.defrostMedia = new SimpleStringProperty(s);
            return this;
        }

        public VitrifiedEmbryo build() {
            VitrifiedEmbryo ve = new VitrifiedEmbryo(this);
            return ve;
        }
    }
}
