
public class IntegerTriple {
	private Integer weight;
	private Integer source;
	private Integer dest;

	public IntegerTriple(Integer w, Integer s, Integer d) {
		this.weight = w;
		this.source = s;
		this.dest = d;
	}

	public Integer getWeight() {
		return this.weight;
	}

	public Integer getSource() {
		return this.source;
	}

	public Integer getDest() {
		return this.dest;
	}

	@Override
	public String toString() {
		return this.weight + " " + this.source + " " + this.dest;
	}
}
