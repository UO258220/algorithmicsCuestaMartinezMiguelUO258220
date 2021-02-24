package algstudent.s1;

public class Vector4 {
	public static void main(String[] args) {

		for (int n = 10; n < Integer.MAX_VALUE; n *= 5) {
			int nTimes = Integer.parseInt(args[0]);
			int[] v = new int[n];
			Vector1.fillIn(v);

			long t1, t2, s = 0;
			t1 = System.currentTimeMillis();
			for (int rep = 1; rep <= nTimes; rep++) {
				s += Vector1.sum(v);
			}
			t2 = System.currentTimeMillis();

			System.out
					.println(String.format("SIZE = %d **  TIME = %d ms  SUM = %d  NTIMES = %d", n, t2 - t1, s, nTimes));

		}
	}
}

