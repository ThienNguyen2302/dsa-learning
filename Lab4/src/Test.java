import java.util.Arrays;

public class Test {
	public static void print(Student [] arr) {
		for(Student s: arr) {
			System.out.println(s.toString()+"\t");
		}
		System.out.println();
	}
	public static void main(String [] args) {
		Student [] s=new Student [5];
		s[0]=new Student("A",5,7,9);
		s[1]=new Student("B",6,5,8);
		s[2]=new Student("C",9,4,5);
		s[3]=new Student("D",7,5,5);
		s[4]=new Student("E",5,8,7);
		print(s);
		Arrays.sort(s, new StudentAscComparator());
		print(s);
		Arrays.parallelSort(s,new StudentDescComparator());
		print(s);
	}
}
