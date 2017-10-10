package gtg.nlp.common.entity;

import edu.stanford.nlp.coref.data.CorefChain;
import gtg.nlp.service.bean.NERTriple;

import java.util.List;

public class SentenceInfo {
    private List<Claim> claim;
    private List<CorefChain> coref;
    private List<NERTriple> triples;
    private int sentencenum;

    public int getSentencenum() {
        return sentencenum;
    }

    public void setSentencenum(int sentencenum) {
        this.sentencenum = sentencenum;
    }

    public List<NERTriple> getTriples() {
        return triples;
    }

    public void setTriples(List<NERTriple> triples) {
        this.triples = triples;
    }

    public List<Claim> getClaim() {
        return claim;
    }

    public void setClaim(List<Claim> claim) {
        this.claim = claim;
    }

    public List<CorefChain> getCoref() {
        return coref;
    }

    public void setCoref(List<CorefChain> coref) {
        this.coref = coref;
    }
}