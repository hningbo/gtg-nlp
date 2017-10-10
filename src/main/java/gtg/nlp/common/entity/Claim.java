package gtg.nlp.common.entity;

public class Claim {
	private String subject;

	private String predicate;

	private String object;

	private int sentencenum;

	public Claim(String subject, String predicate, String object, int sentencenum) {
		this.subject = subject;
		this.predicate = predicate;
		this.object = object;
		this.sentencenum = sentencenum;
	}

	public int getSentencenum() {
		return sentencenum;
	}

	public void setSentencenum(int sentencenum) {
		this.sentencenum = sentencenum;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPredicate() {
		return predicate;
	}

	public void setPredicate(String predicate) {
		this.predicate = predicate;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String toString() {
		return "subject:" + this.subject + "\npredicate:" + this.predicate + "\nobject" + "this.object";
	}
}
