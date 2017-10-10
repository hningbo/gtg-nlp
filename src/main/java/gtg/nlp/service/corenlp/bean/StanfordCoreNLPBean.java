package gtg.nlp.service.corenlp.bean;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import javax.annotation.PostConstruct;
import java.util.Properties;

public class StanfordCoreNLPBean {
	
	private StanfordCoreNLP pipeline;
	
    public @PostConstruct void init()
    {
		Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,depparse,natlog,ner,openie,mention ,coref");
        pipeline = new StanfordCoreNLP(props);
    }
	
	public StanfordCoreNLP getPipeline() {
		return pipeline;
	}
	
	public void setPipeline(StanfordCoreNLP pipeline) {
		this.pipeline = pipeline;
	}

	public static void main(String[] args)
	{
		new StanfordCoreNLPBean().init();
	}
}
