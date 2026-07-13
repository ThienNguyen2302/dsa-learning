
public class Student {
	private String name;
	private double mathematics;
	private double programming;
	private double DSA1;

	public Student() {
		name = "";
		mathematics = 0;
		programming = 0;
		DSA1 = 0;
	}

	public Student(String name, double m, double p, double d) {
		this.name = name;
		mathematics = m;
		programming = p;
		DSA1 = d;
	}

	public double aver() {
		return (mathematics + programming + DSA1) / 3;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", programming: " + programming + ", mathematics: " + mathematics + ", DSA1: " + DSA1;
	}

}
