package gtg.nlp.service.corenlp.impl;

import edu.stanford.nlp.ie.util.RelationTriple;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.naturalli.NaturalLogicAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import gtg.nlp.common.entity.Claim;
import gtg.nlp.service.corenlp.OpenIEService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

@Service
public class OpenIEServiceImpl implements OpenIEService {

	public List<Claim> getSentenceInfo(String content) {
		Properties props = new Properties();
		props.put("annotators", "tokenize,ssplit,pos,lemma,depparse,natlog,openie");
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
		Annotation document = new Annotation(content);
		List<Claim> claims = new ArrayList<Claim>();

		// Loop over sentences in the document
		int j = 0;
		for (CoreMap sentence : document.get(CoreAnnotations.SentencesAnnotation.class)) {

			// Get the OpenIE triples for the sentence
			Collection<RelationTriple> triples = sentence.get(NaturalLogicAnnotations.RelationTriplesAnnotation.class);
			// Print the triples
			for (RelationTriple triple : triples) {
				if(triple.confidence>0.8)
				claims.add(new Claim(triple.subjectGloss(), triple.relationGloss(), triple.objectGloss() ,j));
			}
		}
		return claims;
	}
}
