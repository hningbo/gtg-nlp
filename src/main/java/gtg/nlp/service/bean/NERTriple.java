package gtg.nlp.service.bean;

public class NERTriple {
    private String entity;

    private String name;

    private int sentencenum;

    public NERTriple(String entity, String name, int sentencenum) {
        this.entity = entity;
        this.name = name;
        this.sentencenum = sentencenum;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSentencenum() {
        return sentencenum;
    }

    public void setSentencenum(int sentencenum) {
        this.sentencenum = sentencenum;
    }

}
