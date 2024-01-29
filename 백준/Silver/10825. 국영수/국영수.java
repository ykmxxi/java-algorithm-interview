import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N;
	static Student[] A;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new Student[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			A[i] = new Student();

			A[i].name = st.nextToken();
			A[i].korean = Integer.parseInt(st.nextToken());
			A[i].english = Integer.parseInt(st.nextToken());
			A[i].math = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() {
		Arrays.sort(A);

		for (Student student : A) {
			sb.append(student.name).append('\n');
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static class Student implements Comparable<Student> {
		String name;
		int korean, english, math;

		public Student() {
		}

		@Override
		public int compareTo(Student other) {
			if (this.korean != other.korean) { // 1. 국어 내림차순
				return other.korean - this.korean;
			}
			if (this.english != other.english) { // 2. 영어 오름차순
				return this.english - other.english;
			}
			if (this.math != other.math) { // 3. 수학 내림차순
				return other.math - this.math;
			}
			return this.name.compareTo(other.name); // 4. 이름 오름차순 (사전 순)
		}
	}
}
