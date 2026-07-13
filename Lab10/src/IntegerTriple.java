public class IntegerTriple {
	private Integer weight;
	private Integer source;
	private Integer dest;

	public IntegerTriple(Integer s, Integer d, Integer w) {
		weight = w;
		source = s;
		dest = d;
	}

	public Integer getWeight() {
		return weight;
	}

	public Integer getSource() {
		return source;
	}

	public Integer getDest() {
		return dest;
	}

	@Override
	public String toString() {
		return source + " " + dest + " " + weight;
	}

	public int compareTo(IntegerTriple f) {
		if (this.weight < f.weight)
			return -1;
		else if (this.weight > f.weight)
			return 1;
		else
			return 0;
	}
}