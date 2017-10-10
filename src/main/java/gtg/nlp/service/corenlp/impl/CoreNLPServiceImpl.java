package gtg.nlp.service.corenlp.impl;

import gtg.nlp.common.entity.SentenceInfo;
import gtg.nlp.service.corenlp.CorefService;
import gtg.nlp.service.corenlp.NERService;
import gtg.nlp.service.corenlp.OpenIEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoreNLPServiceImpl {

    private CorefService coref;

    private NERService ner;

    private OpenIEService openie;


    @Autowired
    public void setCoref(CorefService coref) {
        this.coref = coref;
    }

    @Autowired
    public void setNer(NERService ner) {
        this.ner = ner;
    }

    @Autowired
    public void setOpenie(OpenIEService openie) {
        this.openie = openie;
    }

    public SentenceInfo analyse(String content)
    {
        SentenceInfo sentenceInfo = new SentenceInfo();


        //sentenceInfo.setCoref(coref.getSentenceInfo(content));
        //sentenceInfo.setClaim(openie.getSentenceInfo(content));

        return sentenceInfo;
    }
}
