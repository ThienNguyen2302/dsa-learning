public class Fraction {
	private int numer;
	private int denom;

	public Fraction() {
		numer = 0;
		denom = 1;
	}

	public Fraction(int numer, int denom) {
		this.numer = numer;
		this.denom = denom;
	}

	public Fraction(Fraction f) {
		this.numer = f.getNumerator();
		this.denom = f.getDenominator();
	}

	public int getNumerator() {
		return numer;
	}

	public int getDenominator() {
		return denom;
	}

	@Override
	public String toString() {
		return "Numerator: " + numer + ", Denominator: " + denom;
	}

	@Override
	public boolean equals(Object f) {
		if (f == null)
			return false;
		if (this.getClass() != f.getClass())
			return false;
		Fraction other = (Fraction) f;
		return (this.numer == other.getNumerator() && this.denom == other.getDenominator());

	}
}
