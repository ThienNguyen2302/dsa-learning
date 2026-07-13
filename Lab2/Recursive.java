import java.util.Scanner;

public class Recursive {
	public static void main(String[] args) {
		int n;
		double m = 0.0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println("nhap so n: ");
		sc.close();
		MyStack<Double> b = new MyStack<Double>();
		for (int i = 1; i < n; i++) {
			if (i == 1) {
				b.push(3.0);
			} else {
				b.push(Math.pow(2, i) + i * i);
			}
		}
		for (int i = 1; i < n; i++) {
			m = m + b.pop();
		}
		System.out.println("ket qua: " + m);
	}

}
