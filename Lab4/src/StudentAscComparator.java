import java.util.Comparator;

public class StudentAscComparator implements Comparator<Student> {

	@Override
	public int compare(Student arg0, Student arg1) {
		Student s1 = (Student) arg0;
		Student s2 = (Student) arg1;
		double ratio = s1.aver() - s2.aver();
		if (ratio > 0)
			return 1;
		if (ratio < 0)
			return -1;
		return 0;
	}

}
