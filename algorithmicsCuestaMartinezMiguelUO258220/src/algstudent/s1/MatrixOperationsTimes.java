package algstudent.s1;

import algstudent.s0.MatrixOperations;

public class MatrixOperationsTimes {

	public static void main(String[] args) {

		int nTimes = Integer.parseInt(args[0]);

		for (int n = 10; n < Integer.MAX_VALUE; n *= 3) {

			MatrixOperations matrix = new MatrixOperations(n);

			long t1, t2, s = 0;
			t1 = System.currentTimeMillis();
			for (int rep = 1; rep <= nTimes; rep++) {
				s += matrix.sumDiagonal1();
			}
			t2 = System.currentTimeMillis();

			System.out
					.println(String.format("SIZE = %d **  TIME = %d ms  SUM = %d  NTIMES = %d", n, t2 - t1, s, nTimes));

			t1 = System.currentTimeMillis();
			for (int rep = 1; rep <= nTimes; rep++) {
				s += matrix.sumDiagonal2();
			}
			t2 = System.currentTimeMillis();

			System.out
					.println(String.format("SIZE = %d **  TIME = %d ms  SUM = %d  NTIMES = %d", n, t2 - t1, s, nTimes));

		}
	}
}