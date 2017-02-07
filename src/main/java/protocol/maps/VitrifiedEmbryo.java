package protocol.maps;

import javafx.beans.property.SimpleStringProperty;

import java.util.HashMap;

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

    public void setGuid(String guid) {
        this.guid.set(guid);
    }

    public void setStrawNumber(String strawNumber) {
        this.strawNumber.set(strawNumber);
    }

    public void setEmbryoNumber(String embryoNumber) {
        this.embryoNumber.set(embryoNumber);
    }

    public void setCryoDpf(String cryoDpf) {
        this.cryoDpf.set(cryoDpf);
    }

    public void setCryoStage(String cryoStage) {
        this.cryoStage.set(cryoStage);
    }

    public void setCryoNotes(String cryoNotes) {
        this.cryoNotes.set(cryoNotes);
    }

    public void setCryoEmbryologist(String cryoEmbryologist) {
        this.cryoEmbryologist.set(cryoEmbryologist);
    }

    public void setDefrostEmbryo(String defrostEmbryo) {
        this.defrostEmbryo.set(defrostEmbryo);
    }

    public void setDefrostSurvival(String defrostSurvival) {
        this.defrostSurvival.set(defrostSurvival);
    }

    public void setDefrostMedia(String defrostMedia) {
        this.defrostMedia.set(defrostMedia);
    }

    private final SimpleStringProperty cryoDpf;
    private final SimpleStringProperty cryoStage;
    private final SimpleStringProperty cryoNotes;
    private final SimpleStringProperty cryoEmbryologist;

    public void setDefrostDate(String defrostDate) {
        this.defrostDate.set(defrostDate);
    }

    private final SimpleStringProperty defrostDate;
    private final SimpleStringProperty defrostEmbryo;

    public void setDefrostEmbryologist(String defrostEmbryologist) {
        this.defrostEmbryologist.set(defrostEmbryologist);
    }

    public SimpleStringProperty getDefrostEmbryologistProperty() {
        return this.defrostEmbryologist;

    }

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
        defrostEmbryo = b.defrostEmbryoQuality;
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
        map.put("defrostEmbryo", b.defrostEmbryoQuality);
        map.put("defrostMedia", b.defrostMedia);
        map.put("defrostEmbryologist", b.defrostEmbryologist);
        map.put("defrostSurvival", b.defrostSurvival);
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
        private SimpleStringProperty defrostEmbryoQuality;
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

        public VitrifiedEmbryoBuilder defrostEmbryoQuality(String s) {
            this.defrostEmbryoQuality = new SimpleStringProperty(s);
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
