package algstudent.s1;

public class Vector3 {
	public static void main(String[] args) {

		for (int n = 10; n < Integer.MAX_VALUE; n *= 5) {

			int[] v = new int[n];
			Vector1.fillIn(v);

			long t1, t2, s = 0;
			t1 = System.currentTimeMillis();
			s += Vector1.sum(v);
			t2 = System.currentTimeMillis();

			System.out.println(String.format("SIZE = %d ** TIME = %d ms SUM = %d", n, t2 - t1, s));

		}
	}
}