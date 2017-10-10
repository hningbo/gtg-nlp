package gtg.nlp.service.corenlp.impl;

import edu.stanford.nlp.coref.CorefCoreAnnotations;
import edu.stanford.nlp.coref.data.CorefChain;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import gtg.nlp.service.corenlp.CorefService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class CorefServiceImpl implements CorefService{
    
    public List<CorefChain> getSentenceInfo(String content)
    {
        Properties props = new Properties();
        props.put("annotators", "tokenize,ssplit,pos,lemma,ner,parse,mention,coref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        Annotation document = new Annotation(content);

        pipeline.annotate(document);
        List<CorefChain> corefChainList = new ArrayList<CorefChain>();

        for (CorefChain cc : document.get(CorefCoreAnnotations.CorefChainAnnotation.class).values()) {
            corefChainList.add(cc);
        }

        return corefChainList;
    }
}

