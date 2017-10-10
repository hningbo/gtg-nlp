package gtg.nlp.common.entity;

import java.util.List;

public class Claims {
	private List<Claim> claim;
	
	public List<Claim> getClaims() {
		return claim;
	}

	public void setClaims(List<Claim> claim) {
		this.claim = claim;
	}

	public Claims(List<Claim> claim) {
		super();
		this.claim = claim;
	}
	
	public Claims()
	{
		super();
	}
	
}
