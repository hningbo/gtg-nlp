package gtg.nlp.service.corenlp.impl;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.util.Triple;
import gtg.nlp.service.bean.NERTriple;
import gtg.nlp.service.corenlp.NERService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NERServiceImpl implements NERService{

	private AbstractSequenceClassifier<CoreLabel> classifier;

	private @PostConstruct void init() throws IOException, ClassNotFoundException {
		String serializedClassifier = "edu/stanford/nlp/models/ner/english.all.3class.distsim.crf.ser.gz";
		classifier = CRFClassifier.getClassifier(serializedClassifier);
	}

	public List<NERTriple> getSentenceInfo(String[] content) throws Exception {
		init();
		List<NERTriple> nerTriples = new ArrayList<NERTriple>();
		System.out.println("Begin to do the Named Entity Regonized .");
		int j = 0;
		for (String str : content) {
			j++;
			List<Triple<String,Integer,Integer>> triples = classifier.classifyToCharacterOffsets(str);
			for (Triple<String,Integer,Integer> trip : triples) {
				nerTriples.add(new NERTriple(trip.first() ,str.substring(trip.second(),trip.third),j));
			}
		}
		System.out.println("Named Entity Regonized finish.");
		return nerTriples;
	}

	public static void main(String[] args) throws Exception {
		String[] strings = {"Obama is the president.","He is a man"};
		new NERServiceImpl().getSentenceInfo(strings);
	}
}
